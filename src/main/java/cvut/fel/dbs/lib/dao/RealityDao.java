package cvut.fel.dbs.lib.dao;

import cvut.fel.dbs.lib.model.Reality;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class RealityDao {
    private EntityManager em;

    public RealityDao() {
    }

    public RealityDao(EntityManager em) {
        this.em = em;
    }

    public List<Reality> findAll(){

        return em.createQuery("SELECT p FROM Reality p", Reality.class).getResultList();
    }

    public void create(Reality reality)
    {
        try {
            em.getTransaction().begin();
            em.persist(reality);
            em.getTransaction().commit();
            System.out.println("successfully added");
        } catch (Exception e){
            em.getTransaction().rollback();
            System.out.println("smth wrong with transaction");
        }


    }

    public void createFavourite(int idCl, int idObj){

    }

    public Reality find(int id){
        return em.find(Reality.class, id);

    }



    public void update(int id, String street, String city, int price, String objectType, int psc){

        try {
            em.getTransaction().begin();
            Query query = em.createQuery("UPDATE Reality c set c.street = :street, c.city = :city, c.price = :price, c.objectType = :objectType, c.psc = :psc where c.idObject = :id");
            query.setParameter("id", id);
            query.setParameter("city", city);
            query.setParameter("street", street);
            query.setParameter("price", price);
            query.setParameter("objectType", objectType);
            query.setParameter("psc", psc);
            int rows = query.executeUpdate();
            em.getTransaction().commit();
            System.out.println("successfully updated");
        } catch (Exception e){
            em.getTransaction().rollback();
            System.out.println("smth wrong with transaction");
        }
    }

    public void delete(int id){
//        em.remove(find(id));

        try {
            em.getTransaction().begin();
            Query query = em.createQuery("Delete  from Reality c where c.idObject = :id");
            query.setParameter("id", id);
            int rows = query.executeUpdate();
            em.getTransaction().commit();
            System.out.println("successfully deleted");
        } catch (Exception e){
            em.getTransaction().rollback();
            System.out.println("smth wrong with transaction");
        }
    }
}
