package com.autochecksys.dbaccess;


public interface IFileAccess {
    String read();

    void write(String newContent);

}
