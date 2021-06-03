package cvut.fel.dbs.lib.dao;

import cvut.fel.dbs.lib.model.Client;
import cvut.fel.dbs.lib.model.Reality;

import javax.persistence.EntityManager;
import java.util.List;

public class ClientDao {
    private EntityManager em;

    public ClientDao() {
    }

    public ClientDao(EntityManager em) {
        this.em = em;
    }

    public Client find(int id){
        return em.find(Client.class, id);

    }

    public void create(Client client)
    {
        try {
            em.getTransaction().begin();
            em.persist(client);
            em.getTransaction().commit();
            System.out.println("successfully added");
        } catch (Exception e){
            em.getTransaction().rollback();
            System.out.println("smth wrong with transaction");
        }


    }
    public List<Client> findAll(){

        return em.createQuery("SELECT p FROM Client p", Client.class).getResultList();
    }

}
