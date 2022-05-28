package GUI;
/*
 *Author: Katrin
 * Description: GUI class that allows user to edit their info.
 */

import Account.User;
import User_Controls.UserSystem;
import User_Controls.UserManager;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class EditUserAccountGUI extends JFrame {

    private static final JFrame frame = new JFrame();
    private static final JPanel panel = new JPanel();

    private static JLabel titleLabel = new JLabel();
    private static JButton editUsernameBtn = new JButton();
    private static JButton editPasswordBtn = new JButton();
    private static JButton editNameBtn = new JButton();
    private static JButton displayInfoBtn = new JButton();
    private static JButton backBtn = new JButton();

    public EditUserAccountGUI(User account){
        frame.setSize(500,500);
        frame.add(panel);
        panel.setLayout(null);
        frame.setTitle("Trade System Group 0026");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Title label
        titleLabel = new JLabel("Please select what you would like to edit. ");
        titleLabel.setBounds(120,1,400,100);
        panel.add(titleLabel);

        //Edit username button
        editUsernameBtn = new JButton(new AbstractAction("Edit Username") {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                frame.dispose();
                EditUsernameUserGUI newgui = new EditUsernameUserGUI(account);
            }
        });
        editUsernameBtn.setBounds(150,80,200,40);
        panel.add(editUsernameBtn);

        //Edit password button
        editPasswordBtn = new JButton(new AbstractAction("Edit Password") {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                frame.dispose();
                EditPasswordUserGUI newPassword = new EditPasswordUserGUI(account);
            }
        });
        editPasswordBtn.setBounds(150,140,200,40);
        panel.add(editPasswordBtn);

        //Edit name button
        editNameBtn = new JButton(new AbstractAction("Edit Name") {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                frame.dispose();
                EditNameUserGUI newName = new EditNameUserGUI(account);
            }
        });
        editNameBtn.setBounds(150,200,200,40);
        panel.add(editNameBtn);

        //Display user information button
        displayInfoBtn = new JButton(new AbstractAction("Display my Information") {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                frame.dispose();

                DisplayInfoUserGUI display = new DisplayInfoUserGUI(account);

            }
        });
        displayInfoBtn.setBounds(150,260,200,40);
        panel.add(displayInfoBtn);

        //Go back button
        backBtn = new JButton(new AbstractAction("Go back") {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                frame.dispose();

                UserMenuGUI userMenu = new UserMenuGUI(account);
            }
        });
        backBtn.setBounds(150,320,200,40);
        panel.add(backBtn);

        //This line has to be the last
        frame.setVisible(true);


    }
}
