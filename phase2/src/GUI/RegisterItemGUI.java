package GUI;
/*
 *Author: Katrin
 * Description: GUI class that allows user register an item.
 */

import Account.User;
import Item.Item;
import Item.ItemRequest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterItemGUI extends JFrame{
    private JButton BeautyProductsButton;
    private JButton goBackButton;
    private JButton electronicsButton;
    private JButton vehiclesButton;
    private JButton accessoriesAndCareForButton;
    private JButton sportGoodsButton;
    private JButton houseButton;
    private JButton gardeningToolsButton;
    private JButton furnitureButton;
    private JButton clothingButton;
    private JButton campingOutdoorsButton;
    private JButton cleaningProductsButton;
    private JButton healthButton;
    private JButton constructionToolsButton;
    private JButton fashionAccessoriesButton;
    private JButton otherButton;
    private JPanel mainPanel;


    /**
     *
     * @param account user account
     */
    public RegisterItemGUI(User account) {
        super("Register Item");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        BeautyProductsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                SendRequestGUI menu = new SendRequestGUI(account,"Beauty Product");
            }
        });
        campingOutdoorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                SendRequestGUI menu = new SendRequestGUI(account,"Camping & Outdoors");
            }
        });
        cleaningProductsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                SendRequestGUI menu = new SendRequestGUI(account,"Cleaning Products");
            }
        });
        clothingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                SendRequestGUI menu = new SendRequestGUI(account,"Clothing");
            }
        });
        fashionAccessoriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                SendRequestGUI menu = new SendRequestGUI(account,"Fashion Accessories");
            }
        });
        constructionToolsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                SendRequestGUI menu = new SendRequestGUI(account,"Construction Tools");
            }
        });
        furnitureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                SendRequestGUI menu = new SendRequestGUI(account,"Furniture");
            }
        });
        gardeningToolsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                SendRequestGUI menu = new SendRequestGUI(account,"Gardening Tools");
            }
        });
        healthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                SendRequestGUI menu = new SendRequestGUI(account,"Health");
            }
        });
        houseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                SendRequestGUI menu = new SendRequestGUI(account,"House");
            }
        });
        sportGoodsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                SendRequestGUI menu = new SendRequestGUI(account,"Sport Goods");
            }
        });
        accessoriesAndCareForButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                SendRequestGUI menu = new SendRequestGUI(account,"Accessories and Care for Vehicles");
            }
        });
        vehiclesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                SendRequestGUI menu = new SendRequestGUI(account,"Vehicles");
            }
        });
        electronicsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                SendRequestGUI menu = new SendRequestGUI(account,"Electronics");
            }
        });
        otherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                SendRequestGUI menu = new SendRequestGUI(account,"Other");
            }
        });
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                UserMenuGUI menu = new UserMenuGUI(account);
            }
        });

        this.setVisible(true);
    }
}
