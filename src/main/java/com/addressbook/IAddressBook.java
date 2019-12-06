package com.addressbook;

public interface IAddressBook {
    public String createFile(String fileName);
    public String deleteFile(String fileName);
    public AddressDetails addDetails(String firstName, String lastName, String address, String city,
                                     String state, String zipcode,String fileName);
}
