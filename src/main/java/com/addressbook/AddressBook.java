package com.addressbook;

import java.io.File;
import java.io.IOException;

public class AddressBook implements IAddressBook {
    private static final String FILE_PATH="/home/admin293/Desktop/AddressBook/AddressBooks/";


    @Override
    public String createFile(String fileName) {
        String finalFileName=FILE_PATH+fileName;
        File file=new File(finalFileName);
        try {
            Boolean isCreatedOrNot=file.createNewFile();
            if(isCreatedOrNot)
                return "File Created";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Not created";
    }

    public String isFilePresentOrNot(String filePath,String FileName){
        String finalFileName=FILE_PATH+FileName;
        File file=new File(finalFileName);
        if(file.exists()) {
            return "FILE-PRESENT";
        } else
            return "FILE-NOT-PRESENT";

    }

    public String deleteFile(String fileName) {
        String finalFileName=FILE_PATH+fileName;
        File file=new File(finalFileName);
        if(file.delete())
            return "File-Deleted";
        else
            return "Not-Deleted";
    }
}
