package sistema.model.dao;

import jakarta.persistence.EntityManager;
import sistema.connection.ConnectionFactory;
import sistema.model.Pedido;

import java.util.List;

public class PedidoDAO {
    EntityManager em = new ConnectionFactory().getConnection();

    //insert-update
    public Pedido save(Pedido p) {
        try {
            em.getTransaction().begin();
            if (p.getIdPedido() == null) {
                em.persist(p);
            } else {
                em.merge(p);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return p;
    }

    //select where id = <valor desejado>
    public Pedido findById(Integer id) {
        EntityManager em = new ConnectionFactory().getConnection();
        Pedido p= null;

        try {
            p= em.find(Pedido.class, id);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return p;
    }

    //Lista de todos os objetos Tabelateste
    public List<Pedido> findAll() {
        EntityManager em = new ConnectionFactory().getConnection();
        List<Pedido> ps = null;

        try {
            ps = em.createQuery("from Pedido pp").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return ps;
    }

    //delete
    public Pedido remove(Integer id) {
        EntityManager em = new ConnectionFactory().getConnection();
        Pedido p= null;

        try {
            p= em.find(Pedido.class, id);
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return p;

    }

}
