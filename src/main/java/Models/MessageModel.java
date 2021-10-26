package Models;

import Entities.Message;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MessageModel {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public Message getMessage(String pesel){
        Message message;
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            message = (Message) session.createQuery("from Message WHERE pesel = :pesel")
                    .setParameter("pesel", pesel)
                    .getSingleResult();

            transaction.commit();

        } catch (Exception e) {
            message = null;
        }

        return message;
    }
    public ObservableList getAllMessages()
    {
        ObservableList messages;
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            messages = FXCollections.observableArrayList(session.createQuery("from Message").getResultList());
            transaction.commit();
        }
        catch (Exception e) {
            messages = null;
        }
        return messages;
    }

    public void createMessage(String pesel,String message)
    {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Message m = new Message();
            m.setPesel(pesel);
            m.setMessage(message);
            session.save(m);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
