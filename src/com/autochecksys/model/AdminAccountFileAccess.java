package com.autochecksys.model;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AdminAccountFileAccess implements IFileAccess {
    @Override
    public String read() {
//begin of modifiable zone(JavaCode)......C/fc647aae-6fe1-4f0d-9199-a1a6377e2936
        File stockFile = new File("./resources/admins.json");
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
//end of modifiable zone(JavaCode)........E/fc647aae-6fe1-4f0d-9199-a1a6377e2936
//begin of modifiable zone(JavaReturned)..C/fc647aae-6fe1-4f0d-9199-a1a6377e2936

//end of modifiable zone(JavaReturned)....E/fc647aae-6fe1-4f0d-9199-a1a6377e2936

    @Override
    public void write(String newContent) {
//begin of modifiable zone(JavaCode)......C/314ac87c-885d-4e2e-958c-815989f8bd5f
        File stockFile = new File("./resources/admins.json");
        try {
            FileWriter writer = new FileWriter(stockFile);
            writer.write(newContent);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//end of modifiable zone(JavaCode)........E/314ac87c-885d-4e2e-958c-815989f8bd5f
    }

}
