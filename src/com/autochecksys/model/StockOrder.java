package com.autochecksys.model;

import java.util.ArrayList;
import java.util.List;
import com.autochecksys.KeyValuePair;
import com.autochecksys.controller.shared.AbstractController;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StockOrder implements IAutoCheckSysModel {
    private int orderId;

    private int stockItemId;

    private int quantity;

    @JsonIgnore
    private List<AbstractController> observers = new ArrayList<AbstractController> ();

    @JsonProperty("orderId")
    public int getOrderId() {
//begin of modifiable zone................T/1df69327-c523-48f1-8b6d-68c9c950f14e
        // Automatically generated method. Please delete this comment before entering specific code.
//end of modifiable zone..................E/1df69327-c523-48f1-8b6d-68c9c950f14e
//begin of modifiable zone................T/ad791b14-3531-468e-b673-b8addc96781c
        return this.orderId;
//end of modifiable zone..................E/ad791b14-3531-468e-b673-b8addc96781c
    }

    public void setOrderId(int value) {
//begin of modifiable zone................T/c25b34d3-63bc-44e4-b7f2-804d9f735f71
        this.orderId = value;
        onPropertyChanged(new KeyValuePair(AbstractController.ORDER_ID, value, value));
//end of modifiable zone..................E/c25b34d3-63bc-44e4-b7f2-804d9f735f71
    }

    @JsonProperty("stockItemId")
    public int getStockItemId() {
//begin of modifiable zone................T/2ee82031-138a-4487-bd1a-e3e818b0d38e
        // Automatically generated method. Please delete this comment before entering specific code.
//end of modifiable zone..................E/2ee82031-138a-4487-bd1a-e3e818b0d38e
//begin of modifiable zone................T/477c47c8-868b-4620-ba38-47da40957176
        return this.stockItemId;
//end of modifiable zone..................E/477c47c8-868b-4620-ba38-47da40957176
    }

    public void setStockItemId(int value) {
//begin of modifiable zone................T/f851476d-6f4e-4b87-a09e-a57a4d5d70ad
        this.stockItemId = value;
        onPropertyChanged(new KeyValuePair(AbstractController.ORDER_ITEM_ID, value, this.orderId));
//end of modifiable zone..................E/f851476d-6f4e-4b87-a09e-a57a4d5d70ad
    }

    @JsonProperty("quantity")
    public int getQuantity() {
//begin of modifiable zone................T/2b3b16e9-6997-422f-9776-201c84490077
        // Automatically generated method. Please delete this comment before entering specific code.
//end of modifiable zone..................E/2b3b16e9-6997-422f-9776-201c84490077
//begin of modifiable zone................T/034904dc-7ada-4509-b0a0-34042db12a17
        return this.quantity;
//end of modifiable zone..................E/034904dc-7ada-4509-b0a0-34042db12a17
    }

    public void setQuantity(int value) {
//begin of modifiable zone................T/bcfb093c-eb50-4992-a36c-31a8c880c58d
        // Automatically generated method. Please delete this comment before entering specific code.
        this.quantity = value;
        onPropertyChanged(new KeyValuePair(AbstractController.ORDER_QUANTITY, value, this.orderId));
//end of modifiable zone..................E/bcfb093c-eb50-4992-a36c-31a8c880c58d
    }

    public void add(AbstractController observer) {
//begin of modifiable zone................T/58950baa-2088-441a-9b88-97db35a329a2
        this.observers.add(observer);
//end of modifiable zone..................E/58950baa-2088-441a-9b88-97db35a329a2
    }

    public void remove(AbstractController observer) {
//begin of modifiable zone................T/0005fb2b-880d-484f-ac5d-fd0e3f704eba
        this.observers.remove(observer);
//end of modifiable zone..................E/0005fb2b-880d-484f-ac5d-fd0e3f704eba
    }

    public void onPropertyChanged(KeyValuePair change) {
//begin of modifiable zone................T/fc968a8f-b4b7-44b3-a40a-c9183a997f9c
        for (AbstractController observer : observers){
            observer.updateView(change);
        }
//end of modifiable zone..................E/fc968a8f-b4b7-44b3-a40a-c9183a997f9c
    }

}
