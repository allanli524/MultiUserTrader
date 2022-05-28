package GUI;
/*
 *Author: Katrin
 * Description: GUI class that allows user to view past trades.
 */

import Account.User;
import Trade.tradeHistory;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

public class ViewPastTradesGUI extends JFrame{
    private JButton recentTradesBtn;
    private JButton goBackButton;
    private JButton recentUsersBtn;
    private JList lst;
    private JLabel title;
    private JPanel mainPanel;
    private JLabel success;
    private final tradeHistory th = new tradeHistory();
    List<Object> temp = null;
    private final DefaultListModel listModel;

    /**
     *
     * @param user user account
     */
    public ViewPastTradesGUI(User user) {

        super("View my trades");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        listModel = new DefaultListModel();
        lst.setModel(listModel);

        listModel.removeAllElements();

        recentTradesBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.removeAllElements();
                temp = Collections.singletonList(th.getRecentTrades(user));
                if (temp.isEmpty()){
                    success.setText("You have not done any trades.");
                }
                else{
                    for(int i=0;i<temp.size();i++){
                        listModel.addElement(temp.get(i));
                    }
                }
            }
        });
        recentUsersBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.removeAllElements();
                temp = Collections.singletonList(th.getFrequentPartners(user));
                if (temp.isEmpty()){
                    success.setText("You have not done any trades.");
                }
                else{
                    for(int i=0;i<temp.size();i++){
                        listModel.addElement(temp.get(i));
                    }
                }
            }
        });
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                TradeMenuGUI tradeMenuGUI = new TradeMenuGUI(user);
            }
        });

        lst.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

            }
        });
        this.setVisible(true);
    }
}
