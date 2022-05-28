package GUI;
/*
 *Author: Katrin
 * Description: GUI class that displays the user Menu.
 */

import Account.DemoUser;
import Account.User;
import User_Controls.UserManager;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UserMenuGUI extends JFrame {
    private static final JFrame frame = new JFrame();
    private static final JPanel panel = new JPanel();

    private static JLabel titleLabel = new JLabel();
    private static JLabel success = new JLabel();
    private static JButton editAccBtn = new JButton();
    private static JButton viewListsBtn = new JButton();
    private static JButton browseBtn = new JButton();
    private static JButton tradeBtn = new JButton();
    private static JButton regItemBtn = new JButton();
    private static JButton reqUnfreezeBtn = new JButton();
    private static JButton deactReactBtn = new JButton();
    private static JButton logoutBtn = new JButton();
    UserManager userManager = new UserManager();

    /**
     *
     * @param account user account
     */
    public UserMenuGUI(User account){
        frame.setSize(500,550);
        frame.add(panel);
        panel.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Trade System Group 0026");

        //Title label
        titleLabel = new JLabel("Please click what you want to do or access: ");
        titleLabel.setBounds(100,1,400,100);
        panel.add(titleLabel);

        success = new JLabel("");
        success.setBounds(150,460,400,100);
        panel.add(success);

        //Edit Account Info button
        editAccBtn = new JButton(new AbstractAction("Edit Account Info") {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                frame.dispose();

                EditUserAccountGUI editUserInfo = new EditUserAccountGUI(account);

            }
        });
        editAccBtn.setBounds(110,80,250,40);
        panel.add(editAccBtn);

        //View Account Item Lists button
        viewListsBtn = new JButton(new AbstractAction("View Account Item Lists") {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                frame.dispose();

                UserListsViewGUI accountLst = new UserListsViewGUI(account);


            }
        });
        viewListsBtn.setBounds(110,130,250,40);
        panel.add(viewListsBtn);

        //Browse Items button
        browseBtn = new JButton(new AbstractAction("Browse Items") {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                frame.dispose();
                BrowseGUI browse = new BrowseGUI(account);

            }
        });
        browseBtn.setBounds(110,180,250,40);
        panel.add(browseBtn);

        tradeBtn = new JButton(new AbstractAction("Trade") {
            @Override
            public void actionPerformed(ActionEvent e) {
                success.setText("");

                if(!(account instanceof DemoUser)){
                    panel.removeAll();
                    frame.dispose();
                    TradeMenuGUI tradeMenuGUI = new TradeMenuGUI(account);
                }
                else{
                    success.setText("Feature only available to general users.");
                }
            }
        });
        tradeBtn.setBounds(110,230,250,40);
        panel.add(tradeBtn);

        //Register Item button
        regItemBtn = new JButton(new AbstractAction("Register an Item") {
            @Override
            public void actionPerformed(ActionEvent e) {
                success.setText("");

                if(!(account instanceof DemoUser)){
                    panel.removeAll();
                    frame.dispose();
                    RegisterItemGUI registerItemGUI = new RegisterItemGUI(account);
                }
                else{
                    success.setText("Feature only available to general users.");
                }
            }
        });
        regItemBtn.setBounds(110,280,250,40);
        panel.add(regItemBtn);

        //Request Unfreeze Account button
        reqUnfreezeBtn = new JButton(new AbstractAction("Request Unfreeze Account") {
            @Override
            public void actionPerformed(ActionEvent e) {
                success.setText("");

                if(!(account instanceof DemoUser)){
                    if(!account.getFrozenStatus()){
                        success.setText("You are not frozen!");
                    }
                    else{
                        panel.removeAll();
                        frame.dispose();
                        RequestUnfreezeGUI req = new RequestUnfreezeGUI(account);
                    }
                }
                else{
                    success.setText("Feature only available to general users.");
                }

            }
        });
        reqUnfreezeBtn.setBounds(110,330,250,40);
        panel.add(reqUnfreezeBtn);

        //Deactivate or Reactivate Account button
        deactReactBtn = new JButton(new AbstractAction("Deactivate/Reactivate Account") {
            @Override
            public void actionPerformed(ActionEvent e) {
                success.setText("");

                if ((account.getDeactivateStatus())) {
                    userManager.reactivateUser(account);
                    success.setText("Account reactivated!");
                } else if ((!account.getDeactivateStatus())) {
                    userManager.deactivateUser(account);
                    success.setText("Account deactivated!");
                }
            }
        });
        deactReactBtn.setBounds(110,380,250,40);
        panel.add(deactReactBtn);

        //Logout button
        logoutBtn = new JButton(new AbstractAction("Logout") {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                frame.dispose();

                IntroGUI intro = new IntroGUI();
                intro.startGUI();
            }
        });
        logoutBtn.setBounds(110,430,250,40);
        panel.add(logoutBtn);

        //This line has to be the last
        frame.setVisible(true);
    }
}
