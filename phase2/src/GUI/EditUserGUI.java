package GUI;
/*
 *Author: Katrin
 * Description: GUI class that displays the edit user menu
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

public class EditUserGUI extends JFrame{
    private JTextField userTxt;
    private JButton editUserBtn;
    private JLabel success;
    private JPanel mainPanel;
    private JButton goBackBtn;

    UserSystem userSystem = new UserSystem();
    ArrayList<User> users = userSystem.getUsersList();
    AdminManager admin = new AdminManager();
    User user1 = null;

    /**
     *
     * @param account admin account
     */
    public EditUserGUI(Admin account) {
        super("Edit a Users Account");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(400,300));

        editUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                success.setText("");
                if (userSystem.usernameTaken(userTxt.getText())) {
                    for (User user : users) {
                        if (user.getUsername().equals(userTxt.getText())) {
                            user1 = user;
                            removeAll();
                            dispose();
                            EditUser2GUI menu = new EditUser2GUI(user1,account);
                        }
                    }
                }
                success.setText("User not found. Please try again or go back.");
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
