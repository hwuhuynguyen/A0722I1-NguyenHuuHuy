package music.service;

import music.model.Song;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class SongService implements ISongService {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Song> findAll() {
        String queryFindAll = "SELECT c FROM Song AS c";
        TypedQuery<Song> query = entityManager.createQuery(queryFindAll, Song.class);
        return query.getResultList();
    }

    @Override
    public void save(Song song) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(song);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Song update(Song song) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            Song origin = findById(song.getId());
            origin.setName(song.getName());
            origin.setArtist(song.getArtist());
            origin.setType(song.getType());
            origin.setPath(song.getPath());

            session.saveOrUpdate(origin);
            transaction.commit();

            return origin;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            String queryDelete = "DELETE FROM Song AS c WHERE c.id = :id";
            Query query = session.createQuery(queryDelete);
            query.setParameter("id", id);
            query.executeUpdate();

            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Song findById(int id) {
        String queryFindById = "SELECT c FROM Song AS c WHERE c.id = :id";
        TypedQuery<Song> query = entityManager.createQuery(queryFindById, Song.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
