package GUI;
/*
 *Author: Katrin
 * Description: GUI class that allows user to edit their username.
 */

import Account.User;
import javax.swing.*;
import java.awt.event.ActionEvent;
import User_Controls.UserSystem;
import User_Controls.UserManager;
public class EditUsernameUserGUI extends JFrame {

    private static final JFrame frame = new JFrame();
    private static final JPanel panel = new JPanel();

    private static JTextField newUsernameTxt = new JTextField();
    private static JButton submitBtn = new JButton();
    private static JButton backBtn = new JButton();

    private static JLabel titleLabel = new JLabel();
    private static JLabel success = new JLabel();

    private static final UserManager userManager = new UserManager();
    private static final UserSystem allUsers = new UserSystem();

    /**
     *
     * @param account users account
     */
    public EditUsernameUserGUI(User account){
        frame.setSize(350,300);
        frame.add(panel);
        panel.setLayout(null);
        frame.setTitle("Trade System Group 0026");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Title label
        titleLabel = new JLabel("Please enter your new username: ");
        titleLabel.setBounds(50,1,400,100);
        panel.add(titleLabel);

        success = new JLabel("");
        success.setBounds(105,100,400,100);
        panel.add(success);

        // New username text box
        newUsernameTxt = new JTextField();
        newUsernameTxt.setBounds(50,100,230,25);
        panel.add(newUsernameTxt);

        //change username button
        submitBtn = new JButton(new AbstractAction("Change Username") {
            @Override
            public void actionPerformed(ActionEvent e) {

                String newUsername = newUsernameTxt.getText();
                success.setText("");

                if(!allUsers.usernameTaken(newUsername) && !(newUsername.equals(account.getUsername())) && !(newUsername.equals(""))) {
                    userManager.updateUsername(account, newUsername);
                    newUsernameTxt.setText("");
                    success.setText("Username Changed!");

                }
                else {
                    newUsernameTxt.setText("");
                    success = new JLabel("Username Invalid or Taken!");
                    success.setBounds(105,100,400,100);
                    panel.add(success);
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
