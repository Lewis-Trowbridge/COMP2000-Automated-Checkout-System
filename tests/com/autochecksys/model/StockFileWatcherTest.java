package com.autochecksys.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class StockFileWatcherTest {

    Thread testWatcher;
    String realFileContent;

    @Before
    public void setUp() throws Exception {
        testWatcher = new Thread(new StockFileWatcher());
        testWatcher.setDaemon(true);
        realFileContent = StockFileAccess.getInstance().read();
    }

    @Test
    public void readNotifiesRepository(){
        HashMap<Integer, StockItem> stockItems = new HashMap<>();
        StockItem item = new StockItem();
        item.setItemId(1);
        item.setItemName("Jam");
        item.setItemPrice(0.99f);
        item.setStockCount(30);
        stockItems.put(1 ,item);
        testWatcher.start();
        try {
            String testString = "{\"1\":{\"itemId\":1,\"itemName\":\"Jam\",\"itemPrice\":0.99,\"stockCount\":30}}";
            StockFileAccess.getInstance().write(testString);
            // Wait for the thread to update the repository
            Thread.sleep(500);
            assertEquals(stockItems, Repository.getRepositoryInstance().stockItems);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}