package main.services.impl;

import main.constants.GENDERS;
import main.constants.HUMANFIELDS;
import main.data.Human;
import main.services.HumanInfo;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;

public class HumanInfoAcquisitionService implements HumanInfo {

    final static private int NUM_OF_FIELDS = 6;

    private Human parseInput(String[] inputArr) throws DataFormatException{
        if(inputArr.length != NUM_OF_FIELDS)
            throw new DataFormatException(String.format("Required number of tokens: %d, provided number: %d"
                    , NUM_OF_FIELDS
                    , inputArr.length));

        var hb = new Human.HumanBuilder();
        return hb.setLastName(
                        validateName(inputArr[HUMANFIELDS.LASTNAME.ordinal()]))
                .setFirstName(
                        validateName(inputArr[HUMANFIELDS.FIRSTNAME.ordinal()]))
                .setSurname(
                        validateName(inputArr[HUMANFIELDS.SURNAME.ordinal()]))
                .setBirthDay(
                        validateDayOfBirth(inputArr[HUMANFIELDS.DAYOFBIRTH.ordinal()]))
                .setPhoneNumber(
                        validatePhoneNumber(inputArr[HUMANFIELDS.PHONENUMBER.ordinal()]))
                .setGender(
                        validateGender(inputArr[HUMANFIELDS.GENDER.ordinal()]))
                .build();
    }

    private String validateName(String input) throws DataFormatException{
        if(!Pattern.matches("[A-z]+", input))
            throw new DataFormatException("Bad format of last name provided");

        return input;
    }

    private String validateDayOfBirth(String input) throws DataFormatException{
        if(!Pattern.matches("[0-3][0-9].[0-1][0-9].(1[8,9][0-9][0-9]|2[0-9][0-9][0-9])", input))
            throw new DataFormatException("Bad format of birthday provided");

        return input;
    }

    private long validatePhoneNumber(String input) throws DataFormatException{
        if(!Pattern.matches("89[0-9]{9}", input))
            throw new DataFormatException("Bad format of phone number provided");

        return Long.parseLong(input);
    }

    private GENDERS validateGender(String input) throws DataFormatException{
        if(!Pattern.matches("^[MmFf]$", input))
            throw new DataFormatException("Bad format of gender provided");

        String gender = input.equalsIgnoreCase("M")? "MALE" : "FEMALE";

        return GENDERS.valueOf(gender);
    }

    @Override
    public Human getHuman() {
        System.out.println("Enter main.data following next order and format:\n"
                + "Фамилия Имя Отчество датарождения номертелефона пол");

        try (var sc = new Scanner(System.in)) {
            String[] input = sc.nextLine().split(" ");

            return parseInput(input);

        } catch (DataFormatException e) {
            System.out.println(e.getMessage()
                    +"\n" + e.getStackTrace());
        }

        return null;
    }
}
