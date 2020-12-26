package com.autochecksys.model;

import java.util.ArrayList;
import java.util.List;
import com.autochecksys.KeyValuePair;
import com.autochecksys.controller.shared.AbstractController;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StockItem implements IAutoCheckSysModel {
    private int itemId;

    private String itemName;

    private float itemPrice;

    private int stockCount;

    public List<AbstractController> observers = new ArrayList<AbstractController> ();

    @JsonProperty("itemPrice")
    float getItemPrice() {
//begin of modifiable zone................T/50f71d57-5e73-4879-9391-f426287cd6a0
        // Automatically generated method. Please delete this comment before entering specific code.
//end of modifiable zone..................E/50f71d57-5e73-4879-9391-f426287cd6a0
//begin of modifiable zone................T/5217e20a-7928-4169-98d5-bd488867b098
        return this.itemPrice;
//end of modifiable zone..................E/5217e20a-7928-4169-98d5-bd488867b098
    }

    void setItemPrice(float value) {
//begin of modifiable zone................T/9a23d36d-71b6-4fb6-ba24-d9d077e42980
        if (value > 0) {
            this.itemPrice = value;
            onPropertyChanged(new KeyValuePair(AbstractController.ITEM_PRICE, value));
        }
//end of modifiable zone..................E/9a23d36d-71b6-4fb6-ba24-d9d077e42980
    }

    @JsonProperty("itemId")
    int getItemId() {
//begin of modifiable zone................T/15287f22-1fc1-4a62-8978-66df649fa04d
        // Automatically generated method. Please delete this comment before entering specific code.
//end of modifiable zone..................E/15287f22-1fc1-4a62-8978-66df649fa04d
//begin of modifiable zone................T/f55cfb78-539a-4f38-ac3f-0a030c856abf
        return this.itemId;
//end of modifiable zone..................E/f55cfb78-539a-4f38-ac3f-0a030c856abf
    }

    void setItemId(int value) {
//begin of modifiable zone................T/308c68c8-047f-41a7-83c1-ab943b1e8d50
        this.itemId = value;
        onPropertyChanged(new KeyValuePair(AbstractController.ITEM_ID, value));
//end of modifiable zone..................E/308c68c8-047f-41a7-83c1-ab943b1e8d50
    }

    @JsonProperty("itemName")
    String getItemName() {
//begin of modifiable zone................T/5e73a64b-ca3e-4116-8450-7a9e152b006c
        // Automatically generated method. Please delete this comment before entering specific code.
//end of modifiable zone..................E/5e73a64b-ca3e-4116-8450-7a9e152b006c
//begin of modifiable zone................T/68567535-eb11-4283-bb5f-6346c334d0e8
        return this.itemName;
//end of modifiable zone..................E/68567535-eb11-4283-bb5f-6346c334d0e8
    }

    void setItemName(String value) {
//begin of modifiable zone................T/0d907bba-e152-4fd7-80b8-83378bb20dff
        this.itemName = value;
        onPropertyChanged(new KeyValuePair(AbstractController.ITEM_NAME, value));
//end of modifiable zone..................E/0d907bba-e152-4fd7-80b8-83378bb20dff
    }

    @Override
    public boolean equals(Object o) {
//begin of modifiable zone................T/92d5ed13-e8ab-4bab-9f84-703555ba5fbd
        if (o == this) {
            return true;
        }
        
        if (!(o instanceof StockItem)) {
            return false;
        }
        
        StockItem newItem = (StockItem) o;
        
        return this.itemId == newItem.itemId && this.itemName.equals(newItem.itemName) && this.itemPrice == newItem.itemPrice && this.stockCount == newItem.stockCount;
//end of modifiable zone..................E/92d5ed13-e8ab-4bab-9f84-703555ba5fbd
//begin of modifiable zone(JavaReturned)..C/40652c1c-6683-41ec-be34-b9c80d8f4113

//end of modifiable zone(JavaReturned)....E/40652c1c-6683-41ec-be34-b9c80d8f4113
    }

    @JsonProperty("stockCount")
    int getStockCount() {
//begin of modifiable zone................T/a748ca34-0e00-4529-a5ff-5f3e7a150a3a
        // Automatically generated method. Please delete this comment before entering specific code.
//end of modifiable zone..................E/a748ca34-0e00-4529-a5ff-5f3e7a150a3a
//begin of modifiable zone................T/a23f406d-28fd-471d-ba92-24371b1be56f
        return this.stockCount;
//end of modifiable zone..................E/a23f406d-28fd-471d-ba92-24371b1be56f
    }

    void setStockCount(int value) {
//begin of modifiable zone................T/8dfaafaa-b828-4297-a049-a4d1f4e15b81
        this.stockCount = value;
        this.onPropertyChanged(new KeyValuePair(AbstractController.STOCK_COUNT, value));
//end of modifiable zone..................E/8dfaafaa-b828-4297-a049-a4d1f4e15b81
    }

    public void add(AbstractController observer) {
//begin of modifiable zone(JavaCode)......C/5818134a-0968-4028-ae00-15c853a70742
        this.observers.add(observer);
//end of modifiable zone(JavaCode)........E/5818134a-0968-4028-ae00-15c853a70742
    }

    public void remove(AbstractController observer) {
//begin of modifiable zone(JavaCode)......C/04a82c74-2d0c-4484-8fee-031029e9b0a7
        this.observers.remove(observer);
//end of modifiable zone(JavaCode)........E/04a82c74-2d0c-4484-8fee-031029e9b0a7
    }

    public void onPropertyChanged(KeyValuePair change) {
//begin of modifiable zone(JavaCode)......C/94e41433-1a03-4f24-aeba-830d74cd06c3
        for (AbstractController observer: observers){
            observer.updateView(change);
        }
//end of modifiable zone(JavaCode)........E/94e41433-1a03-4f24-aeba-830d74cd06c3
    }

}
