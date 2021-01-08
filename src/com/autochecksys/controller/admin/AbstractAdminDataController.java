package com.autochecksys.controller.admin;

import com.autochecksys.controller.shared.AbstractController;

public abstract class AbstractAdminDataController extends AbstractController {
    public abstract void addStockItem(String name, float price, int quantity);

    public abstract void editStockItem(String name, float price, int quantity);

    public abstract void deleteStockItem(int id);

    public abstract void createStockOrder(int itemId, int quantity);

    public abstract void fulfillStockOrder(int orderId);

}
