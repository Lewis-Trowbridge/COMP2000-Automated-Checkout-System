package com.autochecksys.view.shared;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.autochecksys.KeyValuePair;

public class LoginPanel extends DisplayPanel {
    public JLabel lblWelcome;

    public JTextField txfUsername;

    public JTextField txfPassword;

    public JLabel lblUsernameTitle;

    public JLabel lblPasswordTitle;

    public JButton btnLogin;

    public JButton btnGoToCheckout;

    @Override
    protected void setUpComponents() {
//begin of modifiable zone................T/2459f603-8f00-4ce1-9791-7e89ff42841a
        // Set up grid layout manager on this panel
        this.setLayout(new GridBagLayout());
        GridBagConstraintsBuilder builder = new GridBagConstraintsBuilder();
        lblWelcome = new JLabel("<html>Welcome to the automated checkout system!<br>Log in below to see the admin database view, or select the checkout option.</html>");
        GridBagConstraints lblWelcomeConstraints = builder.setGridWidth(3).build();
        lblUsernameTitle = new JLabel("Username:");
        GridBagConstraints lblUsernameTitleConstraints = builder.setGridY(1).build();
        txfUsername = new JTextField();
        GridBagConstraints txfUsernameConstraints = builder.setGridX(1).setGridY(1).setFill(GridBagConstraints.HORIZONTAL).build();
        lblPasswordTitle = new JLabel("Password");
        GridBagConstraints lblPasswordTitleConstraints = builder.setGridY(2).build();
        txfPassword = new JTextField();
        GridBagConstraints txfPasswordConstraints = builder.setGridX(1).setGridY(2).setFill(GridBagConstraints.HORIZONTAL).build();
        btnLogin = new JButton("Log in");
        GridBagConstraints btnLoginConstraints = builder.setGridX(2).setGridY(1).setGridHeight(2).setFill(GridBagConstraints.CENTER).build();
        btnGoToCheckout = new JButton("Go to checkout");
        GridBagConstraints btnGoToCheckoutConstraints = builder.setGridY(3).setGridHeight(3).setGridWidth(3).setFill(GridBagConstraints.BOTH).build();
        
        
        this.add(lblWelcome, lblWelcomeConstraints);
        this.add(lblUsernameTitle, lblUsernameTitleConstraints);
        this.add(txfUsername, txfUsernameConstraints);
        this.add(lblPasswordTitle, lblPasswordTitleConstraints);
        this.add(txfPassword, txfPasswordConstraints);
        this.add(btnLogin, btnLoginConstraints);
        this.add(btnGoToCheckout, btnGoToCheckoutConstraints);
        
        setUpEventListeners();
//end of modifiable zone..................E/2459f603-8f00-4ce1-9791-7e89ff42841a
    }

    public LoginPanel(MainFrame frameToDisplayIn) {
//begin of modifiable zone................T/6ab92638-dda1-422e-a110-47259d475ba3
    super(frameToDisplayIn);

//end of modifiable zone..................E/6ab92638-dda1-422e-a110-47259d475ba3
//begin of modifiable zone(JavaCode)......C/dfe42758-3f75-43bf-9603-fa1768808e74
//end of modifiable zone(JavaCode)........E/dfe42758-3f75-43bf-9603-fa1768808e74
    }

    public void update(KeyValuePair change) {
//begin of modifiable zone................T/5f8eb331-cfd8-41cc-9ef2-de4b19313d77
        // Since we don't presently need to reflect any changes on screen, this method do not need to do anything for now
//end of modifiable zone..................E/5f8eb331-cfd8-41cc-9ef2-de4b19313d77
    }

    private void setUpEventListeners() {
//begin of modifiable zone................T/fbdd913e-818e-4d84-ab4c-b7ddac9d3ccf
        this.btnGoToCheckout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.getClass().getDeclaredMethod("checkoutButtonClicked").invoke(controller, null);
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException noSuchMethodException) {
                    noSuchMethodException.printStackTrace();
                }
            }
        });
//end of modifiable zone..................E/fbdd913e-818e-4d84-ab4c-b7ddac9d3ccf
    }

}
