package com.autochecksys.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

public class Repository {
    private static Repository repositoryInstance;

    private final ObjectMapper mapper;

    public Map<Integer, StockItem> stockItems = new HashMap<Integer, StockItem> ();

    private Repository() {
//begin of modifiable zone................T/97abe80b-b10a-4b04-927e-85c05783e1f6
mapper = new ObjectMapper();
populateStock(StockFileAccess.getInstance().read());
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

}
