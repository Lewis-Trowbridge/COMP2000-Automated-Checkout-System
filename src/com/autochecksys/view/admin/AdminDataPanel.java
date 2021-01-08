package com.autochecksys.view.admin;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.autochecksys.KeyValuePair;
import com.autochecksys.view.shared.DisplayPanel;
import com.autochecksys.view.shared.GridBagConstraintsBuilder;
import com.autochecksys.view.shared.MainFrame;

import java.awt.*;

public class AdminDataPanel extends DisplayPanel {
    public JScrollPane srpItemTablePanel;

    public JTable tblItems;

    public JScrollPane srpOrderTablePanel;

    public JTable tblOrders;

    public JPanel pnlItemControls;

    public JButton btnAddItem;

    public JButton btnEditItem;

    public JButton btnDeleteItem;

    public JLabel lblItemControlsTitle;

    public JPanel pnlOrdersControls;

    public JButton btnAddOrder;

    public JButton btnFulfillOrder;

    public JLabel lblOrderControlsTitle;

    public AdminDataPanel(MainFrame mainFrameToUse) {
//begin of modifiable zone(JavaSuper).....C/16e44178-5c5b-4387-9d17-40126493d193
        super(mainFrameToUse);
//end of modifiable zone(JavaSuper).......E/16e44178-5c5b-4387-9d17-40126493d193
//begin of modifiable zone(JavaCode)......C/16e44178-5c5b-4387-9d17-40126493d193

//end of modifiable zone(JavaCode)........E/16e44178-5c5b-4387-9d17-40126493d193
    }

    @Override
    protected void setUpComponents() {
//begin of modifiable zone(JavaCode)......C/5fb5842d-3d9e-49bd-a108-60fd43f3151b
        this.setLayout(new GridBagLayout());
        GridBagConstraintsBuilder builder = new GridBagConstraintsBuilder();

        Object[] itemColumns = {"ID", "Name", "Price", "Stock"};
        tblItems = new JTable(new DefaultTableModel(itemColumns, 0));
        srpItemTablePanel = new JScrollPane(tblItems);
        GridBagConstraints srpItemTablePanelConstraints = builder.setGridWidth(2).setFill(GridBagConstraints.BOTH).build();

        pnlItemControls = new JPanel();
        pnlItemControls.setLayout(new GridBagLayout());
        pnlItemControls.setBorder(new LineBorder(Color.BLACK));
        GridBagConstraints pnlItemControlsConstraints = builder.setGridY(1).setFill(GridBagConstraints.BOTH).build();

        btnAddItem = new JButton("Add");
        GridBagConstraints btnAddItemConstraints = builder.setFill(GridBagConstraints.HORIZONTAL).build();
        pnlItemControls.add(btnAddItem, btnAddItemConstraints);

        btnEditItem = new JButton("Edit");
        GridBagConstraints btnEditItemConstraints = builder.setGridX(1).setFill(GridBagConstraints.HORIZONTAL).build();
        pnlItemControls.add(btnEditItem, btnEditItemConstraints);

        btnDeleteItem = new JButton("Delete");
        GridBagConstraints btnDeleteItemConstraints = builder.setGridX(2).setFill(GridBagConstraints.HORIZONTAL).build();
        pnlItemControls.add(btnDeleteItem, btnDeleteItemConstraints);

        lblItemControlsTitle = new JLabel("Items");
        lblItemControlsTitle.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints lblItemControlsTitleConstraints = builder.setGridY(1).setGridWidth(3).setFill(GridBagConstraints.HORIZONTAL).build();
        pnlItemControls.add(lblItemControlsTitle, lblItemControlsTitleConstraints);

        pnlOrdersControls = new JPanel();
        pnlOrdersControls.setLayout(new GridBagLayout());
        pnlOrdersControls.setBorder(new LineBorder(Color.BLACK));
        GridBagConstraints pnlOrdersControlsConstraints = builder.setGridX(1).setGridY(1).setFill(GridBagConstraints.BOTH).build();

        Object[] orderColumns = {"ID", "Stock ID", "Quantity"};
        tblOrders = new JTable(new DefaultTableModel(orderColumns, 0));
        srpOrderTablePanel = new JScrollPane(tblOrders);
        GridBagConstraints srpOrderTablePanelConstraints = builder.setGridY(2).setGridWidth(2).setFill(GridBagConstraints.BOTH).build();

        this.add(srpItemTablePanel, srpItemTablePanelConstraints);
        this.add(pnlItemControls, pnlItemControlsConstraints);
        this.add(pnlOrdersControls, pnlOrdersControlsConstraints);
        this.add(srpOrderTablePanel, srpOrderTablePanelConstraints);

        setUpEventListeners();
//end of modifiable zone(JavaCode)........E/5fb5842d-3d9e-49bd-a108-60fd43f3151b
    }

    @Override
    public void update(KeyValuePair change) {
//begin of modifiable zone(JavaCode)......C/1f76c533-4e4c-4297-aa9f-4d6645fa2c9a

//end of modifiable zone(JavaCode)........E/1f76c533-4e4c-4297-aa9f-4d6645fa2c9a
    }

    private void setUpEventListeners() {
//begin of modifiable zone(JavaCode)......C/aec23e2f-2de6-431e-ac5d-bd617ba2e6e2

//end of modifiable zone(JavaCode)........E/aec23e2f-2de6-431e-ac5d-bd617ba2e6e2
    }

}
