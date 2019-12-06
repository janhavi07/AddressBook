package com.addressbook;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
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
        try {
            String isIt = iaddressBook.createFile("book5.json");
            Assert.assertEquals("File Created", isIt);
        } catch (AddressBookExceptions addressBookExceptions) {
            addressBookExceptions.printStackTrace();
        }
    }

    @Test
    public void to_DeleteAFile_ShouldReturn_FileDeleted() {
        String isIt = iaddressBook.deleteFile("book3.json");
        Assert.assertEquals("File-Deleted", isIt);
    }

    @Test
    public void ifIncorrectFileName_to_DeleteAFile_ShouldReturn_FileNotDeleted() {
        String isIt = iaddressBook.deleteFile("book9.json");
        Assert.assertEquals("Not-Deleted", isIt);
    }

    @Test
    public void toCheckDetails_Added_in_PersonDetails() {

        AddressDetails details = null;
        try {
            details = iaddressBook.addDetails("Janhavi", "Parte", "FriendsColony",
                    "Mumbai", "Maharashtra", "400042", "book1.json");
            Assert.assertEquals("Janhavi", details.getFirstName());
        } catch (AddressBookExceptions addressBookExceptions) {
            addressBookExceptions.printStackTrace();
        }

    }

    @Test
    public void toCheckIf_AddressDetails_AreWrite_InGson() {
        try {
            AddressDetails details = iaddressBook.addDetails("Sima", "Parte", "FriendsColony",
                    "Mumbai", "Maharashtra", "400042", "book1.json");
            Assert.assertTrue(true);
        } catch (AddressBookExceptions addressBookExceptions) {
            addressBookExceptions.printStackTrace();
        }


    }

    @Test
    public void toCheckIf_AddressDetails_AreRead_fromGson() {
        try {
            AddressDetails details = iaddressBook.addDetails("Avani", "Parte", "FriendsColony",
                                              "Mumbai", "Maharashtra", "400042", "book1.json");
            Assert.assertTrue(true);
        } catch (AddressBookExceptions addressBookExceptions) {
            addressBookExceptions.printStackTrace();
        }

    }

    @Test
    public void toCheckIf_particularDetails_Deleted_ShouldReturn_Removed() {
        String detail = null;
        try {
            detail = iaddressBook.deleteDetails("jan", "book1.json");
        } catch (AddressBookExceptions addressBookExceptions) {
            addressBookExceptions.printStackTrace();
        }
        Assert.assertEquals("Removed", detail);
    }

    @Test
    public void toCheckIf_particularDetails_Deleted_ShouldReturn_NotRemoved() {
        String detail = null;
        try {
            detail = iaddressBook.deleteDetails("jan", "book1.json");
            Assert.assertNotEquals("NotRemoved", detail);
        } catch (AddressBookExceptions addressBookExceptions) {
            addressBookExceptions.printStackTrace();
        }


    }

    @Test
    public void toCheckIfAParticular_FieldIsEdited_ThenReturn_True() {
        boolean edit = false;
        try {
            edit = iaddressBook.editDetails("jan", "Orrisa", "Pune", "85135",
                                        "book1.json");
            Assert.assertEquals(true, edit);
        } catch (AddressBookExceptions addressBookExceptions) {
            addressBookExceptions.printStackTrace();
        }

    }

    @Test
    public void toCheckIfAParticular_Field_NotEdited_ThenReturn_False() {
        boolean edit = false;
        try {
            edit = iaddressBook.editDetails("Peep", "Orrisa", "Pune", "85135",
                                            "book1.json");
            Assert.assertEquals(false, edit);
        } catch (AddressBookExceptions addressBookExceptions) {
            addressBookExceptions.printStackTrace();
        }
    }

    @Test
    public void toCheckIfList_IsSortByName_Return_True() {
        boolean sort = iaddressBook.sort("Name", "book1.json");
        Assert.assertEquals(true, sort);
    }

    @Test
    public void toCheckIfList_IsSortByCity_Return_True() {
        boolean sort = iaddressBook.sort("City", "book1.json");
        Assert.assertEquals(true, sort);
    }
    @Test
    public void To_createA_File_ShouldReturn_FileNOtCreated_ShouldThrowException() {
        try {
            String isIt = iaddressBook.createFile("");
            //Assert.assertEquals("File Created", isIt);
        } catch (AddressBookExceptions addressBookExceptions) {
            addressBookExceptions.printStackTrace();
            Assert.assertEquals(AddressBookExceptions.ExceptionType.NO_SUCH_FILE,addressBookExceptions.type);
        }
    }
    @Test
    public void toCheckDetails_Added_in_PersonDetailsInputInWrongFile_ThrowsException() {

        AddressDetails details = null;
        try {
            details = iaddressBook.addDetails("Janhavi", "Parte", "FriendsColony",
                    "Mumbai", "Maharashtra", "400042", "book3.json");
        } catch (AddressBookExceptions addressBookExceptions) {
            addressBookExceptions.printStackTrace();
            Assert.assertEquals(AddressBookExceptions.ExceptionType.NO_SUCH_FILE,addressBookExceptions.type);
        }

    }


}


