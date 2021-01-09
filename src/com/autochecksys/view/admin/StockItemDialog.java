package com.autochecksys.view.admin;

import com.autochecksys.view.shared.GridBagConstraintsBuilder;
import com.autochecksys.view.shared.MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

public abstract class StockItemDialog extends JDialog {
    private JLabel lblNameTitle;

    protected JTextField txfName;

    private JLabel lblPriceTitle;

    protected JTextField txfPrice;

    private JLabel lblStockTitle;

    protected JTextField txfStock;

    private JButton btnGo;

    private JButton btnCancel;

    public Integer finishedState;

    public static int COMPLETED = 1;

    public static int CANCELED = 0;

    public StockItemDialog(MainFrame owner){
        super(owner, true);
        setPreferredSize(new Dimension(500, 300));
        setContentPane(new JPanel());
    }

    public Object[] showDialog() {
//begin of modifiable zone................T/451f3c31-b17b-4e70-b8fb-15ab5759492f
        setUpComponents();
        fillValues();
        pack();
        setVisible(true);

        // Code will pause here until setVisible becomes false again
//end of modifiable zone..................E/451f3c31-b17b-4e70-b8fb-15ab5759492f
//begin of modifiable zone................T/a137aa23-d859-4153-9bec-0c052e612297

        // When we reach this point, assume that the dialog is in a definitive state to exit and
        // return a value
        if (finishedState == null || finishedState == 0){
            // If the dialog was cancelled, return an empty array
            return new Object[0];
        }
        else {
            // If the dialog was confirmed, return the content of the text fields
            float priceToReturn = Float.parseFloat(txfPrice.getText());
            int stockToReturn = Integer.parseInt(txfStock.getText());
            return new Object[]{txfName.getText(), priceToReturn, stockToReturn};
        }
//end of modifiable zone..................E/a137aa23-d859-4153-9bec-0c052e612297
    }

    private void setUpComponents() {
//begin of modifiable zone................T/f0a45ada-0989-4b91-8ade-9b072c29e107
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraintsBuilder builder = new GridBagConstraintsBuilder();
        
        lblNameTitle = new JLabel("Name:");
        GridBagConstraints lblNameTitleConstraints = builder.setFill(GridBagConstraints.HORIZONTAL).build();
        
        txfName = new JTextField();
        GridBagConstraints txfNameConstraints = builder.setGridX(1).setFill(GridBagConstraints.HORIZONTAL).build();
        
        lblPriceTitle = new JLabel("Price:");
        GridBagConstraints lblPriceTitleConstraints = builder.setGridY(1).setFill(GridBagConstraints.HORIZONTAL).build();
        
        txfPrice = new JTextField();
        GridBagConstraints txfPriceConstraints = builder.setGridX(1).setGridY(1).setFill(GridBagConstraints.HORIZONTAL).build();
        
        lblStockTitle = new JLabel("Stock:");
        GridBagConstraints lblStockTitleConstraints = builder.setGridY(2).setFill(GridBagConstraints.HORIZONTAL).build();
        
        txfStock = new JTextField();
        GridBagConstraints txfStockConstraints = builder.setGridX(1).setGridY(2).setFill(GridBagConstraints.HORIZONTAL).build();
        
        btnGo = new JButton("Go");
        btnGo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                completed();
            }
        });
        GridBagConstraints btnGoConstraints = builder.setGridY(3).build();
        
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelled();
            }
        });
        GridBagConstraints btnCancelConstraints = builder.setGridX(1).setGridY(3).build();
        
        this.getContentPane().add(lblNameTitle, lblNameTitleConstraints);
        this.getContentPane().add(txfName, txfNameConstraints);
        this.getContentPane().add(lblPriceTitle, lblPriceTitleConstraints);
        this.getContentPane().add(txfPrice, txfPriceConstraints);
        this.getContentPane().add(lblStockTitle, lblStockTitleConstraints);
        this.getContentPane().add(txfStock, txfStockConstraints);
        this.getContentPane().add(btnGo, btnGoConstraints);
        this.getContentPane().add(btnCancel, btnCancelConstraints);
//end of modifiable zone..................E/f0a45ada-0989-4b91-8ade-9b072c29e107
    }

    protected abstract void fillValues();

    private void cancelled() {
//begin of modifiable zone................T/e2ca3b1a-8233-43f7-9bdb-12d22667fac7
        finishedState = CANCELED;
        setVisible(false);
//end of modifiable zone..................E/e2ca3b1a-8233-43f7-9bdb-12d22667fac7
    }

    private void completed() {
//begin of modifiable zone................T/c46c0543-8238-400d-ad95-869e2d7e03cd
        finishedState = COMPLETED;
        setVisible(false);
//end of modifiable zone..................E/c46c0543-8238-400d-ad95-869e2d7e03cd
    }

}
