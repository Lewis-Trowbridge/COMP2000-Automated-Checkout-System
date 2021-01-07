package com.autochecksys.model;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StockOrderFileAccess implements IFileAccess {
    @Override
    public String read() {
//begin of modifiable zone(JavaCode)......C/1eb5de08-b719-4152-83c9-aa15dd85a0a2
        File orderFile = new File("./resources/orders.json");
        char[] contentArray = new char[(int) orderFile.length()];
        try {
            FileReader reader = new FileReader(orderFile);
            reader.read(contentArray);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(contentArray);
    }
//end of modifiable zone(JavaCode)........E/1eb5de08-b719-4152-83c9-aa15dd85a0a2
//begin of modifiable zone(JavaReturned)..C/1eb5de08-b719-4152-83c9-aa15dd85a0a2

//end of modifiable zone(JavaReturned)....E/1eb5de08-b719-4152-83c9-aa15dd85a0a2

    @Override
    public void write(String newContent) {
//begin of modifiable zone(JavaCode)......C/e0fd25c8-6c3c-4867-a0a9-46a330d7763c
        File ordersFile = new File("./resources/orders.json");
        try {
            FileWriter writer = new FileWriter(ordersFile);
            writer.write(newContent);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//end of modifiable zone(JavaCode)........E/e0fd25c8-6c3c-4867-a0a9-46a330d7763c
    }

}
