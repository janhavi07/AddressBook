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
        File file=new File(FILE_PATH);
        try {
            if(file.createNewFile())
                return "FILE-NOTPRESENT";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "FILE-PRESENT";
    }
}
