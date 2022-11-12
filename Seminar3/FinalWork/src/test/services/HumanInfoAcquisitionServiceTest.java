package test.services;

import main.constants.GENDERS;
import main.data.Human;
import main.services.impl.HumanInfoAcquisitionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.zip.DataFormatException;

import static org.junit.jupiter.api.Assertions.*;

class HumanInfoAcquisitionServiceTest {
    private final static HumanInfoAcquisitionService humanInfoAcquisitionService = new HumanInfoAcquisitionService();

    @ParameterizedTest
    @CsvSource({
            "'Ivanov Ivan Ivanovich 23.08.1994 89125601445 M', 'Ivanov', 'Ivan', 'Ivanovich', '23.08.1994', '89125601445', 'M'",
            "'Petrov Petr Petrovich 01.01.2000 89660000000 m', 'Petrov', 'Petr', 'Petrovich', '01.01.2000', '89660000000', 'm'",
            "'Petrova Petra Petrovna 29.02.2004 89661234567 f', 'Petrova', 'Petra', 'Petrovna', '29.02.2004', '89661234567', 'f'",
            "'Sidorova Elena Fedorovaaaaaaaaaaaaaa 31.12.1960 89185656633 F', 'Sidorova', 'Elena', 'Fedorovaaaaaaaaaaaaaa', '31.12.1960', '89185656633', 'F'",
    })
    void getHumanTestProperInput(String usrInput
                , String lastName
                , String firstName
                , String surname
                , String dayOfBirth
                , String phoneNumber
                , String gender) {
        InputStream defaultInput = System.in;

        byte[] bar = usrInput.getBytes();
        ByteArrayInputStream bas = new ByteArrayInputStream(bar);

        System.setIn(bas);

        Human hTest = humanInfoAcquisitionService.getHuman();

        System.setIn(defaultInput);

        Human h = new Human.HumanBuilder()
                .setLastName(lastName)
                .setFirstName(firstName)
                .setSurname(surname)
                .setBirthDay(dayOfBirth)
                .setPhoneNumber(Long.parseLong(phoneNumber))
                .setGender(gender.equalsIgnoreCase("M")? GENDERS.MALE : GENDERS.FEMALE)
                .build();


        assertEquals(h, hTest);
    }

    @ParameterizedTest
    @CsvSource({
            "'Ivanov'",
            "'Ivanov Ivan'",
            "'Ivanov Ivan Ivanovich'",
            "'Ivanov Ivan Ivanovich 23.08.1994'",
            "'Ivanov Ivan Ivanovich 23.08.1994 89125601445'",
            "'Ivanov Ivanovich 23.08.1994 89125601445 M'",
            "'Ivanov Ivan 23.08.1994 89125601445 M'",
            "'Ivan Ivanovich 23.08.1994 89125601445 M'",
            "'Ivan Ivan Ivanovich 89125601445 M'",
            "'Ivan Ivan Ivanovich 23.08.1994 M'",
            "'Ivanov Ivan Ivanovich 23.08.1994 89125601445'",
            "'Kirill Ivanov Ivan Ivanovich 23.08.1994 89125601445 M'",
            "'Iv2e32e3anov Ivan Ivanovich 23.08.1994 89125601445 M'",
            "'Ivanov Ivde4r444an Ivanovich 23.08.1994 89125601445 M'",
            "'Ivanov Ivan Ivanovi4r4r4ch 23.08.1994 89125601445 M'",
            "'Ivanov Ivan Ivanovich 23.08.1000 89125601445 M'",
            "'Ivanov Ivan Ivanovich 23.08.2000000 89125601445 M'",
            "'Ivanov Ivan Ivanovich 41.08.2000 89125601445 M'",
            "'Ivanov Ivan Ivanovich 12.08.2000 89125601445dede M'",
            "'Ivanov Ivan Ivanovich 12.08.2000 89125601445888 M'",
            "'Ivanov Ivan Ivanovich 12.08.2000 89125601445888 r'",
    })
    void getHumanTestWrongInput(String usrInput) {
        InputStream defaultInput = System.in;

        byte[] bar = usrInput.getBytes();
        ByteArrayInputStream bas = new ByteArrayInputStream(bar);

        System.setIn(bas);

        assertNull(humanInfoAcquisitionService.getHuman());

        System.setIn(defaultInput);
    }
}