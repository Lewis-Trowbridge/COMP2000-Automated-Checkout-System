package com.autochecksys.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class RepositoryTest {

    String testStockString = "{\"1\":{\"itemId\":1,\"itemName\":\"Jam\",\"itemPrice\":0.99,\"stockCount\":30}}";
    HashMap<Integer, StockItem> testStockMap = new HashMap<>();
    StockItem testJam;
    StockItem testBanana;

    @Before
    public void setUp(){
        testJam = new StockItem();
        testJam.setItemId(1);
        testJam.setItemName("Jam");
        testJam.setItemPrice(0.99f);
        testJam.setStockCount(30);
        testStockMap.put(1, testJam);
        testBanana = new StockItem();
        testBanana.setItemId(2);
        testBanana.setItemName("Banana");
        testBanana.setItemPrice(1.47f);
        testBanana.setStockCount(10);
        Repository.getRepositoryInstance().stockItems = testStockMap;
    }

    @Test
    public void singletonSingleInstance(){
        assertEquals(Repository.getRepositoryInstance(), Repository.getRepositoryInstance());
    }

    @Test
    public void updateStockItemDoesNotCreateNewObject(){
        StockItem oldItem = Repository.getRepositoryInstance().stockItems.get(1);
        Repository.getRepositoryInstance().updateStock(testStockString);
        assertSame(oldItem, Repository.getRepositoryInstance().stockItems.get(1));
    }

    @Test
    public void populateStockItemCreatesNewObject(){
        StockItem oldItem = Repository.getRepositoryInstance().stockItems.get(1);
        Repository.getRepositoryInstance().populateStock(testStockString);
        assertNotSame(oldItem, Repository.getRepositoryInstance().stockItems.get(1));
    }

    @Test
    public void addStockItemAddsCorrectly(){
        Repository.getRepositoryInstance().addStockItem(testBanana.getItemName(), testBanana.getItemPrice(), testBanana.getStockCount());
        StockItem testItem = Repository.getRepositoryInstance().stockItems.get(2);
        assertEquals(testBanana, testItem);
    }

    @Test
    public void editStockEditsAllValuesCorrectly(){
        Repository.getRepositoryInstance().editStockItem(1, testBanana.getItemName(), testBanana.getItemPrice(), testBanana.getStockCount());
        StockItem bananaThatWasFormerlyJam = Repository.getRepositoryInstance().stockItems.get(1);
        Object[] expectedValues = {testBanana.getItemName(), testBanana.getItemPrice(), testBanana.getStockCount()};
        Object[] formerJamValues = {bananaThatWasFormerlyJam.getItemName(), bananaThatWasFormerlyJam.getItemPrice(), bananaThatWasFormerlyJam.getStockCount()};
        assertArrayEquals(expectedValues, formerJamValues);
    }

    @Test
    public void editStockEditsNameCorrectly(){
        Repository.getRepositoryInstance().editStockItem(1, "Banana", null, null);
        StockItem bananaInNameOnly = Repository.getRepositoryInstance().stockItems.get(1);
        assertTrue((testBanana.getItemName().equals(bananaInNameOnly.getItemName())) && (testBanana.getItemPrice() != bananaInNameOnly.getItemPrice()) && (testBanana.getStockCount() != bananaInNameOnly.getStockCount()));
    }

    @Test
    public void deleteStockDeletesCorrectly(){
        Repository.getRepositoryInstance().stockItems.put(2, testBanana);
        Repository.getRepositoryInstance().deleteStockItem(2);
        assertNull(Repository.getRepositoryInstance().stockItems.get(2));
    }

    @Test
    public void decrementStockItemWorksCorrectly(){
        Repository.getRepositoryInstance().decrementBoughtItem(1);
        assertEquals(29, Repository.getRepositoryInstance().stockItems.get(1).getStockCount());
    }
}