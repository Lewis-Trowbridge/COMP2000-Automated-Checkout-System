package com.autochecksys.dbaccess;

public class StockFileWatcher implements IJsonFileWatcher, Runnable {
    private String currentContent;

    public void notify(String newFileContent) {
//begin of modifiable zone................T/383c71b7-c848-48af-9522-f733adf1206d
        Repository.getRepositoryInstance().updateStock(newFileContent);
//end of modifiable zone..................E/383c71b7-c848-48af-9522-f733adf1206d
    }

    public void run() {
//begin of modifiable zone................T/eb2216a2-29fc-4354-9b1b-027594d28074
        while (true) {
            String newlyReadContent = StockFileAccess.getInstance().read();
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
//end of modifiable zone..................E/eb2216a2-29fc-4354-9b1b-027594d28074
    }

}
