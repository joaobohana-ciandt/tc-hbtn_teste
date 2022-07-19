import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

 @SuppressWarnings("deprecation")
public class PersonTest {

    static Person person;

    @BeforeAll
    public static void setup(){
        Date date = new Date(2000, Calendar.JANUARY, 1);
        person = new Person("Paul", "McCartney", date,
                true, true, true);
    }

    @Test
    public void show_full_name(){
        assertEquals("Paul McCartney", person.fullName());
    }

    @Test
    public void test_calculateYearlySalary(){
        person.setSalary(1200);
        assertEquals(14400, person.calculateYearlySalary());
    }

    @Test
    public void person_is_MEI(){
        person.setAnotherCompanyOwner(false);
        person.setPensioner(false);
        person.setPublicServer(false);

        assertTrue(person.isMEI());
    }

    @Test
    public void person_is_not_MEI(){
        person.setAnotherCompanyOwner(true);
        assertFalse(person.isMEI());
    }

}
