package GUI;
/*
 *Author: Katrin
 * Description: GUI class that allows user to request an unfreeze status on their account.
 */

import Account.User;
import Admin_Controls.UnfreezeRequest;
import Admin_Controls.UnfreezeRequestInventory;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RequestUnfreezeGUI extends JFrame {

    private static final JFrame frame = new JFrame();
    private static final JPanel panel = new JPanel();

    private static JTextField description = new JTextField();
    private static JButton submitBtn = new JButton();
    private static JButton backBtn = new JButton();

    private static JLabel titleLabel = new JLabel();
    private static JLabel success = new JLabel();

    /**
     *
     * @param account user account
     */
    public RequestUnfreezeGUI(User account){

        frame.setSize(400,350);
        frame.add(panel);
        panel.setLayout(null);
        frame.setTitle("Trade System Group 0026");

        //Title label
        titleLabel = new JLabel("Why you would like to unfreeze your account? ");
        titleLabel.setBounds(50,1,400,100);
        panel.add(titleLabel);

        success = new JLabel("");
        success.setBounds(105,100,400,100);
        panel.add(success);

        // New name text box
        description = new JTextField();
        description.setBounds(80,100,230,25);
        panel.add(description);

        //request button
        submitBtn = new JButton(new AbstractAction("Request") {
            @Override
            public void actionPerformed(ActionEvent e) {

                String request = description.getText();

                if(!(request.equals(""))){
                    UnfreezeRequest req = new UnfreezeRequest(account, request);
                    UnfreezeRequestInventory unfreezeRequestInventory = new UnfreezeRequestInventory();
                    req.addUnfreezeRequest(account,request);
                    unfreezeRequestInventory.addUnfreezeRequest(account, request);
                    success.setText("Your request has been made!");
                    description.setText("");
                }
                else{
                    description.setText("");
                    success.setText("Please enter a description.");
                }
            }
        });
        submitBtn.setBounds(200,180,150,25);
        panel.add(submitBtn);

        //Back button
        backBtn = new JButton(new AbstractAction("Go back") {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                frame.dispose();

                UserMenuGUI userMenu = new UserMenuGUI(account);
            }
        });
        backBtn.setBounds(40,180,150,25);
        panel.add(backBtn);

        //This line has to be the last
        frame.setVisible(true);
    }
}
