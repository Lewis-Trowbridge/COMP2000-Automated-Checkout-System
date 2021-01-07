package com.autochecksys.model;

import java.io.IOException;
import java.util.*;
import java.util.Map;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

public class Repository {
    private static Repository repositoryInstance;

    private final ObjectMapper mapper;

    public Map<Integer, StockItem> stockItems;

    public Map<String, AdminAccount> adminAccounts;

    public Map<Integer, StockOrder> stockOrders;

    private Repository() {
//begin of modifiable zone................T/97abe80b-b10a-4b04-927e-85c05783e1f6
mapper = new ObjectMapper();
populateStock(FileAccessServiceLocator.getStockFileAccess().read());
populateAdminAccounts(FileAccessServiceLocator.getAdminAccountFileAccess().read());
populateStockOrders(FileAccessServiceLocator.getStockOrderFileAccess().read());
Thread watcherThread = new Thread(new StockFileWatcher(), "Stock file watcher");
watcherThread.setDaemon(true);
watcherThread.start();

//end of modifiable zone..................E/97abe80b-b10a-4b04-927e-85c05783e1f6
//begin of modifiable zone(JavaCode)......C/190b61f6-ae29-4a9a-9053-baf0f262fe57

//end of modifiable zone(JavaCode)........E/190b61f6-ae29-4a9a-9053-baf0f262fe57
    }

    public static Repository getRepositoryInstance() {
//begin of modifiable zone................T/a5b7573e-ec82-4f8a-a475-f37ea927c07d
        // Automatically generated method. Please delete this comment before entering specific code.
//end of modifiable zone..................E/a5b7573e-ec82-4f8a-a475-f37ea927c07d
//begin of modifiable zone................T/16ab4d42-20dd-4262-9dc7-7bd2403a12cc
        if (repositoryInstance == null){
            repositoryInstance = new Repository();
        }
        return repositoryInstance;
//end of modifiable zone..................E/16ab4d42-20dd-4262-9dc7-7bd2403a12cc
    }

    public void updateStock(String newJsonString) {
//begin of modifiable zone................T/30b94964-74bc-44c1-a7d4-c27667a8e127
        try {
            // Use factory, as this is the only way to also include a TypeReference to deserialise into
            // a StockItem, not a LinkedHashMap
            JsonFactory fact = new JsonFactory();
            ObjectReader reader = mapper.readerForUpdating(stockItems);
            stockItems = reader.readValue(fact.createParser(newJsonString), new TypeReference<HashMap<Integer, StockItem>>() { });
        } catch (IOException e) {
            e.printStackTrace();
        }
//end of modifiable zone..................E/30b94964-74bc-44c1-a7d4-c27667a8e127
    }

    public void populateStock(String newJsonString) {
//begin of modifiable zone................T/f826a418-edad-4c90-9e04-cc8f0fdeb44e
        try {
            stockItems = mapper.readValue(newJsonString, new TypeReference<HashMap<Integer, StockItem>>() { });
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
//end of modifiable zone..................E/f826a418-edad-4c90-9e04-cc8f0fdeb44e
    }

    public void populateAdminAccounts(String newJsonString) {
//begin of modifiable zone................T/c811d6f2-b394-4a56-8c05-939a59ee554c
        try {
            adminAccounts = mapper.readValue(newJsonString, new TypeReference<HashMap<String, AdminAccount>>() { });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
//end of modifiable zone..................E/c811d6f2-b394-4a56-8c05-939a59ee554c
    }

    public void updateAdminAccounts(String newJsonString) {
//begin of modifiable zone................T/263e2d93-649b-4e7e-b276-89a2ef51599b
        JsonFactory fact = new JsonFactory();
        ObjectReader reader = mapper.readerForUpdating(adminAccounts);
        try {
            reader.readValue(fact.createParser(newJsonString), new TypeReference<HashMap<String, AdminAccount>>() { });
        } catch (IOException e) {
            e.printStackTrace();
        }
//end of modifiable zone..................E/263e2d93-649b-4e7e-b276-89a2ef51599b
    }

    public void populateStockOrders(String newJsonString) {
//begin of modifiable zone................T/bb75e936-d10f-4150-89b3-589475e7745f
        try {
            stockOrders = mapper.readValue(newJsonString, new TypeReference<HashMap<Integer, StockOrder>>() { });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
//end of modifiable zone..................E/bb75e936-d10f-4150-89b3-589475e7745f
    }

    public void updateStockOrders(String newJsonString) {
//begin of modifiable zone................T/cdd9c35d-7b81-4900-b33f-ea3cb49f87e4
        JsonFactory fact = new JsonFactory();
        ObjectReader reader = mapper.readerForUpdating(stockOrders);
        try {
            reader.readValue(fact.createParser(newJsonString), new TypeReference<HashMap<Integer, StockOrder>>() { });
        } catch (IOException e) {
            e.printStackTrace();
        }
//end of modifiable zone..................E/cdd9c35d-7b81-4900-b33f-ea3cb49f87e4
    }

    public boolean addStockItem(String name, float price, int quantity) {
//begin of modifiable zone................T/dc09a2be-d597-4fdb-8e95-5602e903045d
        boolean success;
        try {
            Integer highestKey = Collections.max(stockItems.keySet());
            StockItem newItem = new StockItem();
            newItem.setItemId(highestKey + 1);
            newItem.setItemName(name);
            newItem.setItemPrice(price);
            newItem.setStockCount(quantity);
            stockItems.put(highestKey + 1, newItem);
            success = true;
        }
        catch (Exception e){
            success = false;
        }
//end of modifiable zone..................E/dc09a2be-d597-4fdb-8e95-5602e903045d
//begin of modifiable zone................T/8614ff85-c99a-4e1d-9c57-21ee14827756
        return success;
//end of modifiable zone..................E/8614ff85-c99a-4e1d-9c57-21ee14827756
    }

    public boolean deleteStockItem(int id) {
//begin of modifiable zone................T/8a3a440e-310f-466a-9a1b-6c86db391e34
        boolean success;
        try {
            stockItems.remove(id);
            success = true;
        }
        catch (Exception e){
            success = false;
        }
//end of modifiable zone..................E/8a3a440e-310f-466a-9a1b-6c86db391e34
//begin of modifiable zone................T/358dfe4b-5c5f-4758-8207-3eacb526167d
        return success;
//end of modifiable zone..................E/358dfe4b-5c5f-4758-8207-3eacb526167d
    }

    public boolean editStockItem(int id, String name, float price, int quantity) {
//begin of modifiable zone................T/5e53f2ae-b161-4336-9257-2fda81c56390
        boolean success;
        try {
            StockItem itemToEdit = stockItems.get(id);
            if (name != null){
                itemToEdit.setItemName(name);
            }
            if (!Float.valueOf(price).equals(null)){
                itemToEdit.setItemPrice(price);
            }
            if (Integer.valueOf(quantity) != null){
                itemToEdit.setStockCount(quantity);
            }
            success = true;
        } catch (Exception e){
            success = false;
        }
//end of modifiable zone..................E/5e53f2ae-b161-4336-9257-2fda81c56390
//begin of modifiable zone................T/e6ee97cc-eb41-44df-964f-ebd191f794d6
        return success;
//end of modifiable zone..................E/e6ee97cc-eb41-44df-964f-ebd191f794d6
    }

    public boolean decrementBoughtItem(int id) {
//begin of modifiable zone................T/9678be3e-af75-46db-95de-0e3fb1e60ca7
        boolean success;
        try {
            StockItem itemToDecrement = stockItems.get(id);
            itemToDecrement.setStockCount(itemToDecrement.getStockCount() - 1);
            success = true;
        } catch (Exception e){
            success = false;
        }
//end of modifiable zone..................E/9678be3e-af75-46db-95de-0e3fb1e60ca7
//begin of modifiable zone................T/6158e4b8-8317-470a-bdea-593458ef85d6
        return success;
//end of modifiable zone..................E/6158e4b8-8317-470a-bdea-593458ef85d6
    }

    public boolean login(String username, String password) {
//begin of modifiable zone................T/bf503382-e918-4e32-84b7-b4e4e3c042a4
        boolean validCredentials;
        try {
            AdminAccount accountToCheck = adminAccounts.get(username);
            if (accountToCheck.getPassword().equals(password)){
                validCredentials = true;
            }
            else {
                validCredentials = false;
            }
        } catch (Exception e){
            validCredentials = false;
        }
//end of modifiable zone..................E/bf503382-e918-4e32-84b7-b4e4e3c042a4
//begin of modifiable zone................T/6832c0f5-1289-44ac-a0ca-3591ae9c33e8
        return validCredentials;
//end of modifiable zone..................E/6832c0f5-1289-44ac-a0ca-3591ae9c33e8
    }

    public boolean createStockOrder(int itemId, int quantity) {
//begin of modifiable zone................T/493dc76b-defd-4ff8-8340-7cc63cc01307
        boolean success;
        try {
            Integer highestKey = Collections.max(stockOrders.keySet());
            StockOrder newOrder = new StockOrder();
            newOrder.setOrderId(highestKey + 1);
            newOrder.setStockItemId(itemId);
            newOrder.setQuantity(quantity);
            stockOrders.put(highestKey + 1, newOrder);
            success = true;
        } catch (Exception e){
            success = false;
        }
//end of modifiable zone..................E/493dc76b-defd-4ff8-8340-7cc63cc01307
//begin of modifiable zone................T/76364ef5-8254-4b00-8976-325bf9a16b84
        return success;
//end of modifiable zone..................E/76364ef5-8254-4b00-8976-325bf9a16b84
    }

    public boolean fulfillStockOrder(int orderId) {
//begin of modifiable zone................T/d7890b79-0294-4668-87ef-97574377ff39
        boolean success;
        try {
            StockOrder orderToFulfill = stockOrders.get(orderId);
            StockItem itemToReplenish = stockItems.get(orderToFulfill.getStockItemId());
            itemToReplenish.setStockCount(itemToReplenish.getStockCount() + orderToFulfill.getQuantity());
            success = true;
        } catch (Exception e){
            success = false;
        }
//end of modifiable zone..................E/d7890b79-0294-4668-87ef-97574377ff39
//begin of modifiable zone................T/cd57305a-1277-4150-a71f-2ff88908e2c8
        return success;
//end of modifiable zone..................E/cd57305a-1277-4150-a71f-2ff88908e2c8
    }

}
