package com.dbaccess;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Repository {
    private static Repository repositoryInstance;

    private Repository() {
//begin of modifiable zone(JavaSuper).....C/190b61f6-ae29-4a9a-9053-baf0f262fe57

//end of modifiable zone(JavaSuper).......E/190b61f6-ae29-4a9a-9053-baf0f262fe57
//begin of modifiable zone(JavaCode)......C/190b61f6-ae29-4a9a-9053-baf0f262fe57

//end of modifiable zone(JavaCode)........E/190b61f6-ae29-4a9a-9053-baf0f262fe57
    }

    public static Repository getRepositoryInstance() {
//begin of modifiable zone................T/a5b7573e-ec82-4f8a-a475-f37ea927c07d
        // Automatically generated method. Please delete this comment before entering specific code.
//end of modifiable zone..................E/a5b7573e-ec82-4f8a-a475-f37ea927c07d
//begin of modifiable zone................T/16ab4d42-20dd-4262-9dc7-7bd2403a12cc
        if (repositoryInstance == null){
            repositoryInstance = new Repository();
        }
        return repositoryInstance;
//end of modifiable zone..................E/16ab4d42-20dd-4262-9dc7-7bd2403a12cc
    }

}
