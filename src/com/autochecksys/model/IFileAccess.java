package com.autochecksys.model;


public interface IFileAccess {
    String read();

    void write(String newContent);

}
