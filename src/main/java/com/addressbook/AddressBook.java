package com.addressbook;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;

public class AddressBook implements IAddressBook {
    Scanner s = new Scanner(System.in);
    ObjectMapper mapper=new ObjectMapper();
    private static final String FILE_PATH = "/home/admin293/Desktop/AddressBook/AddressBooks/";
    AddressDetails personDetails = new AddressDetails();
    List<AddressDetails> personBookList ;

    @Override
    public String createFile(String fileName) {
        String finalFileName = FILE_PATH + fileName;
        File file = new File(finalFileName);
        try {
            Boolean isCreatedOrNot = file.createNewFile();
            if (isCreatedOrNot)
                return "File Created";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Not created";
    }

    public String isFilePresentOrNot(String filePath, String FileName) {
        String finalFileName = FILE_PATH + FileName;
        File file = new File(finalFileName);
        if (file.exists()) {
            return "FILE-PRESENT";
        } else
            return "FILE-NOT-PRESENT";

    }

    @Override
    public String deleteFile(String fileName) {
        String finalFileName = FILE_PATH + fileName;
        File file = new File(finalFileName);
        if (file.delete())
            return "File-Deleted";
        else
            return "Not-Deleted";
    }

    @Override
    public AddressDetails addDetails(String firstName, String lastName, String address, String city,
                                     String state, String zipcode, String fileName) {

        String finalFileName=FILE_PATH+fileName;
        List<AddressDetails> personBookList= readFromFile(finalFileName);
        AddressDetails personDetails = new AddressDetails(firstName, lastName, address, city, state, zipcode);
        personBookList.add(personDetails);
        writeToFile(personBookList,finalFileName);

        return personDetails;
    }

    @Override
    public String deleteDetails(String record, String fileName) {
        String finalFileName=FILE_PATH+fileName;
        List<AddressDetails> list=readFromFile(finalFileName);
        List<AddressDetails> temporaryList=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(!record.equals(list.get(i).getFirstName()))
                temporaryList.add(list.get(i));
        }
        writeToFile(temporaryList,finalFileName);
        return "Removed";

    }

    public void writeToFile(List<AddressDetails> personBookList, String fileName){
        File file=new File(fileName);
        try {
            mapper.writeValue(file,personBookList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<AddressDetails> readFromFile(String fileName){
        File file=new File(fileName);
        List<AddressDetails> list= null;
        try {
            list = new ArrayList(Arrays.asList(mapper.readValue(file, AddressDetails[].class)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;

    }
}
