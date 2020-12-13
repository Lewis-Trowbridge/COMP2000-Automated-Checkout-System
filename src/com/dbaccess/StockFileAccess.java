package com.dbaccess;


import java.io.*;

public class StockFileAccess implements IFileAccess {
    private static StockFileAccess instance;

    @Override
    public synchronized String read() {
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
    public synchronized void write(String newContent) {
//begin of modifiable zone(JavaCode)......C/02427273-e11c-4c08-a0de-38f6ea53f916
        File stockFile = new File("./resources/stock.json");
        try {
            FileWriter writer = new FileWriter(stockFile);
            writer.write(newContent);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//end of modifiable zone(JavaCode)........E/02427273-e11c-4c08-a0de-38f6ea53f916
    }

    private StockFileAccess() {
//begin of modifiable zone(JavaSuper).....C/7440b36a-b7fe-48c6-955d-467fae230a64

//end of modifiable zone(JavaSuper).......E/7440b36a-b7fe-48c6-955d-467fae230a64
//begin of modifiable zone(JavaCode)......C/7440b36a-b7fe-48c6-955d-467fae230a64

//end of modifiable zone(JavaCode)........E/7440b36a-b7fe-48c6-955d-467fae230a64
    }

    public static StockFileAccess getInstance() {
//begin of modifiable zone................T/d76b55d3-8e9a-49ca-8c6a-48142ea6090b
        if (instance == null){
            instance = new StockFileAccess();
        }
//end of modifiable zone..................E/d76b55d3-8e9a-49ca-8c6a-48142ea6090b
//begin of modifiable zone................T/f7a27447-fb03-4feb-87f8-b7be7654d204
        return instance;
//end of modifiable zone..................E/f7a27447-fb03-4feb-87f8-b7be7654d204
    }

}
