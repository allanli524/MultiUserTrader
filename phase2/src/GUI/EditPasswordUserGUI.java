package GUI;
/*
 *Author: Katrin
 * Description: GUI class that allows user to edit their password.
 */

import Account.User;
import User_Controls.UserManager;
import User_Controls.UserSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EditPasswordUserGUI {

    private static final JFrame frame = new JFrame();
    private static final JPanel panel = new JPanel();

    private static JTextField newPasswordTxt = new JTextField();
    private static JButton submitBtn = new JButton();
    private static JButton backBtn = new JButton();

    private static JLabel titleLabel = new JLabel();
    private static JLabel success = new JLabel();

    private static final UserManager userManager = new UserManager();

    /**
     *
     * @param account user account
     */
    public EditPasswordUserGUI(User account){
        frame.setSize(350,300);

        //Adding the panel onto the frame
        frame.add(panel);
        panel.setLayout(null);
        frame.setTitle("Trade System Group 0026");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Title label
        titleLabel = new JLabel("Please enter your new password: ");
        titleLabel.setBounds(50,1,400,100);
        panel.add(titleLabel);

        success = new JLabel("");
        success.setBounds(105,100,400,100);
        panel.add(success);

        // New password text box
        newPasswordTxt = new JTextField();
        newPasswordTxt.setBounds(50,100,230,25);
        panel.add(newPasswordTxt);

        //change password button
        submitBtn = new JButton(new AbstractAction("Change Password") {
            @Override
            public void actionPerformed(ActionEvent e) {

                String newPass = newPasswordTxt.getText();
                success.setText("");

                if(newPass.length() > 8 && newPass.matches("[a-zA-Z0-9]*") && !(newPass.equals(""))) {
                    userManager.updatePassword(account, newPass);
                    newPasswordTxt.setText("");
                    success.setText("Password Changed!");
                }
                else{
                    newPasswordTxt.setText("");
                    success.setText("Please enter a valid password.");
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
