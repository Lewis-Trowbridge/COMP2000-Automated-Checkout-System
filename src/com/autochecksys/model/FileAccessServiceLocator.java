package com.autochecksys.model;


public class FileAccessServiceLocator {
    private static FileAccessServiceLocator instance;

    private static StockFileAccess stockFileAccess;

    private static AdminAccountFileAccess adminAccountFileAccess;

    private static StockOrderFileAccess stockOrderFileAccess;

    private static FileAccessServiceLocator getInstance() {
//begin of modifiable zone................T/c263d714-0fca-4fe6-80a7-e6f2a3ff4708
        if (instance == null) {
            instance = new FileAccessServiceLocator();
        }
        return instance;
//end of modifiable zone..................E/c263d714-0fca-4fe6-80a7-e6f2a3ff4708
//begin of modifiable zone................T/d77c5756-142a-4575-8609-4fe9de556da2
//end of modifiable zone..................E/d77c5756-142a-4575-8609-4fe9de556da2
    }

    private FileAccessServiceLocator() {
//begin of modifiable zone(JavaSuper).....C/9362da55-f403-417f-84b0-19802bf5dad9

//end of modifiable zone(JavaSuper).......E/9362da55-f403-417f-84b0-19802bf5dad9
//begin of modifiable zone(JavaCode)......C/9362da55-f403-417f-84b0-19802bf5dad9
        stockFileAccess = new StockFileAccess();
        adminAccountFileAccess = new AdminAccountFileAccess();
        stockOrderFileAccess = new StockOrderFileAccess();
//end of modifiable zone(JavaCode)........E/9362da55-f403-417f-84b0-19802bf5dad9
    }

    public static StockFileAccess getStockFileAccess() {
//begin of modifiable zone................T/b31343e2-6879-4638-9306-53af5465919e
        // Automatically generated method. Please delete this comment before entering specific code.
//end of modifiable zone..................E/b31343e2-6879-4638-9306-53af5465919e
//begin of modifiable zone................T/37d4f1cb-02aa-4d24-8850-719fe834a6db
        return stockFileAccess;
//end of modifiable zone..................E/37d4f1cb-02aa-4d24-8850-719fe834a6db
    }

    public static AdminAccountFileAccess getAdminAccountFileAccess() {
//begin of modifiable zone................T/d8000f72-9823-420d-bc74-46c9e51ae8cf
        // Automatically generated method. Please delete this comment before entering specific code.
//end of modifiable zone..................E/d8000f72-9823-420d-bc74-46c9e51ae8cf
//begin of modifiable zone................T/c9d78757-e3a2-47db-a146-fb565edcd078
        return adminAccountFileAccess;
//end of modifiable zone..................E/c9d78757-e3a2-47db-a146-fb565edcd078
    }

    public static StockOrderFileAccess getStockOrderFileAccess() {
//begin of modifiable zone................T/cb7f0391-58d7-4987-acec-e4d250d64186
        // Automatically generated method. Please delete this comment before entering specific code.
//end of modifiable zone..................E/cb7f0391-58d7-4987-acec-e4d250d64186
//begin of modifiable zone................T/50fcdec5-1db9-4f5c-8de0-7894a067d35e
        return stockOrderFileAccess;
//end of modifiable zone..................E/50fcdec5-1db9-4f5c-8de0-7894a067d35e
    }

}
