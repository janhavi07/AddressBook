package com.addressbook;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook implements IAddressBook {
    Scanner s=new Scanner(System.in);
    private static final String FILE_PATH="/home/admin293/Desktop/AddressBook/AddressBooks/";
    AddressDetails personDetails=new AddressDetails();
    ArrayList<AddressDetails> personBookList=new ArrayList<>();


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

    @Override
    public AddressDetails add(String firstName, String lastName, String address, String city, String state, String zipcode) {
        AddressDetails personDetails=new AddressDetails(firstName,lastName,address,city,state,zipcode );
        return personDetails;
    }

    private void writeToGson(ArrayList<AddressDetails> personBookList,String fileName) {
        String finalFileName=FILE_PATH+fileName;
        Gson gson=new Gson();
        String json=gson.toJson(personBookList);
        FileWriter writer= null;
        try {
            writer = new FileWriter(finalFileName);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
