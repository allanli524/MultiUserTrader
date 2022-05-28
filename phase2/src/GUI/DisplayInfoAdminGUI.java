package GUI;
/*
 *Author: Katrin
 * Description: GUI class that allows admin to display all their information.
 */

import Account.Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DisplayInfoAdminGUI {
    private static final JFrame frame = new JFrame();
    private static final JPanel panel = new JPanel();

    private static JLabel titleLabel = new JLabel();
    private static JLabel username = new JLabel();
    private static JLabel password = new JLabel();
    private static JLabel name = new JLabel();
    private static JButton backBtn = new JButton();

    /**
     *
     * @param account admins account
     */
    public DisplayInfoAdminGUI(Admin account){
        frame.setSize(500,500);
        frame.add(panel);
        panel.setLayout(null);
        frame.setTitle("Trade System Group 0026");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Title label
        titleLabel = new JLabel("Here is all your information: ");
        titleLabel.setBounds(150,1,400,100);
        panel.add(titleLabel);

        //username label
        username = new JLabel("Username: " + account.getUsername());
        username.setBounds(100,100,400,100);
        panel.add(username);

        //password label
        password = new JLabel("Password: " + account.getPassword());
        password.setBounds(100,150,400,100);
        panel.add(password);

        //name label
        name = new JLabel("Name: " + account.getName());
        name.setBounds(100,200,400,100);
        panel.add(name);

        //Go back button
        backBtn = new JButton(new AbstractAction("Go back") {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                frame.dispose();
                EditAdminMenuGUI userMenu = new EditAdminMenuGUI(account);
            }
        });
        backBtn.setBounds(150,320,200,40);
        panel.add(backBtn);

        //This line has to be the last
        frame.setVisible(true);
    }
}

