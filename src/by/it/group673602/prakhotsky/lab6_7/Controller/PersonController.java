package Application.Controller;

import Application.Model.Person;
import Application.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/api/test/admin/persons/all")
    public List<Person> getAllPersons() {

        System.out.println("Get all Persons...");

        List<Person> people = new ArrayList<>();
        personRepository.findAll().forEach(people::add);
        System.out.println(people.get(0).getJob());
        return people;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/api/test/admin/persons/create")
    public Person postPerson(@RequestBody Person person) {

        System.out.println(person.getDate());

        Person newPerson = new Person();
        newPerson.init(person);

        personRepository.save(newPerson);

        return newPerson;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/api/test/admin/persons/delete/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") long id) {
        System.out.println("Delete Person with ID = " + id + "...");

        personRepository.deleteById(id);

        return new ResponseEntity<>("Person has been deleted!", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/api/test/admin/persons/delete")
    public ResponseEntity<String> deleteAllPersons() {
        System.out.println("Delete All People...");

        personRepository.deleteAll();

        return new ResponseEntity<>("All people have been deleted!", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/api/test/admin/persons/{name}")
    public List<Person> findByName(@PathVariable String name) {

        List<Person> people = personRepository.findByName(name);

        System.out.println(people.get(0));

        return people;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/api/test/admin/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") long id, @RequestBody Person person) {
        System.out.println("Update Person with ID = " + id + "...");

        Optional<Person> optionalPerson = personRepository.findById(id);
        System.out.println(person.getJob());

        if (optionalPerson.isPresent()) {
            return new ResponseEntity<>(personRepository.save(person), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
