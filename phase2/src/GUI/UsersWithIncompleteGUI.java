package GUI;
/*
 *Author: Katrin
 * Description: GUI class that allows admin to see users with incomplete trades.
 */

import Account.Admin;
import Account.User;
import Admin_Controls.AdminManager;
import Admin_Controls.UnfreezeRequestInventory;
import User_Controls.UserSystem;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UsersWithIncompleteGUI extends JFrame{
    private JButton freezeUserButton;
    private JButton goBackButton;
    private JList usersLst;
    private JLabel success;
    private JLabel title;
    private JPanel mainPanel;
    private DefaultListModel listModel;
    private User selectedUser;
    private int itemNum;

    UserSystem userSystem = new UserSystem();
    UnfreezeRequestInventory unfreezeRequest = new UnfreezeRequestInventory();
    ArrayList<User> users = userSystem.getUsersList();
    AdminManager admin = new AdminManager();
    ArrayList<User> incompleteTrades = admin.incompleteTrades();

    /**
     *
     * @param account admin account
     */
    public UsersWithIncompleteGUI(Admin account) {
        super("Incomplete trades");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        listModel = new DefaultListModel();
        usersLst.setModel(listModel);

        listModel.removeAllElements();

        for (int i=0;  i < incompleteTrades.size() ; i++) {
            listModel.addElement((i+1) + ". " + incompleteTrades.get(i).getUsername());
        }

        freezeUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(selectedUser==null)){
                    admin.accountFrozenStatus(selectedUser, true);
                    if (incompleteTrades.contains(selectedUser)){
                        selectedUser.setNumIncompleteTrades(0);
                    }
                    success.setText("User is now frozen.");
                }
                success.setText("Please select a user.");
            }
        });

        usersLst.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                success.setText("");
                int itemNum = usersLst.getSelectedIndex();
                if(itemNum>=0) {
                    selectedUser = users.get(itemNum);
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
