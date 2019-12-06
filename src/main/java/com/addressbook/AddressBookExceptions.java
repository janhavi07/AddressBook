package com.addressbook;

public class AddressBookExceptions extends Exception{
    enum ExceptionType{NO_SUCH_FILE

    }
    ExceptionType type;
    public AddressBookExceptions(ExceptionType type, String errorMessage) {
        super(errorMessage);
        this.type = type;
    }

}
