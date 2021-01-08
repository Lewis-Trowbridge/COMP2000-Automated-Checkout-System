package com.autochecksys.model;


public class StockOrderFileWatcher implements IJsonFileWatcher, Runnable {
    public String currentContent;

    @Override
    public void notify(String newFileContent) {
//begin of modifiable zone................T/a170c128-ca49-4fc4-abdd-43b714481007
        Repository.getRepositoryInstance().updateStockOrders(newFileContent);
//end of modifiable zone..................E/a170c128-ca49-4fc4-abdd-43b714481007
    }

    @Override
    public void run() {
//begin of modifiable zone................T/bfb5c4c0-88e6-44fa-9add-89d5b4394004
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
//end of modifiable zone..................E/bfb5c4c0-88e6-44fa-9add-89d5b4394004
    }

}
