package test.data;

import main.constants.GENDERS;
import main.data.Human;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {
    private static final Human human = new Human.HumanBuilder()
            .setLastName("Ivanov")
            .setFirstName("Ivan")
            .setSurname("Ivanovich")
            .setBirthDay("01.01.1970")
            .setPhoneNumber(89226531925L)
            .setGender(GENDERS.MALE)
            .build();

    @org.junit.jupiter.api.Test
    void getLastName() {
        assertEquals("Ivanov", human.getLastName());
    }

    @org.junit.jupiter.api.Test
    void getSurname() {
        assertEquals("Ivanovich", human.getSurname());
    }

    @org.junit.jupiter.api.Test
    void getFirstName() {
        assertEquals("Ivan", human.getFirstName());
    }

    @org.junit.jupiter.api.Test
    void getBirthDay() {
        assertEquals("01.01.1970", human.getBirthDay());
    }

    @org.junit.jupiter.api.Test
    void getPhoneNumber() {
        assertEquals(89226531925L, human.getPhoneNumber());
    }

    @org.junit.jupiter.api.Test
    void getGender() {
        assertEquals(GENDERS.MALE, human.getGender());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        assertEquals("Ivanov Ivan Ivanovich 01.01.1970 89226531925 MALE"
                , human.getLastName()
                        + " " + human.getFirstName()
                        + " " + human.getSurname()
                        + " " + human.getBirthDay()
                        + " " + human.getPhoneNumber()
                        + " " + human.getGender());
    }
}