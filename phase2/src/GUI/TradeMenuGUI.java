package GUI;
/*
 *Author: Katrin
 * Description: GUI class that displays the trade menu.
 */

import Account.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Trade.TradeController;

public class TradeMenuGUI extends JFrame{
    private JButton viewEditCurrentTradesBtn;
    private JButton goBackButton;
    private JButton viewPastTradesBtn;
    private JLabel success;
    private JPanel mainPanel;

    /**
     *
     * @param user user account
     */
    public TradeMenuGUI(User user) {
        super("Trade Menu");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        viewEditCurrentTradesBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //removeAll();
                //dispose();
                TradeController tradeController = new TradeController();
                tradeController.view(user);
                success.setText("Please refer to the console.");
                //ViewEditTradesGUI viewEditTradesGUI = new ViewEditTradesGUI(user);
            }
        });
        viewPastTradesBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                ViewPastTradesGUI viewPastTradesGUI = new ViewPastTradesGUI(user);
            }
        });

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                UserMenuGUI userMenuGUI = new UserMenuGUI(user);
            }
        });
        this.setVisible(true);
    }
}
