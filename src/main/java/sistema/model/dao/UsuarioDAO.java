package sistema.model.dao;

import jakarta.persistence.EntityManager;
import sistema.connection.ConnectionFactory;
import sistema.model.TabelaTeste;
import sistema.model.Usuario;

import java.util.List;

public class UsuarioDAO {
    EntityManager em = new ConnectionFactory().getConnection();

    //insert-update
    public Usuario save(Usuario u) {
        try {
            em.getTransaction().begin();
            if (u.getId() == null) {
                em.persist(u);
            } else {
                em.merge(u);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return u;
    }

    //select where id = <valor desejado>
    public Usuario findById(String id) {
        EntityManager em = new ConnectionFactory().getConnection();
        Usuario u = null;

        try {
            u = em.find(Usuario.class, id);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return u;
    }

    //Lista de todos os objetos Tabelateste
    public List<Usuario> findAll() {
        EntityManager em = new ConnectionFactory().getConnection();
        List<Usuario> us = null;

        try {
            us = em.createQuery("from Usuario us").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return us;
    }

    //delete
    public Usuario remove(String id) {
        EntityManager em = new ConnectionFactory().getConnection();
        Usuario us = null;

        try {
            us = em.find(Usuario.class, id);
            em.getTransaction().begin();
            em.remove(us);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return us;

    }
}
