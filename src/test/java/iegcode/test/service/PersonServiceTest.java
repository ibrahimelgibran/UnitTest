package iegcode.test.service;

import iegcode.test.data.Person;
import iegcode.test.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setUp(){
        personService = new PersonService(personRepository);
    }

    @Test
    public void testNotFound(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            personService.get("Not Found");
        });
    }

    @Test
    void testGetPersonSuccess(){
        // menambahkan behavior ke mock object
        Mockito.when(personRepository.selectById("gibran"))
                .thenReturn(new Person("gibran", "Gibran"));

        var person = personService.get("gibran");

        Assertions.assertNotNull(person);
        Assertions.assertNotNull("gibran", person.getId());
        Assertions.assertNotNull("Gibran", person.getName());
    }

    @Test
    void testRegisterSuccess() {
        var person = personService.register("Gibran");
        Assertions.assertNotNull(person);
        Assertions.assertEquals("Gibran", person.getName());
        Assertions.assertNotNull(person.getId());

        Mockito.verify(personRepository, Mockito.times(1))
                .insert(new Person(person.getId(), "Gibran"));
    }
}
