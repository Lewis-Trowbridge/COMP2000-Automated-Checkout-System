package com.dbaccess;

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
        realFileContent = StockFileAccess.getInstance().read();
    }

    @Test
    public void testRead(){
        try {
            List<StockItem> stockItems = new ArrayList<>();
            StockItem item = new StockItem();
            item.setItemId(1);
            item.setItemName("Jam");
            item.setItemPrice(0.99f);
            stockItems.add(item);
            System.out.println(Thread.currentThread());
            testWatcher.start();
            String testString = "[{\"itemId\":1,\"itemName\":\"Jam\",\"itemPrice\":0.99}]";
            StockFileAccess.getInstance().write(testString);
            Thread.sleep(1000);
            assertEquals(stockItems, Repository.getRepositoryInstance().stockItems);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}