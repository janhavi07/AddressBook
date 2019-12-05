package com.addressbook;

import java.io.File;
import java.io.IOException;

public class AddressBook implements IAddressBook {
    private static final String FILE_PATH="/home/admin293/Desktop/AddressBook/AddressBooks";
    @Override
    public void add() {

    }

    @Override
    public void edit() {

    }

    @Override
    public void sort() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void display() {

    }
    public String isFilePresentOrNot(String filePath,String FileName){
        String fullpath=filePath+FileName;
        File file=new File(fullpath);
        if(file.exists()) {
            return "FILE-PRESENT";
        } else
            return "FILE-NOTPRESENT";

    }
}
