package GUI;
/*
 *Author: Katrin
 * Description: GUI class that allows user to view their lists.
 */

import Account.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserListsViewGUI extends JFrame{
    private JList userLists;
    private JButton giveBtn;
    private JButton goBackButton;
    private JButton wishListButton;
    private JButton borrowedBtn;
    private JButton lentBtn;
    private JLabel titleLbl;
    private JPanel leftPanel;
    private JPanel topPanel;
    private JPanel rightPanel;
    private JPanel mainPanel;
    private final DefaultListModel listModel;

    /**
     *
     * @param account user account
     */
    public UserListsViewGUI(User account){
        super("View my lists");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        listModel = new DefaultListModel();
        userLists.setModel(listModel);

        giveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.removeAllElements();
                for(int i=0; i< account.getGiveList().size() ;i++)
                {
                    listModel.addElement(account.getGiveList().get(i).getItemName());
                }
            }
        });
        lentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.removeAllElements();
                for(int i=0; i< account.getLentList().size() ;i++)
                {
                    listModel.addElement(account.getLentList().get(i).getItemName());
                }
            }
        });
        borrowedBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.removeAllElements();
                for(int i=0; i< account.getBorrowedList().size() ;i++)
                {
                    listModel.addElement(account.getBorrowedList().get(i).getItemName());
                }
            }
        });
        wishListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.removeAllElements();
                for(int i=0; i< account.getWishList().size() ;i++)
                {
                    listModel.addElement(account.getWishList().get(i).getItemName());
                }
            }
        });
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                UserMenuGUI userMenu = new UserMenuGUI(account);
            }
        });

        userLists.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

            }
        });

        this.setVisible(true);
    }
}
