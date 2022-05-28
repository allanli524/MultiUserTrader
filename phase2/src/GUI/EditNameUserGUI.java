package GUI;
/*
 *Author: Katrin
 * Description: GUI class that allows user to edit their name.
 */

import Account.User;
import User_Controls.UserManager;
import User_Controls.UserSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EditNameUserGUI {
    private static final JFrame frame = new JFrame();
    private static final JPanel panel = new JPanel();

    private static JTextField newNameTxt = new JTextField();
    private static JButton submitBtn = new JButton();
    private static JButton backBtn = new JButton();

    private static JLabel titleLabel = new JLabel();
    private static JLabel success = new JLabel();

    private static final UserManager userManager = new UserManager();

    /**
     *
     * @param account users account
     */
    public EditNameUserGUI(User account){
        frame.setSize(350,300);
        frame.add(panel);
        panel.setLayout(null);
        frame.setTitle("Trade System Group 0026");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Title label
        titleLabel = new JLabel("Please enter your new name: ");
        titleLabel.setBounds(50,1,400,100);
        panel.add(titleLabel);

        success = new JLabel("");
        success.setBounds(105,100,400,100);
        panel.add(success);

        // New name text box
        newNameTxt = new JTextField();
        newNameTxt.setBounds(50,100,230,25);
        panel.add(newNameTxt);

        //change name button
        submitBtn = new JButton(new AbstractAction("Change Name") {
            @Override
            public void actionPerformed(ActionEvent e) {

                String newName = newNameTxt.getText();
                success.setText("");

                if(!newName.equals("")){
                    userManager.updateName(account, newName);
                    newNameTxt.setText("");
                    success.setText("Name Changed!");
                }
                else{
                    newNameTxt.setText("");
                    success.setText("Please enter a name.");
                }
            }
        });
        submitBtn.setBounds(160,180,150,25);
        panel.add(submitBtn);

        //Back button
        backBtn = new JButton(new AbstractAction("Go back") {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                frame.dispose();

                EditUserAccountGUI editAccount = new EditUserAccountGUI(account);
            }
        });
        backBtn.setBounds(10,180,150,25);
        panel.add(backBtn);

        //This line has to be the last
        frame.setVisible(true);
    }
}
