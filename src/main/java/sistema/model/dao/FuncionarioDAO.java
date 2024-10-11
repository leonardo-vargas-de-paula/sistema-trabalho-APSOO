package sistema.model.dao;

import jakarta.persistence.EntityManager;
import sistema.connection.ConnectionFactory;
import sistema.model.Funcionario;
import sistema.model.Funcionario;

import java.util.List;

public class FuncionarioDAO {
    EntityManager em = new ConnectionFactory().getConnection();

    //insert-update
    public Funcionario save(Funcionario f) {
        try {
            em.getTransaction().begin();
            if (f.getCpf() == null) {
                em.persist(f);
            } else {
                em.merge(f);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return f;
    }

    //select where id = <valor desejado>
    public Funcionario findById(String cpf) {
        EntityManager em = new ConnectionFactory().getConnection();
        Funcionario f= null;

        try {
            f= em.find(Funcionario.class, cpf);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return f;
    }

    //Lista de todos os objetos Funcionario
    public List<Funcionario> findAll() {
        EntityManager em = new ConnectionFactory().getConnection();
        List<Funcionario> f = null;

        try {
            f = em.createQuery("from Funcionario ff").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return f;
    }

    //delete
    public Funcionario remove(Integer id) {
        EntityManager em = new ConnectionFactory().getConnection();
        Funcionario f= null;

        try {
            f= em.find(Funcionario.class, id);
            em.getTransaction().begin();
            em.remove(f);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return f;

    }

}
