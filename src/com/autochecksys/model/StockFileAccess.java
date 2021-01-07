package com.autochecksys.model;

import java.io.*;

public class StockFileAccess implements IFileAccess {
    @Override
    public String read() {
//begin of modifiable zone(JavaCode)......C/cf678d81-e7bd-487d-9c8f-c00c7a5b2c49

//end of modifiable zone(JavaCode)........E/cf678d81-e7bd-487d-9c8f-c00c7a5b2c49
//begin of modifiable zone................T/a6513b9b-46a5-4c8c-a7c0-8f16473cc6eb
        File stockFile = new File("./resources/stock.json");
        char[] contentArray = new char[(int) stockFile.length()];
        try {
            FileReader reader = new FileReader(stockFile);
            reader.read(contentArray);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(contentArray);
    }
//end of modifiable zone..................E/a6513b9b-46a5-4c8c-a7c0-8f16473cc6eb

    @Override
    public void write(String newContent) {
//begin of modifiable zone................T/100e8a54-28e5-44b1-ae2c-491d864e6ff0
        File stockFile = new File("./resources/stock.json");
        try {
            FileWriter writer = new FileWriter(stockFile);
            writer.write(newContent);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//end of modifiable zone..................E/100e8a54-28e5-44b1-ae2c-491d864e6ff0
    }

}
