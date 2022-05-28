package GUI;
/*
 *Author: Katrin
 * Description: GUI class that allows admin to confirm an item.
 */

import Account.Admin;
import Account.User;
import Admin_Controls.AdminManager;
import Item.Inventory;
import Item.Item;
import Item.ItemRequest;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmItemGUI extends JFrame{
    private JList ItemsToConfirmLst;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JPanel mainPanel;
    private JPanel topPanel;
    private JLabel titleLbl;
    private JLabel success;
    private JButton confirmItemButton;
    private JButton goBackButton;
    private JButton denyItemButton;

    ItemRequest itemRequests = new ItemRequest();
    public static Inventory inventory = new Inventory();
    private DefaultListModel listModel;
    private Item selectedItem;


    /**
     *
     * @param account admin account
     */
    public ConfirmItemGUI(Admin account) {
        super("Freeze or Unfreeze User");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(600,500));

        listModel = new DefaultListModel();
        ItemsToConfirmLst.setModel(listModel);

        listModel.removeAllElements();

        for (int i = 0; i < itemRequests.getRequestedItems().size(); i++) {
            listModel.addElement(itemRequests.getRequestedItems().get(i).getItemName());
        }

        denyItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                success.setText("");
                itemRequests.removeItem(selectedItem);

                listModel.removeAllElements();

                for (int i = 0; i < itemRequests.getRequestedItems().size(); i++) {
                    listModel.addElement(itemRequests.getRequestedItems().get(i).getItemName());
                }
                success.setText("The item has been denied");
            }
        });
        confirmItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                success.setText("");
                itemRequests.removeItem(selectedItem);
                inventory.addItem(selectedItem);
                selectedItem.setItemStatus(true);
                User itemOwner = selectedItem.getItemOwner();
                itemOwner.getGiveList().add(selectedItem);

                listModel.removeAllElements();

                for (int i = 0; i < itemRequests.getRequestedItems().size(); i++) {
                    listModel.addElement(itemRequests.getRequestedItems().get(i).getItemName());
                }

                success.setText("The item has been confirmed");
            }
        });

        ItemsToConfirmLst.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                success.setText("");
                int itemNum = ItemsToConfirmLst.getSelectedIndex();
                if(itemNum>=0){
                    selectedItem = itemRequests.getRequestedItems().get(itemNum);
                    success.setText("Item name: " + selectedItem.getItemName() + ", Description: "+
                            selectedItem.getItemDescription() + ", Type: "+ selectedItem.getItemType());
                }
            }
        });

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                AdminMenuGUI userMenu = new AdminMenuGUI(account);
            }
        });

        this.setVisible(true);
    }
}
