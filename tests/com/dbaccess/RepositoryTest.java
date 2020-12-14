package com.dbaccess;

import org.junit.Test;

import static org.junit.Assert.*;

public class RepositoryTest {

    @Test
    public void singletonSingleInstance(){
        assertEquals(Repository.getRepositoryInstance(), Repository.getRepositoryInstance());
    }
}