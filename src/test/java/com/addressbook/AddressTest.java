package com.addressbook;

import org.junit.Assert;
import org.junit.Test;

public class AddressTest {
    private static final String FILE_PATH="/home/admin293/Desktop/AddressBook/AddressBooks";
    AddressBook addressBook=new AddressBook();
    @Test
    public void toCheckIf_AdrressDetails_areInitialised() {
        AddressDetails details = new AddressDetails("Janhavi","Parte","FriendsColony",
                "Mumbai","Maharashtra",400042);
        String name=details.getFirstName();
        Assert.assertEquals("Janhavi",name);
    }

    @Test
    public void ifFileDoesNotExists_thenReturn_NotPresent() {
        AddressDetails details=new AddressDetails();
        String isIt=addressBook.isFilePresentOrNot(FILE_PATH,"book1.json");
        Assert.assertEquals("FILE-NOTPRESENT",isIt);
    }
}
