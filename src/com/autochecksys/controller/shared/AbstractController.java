package com.autochecksys.controller.shared;

import com.autochecksys.KeyValuePair;

public abstract class AbstractController {
    public static final String ITEM_ID = "ItemId";

    public static final String ITEM_NAME = "ItemName";

    public static final String ITEM_PRICE = "ItemPrice";

    public static final String STOCK_COUNT = "StockCount";

    public abstract void updateView(KeyValuePair change);

    public abstract void setModelProperty(KeyValuePair change);

}
