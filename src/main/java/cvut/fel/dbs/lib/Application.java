package cvut.fel.dbs.lib;

import cvut.fel.dbs.lib.dao.ClientDao;
import cvut.fel.dbs.lib.dao.RealityDao;
import cvut.fel.dbs.lib.view.MainView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.*;


public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public EntityManagerFactory emf;
    public EntityManager em;
    public RealityDao realityDao;
    public ClientDao clientDao;

    public void run(){
        setup();
        startGUI();
    }

    public void startGUI(){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                JFrame frame = new MainView(emf,em,realityDao, clientDao);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setVisible(true);
            }
        });
    }

    public void setup(){
        // create emf
        emf = Persistence.createEntityManagerFactory("pu");
        // create entity manager
        em = emf.createEntityManager();

        realityDao = new RealityDao(em);
        clientDao = new ClientDao(em);

    }

    public static void main(String[] args) {
        new Application().run();
    }
}
