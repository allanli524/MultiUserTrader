package GUI;
/*
 *Author: Katrin
 * Description: GUI class that lists all the users and allows admin to select a user to unfreeze/freeze their account.
 */

import Account.Admin;
import Account.User;
import Admin_Controls.AdminManager;
import Admin_Controls.UnfreezeRequestInventory;
import User_Controls.UserSystem;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FreezeUnfreezeGUI extends JFrame{
    private JButton freezeUnfreezeUserButton;
    private JButton goBackButton;
    private JList usersLst;
    private JLabel title;
    private JLabel success;
    private JPanel mainPanel;
    private DefaultListModel listModel;
    private User selectedUser;
    private int itemNum;
    UserSystem userSystem = new UserSystem();
    ArrayList<User> users = userSystem.getUsersList();
    AdminManager admin = new AdminManager();


    /**
     *
     * @param account admin account
     */
    public FreezeUnfreezeGUI(Admin account) {
        super("Freeze or Unfreeze User");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(600,300));
        //this.pack();

        listModel = new DefaultListModel();
        usersLst.setModel(listModel);

        listModel.removeAllElements();

        for (int i = 0; i < users.size(); i++) {
            listModel.addElement(users.get(i).getUsername());
        }

        freezeUnfreezeUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(selectedUser == null)){
                    if(!selectedUser.getFrozenStatus()){
                        admin.accountFrozenStatus(selectedUser, true);
                        success.setText(selectedUser.getUsername()+ " is now frozen");
                    }
                    else{
                        admin.accountFrozenStatus(selectedUser, false);
                        success.setText(selectedUser.getUsername() +" is now unfrozen");
                    }
                }
            }
        });

        usersLst.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                success.setText("");
                int itemNum = usersLst.getSelectedIndex();
                if(itemNum>=0){
                    selectedUser = users.get(itemNum);
                    if(selectedUser.getFrozenStatus()){
                        success.setText("Username: " + selectedUser.getUsername() + ", is frozen. Click Freeze/Unfreeze, to unfreeze them.");
                    }
                    else{
                        success.setText("Username: " + selectedUser.getUsername() + ", is not frozen. Click Freeze/Unfreeze, to freeze them.");
                    }
                }
            }
        });

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                AdminMenuGUI userMenu = new AdminMenuGUI(account);
            }
        });

        this.setVisible(true);
    }
}
