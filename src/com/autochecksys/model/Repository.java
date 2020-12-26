package com.autochecksys.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

public class Repository {
    private static Repository repositoryInstance;

    private final ObjectMapper mapper;

    public List<StockItem> stockItems = new ArrayList<StockItem> ();

    private Repository() {
//begin of modifiable zone................T/97abe80b-b10a-4b04-927e-85c05783e1f6
mapper = new ObjectMapper();
populateStock(StockFileAccess.getInstance().read());

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
        ObjectReader reader = mapper.readerForUpdating(stockItems);
        try {
            reader.readValue(newJsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
//end of modifiable zone..................E/30b94964-74bc-44c1-a7d4-c27667a8e127
    }

    public void populateStock(String newJsonString) {
//begin of modifiable zone(JavaCode)......C/3df696fb-e145-4493-9e08-4c6f9551d2bd
        try {
            stockItems = mapper.readValue(newJsonString, new TypeReference<List<StockItem>>() { });
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
//end of modifiable zone(JavaCode)........E/3df696fb-e145-4493-9e08-4c6f9551d2bd
    }

}
