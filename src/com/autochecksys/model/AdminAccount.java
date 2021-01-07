package com.autochecksys.model;

import java.util.ArrayList;
import java.util.List;
import com.autochecksys.KeyValuePair;
import com.autochecksys.controller.shared.AbstractController;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AdminAccount implements IAutoCheckSysModel {
    private String username;

    private String password;

    @JsonIgnore
    private List<AbstractController> observers = new ArrayList<AbstractController> ();

    @JsonProperty("username")
    public String getUsername() {
//begin of modifiable zone................T/22bcda17-24fb-40d2-b525-a340adbb0ca7
        // Automatically generated method. Please delete this comment before entering specific code.
//end of modifiable zone..................E/22bcda17-24fb-40d2-b525-a340adbb0ca7
//begin of modifiable zone................T/c2f1f2f5-ad76-4780-8f82-214faaa92500
        return this.username;
//end of modifiable zone..................E/c2f1f2f5-ad76-4780-8f82-214faaa92500
    }

    public void setUsername(String value) {
//begin of modifiable zone................T/f092e88f-64c6-4fbb-9d56-c1dc7a58386f
        this.username = value;
        onPropertyChanged(new KeyValuePair(AbstractController.ADMIN_USERNAME, value, -1));
//end of modifiable zone..................E/f092e88f-64c6-4fbb-9d56-c1dc7a58386f
    }

    @JsonProperty("password")
    public String getPassword() {
//begin of modifiable zone................T/ea5ecd07-8c43-4f47-bbcd-dd63c5d41a32
        // Automatically generated method. Please delete this comment before entering specific code.
//end of modifiable zone..................E/ea5ecd07-8c43-4f47-bbcd-dd63c5d41a32
//begin of modifiable zone................T/7dbba08e-b20d-4f99-9073-46789766de95
        return this.password;
//end of modifiable zone..................E/7dbba08e-b20d-4f99-9073-46789766de95
    }

    public void setPassword(String value) {
//begin of modifiable zone................T/1716b155-37f5-4770-8fbb-e116a25e6be7
        // Automatically generated method. Please delete this comment before entering specific code.
        this.password = value;
        onPropertyChanged(new KeyValuePair(AbstractController.ADMIN_PASSWORD, value, -1));
//end of modifiable zone..................E/1716b155-37f5-4770-8fbb-e116a25e6be7
    }

    public void add(AbstractController observer) {
//begin of modifiable zone................T/64cdec6c-b0bf-48ab-92b7-1e496541c6f3
        this.observers.add(observer);
//end of modifiable zone..................E/64cdec6c-b0bf-48ab-92b7-1e496541c6f3
    }

    public void remove(AbstractController observer) {
//begin of modifiable zone................T/868b62ca-f6d0-494c-bc60-4f6fc02a586b
        this.observers.remove(observer);
//end of modifiable zone..................E/868b62ca-f6d0-494c-bc60-4f6fc02a586b
    }

    public void onPropertyChanged(KeyValuePair change) {
//begin of modifiable zone................T/cdc390e5-d435-4fa3-ab21-f795bb97efda
        for (AbstractController observer: observers) {
            observer.updateView(change);
        }
//end of modifiable zone..................E/cdc390e5-d435-4fa3-ab21-f795bb97efda
    }

}
