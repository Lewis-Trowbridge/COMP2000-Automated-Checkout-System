package com.autochecksys.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SaveChangesWorker implements Runnable {
    public ObjectMapper mapper;

    public SaveChangesWorker(ObjectMapper mapper) {
//begin of modifiable zone(JavaSuper).....C/340670a6-c4f7-479b-9134-9a7dabce5258

//end of modifiable zone(JavaSuper).......E/340670a6-c4f7-479b-9134-9a7dabce5258
//begin of modifiable zone................T/aa1fa899-ccbc-4533-b240-a8d549c8ab62
        this.mapper = mapper;
//end of modifiable zone..................E/aa1fa899-ccbc-4533-b240-a8d549c8ab62
    }

    @Override
    public void run() {
//begin of modifiable zone................T/d05b7ab8-5b59-4227-83e4-0675f92511eb
        // Write all three collections to JSON files using the provided ObjectMapper and file access classes from
        // the service locator.
        try {
            FileAccessServiceLocator.getStockFileAccess().write(mapper.writeValueAsString(Repository.getRepositoryInstance().stockItems));
            FileAccessServiceLocator.getAdminAccountFileAccess().write(mapper.writeValueAsString(Repository.getRepositoryInstance().adminAccounts));
            FileAccessServiceLocator.getStockOrderFileAccess().write(mapper.writeValueAsString(Repository.getRepositoryInstance().stockOrders));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
//end of modifiable zone..................E/d05b7ab8-5b59-4227-83e4-0675f92511eb
    }

}
