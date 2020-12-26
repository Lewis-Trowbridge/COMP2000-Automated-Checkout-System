package com.autochecksys.model;

import com.autochecksys.KeyValuePair;
import com.autochecksys.controller.shared.AbstractController;

public interface IAutoCheckSysModel {
    void add(AbstractController observer);

    void remove(AbstractController observer);

    void onPropertyChanged(KeyValuePair change);

}
