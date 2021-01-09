package com.autochecksys.controller.admin;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import com.autochecksys.KeyValuePair;
import com.autochecksys.controller.shared.AbstractController;
import com.autochecksys.model.IAutoCheckSysModel;
import com.autochecksys.model.Repository;
import com.autochecksys.model.StockItem;
import com.autochecksys.view.shared.DisplayPanel;

public class AdminDataController extends AbstractAdminDataController {
    public DisplayPanel viewToControl;

    public List<IAutoCheckSysModel> itemsToDisplay;

    public List<IAutoCheckSysModel> ordersToDisplay;

    public AdminDataController(DisplayPanel viewToControl) {
//begin of modifiable zone................T/faa1db4a-7f88-4429-8753-59fb31e72593
this.viewToControl = viewToControl;

//end of modifiable zone..................E/faa1db4a-7f88-4429-8753-59fb31e72593
//begin of modifiable zone................T/585269e9-16bd-4cff-9250-59acc6a32f51
        // Convert the map into a temporary arraylist, since all stock items need to be displayed on this screen.
        itemsToDisplay = new ArrayList<>(Repository.getRepositoryInstance().stockItems.values());
        // Register this controller as an observer for each of the models, as they will all be displayed
        for (IAutoCheckSysModel model: itemsToDisplay) {
            model.add(this);
            try {
                // Obtain data to display from this model
                Integer itemId = (Integer) model.getClass().getDeclaredMethod("getItemId").invoke(model);
                String itemName = (String) model.getClass().getDeclaredMethod("getItemName").invoke(model);
                Float itemPrice = (Float) model.getClass().getDeclaredMethod("getItemPrice").invoke(model);
                Integer itemStock = (Integer) model.getClass().getDeclaredMethod("getStockCount").invoke(model);
                // Convert data obtained from model into a presentable format
                String[] stringItemData = {Integer.toString(itemId), itemName, String.format("%.2f", itemPrice), Integer.toString(itemStock)};
                // Pass the string array to the view to display as a new entry in the table
                updateView(new KeyValuePair("NewStockItemDisplay", stringItemData, itemId));
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        // Perform the same operations for the stock orders as these will be displayed on the same page
        ordersToDisplay = new ArrayList<>(Repository.getRepositoryInstance().stockOrders.values());
        for (IAutoCheckSysModel model: ordersToDisplay){
            model.add(this);
            try {
                Integer orderId = (Integer) model.getClass().getDeclaredMethod("getOrderId").invoke(model);
                Integer stockItemId = (Integer) model.getClass().getDeclaredMethod("getStockItemId").invoke(model);
                Integer quantity = (Integer) model.getClass().getDeclaredMethod("getQuantity").invoke(model);
                String[] orderData = {Integer.toString(orderId), Integer.toString(stockItemId), Integer.toString(quantity)};
                updateView(new KeyValuePair("NewStockOrderDisplay", orderData, orderId));
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
//end of modifiable zone..................E/585269e9-16bd-4cff-9250-59acc6a32f51
    }

    @Override
    public void updateView(KeyValuePair change) {
//begin of modifiable zone................T/57ff0edc-daf9-4cd7-b0b2-4e0180f800ea
        this.viewToControl.update(change);
//end of modifiable zone..................E/57ff0edc-daf9-4cd7-b0b2-4e0180f800ea
    }

    @Override
    public void setModelProperty(KeyValuePair change) {
//begin of modifiable zone(JavaCode)......C/22da1484-a7f0-43be-bf81-6b3e6885538c

//end of modifiable zone(JavaCode)........E/22da1484-a7f0-43be-bf81-6b3e6885538c
    }

    @Override
    public void addStockItem(String name, float price, int quantity) {
//begin of modifiable zone................T/a6dc2641-4429-4428-8a5f-31c41fe25101
        StockItem newItem = Repository.getRepositoryInstance().addStockItem(name, price, quantity);
        if (newItem != null){
            // Save changes back to the file in a background thread
            Repository.getRepositoryInstance().saveChanges();
            // Add this to the controller's array of models
            this.itemsToDisplay.add(newItem);
            // Add this controller to the model's observers
            newItem.add(this);
            String[] itemData = {Integer.toString(newItem.getItemId()), newItem.getItemName(), String.format("%.2f", newItem.getItemPrice()), Integer.toString(newItem.getStockCount())};
             updateView(new KeyValuePair("NewStockItemDisplay", itemData, newItem.getItemId()));
        }
//end of modifiable zone..................E/a6dc2641-4429-4428-8a5f-31c41fe25101
    }

    @Override
    public void editStockItem(int id, String name, float price, int quantity) {
//begin of modifiable zone(JavaCode)......C/596cc404-c712-4b65-999e-02245b872664
        StockItem editedItem = Repository.getRepositoryInstance().editStockItem(id, name, price, quantity);
        // Observers will be updated by the model objects themselves when their properties are changed, so
        // there is no need to explicitly update the view
        if (editedItem != null){
            Repository.getRepositoryInstance().saveChanges();
        }
//end of modifiable zone(JavaCode)........E/596cc404-c712-4b65-999e-02245b872664
    }

    @Override
    public void deleteStockItem(int id) {
//begin of modifiable zone(JavaCode)......C/db84e305-e9ed-41cf-8fd7-ae90ee922b63

//end of modifiable zone(JavaCode)........E/db84e305-e9ed-41cf-8fd7-ae90ee922b63
    }

    @Override
    public void createStockOrder(int itemId, int quantity) {
//begin of modifiable zone(JavaCode)......C/c9f9f419-139f-40c0-b423-e3ed7d05ebfa

//end of modifiable zone(JavaCode)........E/c9f9f419-139f-40c0-b423-e3ed7d05ebfa
    }

    @Override
    public void fulfillStockOrder(int orderId) {
//begin of modifiable zone(JavaCode)......C/7f5cd3af-e26b-48cf-a1d7-825cfcbd5644

//end of modifiable zone(JavaCode)........E/7f5cd3af-e26b-48cf-a1d7-825cfcbd5644
    }

}
