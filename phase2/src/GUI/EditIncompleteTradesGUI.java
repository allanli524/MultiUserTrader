package GUI;
/*
 *Author: Katrin
 * Description: GUI class that allows the admin to edit the incomplete trades.
 */

import Account.Admin;
import Admin_Controls.AdminManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditIncompleteTradesGUI extends JFrame{
    private JButton submitBtn;
    private JButton goBackBtn;
    private JTextField newIncompleteTxt;
    private JLabel title;
    private JPanel mainPanel;
    private JLabel success;
    AdminManager admin = new AdminManager();

    /**
     *
     * @param account admin account
     */
    public EditIncompleteTradesGUI(Admin account) {
        super("Change the number of incomplete trades for freezing an account");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(500,300));

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                success.setText("");
                int num = Integer.parseInt(newIncompleteTxt.getText());
                admin.setMaxIncompleteTrade(num);
                success.setText("The Incomplete Trades that can be allowed has been changed to " + num + "!");
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
