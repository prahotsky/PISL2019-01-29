package Application.Security.Service;

import Application.Model.Person;

import java.util.Optional;

public interface PersonService {

    Person addPerson(Person person);
    Person findByName(String name);
    Optional<Person> findById(Long id);
    Person editPerson(Person person);
    Person deletePerson(Person person);
    Iterable<Person> getAll();

}
