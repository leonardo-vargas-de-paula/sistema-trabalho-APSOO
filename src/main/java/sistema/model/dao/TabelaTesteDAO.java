package sistema.model.dao;

import jakarta.persistence.EntityManager;
import sistema.connection.ConnectionFactory;
import sistema.model.TabelaTeste;

import java.util.List;

public class TabelaTesteDAO {
    EntityManager em = new ConnectionFactory().getConnection();

    //insert-update
    public TabelaTeste save(TabelaTeste tt) {
        try {
            em.getTransaction().begin();
            if (tt.getId() == null) {
                em.persist(tt);
            } else {
                em.merge(tt);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return tt;
    }

    //select where id = <valor desejado>
    public TabelaTeste findById(Integer id) {
        EntityManager em = new ConnectionFactory().getConnection();
        TabelaTeste tt = null;

        try {
            tt = em.find(TabelaTeste.class, id);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return tt;
    }

    //Lista de todos os objetos Tabelateste
    public List<TabelaTeste> findAll() {
        EntityManager em = new ConnectionFactory().getConnection();
        List<TabelaTeste> tts = null;

        try {
            tts = em.createQuery("from TabelaTeste tt").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return tts;
    }

    //delete
    public TabelaTeste remove(Integer id) {
        EntityManager em = new ConnectionFactory().getConnection();
        TabelaTeste tt = null;

        try {
            tt = em.find(TabelaTeste.class, id);
            em.getTransaction().begin();
            em.remove(tt);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return tt;

    }

}

