package com.dbaccess;


public class StockItem {
    private int itemId;

    private String itemName;

    private float itemPrice;

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
        // Automatically generated method. Please delete this comment before entering specific code.
        if (value > 0) {
            this.itemPrice = value;
        }
//end of modifiable zone..................E/9a23d36d-71b6-4fb6-ba24-d9d077e42980
    }

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
        // Automatically generated method. Please delete this comment before entering specific code.
        this.itemId = value;
//end of modifiable zone..................E/308c68c8-047f-41a7-83c1-ab943b1e8d50
    }

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
        // Automatically generated method. Please delete this comment before entering specific code.
        this.itemName = value;
//end of modifiable zone..................E/0d907bba-e152-4fd7-80b8-83378bb20dff
    }

}
