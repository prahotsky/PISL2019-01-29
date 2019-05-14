package by.it.group673602.prahotsky.lab5.Service;

import Addition.Citizenship;
import Addition.City;
import Addition.Passport;
import Entity.Address;
import Entity.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PersonService {

    public Person setPerson()  {
        Person person = new Person();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try {
                System.out.println("Имя: ");
                person.setFirstName(scanner.nextLine());
                System.out.println("Фамилия: ");
                person.setLastName(scanner.nextLine());
                System.out.println("Отчество: ");
                person.setThirdName(scanner.nextLine());
                System.out.println("Дата рождения: ");
                String date = scanner.nextLine();
                SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
                person.setBirthDate(ft.parse(date));
                System.out.println("Национальность: ");
                person.setCitizenship(setCitizenship());
                Address address = new Address();
                System.out.println("Адресс: ");
                person.setActualAddress(scanner.nextLine());
                System.out.println("Город: ");
                person.setActualCity(setCity());
                Passport passport = new Passport();
                System.out.println("Номер паспорта");
                passport.setNumber(scanner.nextLine());
                System.out.println("Серия: ");
                passport.setSeries(scanner.nextLine());
                person.setPassport(passport);
                System.out.println("Трудоустроен");
                person.setJob(Boolean.parseBoolean(scanner.nextLine()));
                if(person.isJob()){
                    System.out.println("Должность: ");
                    person.setPost(scanner.nextLine());
                } else {
                    person.setPost(null);
                }
                System.out.println(address);
            } catch (ParseException ex) {
                System.out.println("Failed input date");
                continue;
            }

            return person;
        }
    }

    private Citizenship setCitizenship(){
        System.out.println("1. Беларусь\n2. Россия\n3. Украина\n4. Польша\n5. Латвия\n6. Литва\n");
        Scanner scan = new Scanner(System.in);
        switch (scan.nextLine()){
            case "1": return Citizenship.BELARUS;
            case "2": return Citizenship.RUSSIAN;
            case "3": return Citizenship.UKRAIN;
            case "4": return Citizenship.POLAND;
            case "5": return Citizenship.LATVIAN;
            case "6": return Citizenship.LITHUANIA;

        }
        return Citizenship.BELARUS;
    }

    private String setCity(){
        System.out.println("1. Минск\n2. Гродно\n3. Гомель\n4. Витебск\n5. Брест\n");
        Scanner scan = new Scanner(System.in);
        switch (scan.nextLine()){
            case "1": return City.MINSK.toString();
            case "2": return City.GRODNO.toString();
            case "3": return City.GOMEL.toString();
            case "4": return City.VITEBSK.toString();
            case "5": return City.BREST.toString();
        }
        return City.MINSK.toString();
    }


}
