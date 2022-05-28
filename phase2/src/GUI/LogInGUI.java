package GUI;
/*
 *Author: Katrin
 * Description: GUI class that allows user to log in.
 */

import Account.Account;
import User_Controls.UserSystem;
import Account.Admin;
import Account.User;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LogInGUI extends JFrame {

    private static final JFrame frame = new JFrame();
    private static final JPanel panel = new JPanel();

    private static JTextField userNameText = new JTextField();
    private static JTextField passwordText = new JTextField();
    private static JButton button = new JButton();
    private static JButton goBackBtn = new JButton();
    private static JLabel titleLbl = new JLabel();
    private static JLabel success = new JLabel();

    private final UserSystem allUsers = new UserSystem();

    public LogInGUI(){

        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        frame.setTitle("Trade System Group 0026");

        //Title label
        titleLbl = new JLabel("Trade System Group 0026!");
        titleLbl.setBounds(160,1,400,100);
        panel.add(titleLbl);

        //success label
        success = new JLabel("");
        success.setBounds(140,320,400,100);
        panel.add(success);

        //Username label
        JLabel userNameLbl = new JLabel("Please enter your username below:");
        userNameLbl.setBounds(140,80,400,100);
        panel.add(userNameLbl);

        //Password label
        JLabel passwordLbl = new JLabel("Please enter your password below:");
        passwordLbl.setBounds(140,180,400,100);
        panel.add(passwordLbl);

        // Username Textbox
        userNameText = new JTextField();
        userNameText.setBounds(130,150,230,25);
        panel.add(userNameText);

        // Password Textbox
        passwordText = new JTextField();
        passwordText.setBounds(130,250,230,25);
        panel.add(passwordText);

        // Login Button
        button = new JButton(new AbstractAction("Login") {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Log in
                String userNameTxt = userNameText.getText();
                String passwordTxt = passwordText.getText();
                success.setText("");

                //Checks if the account is valid
                Account currentAccount = allUsers.getUser(userNameTxt, passwordTxt);
                if (currentAccount == null){
                    currentAccount = allUsers.getAdmin(userNameTxt, passwordTxt);
                }
                if (currentAccount == null) {
                    //Title label
                    success.setText("Incorrect Username or password.");

                    //If account is valid, it checks for the account type before running the appropriate menu for user or admin
                    userNameText.setText("");
                    passwordText.setText("");
                }else{
                    System.out.println("You have successfully logged in!");
                    if(currentAccount instanceof Admin){
                        Admin currentAdmin = (Admin)currentAccount;
                        System.out.println("admin");
                        panel.removeAll();
                        frame.dispose();
                        AdminMenuGUI adminMenu = new AdminMenuGUI(currentAdmin);
                    }else {
                        User currentUser = (User)currentAccount;
                        //String username = currentUser.getName();
                        //ActionManager actionManager = new ActionManager(username);

                        //call correct menu for user
                        panel.removeAll();
                        frame.dispose();
                        UserMenuGUI userMenu = new UserMenuGUI(currentUser);
                    }
                }
            }
        });
        button.setBounds(250,300,130,25);
        panel.add(button);

        // go back Button
        goBackBtn = new JButton(new AbstractAction("Go back") {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                frame.dispose();

                IntroGUI intro = new IntroGUI();
                intro.startGUI();
            }
        });

        goBackBtn.setBounds(100,300,130,25);
        panel.add(goBackBtn);

        //This line has to be the last
        frame.setVisible(true);
    }
}
