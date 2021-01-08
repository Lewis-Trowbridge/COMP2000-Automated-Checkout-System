package com.autochecksys.controller.admin;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import com.autochecksys.KeyValuePair;
import com.autochecksys.model.IAutoCheckSysModel;
import com.autochecksys.model.Repository;
import com.autochecksys.model.StockItem;
import com.autochecksys.view.shared.DisplayPanel;

public class AdminDataController extends AbstractAdminDataController {
    public DisplayPanel viewToControl;

    public List<IAutoCheckSysModel> itemsToDisplay;

    public List<IAutoCheckSysModel> ordersToDisplay;

    public AdminDataController(DisplayPanel viewToControl) {
//begin of modifiable zone(JavaSuper).....C/bee3a8dc-85c8-411a-9ffe-015b0f37cf1f
        this.viewToControl = viewToControl;
//end of modifiable zone(JavaSuper).......E/bee3a8dc-85c8-411a-9ffe-015b0f37cf1f
//begin of modifiable zone(JavaCode)......C/bee3a8dc-85c8-411a-9ffe-015b0f37cf1f
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
//end of modifiable zone(JavaCode)........E/bee3a8dc-85c8-411a-9ffe-015b0f37cf1f
    }

    @Override
    public void updateView(KeyValuePair change) {
//begin of modifiable zone(JavaCode)......C/8917e867-85e0-4654-bbc9-cade674e588a
        this.viewToControl.update(change);
//end of modifiable zone(JavaCode)........E/8917e867-85e0-4654-bbc9-cade674e588a
    }

    @Override
    public void setModelProperty(KeyValuePair change) {
//begin of modifiable zone(JavaCode)......C/22da1484-a7f0-43be-bf81-6b3e6885538c

//end of modifiable zone(JavaCode)........E/22da1484-a7f0-43be-bf81-6b3e6885538c
    }

    @Override
    public void addStockItem(String name, float price, int quantity) {
//begin of modifiable zone(JavaCode)......C/d2d5a9ec-bf21-47b5-a4d6-e7e9b1460c75

//end of modifiable zone(JavaCode)........E/d2d5a9ec-bf21-47b5-a4d6-e7e9b1460c75
    }

    @Override
    public void editStockItem(String name, float price, int quantity) {
//begin of modifiable zone(JavaCode)......C/596cc404-c712-4b65-999e-02245b872664

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
