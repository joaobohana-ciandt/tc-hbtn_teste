package src;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {
    static Person person;

    @BeforeAll
    public static void setup(){
        person = new Person();
    }

    @ParameterizedTest(name = "Check if user is valid")
    @ValueSource(strings = {"PaulMcCartney2", "NeilArms2"})
    public void check_user_valid(String user){
        assertTrue(person.checkUser(user));
    }

    @ParameterizedTest(name = "Check if user is not valid")
    @ValueSource(strings = {"Paul#McCartney", "Neil@Arms"})
    public void check_user_not_valid(String user){
        assertFalse(person.checkUser(user));
    }

    @ParameterizedTest(name = "Password without letters")
    @ValueSource(strings = {"123456789", "#$%1234"})
    public void does_not_have_letters(String password){
        assertFalse(person.checkPassword(password));
    }

    @ParameterizedTest(name = "Password without numbers")
    @ValueSource(strings = {"Abcabcdefgh@", "#hbtn@%tc"})
    public void does_not_have_numbers(String password){
        assertFalse(person.checkPassword(password));
    }

    @ParameterizedTest(name = "Password with less than 8 characters")
    @ValueSource(strings = {"Abc@123", "12$@hbt"})
    public void does_not_have_eight_chars(String password){
        assertFalse(person.checkPassword(password));
    }

    @ParameterizedTest(name = "Password is valid")
    @ValueSource(strings = {"abC123456$", "Hbtn@1234", "Betty@1#2", "Hbtn@123"})
    public void check_password_valid(String password){
        assertTrue(person.checkPassword(password));
    }


}
