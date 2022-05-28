package GUI;
/*
 *Author: Katrin
 * Description: GUI class that displays the edit user menu
 */

import Account.Admin;
import Account.User;
import Admin_Controls.ActionManager;
import Admin_Controls.ViewListsController;
import User_Controls.UserSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditUser2GUI extends JFrame {
    private JButton deacReacBtn;
    private JButton editTheirNameButton;
    private JButton editTheirUsernameButton;
    private JButton editTheirPasswordButton;
    private JButton goBackButton;
    private JButton undoButton;
    private JLabel success;
    private JLabel title;
    private JPanel mainPanel;
    private JTextField nameTxt;
    private JTextField passwordTxt;
    private JButton viewListsButton;

    UserSystem userSystem = new UserSystem();
    ArrayList<User> users = userSystem.getUsersList();
    ViewListsController viewListsController = new ViewListsController();

    /**
     *
     * @param account user account
     * @param admin admin account
     */
    public EditUser2GUI(User account, Admin admin) {

        super("Edit a Users Account");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(600,500));

        success.setText("Name: "+ account.getName() + ", Password: " + account.getPassword());

        deacReacBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                success.setText("");
                if (account.getDeactivateStatus()) {
                    account.setDeactivateStatus(true);
                    success.setText("User " + account.getName() + " has been deactivated.");
                }
                else{
                    account.setDeactivateStatus(false);
                    success.setText("User " + account.getName() + " has been activated.");
                }
            }
        });
        editTheirNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                success.setText("");
                String newName = nameTxt.getText();

                boolean successCreate = true;
                if (!(newName.length() > 0)) {
                    successCreate = false;
                }
                if (successCreate) {
                    account.setName(newName);
                    success.setText("Name: "+ account.getName() + ", Password: " + account.getPassword());
                }
                else {
                    success.setText("This is not a valid name. A name cannot be blank.");
                }
            }
        });

        editTheirPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                success.setText("");
                String newPass = passwordTxt.getText();

                boolean successCreate = true;
                if(!(newPass.length() > 8 && newPass.matches("[a-zA-Z0-9]*")) ) {
                    successCreate = false;
                }
                if (successCreate) {
                    account.setPassword(newPass);
                    success.setText("Name: "+ account.getName() + ", Password: " + account.getPassword());
                }
                else {
                    success.setText("Invalid password. Must be longer than 8 characters and only contain letters and numbers.");
                }
            }
        });
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionManager actionManager = new ActionManager(account.getUsername());
                boolean result = actionManager.undo(account);
                if (result){
                    success.setText("Undo for user: " + account.getName() + " is successful.");
                } else {
                    success.setText("Oops! " + account.getName() + " is not qualified for undo.");
                }
            }
        });

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                AdminMenuGUI menu = new AdminMenuGUI(admin);
            }
        });
        this.setVisible(true);
    }
}
