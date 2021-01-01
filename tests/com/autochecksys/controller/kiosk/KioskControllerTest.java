package com.autochecksys.controller.kiosk;

import com.autochecksys.KeyValuePair;
import com.autochecksys.model.Repository;
import com.autochecksys.model.StockItem;
import com.autochecksys.view.shared.DisplayPanel;
import com.autochecksys.view.shared.MainFrame;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class KioskControllerTest {

    class MockView extends DisplayPanel {

        public List<Object> returnedValues;

        public MockView() {
            super(new MainFrame());
            returnedValues = new ArrayList<>();
        }

        @Override
        protected void setUpComponents() {

        }

        @Override
        public void update(KeyValuePair change) {
            switch (change.key){
                case "StockItem":
                    returnedValues.add(change.value);
                    break;
                case "Total":
                    returnedValues.add(change.value);
            }
        }
    }

    MockView mockV;
    KioskController controller;
    Map<Integer, StockItem> stockMap;

    @Before
    public void setUp() throws Exception {

        // Set up stock items
        StockItem item1 = new StockItem();
        item1.setItemId(1);
        item1.setItemName("Item 1");
        item1.setItemPrice(0.99f);
        item1.setStockCount(1);
        StockItem item2 = new StockItem();
        item2.setItemId(2);
        item2.setItemName("Item 2");
        item2.setItemPrice(1.50f);
        item2.setStockCount(2);

        // Create new hashmap and place into repository for testing purposes
        stockMap = new HashMap<>();
        stockMap.put(item1.getItemId(), item1);
        stockMap.put(item2.getItemId(), item2);
        Repository.getRepositoryInstance().stockItems = stockMap;

        mockV = new MockView();
        controller = new KioskController(mockV);
    }

    @Test
    public void scanItemPassesCorrectSingleItem(){
        controller.scanItem(1);
        assertEquals(mockV.returnedValues.get(0), stockMap.get(1));
    }

    @Test
    public void scanItemPassesCorrectSinglePrice(){
        controller.scanItem(1);
        assertEquals(mockV.returnedValues.get(1), stockMap.get(1).getItemPrice());
    }

    @Test
    public void scanItemPassesCorrectMultiItem(){
        controller.scanItem(1);
        controller.scanItem(2);
        assertEquals(mockV.returnedValues.get(0), stockMap.get(1));
        assertEquals(mockV.returnedValues.get(2), stockMap.get(2));
    }

    @Test
    public void scanItemPassesCorrectTotal(){
        controller.scanItem(1);
        controller.scanItem(2);
        float expectedTotal = stockMap.get(1).getItemPrice() + stockMap.get(2).getItemPrice();
        assertEquals(expectedTotal, controller.currentTotal, 0);
    }

    @Test
    public void scanItemAddsToBasket(){
        controller.scanItem(1);
        assertEquals(stockMap.get(1), controller.currentBasket.get(0));
    }
}