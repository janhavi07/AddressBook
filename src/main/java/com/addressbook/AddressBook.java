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
    public void add(String fileName) {
        System.out.println("Enter the details");
        System.out.println("Enter your FirstName");
        personDetails.setFirstName(s.nextLine());
        System.out.println("Enter your LastName");
        personDetails.setLastName(s.nextLine());
        System.out.println("Enter your Address");
        personDetails.setAddress(s.nextLine());
        System.out.println("Enter your City");
        personDetails.setCity(s.nextLine());
        System.out.println("Enter your State");
        personDetails.setState(s.nextLine());
        System.out.println("Enter your ZipCode");
        personDetails.setZip(s.nextDouble());
        personBookList.add(personDetails);
        System.out.println(personDetails.toString());
        writeToGson(personBookList,fileName);
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
