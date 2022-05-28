package GUI;
/*
 *Author: Katrin
 * Description: GUI class that allows you to create a demo user.
 */

import User_Controls.UserManager;
import User_Controls.UserSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CreateDemoUserGUI {
    private static final JFrame frame = new JFrame();
    private static final JPanel panel = new JPanel();

    private static JFrame frame2 = new JFrame();
    private static JPanel panel2 = new JPanel();

    private static JButton closePopUp1 = new JButton();
    private static JButton closePopUp2 = new JButton();
    private static JButton closePopUp3 = new JButton();

    private static JFrame frame3 = new JFrame();
    private static JPanel panel3 = new JPanel();

    private static JFrame frame4 = new JFrame();
    private static JPanel panel4 = new JPanel();

    private static JTextField userNameText = new JTextField();
    private static JTextField passwordText = new JTextField();
    private static JTextField nameText = new JTextField();
    private static JButton submitBtn = new JButton();
    private static JButton goBackBtn = new JButton();
    private static JLabel titleLbl = new JLabel();

    private final UserSystem allUsers = new UserSystem();
    private final UserManager userManager = new UserManager();

    public CreateDemoUserGUI(){

        frame.setSize(480,550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Adding the panel onto the frame
        frame.add(panel);
        panel.setLayout(null);

        //popup 1
        frame2 = new JFrame();
        panel2 = new JPanel();
        frame2.setSize(200,100);
        //Adding the panel onto the frame
        frame2.add(panel2);
        panel2.setLayout(null);

        //popup 2
        frame3 = new JFrame();
        panel3 = new JPanel();
        frame3.setSize(200,100);
        //Adding the panel onto the frame
        frame3.add(panel3);
        panel3.setLayout(null);

        //popup 3
        frame4 = new JFrame();
        panel4 = new JPanel();
        frame4.setSize(400,100);
        //Adding the panel onto the frame
        frame4.add(panel4);
        panel4.setLayout(null);

        //Title label
        titleLbl = new JLabel("Create an account!");
        titleLbl.setBounds(170,20,400,100);
        panel.add(titleLbl);

        //Username label
        JLabel userNameLbl = new JLabel("Please enter your username below:");
        userNameLbl.setBounds(130,80,400,100);
        panel.add(userNameLbl);

        //Password label
        JLabel passwordLbl = new JLabel("Please enter your password below:");
        passwordLbl.setBounds(130,180,400,100);
        panel.add(passwordLbl);

        //Name label
        JLabel nameLbl = new JLabel("Please enter your name below:");
        nameLbl.setBounds(140,280,400,100);
        panel.add(nameLbl);

        // Username Textbox
        userNameText = new JTextField();
        userNameText.setBounds(120,150,230,25);
        panel.add(userNameText);

        // Password Textbox
        passwordText = new JTextField();
        passwordText.setBounds(120,250,230,25);
        panel.add(passwordText);

        // Password Textbox
        nameText = new JTextField();
        nameText.setBounds(120,350,230,25);
        panel.add(nameText);

        // create account account Button
        submitBtn = new JButton(new AbstractAction("Create Account") {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Log in
                String user = userNameText.getText();
                String password = passwordText.getText();
                String name = nameText.getText();
                boolean successCreate = true;

                //Username can not be a blank
                if(!(name.length() > 0)) {
                    successCreate = false;
                }
                if(!(password.length() > 8 && password.matches("[a-zA-Z0-9]*"))) {
                    successCreate = false;
                }
                //Name can not be a blank
                if(!(name.trim().length() > 0)) {
                    successCreate = false;
                }
                //If the above checks are passed, it checks if a user as already been created and gives proper prompts.
                if(successCreate){
                    successCreate = userManager.createDemoUser(user, name, password, allUsers);
                    if(successCreate){
                        //account has been created
                        JLabel titleLbl2 = new JLabel("Account created!");
                        titleLbl2.setBounds(45,1,150,40);
                        panel2.add(titleLbl2);
                        closePopUp1 = new JButton(new AbstractAction("Close") {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                panel2.removeAll();
                                frame2.dispose();
                            }
                        });
                        closePopUp1.setBounds(45,40,100,25);
                        panel2.add(closePopUp1);
                        frame2.setVisible(true);
                    }
                    else{
                        //account is taken
                        JLabel titleLbl3 = new JLabel("Username is taken!");
                        titleLbl3.setBounds(10,1,180,40);
                        closePopUp2 = new JButton(new AbstractAction("Close") {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                panel3.removeAll();
                                frame3.dispose();
                            }
                        });
                        closePopUp2.setBounds(45,40,100,25);
                        panel3.add(closePopUp2);
                        panel3.add(titleLbl3);
                        frame3.setVisible(true);
                    }
                }
                else{
                    JLabel titleLbl4 = new JLabel("One of the inputs were blank or your password is invalid.");
                    titleLbl4.setBounds(10,1,380,40);
                    panel4.add(titleLbl4);
                    closePopUp3 = new JButton(new AbstractAction("Close") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            panel4.removeAll();
                            frame4.dispose();
                        }
                    });
                    closePopUp3.setBounds(150,40,100,25);
                    panel4.add(closePopUp3);
                    frame4.setVisible(true);

                }
                userNameText.setText("");
                passwordText.setText("");
                nameText.setText("");
            }
        });

        submitBtn.setBounds(240,420,130,25);
        panel.add(submitBtn);

        // go back Button
        goBackBtn = new JButton(new AbstractAction("Go back") {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.removeAll();
                panel3.removeAll();
                panel4.removeAll();
                panel.removeAll();
                frame.dispose();
                frame2.dispose();
                frame3.dispose();
                frame4.dispose();

                IntroGUI intro = new IntroGUI();
                intro.startGUI();
            }
        });

        goBackBtn.setBounds(100,420,130,25);
        panel.add(goBackBtn);

        //This line has to be the last
        frame.setVisible(true);
    }
}
