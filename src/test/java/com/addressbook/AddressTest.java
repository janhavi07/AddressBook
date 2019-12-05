package com.addressbook;

import org.junit.Assert;
import org.junit.Test;

public class AddressTest {
    AddressBook addressBook=new AddressBook();
    @Test
    public void toCheckIf_AdrressDetails_areInitialised() {
        AddressDetails details = new AddressDetails("Janhavi","Parte","FriendsColony",
                "Mumbai","Maharashtra",400042);
        String name=details.getFirstName();
        Assert.assertEquals("Janhavi",name);
    }


}
