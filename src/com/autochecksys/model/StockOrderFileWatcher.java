package com.autochecksys.model;


public class StockOrderFileWatcher implements IJsonFileWatcher, Runnable {
    public String currentContent;

    @Override
    public void notify(String newFileContent) {
//begin of modifiable zone(JavaCode)......C/089fad9e-a8a9-43f0-a9d9-edd6455180fc

//end of modifiable zone(JavaCode)........E/089fad9e-a8a9-43f0-a9d9-edd6455180fc
    }

    @Override
    public void run() {
//begin of modifiable zone(JavaCode)......C/1d2124bd-fcd9-4d38-b44d-eb44881c00b8
        currentContent = FileAccessServiceLocator.getStockOrderFileAccess().read();
        while (true) {
            String newlyReadContent = FileAccessServiceLocator.getStockOrderFileAccess().read();
            if (!newlyReadContent.equals(currentContent)){
                notify(newlyReadContent);
                currentContent = newlyReadContent;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//end of modifiable zone(JavaCode)........E/1d2124bd-fcd9-4d38-b44d-eb44881c00b8
    }

}
