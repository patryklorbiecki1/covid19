package Models;

import Entities.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserModel {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public User getUser(String pesel){
        User user;
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            user = (User) session.createQuery("from User WHERE pesel = :pesel")
                    .setParameter("pesel", pesel)
                    .getSingleResult();

            transaction.commit();

        } catch (Exception e) {
            user = null;

        }

        return user;
    }
    public ObservableList getListOfUsers(String type)
    {

        ObservableList users;
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            switch (type) {
                default:
                    users = FXCollections.observableArrayList(session.createQuery("from User").getResultList());
                    break;
                case "dead":
                    users = FXCollections.observableArrayList(session.createQuery("from User WHERE dead = 1").getResultList());
                    break;
                case "recovered":
                    users = FXCollections.observableArrayList(session.createQuery("from User WHERE recovered = 1").getResultList());
                    break;
                case "quarantine":
                    users = FXCollections.observableArrayList(session.createQuery("from User WHERE quarantine = 1").getResultList());
                    break;
                case "infected":
                    users = FXCollections.observableArrayList(session.createQuery("from User WHERE infected = 1").getResultList());
                    break;
            }
            transaction.commit();

        } catch (Exception e) {
            users = null;

        }
        return users;
    }


    public void createUser(String pesel,String lastname,int d,int i,int q,int r,int admin, String name,String region,
                    String city,String district,String community,String postcode,String street,String houseNr)
    {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            User user = new User();
            user.setPesel(pesel);
            user.setLastName(lastname);
            user.setDead(d);
            user.setInfected(i);
            user.setQuarantine(q);
            user.setRecovered(r);
            user.setAdmin(admin);
            user.setName(name);
            user.setRegion(region);
            user.setCity(city);
            user.setDistrict(district);
            user.setCommunity(community);
            user.setPostcode(postcode);
            user.setStreet(street);
            user.setHouseNr(houseNr);
            session.save(user);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    public void updateUser(String pesel,int d,int i,int q,int r){
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            session.createQuery("update from User Set quarantine =: quarantine," +
                    "recovered =: recovered,infected =: infected, dead =:dead WHERE pesel = :pesel")
                    .setParameter("pesel", pesel)
                    .setParameter("quarantine", q)
                    .setParameter("recovered", r)
                    .setParameter("infected", i)
                    .setParameter("dead", d)
                    .executeUpdate();

            transaction.commit();

        } catch (Exception e) {

        }

    }

}
