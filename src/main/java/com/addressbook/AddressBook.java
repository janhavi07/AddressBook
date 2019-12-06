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

    @Override
    public boolean editDetails(String fieldName,String state,String city,String zipcode, String fileName) {
        String finalFileName = FILE_PATH + fileName;
        List<AddressDetails> personBookList = readFromFile(finalFileName);
        for (int i = 0; i < personBookList.size(); i++) {
            if (fieldName.equals(personBookList.get(i).getFirstName())) {
                personBookList.get(i).setState(state);
                personBookList.get(i).setCity(city);
                personBookList.get(i).setZip(zipcode);
                writeToFile(personBookList, finalFileName);
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean sort(String fieldToSortBy, String fileName) {
        String finalFileName = FILE_PATH + fileName;
        List<AddressDetails> personBookList = readFromFile(finalFileName);
        for (int i = 0; i < personBookList.size(); i++) {
            for (int j = i + 1; j < personBookList.size(); j++) {
                if (fieldToSortBy.equals("Name")) {
                    if (personBookList.get(i).getFirstName().compareTo(personBookList.get(j).getFirstName()) > 0) {
                        swapping(personBookList, i, j);
                    }
                } else if (fieldToSortBy.equals("City")) {
                    if (personBookList.get(i).getCity().compareTo(personBookList.get(j).getCity()) > 0) {
                        swapping(personBookList, i, j);
                    }

                } else if (fieldToSortBy.equals("State")) {
                    if (personBookList.get(i).getState().compareTo(personBookList.get(j).getState()) > 0) {
                        swapping(personBookList, i, j);
                    }

                } else if (fieldToSortBy.equals("Zip")) {
                    if (personBookList.get(i).getZip().compareTo(personBookList.get(j).getZip()) > 0) {
                        swapping(personBookList, i, j);
                    }
                }
            }
        }
        writeToFile(personBookList, finalFileName);
        return true;
    }

    private void swapping(List<AddressDetails> personBookList, int i, int j) {
        AddressDetails tempDetail1= personBookList.get(i);
        AddressDetails tempDetail2=personBookList.get(j);
        personBookList.set(i,tempDetail2);
        personBookList.set(j,tempDetail1);
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
        List<AddressDetails> personBookList= null;
        try {
            personBookList = new ArrayList(Arrays.asList(mapper.readValue(file, AddressDetails[].class)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personBookList;

    }
}
