package GUI;
/*
 *Author: Katrin
 * Description: GUI class that allows the admin to edit the limit.
 */

import Account.Admin;
import Admin_Controls.AdminManager;
import User_Controls.UserSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditLimitGUI extends JFrame{
    private JTextField textField1;
    private JButton submitButton;
    private JButton goBackButton;
    private JLabel success;
    private JLabel title;
    private JPanel mainPanel;
    AdminManager admin = new AdminManager();
    UserSystem userSystem = new UserSystem();

    /**
     *
     * @param account admin account
     */
    public EditLimitGUI(Admin account) {
        super("Change the number of min. items to be lent.");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(600,300));

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                success.setText("");
                int num = Integer.parseInt(textField1.getText());
                admin.changeLimitPerWeek(num, userSystem);
                success.setText("The num. of min. items to be lent before the user can borrow has been changed to " + num + "!");

            }
        });
        goBackButton.addActionListener(new ActionListener() {
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
