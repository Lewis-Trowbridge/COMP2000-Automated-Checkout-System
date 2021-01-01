package com.autochecksys.view.kiosk;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.autochecksys.KeyValuePair;
import com.autochecksys.controller.shared.AbstractController;
import com.autochecksys.model.StockItem;
import com.autochecksys.view.shared.DisplayPanel;
import com.autochecksys.view.shared.GridBagConstraintsBuilder;
import com.autochecksys.view.shared.MainFrame;

public class KioskPanel extends DisplayPanel {
    public JLabel lblKiosk;

    public JTextField txfBarcodeInput;

    public JButton btnBarcodeEnter;

    public JTable tblItemDisplay;

    public JScrollPane srpTablePanel;

    public JLabel lblTotalPrice;

    public JButton btnGoToPayment;

    public KioskPanel(MainFrame mainFrameToUse) {
//begin of modifiable zone................T/659be782-e128-4838-a1d4-2cacf7025a79
super(mainFrameToUse);

//end of modifiable zone..................E/659be782-e128-4838-a1d4-2cacf7025a79
//begin of modifiable zone(JavaCode)......C/d8e01269-50cd-44cd-9975-4c666c98e662

//end of modifiable zone(JavaCode)........E/d8e01269-50cd-44cd-9975-4c666c98e662
    }

    @Override
    protected void setUpComponents() {
//begin of modifiable zone................T/32ed2544-31bb-4081-86f0-64ff77155ffc
        this.setLayout(new GridBagLayout());
        GridBagConstraintsBuilder builder = new GridBagConstraintsBuilder();
        Object[] columns = {"ID", "Item", "Price"};
        tblItemDisplay = new JTable(new DefaultTableModel(columns, 0));
        srpTablePanel = new JScrollPane(tblItemDisplay);
        GridBagConstraints srpTablePanelConstraints = builder.setGridHeight(5).setFill(GridBagConstraints.BOTH).build();
        lblTotalPrice = new JLabel("Current total: £0.00");
        GridBagConstraints lblTotalPriceConstraints = builder.setGridY(5).setWeightY(0).setFill(GridBagConstraints.HORIZONTAL).build();
        JPanel scanPanel = new JPanel();
        scanPanel.setLayout(new GridBagLayout());
        GridBagConstraints scanPanelConstraints = builder.setGridY(6).setWeightY(0).setFill(GridBagConstraints.HORIZONTAL).build();
        txfBarcodeInput = new JTextField();
        GridBagConstraints txfBarcodeInputConstraints = builder.setGridWidth(3).setFill(GridBagConstraints.HORIZONTAL).build();
        btnBarcodeEnter = new JButton("Go");
        GridBagConstraints btnBarcodeEnterConstraints = builder.setGridX(4).setFill(GridBagConstraints.HORIZONTAL).build();
        
        
        this.add(srpTablePanel, srpTablePanelConstraints);
        this.add(lblTotalPrice, lblTotalPriceConstraints);
        scanPanel.add(txfBarcodeInput, txfBarcodeInputConstraints);
        scanPanel.add(btnBarcodeEnter, btnBarcodeEnterConstraints);
        this.add(scanPanel, scanPanelConstraints);
        
        setUpEventListeners();
//end of modifiable zone..................E/32ed2544-31bb-4081-86f0-64ff77155ffc
    }

    @Override
    public void update(KeyValuePair change) {
//begin of modifiable zone................T/9ccc00b1-27d7-43e3-974f-75ee359c3836
        DefaultTableModel model = (DefaultTableModel) tblItemDisplay.getModel();
        switch (change.key) {
            case "StockItem":
                StockItem newItem = (StockItem)change.value;
                model.addRow(new String[] {Integer.toString(newItem.getItemId()), newItem.getItemName(), Float.toString(newItem.getItemPrice())});
                break;
            case "Total":
                lblTotalPrice.setText("Current total: £" + String.format("%.2f", (float)change.value));
            case AbstractController.ITEM_NAME:
                for (int i = 0; i < tblItemDisplay.getRowCount(); i++){
                    // Get the ID of the current row in string format, as this is how it is displayed
                    String stringId = (String)model.getValueAt(i, 0);
                    // Convert the stringId into an integer
                    int intId = Integer.parseInt(stringId);
                    // If this row's ID has the same ID as the data we're getting in
                    if (intId == change.id){
                        model.setValueAt(change.value, i, 1);
                        model.fireTableCellUpdated(i, 1);
                    }
                }
                break;
            case AbstractController.ITEM_PRICE:
                for (int i = 0; i < tblItemDisplay.getRowCount(); i++){
                    String stringId = (String)model.getValueAt(i, 0);
                    int intId = Integer.parseInt(stringId);
                    if (intId == change.id){
                        model.setValueAt(change.value, i, 2);
                        model.fireTableCellUpdated(i, 2);
                    }
                }
                break;
        }
//end of modifiable zone..................E/9ccc00b1-27d7-43e3-974f-75ee359c3836
    }

    private void setUpEventListeners() {
//begin of modifiable zone................T/df3572e1-b53a-4c04-8aa0-0b442648ce87
        btnBarcodeEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.getClass().getDeclaredMethod("scanItem", Integer.TYPE).invoke(controller, Integer.parseInt(txfBarcodeInput.getText()));
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException illegalAccessException) {
                    illegalAccessException.printStackTrace();
                }
            }
        });
//end of modifiable zone..................E/df3572e1-b53a-4c04-8aa0-0b442648ce87
    }

}
