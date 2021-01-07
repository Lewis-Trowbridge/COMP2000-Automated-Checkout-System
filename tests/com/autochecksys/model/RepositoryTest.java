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
    HashMap<String, AdminAccount> testAdminMap = new HashMap<>();
    AdminAccount testAdmin;
    HashMap<Integer, StockOrder> testStockOrderMap = new HashMap<>();
    StockOrder testJamOrder;
    StockOrder testBananaOrder;

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
        // Banana is not in map on purpose to test addition and other methods
        Repository.getRepositoryInstance().stockItems = testStockMap;

        testAdmin = new AdminAccount();
        testAdmin.setUsername("rsmith");
        testAdmin.setPassword("unsecure");
        testAdminMap.put(testAdmin.getUsername(), testAdmin);
        Repository.getRepositoryInstance().adminAccounts = testAdminMap;

        testJamOrder = new StockOrder();
        testJamOrder.setOrderId(1);
        testJamOrder.setStockItemId(testJam.getItemId());
        testJamOrder.setQuantity(5000);
        testStockOrderMap.put(testJamOrder.getOrderId(), testJamOrder);
        testBananaOrder = new StockOrder();
        testBananaOrder.setOrderId(2);
        testBananaOrder.setStockItemId(testBanana.getItemId());
        testBananaOrder.setQuantity(3);
        Repository.getRepositoryInstance().stockOrders = testStockOrderMap;
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

    @Test
    public void loginWithCorrectCredentialsReturnsTrue(){
        boolean success = Repository.getRepositoryInstance().login(testAdmin.getUsername(), testAdmin.getPassword());
        assertTrue(success);
    }

    @Test
    public void loginWithIncorrectCredentialsReturnsFalse(){
        boolean success = Repository.getRepositoryInstance().login("notA", "validLogin");
        assertFalse(success);
    }

    @Test
    public void loginWithIncorrectPasswordReturnsFalse(){
        boolean success = Repository.getRepositoryInstance().login(testAdmin.getUsername(), "notValid");
        assertFalse(success);
    }

    @Test
    public void createStockOrderAddsCorrectly(){
        Repository.getRepositoryInstance().stockItems.put(testBanana.getItemId(), testBanana);
        Repository.getRepositoryInstance().createStockOrder(testBananaOrder.getStockItemId(), testBananaOrder.getQuantity());
        StockOrder what = Repository.getRepositoryInstance().stockOrders.get(2);
        assertEquals(testBananaOrder, what);
    }

    @Test
    public void createStockOrderFulfillsCorrectly(){
        Repository.getRepositoryInstance().fulfillStockOrder(1);
        assertEquals(5030, Repository.getRepositoryInstance().stockItems.get(1).getStockCount());
    }
}