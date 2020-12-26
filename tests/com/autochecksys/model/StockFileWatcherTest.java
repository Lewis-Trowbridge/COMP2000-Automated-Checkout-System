package com.autochecksys.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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
        List<StockItem> stockItems = new ArrayList<>();
        StockItem item = new StockItem();
        item.setItemId(1);
        item.setItemName("Jam");
        item.setItemPrice(0.99f);
        item.setStockCount(30);
        stockItems.add(item);
        testWatcher.start();
        try {
            Thread.sleep(2000);
            String testString = "[{\"itemId\":1,\"itemName\":\"Jam\",\"itemPrice\":0.99,\"stockCount\":30}]";
            StockFileAccess.getInstance().write(testString);
            assertEquals(stockItems.get(0), Repository.getRepositoryInstance().stockItems.get(0));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}