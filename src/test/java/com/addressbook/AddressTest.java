package com.addressbook;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class AddressTest {
    private static final String FILE_PATH = "/home/admin293/Desktop/AddressBook/AddressBooks/";
    IAddressBook iaddressBook = new AddressBook();
    AddressBook addressBook = new AddressBook();
    ArrayList<AddressDetails> personBookList = new ArrayList<>();
    AddressDetails details = new AddressDetails();


    @Test
    public void toCheckIf_AddressDetails_areInitialised() {
        AddressDetails details = new AddressDetails("Janhavi", "Parte", "FriendsColony",
                "Mumbai", "Maharashtra", "400042");
        String name = details.getFirstName();
        Assert.assertEquals("Janhavi", name);
    }


    @Test
    public void ifFileDoesNotExists_thenReturn_NotPresent() {
        String isIt = addressBook.isFilePresentOrNot(FILE_PATH, "book.json");
        Assert.assertEquals("FILE-NOT-PRESENT", isIt);
    }

    @Test
    public void ifFileDoesExists_thenReturn_Present() {
        String isIt = addressBook.isFilePresentOrNot(FILE_PATH, "book1.json");
        Assert.assertEquals("FILE-PRESENT", isIt);
    }

    @Test
    public void To_createA_File_ShouldReturn_FileCreated() {
        String isIt = iaddressBook.createFile("book2.json");
        Assert.assertEquals("File Created", isIt);
    }

    @Test
    public void to_DeleteAFile_ShouldReturn_FileDeleted() {
        String isIt = iaddressBook.deleteFile("book2.json");
        Assert.assertEquals("File-Deleted", isIt);
    }

    @Test
    public void ifIncorrectFileName_to_DeleteAFile_ShouldReturn_FileNotDeleted() {
        String isIt = iaddressBook.deleteFile("book3.json");
        Assert.assertEquals("Not-Deleted", isIt);
    }

    @Test
    public void toCheckDetails_Added_in_PersonDetails() {
        AddressDetails details = iaddressBook.addDetails("Janhavi", "Parte", "FriendsColony",
                "Mumbai", "Maharashtra", "400042", "book1.json");
        Assert.assertEquals("Janhavi", details.getFirstName());
    }

    @Test
    public void toCheckIf_AddressDetails_AreWrite_InGson() {
        AddressDetails details = iaddressBook.addDetails("jan", "Parte", "FriendsColony",
                "Mumbai", "Maharashtra", "400042", "book1.json");
        //boolean isIt = addressBook.writeToGson(details, "book1.json");
        //Assert.assertEquals(true,isIt);

    }

    @Test
    public void toCheckIf_AddressDetails_AreRead_fromGson() {
        AddressDetails details = iaddressBook.addDetails("Avani", "Parte", "FriendsColony",
                "Mumbai", "Maharashtra", "400042", "book1.json");
       // boolean isIt = addressBook.writeToGson(details, "book1.json");
        //Assert.assertEquals(true, isIt);

    }
}


