package com.autochecksys.controller.kiosk;

import com.autochecksys.KeyValuePair;
import com.autochecksys.model.IAutoCheckSysModel;
import com.autochecksys.model.Repository;
import com.autochecksys.view.shared.DisplayPanel;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class KioskController extends AbstractKioskController {
    public DisplayPanel viewToControl;

    public IAutoCheckSysModel[] modelsToUse;

    public void scanItem(int id) {
//begin of modifiable zone(JavaCode)......C/467de3ce-a1a7-4097-a373-27e77f31101c
        for (IAutoCheckSysModel model: this.modelsToUse) {
            try {
                Integer currentModelID = (Integer) model.getClass().getDeclaredMethod("getItemId").invoke(model, null);
                if (currentModelID == id){
                    updateView(new KeyValuePair("StockItem", model));
                }
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
//end of modifiable zone(JavaCode)........E/467de3ce-a1a7-4097-a373-27e77f31101c
    }

    public KioskController(DisplayPanel viewToControl) {
//begin of modifiable zone(JavaSuper).....C/98ee244d-b816-418f-82ce-bd907c4f383f

//end of modifiable zone(JavaSuper).......E/98ee244d-b816-418f-82ce-bd907c4f383f
//begin of modifiable zone(JavaCode)......C/98ee244d-b816-418f-82ce-bd907c4f383f
        this.viewToControl = viewToControl;
        IAutoCheckSysModel[] modelArray = new IAutoCheckSysModel[Repository.getRepositoryInstance().stockItems.size()];
        this.modelsToUse = Repository.getRepositoryInstance().stockItems.toArray(modelArray);
        for (IAutoCheckSysModel model: this.modelsToUse){
            model.add(this);
        }
//end of modifiable zone(JavaCode)........E/98ee244d-b816-418f-82ce-bd907c4f383f
    }

    public void updateView(KeyValuePair change) {
//begin of modifiable zone(JavaCode)......C/058022de-1be2-4867-9aa9-e7edf5f2b740
        this.viewToControl.update(change);
//end of modifiable zone(JavaCode)........E/058022de-1be2-4867-9aa9-e7edf5f2b740
    }

    public void setModelProperty(KeyValuePair change) {
//begin of modifiable zone(JavaCode)......C/9459e6c4-51c8-4180-b3b2-fbfdb94ad89d

//end of modifiable zone(JavaCode)........E/9459e6c4-51c8-4180-b3b2-fbfdb94ad89d
    }

}
