package com.addressbook;

public interface IAddressBook {
    public String createFile(String fileName);
    public String deleteFile(String fileName);
    public AddressDetails add(String firstName, String lastName, String address, String city, String state, String zipcode);
    //public String isFilePresentOrNot(String filePath,String FileName);
}
