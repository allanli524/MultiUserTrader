package GUI;
/*
 *Author: Katrin
 * Description: GUI class that allows admin to convert a user to an admin.
 */

import Account.Admin;
import Account.User;
import Admin_Controls.AdminManager;
import User_Controls.UserSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserToAdminGUI extends JFrame{
    private JButton changeBtn;
    private JButton goBackBtn;
    private JTextField userTxt;
    private JLabel titleLbl;
    private JLabel success;
    private JPanel mainPanel;

    UserSystem userSystem = new UserSystem();
    ArrayList<User> users = userSystem.getUsersList();
    AdminManager admin = new AdminManager();
    User user1 = null;

    /**
     *
     * @param account admin account
     */
    public UserToAdminGUI(Admin account) {

        super("User to Admin");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(450,300));

        changeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                success.setText("");
                if (userSystem.usernameTaken(userTxt.getText())) {
                    for (User user : users) {
                        if (user.getUsername().equals(userTxt.getText())) {
                            user1 = user;
                        }
                    }
                    admin.designateAdmin(user1, userSystem);
                    success.setText("The user has been changed to an Admin!");

                } else {
                    success.setText("This username does not exist.");
                }
            }
        });

        goBackBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                AdminMenuGUI menu = new AdminMenuGUI(account);
            }
        });
        this.setVisible(true);
    }
}
