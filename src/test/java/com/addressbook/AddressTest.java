package com.addressbook;

import org.junit.Assert;
import org.junit.Test;

public class AddressTest {
    private static final String FILE_PATH="/home/admin293/Desktop/AddressBook/AddressBooks/";
    AddressBook addressBook=new AddressBook();
    @Test
    public void toCheckIf_AddressDetails_areInitialised() {
        AddressDetails details = new AddressDetails("Janhavi","Parte","FriendsColony",
                "Mumbai","Maharashtra",400042);
        String name=details.getFirstName();
        Assert.assertEquals("Janhavi",name);
    }

    @Test
    public void ifFileDoesNotExists_thenReturn_NotPresent() {
        String isIt=addressBook.isFilePresentOrNot(FILE_PATH,"book.json");
        Assert.assertEquals("FILE-NOTPRESENT",isIt);
    }
    @Test
    public void ifFileDoesExists_thenReturn_Present() {
        String isIt=addressBook.isFilePresentOrNot(FILE_PATH,"book1.json");
        Assert.assertEquals("FILE-PRESENT",isIt);
    }

    @Test
    public void To_createA_File_ShouldReturn_FileCreated() {
        String isIt=addressBook.createFile("book2.json");
        Assert.assertEquals("File Created",isIt);
    }
}
