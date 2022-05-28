package GUI;
/*
 *Author: Katrin
 * Description: GUI class that allows user to browse.
 */

import Account.User;
import Item.Inventory;
import Item.Item;
import Trade.TradeCreatorController;
import User_Controls.UserManager;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrowseGUI extends JFrame{
    private JButton addToWishlistBtn;
    private JButton goBackBtn;
    private JLabel browseLbl;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel topPanel;
    private JButton createTradeSuggestionBtn;
    private JPanel mainPanel;
    private JList browseLst;
    private JLabel success;
    private JButton removeFromWishlistButton;
    private JButton createTradeWithoutSuggBtn;
    private final DefaultListModel listModel;
    private Item selectedItem;

    // creating the inventory
    private final Inventory inventoryToBrowse = new Inventory();

    /**
     *
     * @param account user account
     */
    public BrowseGUI(User account) {

        super("View my lists");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        listModel = new DefaultListModel();
        browseLst.setModel(listModel);

        listModel.removeAllElements();

        if(inventoryToBrowse.getItemStorage().isEmpty()){
            System.out.println("There are no items in the inventory." );
        }
        else{
            listModel.removeAllElements();
            System.out.println("Here is the list of items in the inventory." );

            for(int i=0; i< inventoryToBrowse.getItemStorage().size();i++)
            {
                // Add every item from inventory to list
                listModel.addElement(inventoryToBrowse.getItemStorage().get(i));
            }
        }

        goBackBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
                UserMenuGUI userMenu = new UserMenuGUI(account);
            }
        });

        addToWishlistBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                success.setText("");
                if(!(selectedItem==null)){
                    if(!(account.getWishList().contains(selectedItem))){
                        UserManager userManager = new UserManager();
                        userManager.addToWishList(account, selectedItem);
                        success.setText("This item has been added to your wishlist.");
                    }
                    else{
                        success.setText("This item is already in your wishlist.");
                    }
                }
                else{
                    success.setText("Please click on item in the list");
                }
            }
        });
        createTradeSuggestionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                success.setText("");
                if (!(selectedItem == null)) {
                    TradeCreatorController tradeCreatorController = new TradeCreatorController();
                    tradeCreatorController.setBorrowing(account, selectedItem);

                    tradeCreatorController.create(account, selectedItem.getItemOwner());
                    success.setText("Please refer to the console");
                }
            }
        });

        browseLst.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int itemNum = browseLst.getSelectedIndex();
                if(itemNum>=0){
                    selectedItem = inventoryToBrowse.getItemStorage().get(itemNum);
                }
            }
        });

        removeFromWishlistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(selectedItem==null)) {
                    if((account.getWishList().contains(selectedItem))) {
                        UserManager userManager = new UserManager();
                        userManager.removeFromWishList(account, selectedItem);
                        success.setText("The item has been removed from your wishlist");
                    }
                    else{
                        success.setText("The item is not in your wishlist");
                    }
                }
                else{
                    success.setText("Please click on item in the list");
                }
            }
        });

        this.setVisible(true);
    }
}
