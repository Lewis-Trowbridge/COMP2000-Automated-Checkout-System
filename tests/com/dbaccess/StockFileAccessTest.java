package com.dbaccess;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class StockFileAccessTest {

    String fakeContent = "{\"test\": \"this\"}";
    String realContent;

    @Before
    public void setUp() throws Exception {
        // A bad implementation, but an implementation nonetheless
        File tempFile = new File("./resources/stock.json");
        BufferedReader reader = new BufferedReader(new FileReader(tempFile));
        char[] tempArray = new char[(int)tempFile.length()];
        reader.read(tempArray);
        realContent = new String(tempArray);
        reader.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        writer.write(fakeContent);
        writer.close();

    }

    @Test
    public void readMatchesFake() {
        String testContent = StockFileAccess.getInstance().read();
        assertEquals(testContent, fakeContent);
    }

    @Test
    public void writeMatchesTest() {
        String testString = "{\"write\": \"test\"}";
        StockFileAccess.getInstance().write(testString);
        File testFile = new File("./resources/stock.json");
        char[] contentArray = new char[(int)testFile.length()];
        try {
            FileReader reader = new FileReader(testFile);
            reader.read(contentArray);
            String writeString = new String(contentArray);
            reader.close();
            assertEquals(testString, writeString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {
        // Set the file back to its original content
        File tempFile = new File("./resources/stock.json");
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        writer.write(realContent);
        writer.close();
    }
}