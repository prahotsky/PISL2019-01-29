package by.it.group673602.prahotsky.lab5.Entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Persons {
    @XmlElement(name="person")
    private List<Person> list = new ArrayList<Person>();

    public Persons() {
        super();
    }


    public void setList(List<Person> list) {
        this.list = list;
    }

    public List<Person> getPersons(){
        return this.list;
    }

    public boolean add(Person person){
        return this.list.add(person);
    }

    @Override
    public String toString() {
        return "Persons{" +
                "list=" + list +
                '}';
    }
}

