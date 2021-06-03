package cvut.fel.dbs.lib.view;

import cvut.fel.dbs.lib.dao.ClientDao;
import cvut.fel.dbs.lib.dao.RealityDao;
import cvut.fel.dbs.lib.model.Client;
import cvut.fel.dbs.lib.model.Reality;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class MainView extends JFrame {

    private final RealityView realityView;
    private final EntityManagerFactory emf;
    private final EntityManager em;
    private final RealityDao realityDao;
    private final ClientDao clientDao;

    public JButton addButton;
    public JButton deleteButton;
    public JButton editButton;
    public JButton listButton;
    public JButton favaddButton;
    public JButton favdeleteButton;
    public JButton favlistButton;

    /**
     * Main controller of app, manipulates with dao and Reality view. Gets instances from main class - application.java
     * @param emf
     * @param em
     * @param realityDao
     * @param clientDao
     */
    public MainView(EntityManagerFactory emf, EntityManager em, RealityDao realityDao, ClientDao clientDao){

        this.emf = emf;
        this.em = em;
        this.realityDao = realityDao;
        this.clientDao = clientDao;
        this.realityView = new RealityView();
        this.addButton = realityView.getAddButton();
        this.listButton = realityView.getListButton();
        this.editButton = realityView.getEditButton();
        this.deleteButton = realityView.getDeleteButton();
        this.favaddButton = realityView.getFavaddButton();
        this.favdeleteButton = realityView.getFavdeleteButton();
        this.favlistButton = realityView.getFavlistButton();

        setSize(1300,700);
        add(realityView);



        favaddButton.addActionListener(new ActionListener()   {

            @Override
            public void actionPerformed(ActionEvent e) {
                createFavourite();
            }

        });   
        favdeleteButton.addActionListener(new ActionListener()   {

            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFavourite();
            }

        });
        
        
        favlistButton.addActionListener(new ActionListener()   {

            @Override
            public void actionPerformed(ActionEvent e) {
                listFavourites();
            }

        });
        
        
        addButton.addActionListener(new ActionListener()   {

            @Override
            public void actionPerformed(ActionEvent e) {
                createReality();
            }

        });

        editButton.addActionListener(new ActionListener()   {

            @Override
            public void actionPerformed(ActionEvent e) {
                editReality();
            }

        });

        deleteButton.addActionListener(new ActionListener()   {

            @Override
            public void actionPerformed(ActionEvent e) {
                deleteReality();
            }

        });

        listButton.addActionListener(new ActionListener()   {

            @Override
            public void actionPerformed(ActionEvent e) {
                listReality();
            }

        });


    }

    /**
     * Deleting relationship by both ids
     */
    private void deleteFavourite() {

        String idObject = realityView.getIdObject().getText();
        String idClient = realityView.getIdClient().getText();


        int idObj = Integer.parseInt(idObject);
        int idCl = Integer.parseInt(idClient);

        Reality reality = realityDao.find(idObj);
        Client client = clientDao.find(idCl);

        if(!reality.getFanClients().contains(client)){
            System.out.println("relationship doesnt exist");
            return;
        }else{
            reality.getFanClients().remove(client);
            try {
                em.getTransaction().begin();
                em.merge(reality);
                em.refresh(client);
                System.out.println("Relationship removed :)");
                em.getTransaction().commit();
            }
            catch (Exception e ){
                em.getTransaction().rollback();
                System.out.println("smth wrong with transaction");
            }
        }

    }

    /**
     * Get list of all relationships and add them to fav text area
     */
    private void listFavourites() {
        String idObject = realityView.getIdObject().getText();
        String idClient = realityView.getIdClient().getText();
        realityView.getFavouritesArea().setText(null);


            if (idClient.trim().length() != 0 && idObject.trim().length() == 0) {
                int idCl = Integer.parseInt(idClient);
                Client client = clientDao.find(idCl);
                Collection<Reality> realities = client.getRealities();
                realityView.getFavouritesArea().append(client.toString2());
                for (Reality rl : realities) {
                    realityView.getFavouritesArea().append(rl.toString2());
                }
            }
            if (idClient.trim().length() == 0 && idObject.trim().length() != 0) {
                int idObj = Integer.parseInt(idObject);
                Reality reality = realityDao.find(idObj);
                Collection<Client> clients = reality.getFanClients();
                realityView.getFavouritesArea().append(reality.toString3());

                for (Client cl : clients) {
                    realityView.getFavouritesArea().append(cl.toString());
                }
            }

    }
    /**
     * Create new relationship between client and object
     */
    public void createFavourite() {
        String idObject = realityView.getIdObject().getText();
        String idClient = realityView.getIdClient().getText();


        int idObj = Integer.parseInt(idObject);
        int idCl = Integer.parseInt(idClient);

        Reality reality = realityDao.find(idObj);
        Client client = clientDao.find(idCl);

        if(reality == null || client == null){
            System.out.println("Id doesnt exist");
            return;
        }else{
            reality.getFanClients().add(client);
            try {
                em.getTransaction().begin();
                em.persist(reality);
                em.refresh(client);
                System.out.println("Relationship created :)");
                em.getTransaction().commit();
            }
            catch (Exception e ){
                em.getTransaction().rollback();
                System.out.println("smth wrong with transaction");
            }
        }


    }



    /**
     * Create new reality, checks if inputs are not empty
     */
    public void createReality(){
        String city = realityView.getCity().getText();
        String street = realityView.getStreet().getText();
        String psc = realityView.getPsc().getText();
        String price = realityView.getPrice().getText();
        String type = realityView.getObjectType().getText();

        if(city.trim().length() != 0 && street.trim().length()
                != 0 && psc.trim().length() !=0 && price.trim().length() != 0 && type.trim().length() != 0){
            int priceInt=Integer.parseInt(price);
            int pscInt=Integer.parseInt(psc);
            Reality reality = new Reality(city,street,pscInt,type,priceInt);
            realityDao.create(reality);

        }
    }

    /**
     * Get list of all realities, then add them to text area via cycle
     */
    public void listReality(){
        realityView.getTableArea().setText(null);
        for(Reality real : realityDao.findAll()){
            realityView.getTableArea().append(real.toString());
        }
    }

    /**
     * Editing reality object, if form is empty, we assign the current values
     */
    public void editReality(){
        String city = realityView.getCity().getText();
        String street = realityView.getStreet().getText();
        String psc = realityView.getPsc().getText();
        String price = realityView.getPrice().getText();
        String type = realityView.getObjectType().getText();
        String id = realityView.getId().getText();

        if(id.trim().length() != 0 && city.trim().length() != 0 && street.trim().length()
                != 0 && psc.trim().length() !=0 && price.trim().length() != 0 && type.trim().length() != 0){
            String newCity = city;
            String newStreet = street;
            String newType = type;
            int newPsc = Integer.parseInt(psc);
            int newPrice = Integer.parseInt(price);
            int newId = Integer.parseInt(id);

            if(realityDao.find(newId) == null){

            }else{
                if(city.trim().length() == 0){
                    newCity = realityDao.find(newId).getCity();
                }if(street.trim().length() == 0){
                newStreet = realityDao.find(newId).getStreet();
                }if(type.trim().length() == 0){
                    newType = realityDao.find(newId).getObjectType();
                }if(psc.trim().length() == 0){
                    newPsc = realityDao.find(newId).getPsc();
                }if(price.trim().length() == 0){
                    newPrice = realityDao.find(newId).getPrice();
                }

                realityDao.update(newId, newStreet, newCity, newPrice, newType, newPsc);


            }
        }else{
            System.out.println("missing parametrs");
        }

    }


    /**
     * Delete reality object from database, find object by id
     */
    public void deleteReality(){

        String id = realityView.getId().getText();

        if(id.trim().length() != 0){
            int longid = Integer.parseInt(id);
            realityDao.delete(longid);
            realityView.getId().setText(null);
        }

    }


}
