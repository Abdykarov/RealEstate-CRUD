package cvut.fel.dbs.lib.view;

import javax.swing.*;
import java.awt.*;

public class RealityView extends JPanel{


    private final JButton addButton;
    private final JButton deleteButton;
    private final JButton listButton;
    private final JButton favaddButton;
    private final JButton favdeleteButton;
    private final JButton favlistButton;
    private final JButton editButton;

    private final JTextField city;
    private final JTextField street;
    private final JTextField psc;
    private final JTextField objectType;
    private final JTextField price;
    private final JTextField id;

    private final JTextField idObject;
    private final JTextField idClient;

    private final JTextArea tableArea;
    private final JTextArea favouritesArea;
    private final JScrollPane scrollBar;
    private final JScrollPane favscrollBar;

    private final JLabel cityLabel;
    private final JLabel streetLabel;
    private final JLabel pscLabel;
    private final JLabel objectTypeLabel;
    private final JLabel priceLabel;
    private final JLabel idLabel;
    private final JLabel clientLabel;
    private final JLabel objectLabel;


    /**
     * Creating all needed components for gui
     */
    public RealityView(){
        setLayout(null);
        setSize(800, 800);
        setBackground(new Color(10, 1, 50, 198));

        cityLabel = new JLabel("City");
        cityLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cityLabel.setLocation(25, 10);
        cityLabel.setSize(150, 25);
        cityLabel.setForeground(Color.white);
        this.add(cityLabel);


        streetLabel = new JLabel("Street");
        streetLabel.setHorizontalAlignment(SwingConstants.CENTER);
        streetLabel.setLocation(200, 10);
        streetLabel.setSize(150, 25);
        streetLabel.setForeground(Color.white);
        this.add(streetLabel);



        pscLabel = new JLabel("Psc");
        pscLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pscLabel.setLocation(375, 10);
        pscLabel.setSize(150, 25);
        pscLabel.setForeground(Color.white);
        this.add(pscLabel);



        objectTypeLabel = new JLabel("ObjectType");
        objectTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        objectTypeLabel.setLocation(550, 10);
        objectTypeLabel.setSize(150, 25);
        objectTypeLabel.setForeground(Color.white);
        this.add(objectTypeLabel);



        priceLabel = new JLabel("price");
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        priceLabel.setLocation(725, 10);
        priceLabel.setSize(150, 25);
        priceLabel.setForeground(Color.white);
        this.add(priceLabel);

        idLabel = new JLabel("id");
        idLabel.setHorizontalAlignment(SwingConstants.CENTER);
        idLabel.setLocation(925, 10);
        idLabel.setSize(150, 25);
        idLabel.setForeground(Color.white);
        this.add(idLabel);

        clientLabel = new JLabel("objectId");
        clientLabel.setHorizontalAlignment(SwingConstants.CENTER);
        clientLabel.setLocation(1100, 345);
        clientLabel.setSize(150, 25);
        clientLabel.setForeground(Color.white);
        this.add(clientLabel);

        objectLabel = new JLabel("clientId");
        objectLabel.setHorizontalAlignment(SwingConstants.CENTER);
        objectLabel.setLocation(1100, 415);
        objectLabel.setSize(150, 25);
        objectLabel.setForeground(Color.white);
        this.add(objectLabel);

        addButton = new JButton("add");
        addButton.setLocation(1100, 25);
        addButton.setSize(150, 30);
        this.add(addButton);

        deleteButton = new JButton("delete");
        deleteButton.setLocation(1100, 65);
        deleteButton.setSize(150, 30);
        this.add(deleteButton);

        editButton = new JButton("edit");
        editButton.setLocation(1100, 105);
        editButton.setSize(150, 30);
        this.add(editButton);

        listButton = new JButton("list");
        listButton.setLocation(1100, 145);
        listButton.setSize(150, 30);
        this.add(listButton);

        favaddButton = new JButton("add");
        favaddButton.setLocation(1100, 225);
        favaddButton.setSize(150, 30);
        this.add(favaddButton);

        favdeleteButton = new JButton("delete");
        favdeleteButton.setLocation(1100, 265);
        favdeleteButton.setSize(150, 30);
        this.add(favdeleteButton);


        favlistButton = new JButton("list");
        favlistButton.setLocation(1100, 305);
        favlistButton.setSize(150, 30);
        this.add(favlistButton);

        idObject = new JTextField();
        idObject.setLocation(1100, 375);
        idObject.setSize(150,40);
        this.add(idObject);

        idClient = new JTextField();
        idClient.setLocation(1100, 445);
        idClient.setSize(150,40);
        this.add(idClient);

        city = new JTextField();
        city.setLocation(25, 50);
        city.setSize(150,40);
        this.add(city);

        street = new JTextField();
        street.setLocation(200, 50);
        street.setSize(150,40);
        this.add(street);

        psc = new JTextField();
        psc.setLocation(375, 50);
        psc.setSize(150,40);
        this.add(psc);

        objectType = new JTextField();
        objectType.setLocation(550, 50);
        objectType.setSize(150,40);
        this.add(objectType);

        price = new JTextField();
        price.setLocation(725, 50);
        price.setSize(150,40);
        this.add(price);

        id = new JTextField();
        id.setLocation(950, 50);
        id.setSize(100,40);
        this.add(id);

        tableArea = new JTextArea();
        scrollBar = new JScrollPane(tableArea);
        scrollBar.setAutoscrolls(true);
        tableArea.setAutoscrolls(true);
        tableArea.setEditable(true);

        scrollBar.setLocation(25,100);
        scrollBar.setSize(500, 500);
        scrollBar.setViewportView(tableArea);
        this.add(scrollBar);


        favouritesArea = new JTextArea();
        favscrollBar = new JScrollPane(favouritesArea);
        favscrollBar.setAutoscrolls(true);
        favouritesArea.setAutoscrolls(true);
        favouritesArea.setEditable(true);

        favscrollBar.setLocation(550,100);
        favscrollBar.setSize(500, 500);
        favscrollBar.setViewportView(favouritesArea);
        this.add(favscrollBar);


        this.setVisible(true);
    }

    public JButton getAddButton(){
        return addButton;
    }

    public JButton getListButton(){
        return listButton;
    }

    public JButton getDeleteButton(){
        return deleteButton;
    }

    public JButton getEditButton(){
        return editButton;
    }

    public JButton getFavaddButton() {
        return favaddButton;
    }

    public JButton getFavdeleteButton() {
        return favdeleteButton;
    }

    public JButton getFavlistButton() {
        return favlistButton;
    }

    public JTextField getCity() {
        return city;
    }

    public JTextField getStreet() {
        return street;
    }

    public JTextField getPsc() {
        return psc;
    }

    public JTextField getObjectType() {
        return objectType;
    }

    public JTextField getPrice() {
        return price;
    }

    public JTextField getId() {
        return id;
    }

    public JTextField getIdObject() {
        return idObject;
    }

    public JTextField getIdClient() {
        return idClient;
    }

    public JTextArea getTableArea() {
        return tableArea;
    }

    public JTextArea getFavouritesArea() {
        return favouritesArea;
    }

    public JScrollPane getScrollBar() {
        return scrollBar;
    }

    public JScrollPane getFavscrollBar() {
        return favscrollBar;
    }

    public JLabel getCityLabel() {
        return cityLabel;
    }

    public JLabel getStreetLabel() {
        return streetLabel;
    }

    public JLabel getPscLabel() {
        return pscLabel;
    }

    public JLabel getObjectTypeLabel() {
        return objectTypeLabel;
    }

    public JLabel getPriceLabel() {
        return priceLabel;
    }

    public JLabel getIdLabel() {
        return idLabel;
    }

    public JLabel getClientLabel() {
        return clientLabel;
    }

    public JLabel getObjectLabel() {
        return objectLabel;
    }



}
