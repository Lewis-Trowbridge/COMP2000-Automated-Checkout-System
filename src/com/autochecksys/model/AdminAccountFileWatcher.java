package com.autochecksys.model;


public class AdminAccountFileWatcher implements IJsonFileWatcher, Runnable {
    public String currentContent;

    @Override
    public void notify(String newFileContent) {
//begin of modifiable zone(JavaCode)......C/974a2228-fada-431f-9be4-86fa268bef66
        Repository.getRepositoryInstance().updateAdminAccounts(newFileContent);
//end of modifiable zone(JavaCode)........E/974a2228-fada-431f-9be4-86fa268bef66
    }

    @Override
    public void run() {
//begin of modifiable zone(JavaCode)......C/443a0510-bcbb-4fea-a45b-c4b31dde8b0a
        currentContent = FileAccessServiceLocator.getAdminAccountFileAccess().read();
        while (true) {
            String newlyReadContent = FileAccessServiceLocator.getAdminAccountFileAccess().read();
            if (!newlyReadContent.equals(currentContent) || !newlyReadContent.isEmpty()){
                notify(newlyReadContent);
                currentContent = newlyReadContent;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//end of modifiable zone(JavaCode)........E/443a0510-bcbb-4fea-a45b-c4b31dde8b0a
    }

}
