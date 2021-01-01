package com.autochecksys.controller.kiosk;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import com.autochecksys.KeyValuePair;
import com.autochecksys.model.IAutoCheckSysModel;
import com.autochecksys.model.Repository;
import com.autochecksys.view.kiosk.PaymentPanel;
import com.autochecksys.view.shared.DisplayPanel;

public class KioskController extends AbstractKioskController {
    public DisplayPanel viewToControl;

    public IAutoCheckSysModel[] modelsToUse;

    public float currentTotal;

    public List<IAutoCheckSysModel> currentBasket = new ArrayList<IAutoCheckSysModel> ();

    @Override
    public void scanItem(int id) {
//begin of modifiable zone................T/744f72bc-da00-4c2a-86cd-6979d543f8a5
        for (IAutoCheckSysModel model: this.modelsToUse) {
            try {
                Integer currentModelID = (Integer) model.getClass().getDeclaredMethod("getItemId").invoke(model, null);
                if (currentModelID == id){
                    // Add this controller as an observer to this model, as it has now been "scanned"
                    model.add(this);
                    // Add this model to the current basket in order to pass forward to the payment screen
                    currentBasket.add(model);
                    // Send back the whole model, since this will be needed by the view
                    updateView(new KeyValuePair("StockItem", model, -1));
                    currentTotal += (float)model.getClass().getDeclaredMethod("getItemPrice").invoke(model, null);
                    updateView(new KeyValuePair("Total", currentTotal, -1));
                }
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
//end of modifiable zone..................E/744f72bc-da00-4c2a-86cd-6979d543f8a5
    }

    public KioskController(DisplayPanel viewToControl) {
//begin of modifiable zone(JavaSuper).....C/98ee244d-b816-418f-82ce-bd907c4f383f

//end of modifiable zone(JavaSuper).......E/98ee244d-b816-418f-82ce-bd907c4f383f
//begin of modifiable zone................T/bf7d9327-e4a5-4266-bb65-b9fdb4e86f73
        this.viewToControl = viewToControl;
        IAutoCheckSysModel[] modelArray = new IAutoCheckSysModel[Repository.getRepositoryInstance().stockItems.size()];
        this.modelsToUse = Repository.getRepositoryInstance().stockItems.values().toArray(modelArray);
        this.currentTotal = 0f;
//end of modifiable zone..................E/bf7d9327-e4a5-4266-bb65-b9fdb4e86f73
    }

    @Override
    public void updateView(KeyValuePair change) {
//begin of modifiable zone................T/e8a74519-7a9b-4bd6-9c96-fb57aaba34e8
        // Pass change along to the view
        this.viewToControl.update(change);
//end of modifiable zone..................E/e8a74519-7a9b-4bd6-9c96-fb57aaba34e8
    }

    @Override
    public void setModelProperty(KeyValuePair change) {
//begin of modifiable zone(JavaCode)......C/9459e6c4-51c8-4180-b3b2-fbfdb94ad89d

//end of modifiable zone(JavaCode)........E/9459e6c4-51c8-4180-b3b2-fbfdb94ad89d
    }

    public void goToPayment() {
//begin of modifiable zone(JavaCode)......C/b72f577c-53a1-42f8-990c-23f642de3ce8
        PaymentPanel panel = new PaymentPanel(viewToControl.mainFrameToUse);
        PaymentController controller = new PaymentController(panel, this.currentBasket, this.currentTotal);
        panel.setController(controller);
        panel.setupAndDisplay();
//end of modifiable zone(JavaCode)........E/b72f577c-53a1-42f8-990c-23f642de3ce8
    }

}
