package GUI;
/*
 *Author: Katrin
 * Description: GUI class the admin to edit num lent items.
 */

import Account.Admin;
import Admin_Controls.AdminManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditNumLentItemsGUI extends JFrame {
    private JButton submitButton;
    private JButton goBackButton;
    private JTextField userInputTxt;
    private JLabel success;
    private JLabel title;
    private JPanel mainPanel;
    AdminManager admin = new AdminManager();

    /**
     *
     * @param account admin account
     */
    public EditNumLentItemsGUI(Admin account) {
        super("Change the number of incomplete trades for freezing an account");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(600,300));

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                success.setText("");
                int num = Integer.parseInt(userInputTxt.getText());
                admin.setTradePrerequisite(num);
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
