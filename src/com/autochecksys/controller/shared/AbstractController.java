package com.autochecksys.controller.shared;

import com.autochecksys.KeyValuePair;

public abstract class AbstractController {
    public static final String ITEM_ID = "ItemId";

    public static final String ITEM_NAME = "ItemName";

    public static final String ITEM_PRICE = "ItemPrice";

    public static final String STOCK_COUNT = "StockCount";

    public static final String ADMIN_USERNAME = "username";

    public static final String ADMIN_PASSWORD = "password";

    public static final String ORDER_ID = "orderId";

    public static final String ORDER_ITEM_ID = "orderItemId";

    public static final String ORDER_QUANTITY = "orderQuantity";

    public abstract void updateView(KeyValuePair change);

    public abstract void setModelProperty(KeyValuePair change);

}
