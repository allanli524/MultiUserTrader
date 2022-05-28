package GUI;
/*
 *Author: Katrin
 * Description: GUI class that allows admin to view unfreeze requests.
 */

import Account.Admin;
import Account.User;
import Item.Item;
import User_Controls.UserSystem;
import Admin_Controls.AdminManager;
import Admin_Controls.UnfreezeRequest;
import Admin_Controls.UnfreezeRequestInventory;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UnfreezeReqGUI extends JFrame{
    private JList frozenUsersLst;
    private JButton unfreezeBtn;
    private JButton goBackBtn;
    private JLabel titleLbl;
    private JLabel success;
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private DefaultListModel listModel;
    private User selectedUser;
    private int itemNum;

    UnfreezeRequestInventory unfreezeRequest = new UnfreezeRequestInventory();
    AdminManager admin = new AdminManager();
    ArrayList<UnfreezeRequest> unfreezeRequests = UnfreezeRequestInventory.getUnfreezeRequests();

    /**
     *
     * @param account admin account
     */
    public UnfreezeReqGUI(Admin account){
        super("Unfreeze Requests");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(600,500));
        //this.pack();

        listModel = new DefaultListModel();
        frozenUsersLst.setModel(listModel);

        listModel.removeAllElements();

        System.out.println("This is a list of users who have unfreeze requests: ");

        if(unfreezeRequests.size() == 0){
            success.setText("There are no users who have unfreeze requests.");
        }
        else{
            for (int i = 1; i < unfreezeRequests.size() + 1; i++) {
                String description = unfreezeRequests.get(itemNum-1).getDescription();
                success.setText("Unfreeze Request: " + description + "If you wish to unfreeze user, click Unfreeze.");
                listModel.addElement(unfreezeRequests.get(i - 1).getUser().getName() + ", Description: " + description);
            }
        }

        frozenUsersLst.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                success.setText("");
                itemNum = frozenUsersLst.getSelectedIndex();
                if(itemNum>=0){
                    selectedUser = unfreezeRequests.get(itemNum).getUser();
                }
            }
        });

        unfreezeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                success.setText("");
                if(!(itemNum == 0)){
                    admin.accountFrozenStatus(unfreezeRequests.get(itemNum-1).getUser(), false);
                    unfreezeRequest.removeUnFreezeRequest(unfreezeRequests.get(itemNum-1).getUser());
                    success.setText(selectedUser + " has been unfrozen and their unfreeze request has been removed.");
                }
                else{
                    success.setText("Please select a user.");
                }
            }
        });

        goBackBtn.addActionListener(new ActionListener() {
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
