package by.it.group673602.prahotsky.lab5.Service;

import Entity.Person;
import org.hibernate.Session;

import java.util.List;

public class DAO {

    private static DAO dao;
    private Session session;

    private DAO(){
    }

    public static DAO getInstance(){
        if (dao == null){
            dao = new DAO();
        }
        return dao;
    }

    public void beginTransaction() throws Exception {
        if (session == null) {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
        }
        else session.beginTransaction();
    }

    public void commit() {
        session.getTransaction().commit();
    }

    public void rollback() throws Exception{
        session.getTransaction().rollback();
    }

    public List<Person> getPersons() throws Exception {
        return (List<Person>) session.createQuery("select p from Person p").list();    }

    public Person finById(long id){
        return session.find(Person.class, id);
    }

    public void savePerson(Person p){
        System.out.println(p);

        session.save(p);
    }

    public void savePersons(List<Person> personList){
        personList.forEach(e -> session.save(e));
    }

    public void close(){
        session.close();
    }

}


