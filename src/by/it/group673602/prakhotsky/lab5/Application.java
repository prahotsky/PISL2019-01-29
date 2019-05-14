package by.it.group673602.prahotsky.lab5;

import by.it.group673602.prahotsky.lab5.Entity.Person;
import by.it.group673602.prahotsky.lab5.Entity.Persons;
import by.it.group673602.prahotsky.lab5.Service.DAO;
import by.it.group673602.prahotsky.lab5.Service.PersonService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Application {


    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        while(true){
            menu();
            switch (scanner.nextLine()){
                case "1": marshaling(); break;
                case "2": unmarshaling(); break;
                case "3": addPerson(); break;
                case "4": toJSON(); break;
                case "5": fromJSON(); break;
                case "6": return;
            }
        }
    }

    public static void menu(){
        System.out.println("Выберите: \n" +
                "1. Записать в XML\n" +
                "2. Сохраненить из XML в БД\n" +
                "3. Добавить человека в БД\n" +
                "4. Записать в JSON\n" +
                "5. Преобразовать из JSON\n"+
                "6. Выход");
    }

    public static void marshaling(){
        try {
            DAO dao = DAO.getInstance();
            Persons persons = new Persons();
            dao.beginTransaction();
            persons.setList(dao.getPersons());
            dao.commit();
            JAXBContext context = JAXBContext.newInstance(Persons.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(persons, new FileOutputStream("src/main/resources/person.xml"));
            System.out.println("XML файл создан");
            m.marshal(persons, System.out);
        }
        catch (FileNotFoundException e ) {
            e.printStackTrace();
        }
        catch (JAXBException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void unmarshaling(){
        try {
            DAO dao = DAO.getInstance();
            JAXBContext context = JAXBContext.newInstance(Persons.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader reader = new FileReader("src/main/resources/person.xml");
            List<Person> personList = ((Persons) unmarshaller.unmarshal(reader)).getPersons();
            dao.beginTransaction();
            dao.savePersons(personList);
            dao.commit();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addPerson(){
        PersonService personService = new PersonService();
        Person person = personService.setPerson();
        DAO dao = DAO.getInstance();
        try {
            System.out.println(person);
            dao.beginTransaction();
            dao.savePerson(person);
            dao.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void toJSON(){
        DAO dao = DAO.getInstance();
        Persons persons = new Persons();
        try {
            dao.beginTransaction();
            persons.setList(dao.getPersons());
            dao.commit();
            ObjectMapper objectMapper = new ObjectMapper();
            File file =  new File("src/main/resources/person.json");
            objectMapper.writeValue(file, persons);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void fromJSON(){
        ObjectMapper objectMapper = new ObjectMapper();
        File file =  new File("src/main/resources/person.json");
        try {
            System.out.println(objectMapper.readValue(file, Persons.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
