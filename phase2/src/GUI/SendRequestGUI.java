package GUI;
/*
 *Author: Katrin
 * Description: GUI class that allows user to send an item request to admin.
 */

import Account.User;
import Item.Item;
import Item.ItemRequest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendRequestGUI extends JFrame{
    private JButton goBackButton;
    private JButton sendRequestButton;
    private JTextField desc;
    private JTextField nameTxt;
    private JLabel success;
    private JPanel mainPanel;
    ItemRequest listOfRequestedItems = new ItemRequest();

    /**
     *
     * @param user user account
     * @param itemType string representation of the item
     */
    public SendRequestGUI(User user, String itemType) {
        super("Send Item Request to Admin");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(600,500));

        sendRequestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(nameTxt.getText().isEmpty() && desc.getText().isEmpty())){
                    Item newItem = new Item(user, nameTxt.getText(), desc.getText(), itemType, false);
                    listOfRequestedItems.addItems(newItem);
                    success.setText("The item request has been sent to administration!");
                }
                else{
                    success.setText("Please enter a valid text in the text boxes.");
                }
            }
        });
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                RegisterItemGUI menu = new RegisterItemGUI(user);
            }
        });

        this.setVisible(true);
    }
}
