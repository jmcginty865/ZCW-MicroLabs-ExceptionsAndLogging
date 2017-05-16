package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import sun.rmi.runtime.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory extends RandomNumberFactory {
    private static final Logger logger = LoggerFactory.getLogger(PhoneNumberFactory.class);

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {
        PhoneNumber [] phoneNumber = new PhoneNumber[phoneNumberCount];

        for(int i = 0; i < phoneNumberCount; i++){
                phoneNumber[i] = createRandomPhoneNumber();
        }

        return null;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    private static PhoneNumber createRandomPhoneNumber() {
        int areaCode = 0;
        int centralOfficeCode = 0;
        int phoneLineCode = 0;


        String phoneNumber = null;
        for (int i = 0; i < 10; i++) {
           int randomDigit = RandomNumberFactory.createInteger(1, 9);

           if (areaCode <= 3) {
                areaCode += randomDigit;
            } else if (centralOfficeCode <= 3) {
                centralOfficeCode += randomDigit;
            } else if (phoneLineCode <= 4) {
                phoneLineCode += randomDigit;
            }

            phoneNumber = "(" + areaCode + ")" + centralOfficeCode + phoneLineCode;
        }

        logger.debug(phoneNumber);
        return createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);

    }



    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {

        try {

            return createPhoneNumber(String.valueOf(areaCode)+ String.valueOf(centralOfficeCode) + String.valueOf(phoneLineCode));
        }
        catch (InvalidPhoneNumberFormatException e) {
            logger.debug("Is not a vaild phone number",areaCode,centralOfficeCode,phoneLineCode);
            return null;
        }

    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString)throws InvalidPhoneNumberFormatException {
        //logger.debug(phoneNumberString);
        return null;
    }
}