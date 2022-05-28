package GUI;
/*
 *Author: Katrin
 * Description: GUI class that displays admin menu.
 */

import Account.Admin;
import Account.User;
import Item.Item;
import User_Controls.UserSystem;
import Admin_Controls.AdminManager;
import Admin_Controls.UnfreezeRequest;
import Admin_Controls.UnfreezeRequestInventory;
import Item.ItemRequest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminMenuGUI extends JFrame{
    private JPanel topPanel;
    private JPanel leftPanel;
    private JButton unfreezeReqBtn;
    private JButton logoutBtn;
    private JButton editUserInfoBtn;
    private JButton changeNumIncompleteBtn;
    private JButton changeNumLentBtn;
    private JButton changeLimitPerBtn;
    private JButton editInfoBtn;
    private JButton userToAdminBtn;
    private JButton confirmItemBtn;
    private JLabel title;
    private JPanel mainPanel;
    private JLabel success;
    private JButton freezeUnfreezeBtn;
    private JButton usersWithIncompBtn;

    UserSystem userSystem = new UserSystem();
    ArrayList<User> users = userSystem.getUsersList();
    AdminManager admin = new AdminManager();
    ArrayList<UnfreezeRequest> unfreezeRequests = UnfreezeRequestInventory.getUnfreezeRequests();
    ItemRequest itemRequests = new ItemRequest();
    ArrayList<Item> requestedItems = itemRequests.getRequestedItems();
    ArrayList<User> incompleteTrades = admin.incompleteTrades();

    /**
     *
     * @param account admins account
     */
    public AdminMenuGUI(Admin account) {
        super("Admin Menu");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(600,500));

        unfreezeReqBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (unfreezeRequests.isEmpty()) {
                    success.setText("There are no unfreeze requests.");
                }
                else {
                    removeAll();
                    dispose();
                    UnfreezeReqGUI unfreezeUsers = new UnfreezeReqGUI(account);
                }
            }
        });

        freezeUnfreezeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //no users
                if (users.isEmpty()) {
                    success.setText("There are no users.");
                }
                else {
                    removeAll();
                    dispose();
                    FreezeUnfreezeGUI menu = new FreezeUnfreezeGUI(account);
                }

            }
        });

        usersWithIncompBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (incompleteTrades.isEmpty()) {
                    success.setText("There are no users with incomplete trades.");
                }
                else {
                    removeAll();
                    dispose();
                    UsersWithIncompleteGUI menu = new UsersWithIncompleteGUI(account);
                }
            }
        });

        userToAdminBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                UserToAdminGUI menu = new UserToAdminGUI(account);
            }
        });

        confirmItemBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (requestedItems.isEmpty()) {
                    success.setText("There are no requested items.");
                }
                else{
                    removeAll();
                    dispose();
                    ConfirmItemGUI menu = new ConfirmItemGUI(account);
                }
            }
        });

        editInfoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                EditAdminMenuGUI editMenu = new EditAdminMenuGUI(account);
            }
        });

        changeLimitPerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                EditLimitGUI menu = new EditLimitGUI(account);

            }
        });

        changeNumIncompleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                EditIncompleteTradesGUI menu = new EditIncompleteTradesGUI(account);

            }
        });

        changeNumLentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                EditNumLentItemsGUI menu = new EditNumLentItemsGUI(account);

            }
        });

        editUserInfoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();

                EditUserGUI menu = new EditUserGUI(account);
            }
        });

        logoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                IntroGUI intro = new IntroGUI();
                intro.startGUI();
            }
        });

        this.setVisible(true);
    }
}
