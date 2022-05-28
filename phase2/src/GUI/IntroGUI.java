package GUI;
/*
 *Author: Katrin
 * Description: GUI class that begins the GUI.
 */

import Account.Admin;
import Account.LoginController;
import Item.Inventory;
import Item.ItemRequest;
import Serializer.AccountSerializer;
import Serializer.ItemSerializer;
import Trade.BackgroundTradeChecker;
import User_Controls.UserSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class IntroGUI extends JFrame {

    private static final JFrame frame = new JFrame();
    private static final JPanel panel = new JPanel();

    private static JLabel titleLabel = new JLabel();
    private static JButton loginBtn = new JButton();
    private static JButton createGeneralBtn = new JButton();
    private static JButton createDemoBtn = new JButton();
    private static JButton exitBtn = new JButton();

    public void startGUI() {

        frame.setSize(500,400);
        frame.add(panel);
        panel.setLayout(null);
        frame.setTitle("Trade System Group 0026");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Title label
        titleLabel = new JLabel("Welcome to G26 Trading! Please select an option: ");
        titleLabel.setBounds(100,1,400,100);
        panel.add(titleLabel);

        //Login button
        loginBtn = new JButton(new AbstractAction("Login to account") {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                frame.dispose();

                LogInGUI loginPanel = new LogInGUI();
            }
        });
        loginBtn.setBounds(150,80,200,40);
        panel.add(loginBtn);

        //Create general user account button
        createGeneralBtn = new JButton(new AbstractAction("Create General account") {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                frame.dispose();

                CreateGeneralUserGUI createAcc = new CreateGeneralUserGUI();
            }
        });
        createGeneralBtn.setBounds(150,145,200,40);
        panel.add(createGeneralBtn);

        //Create demo user account button
        createDemoBtn = new JButton(new AbstractAction("Create Demo account") {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                frame.dispose();

                CreateDemoUserGUI createAcc = new CreateDemoUserGUI();
            }
        });
        createDemoBtn.setBounds(150,215,200,40);
        panel.add(createDemoBtn);

        //Exit button
        exitBtn = new JButton(new AbstractAction("Exit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                frame.dispose();
                System.exit(0);
            }
        });
        exitBtn.setBounds(150,280,200,40);
        panel.add(exitBtn);

        //This line has to be the last
        frame.setVisible(true);
    }
}
