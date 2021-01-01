package com.autochecksys.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class RepositoryTest {

    @Test
    public void singletonSingleInstance(){
        assertEquals(Repository.getRepositoryInstance(), Repository.getRepositoryInstance());
    }

    @Test
    public void updateDoesNotCreateNewObject(){
        String jsonString = StockFileAccess.getInstance().read();
        StockItem oldItem = Repository.getRepositoryInstance().stockItems.get(1);
        Repository.getRepositoryInstance().updateStock(jsonString);
        assertSame(oldItem, Repository.getRepositoryInstance().stockItems.get(1));
    }

    @Test
    public void populateCreatesNewObject(){
        String jsonString = StockFileAccess.getInstance().read();
        StockItem oldItem = Repository.getRepositoryInstance().stockItems.get(1);
        Repository.getRepositoryInstance().populateStock(jsonString);
        assertNotSame(oldItem, Repository.getRepositoryInstance().stockItems.get(1));
    }
}