package com.addressbook;

public interface IAddressBook {
    public String createFile(String fileName) throws AddressBookExceptions;
    public String deleteFile(String fileName);
    public AddressDetails addDetails(String firstName, String lastName, String address, String city,String state, String zipcode,String fileName) throws AddressBookExceptions;
    public String deleteDetails(String toChange, String fileName) throws AddressBookExceptions;
    public boolean editDetails(String fieldName,String state,String city,String zipcode, String fileName) throws AddressBookExceptions;
    public boolean sort(String filedToSortBy, String fileName);
}
