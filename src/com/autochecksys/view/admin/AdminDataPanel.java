package com.autochecksys.view.admin;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.autochecksys.KeyValuePair;
import com.autochecksys.controller.shared.AbstractController;
import com.autochecksys.view.shared.DisplayPanel;
import com.autochecksys.view.shared.GridBagConstraintsBuilder;
import com.autochecksys.view.shared.MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

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
        tblItems = new JTable(new DefaultTableModel(itemColumns, 0)) {
            // Override table cell renderer to colour the background of cells with less than 5 items
            // left in stock
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                JComponent component = (JComponent) super.prepareRenderer(renderer, row, column);

                if (Integer.parseInt(getValueAt(row, 3).toString()) < 5){
                    component.setBackground(Color.RED);
                    // Set the font to bold for items low on stock to communicate the problem without
                    // solely relying on colour
                    component.setFont(component.getFont().deriveFont(Font.BOLD, 12f));
                }
                else {
                    // Set back to normal in case of an updated previously low-stock item
                    component.setBackground(Color.WHITE);
                    component.setFont(component.getFont().deriveFont(Font.PLAIN, 12f));
                }
                return component;
            }
        };
        srpItemTablePanel = new JScrollPane(tblItems);
        GridBagConstraints srpItemTablePanelConstraints = builder.setGridWidth(2).setFill(GridBagConstraints.BOTH).build();

        pnlItemControls = new JPanel();
        pnlItemControls.setLayout(new GridBagLayout());
        pnlItemControls.setBorder(new LineBorder(Color.BLACK));
        GridBagConstraints pnlItemControlsConstraints = builder.setGridY(1).setFill(GridBagConstraints.BOTH).build();

        btnAddItem = new JButton("Add");
        GridBagConstraints btnAddItemConstraints = builder.setFill(GridBagConstraints.HORIZONTAL).build();

        btnEditItem = new JButton("Edit");
        GridBagConstraints btnEditItemConstraints = builder.setGridX(1).setFill(GridBagConstraints.HORIZONTAL).build();

        btnDeleteItem = new JButton("Delete");
        GridBagConstraints btnDeleteItemConstraints = builder.setGridX(2).setFill(GridBagConstraints.HORIZONTAL).build();

        lblItemControlsTitle = new JLabel("Items");
        lblItemControlsTitle.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints lblItemControlsTitleConstraints = builder.setGridY(1).setGridWidth(3).setFill(GridBagConstraints.HORIZONTAL).build();

        pnlOrdersControls = new JPanel();
        pnlOrdersControls.setLayout(new GridBagLayout());
        pnlOrdersControls.setBorder(new LineBorder(Color.BLACK));
        GridBagConstraints pnlOrdersControlsConstraints = builder.setGridX(1).setGridY(1).setFill(GridBagConstraints.BOTH).build();

        btnAddOrder = new JButton("Add");
        GridBagConstraints btnAddOrderConstraints = builder.setFill(GridBagConstraints.HORIZONTAL).build();

        btnFulfillOrder = new JButton("Fulfill");
        GridBagConstraints btnFulfillOrderConstraints = builder.setGridX(1).setFill(GridBagConstraints.HORIZONTAL).build();

        lblOrderControlsTitle = new JLabel("Orders");
        lblOrderControlsTitle.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints lblOrderControlsTitleConstraints = builder.setGridY(1).setGridWidth(2).setFill(GridBagConstraints.HORIZONTAL).build();

        Object[] orderColumns = {"ID", "Stock ID", "Quantity"};
        tblOrders = new JTable(new DefaultTableModel(orderColumns, 0));
        srpOrderTablePanel = new JScrollPane(tblOrders);
        GridBagConstraints srpOrderTablePanelConstraints = builder.setGridY(2).setGridWidth(2).setFill(GridBagConstraints.BOTH).build();

        pnlOrdersControls.add(btnAddOrder, btnAddOrderConstraints);
        pnlOrdersControls.add(btnFulfillOrder, btnFulfillOrderConstraints);
        pnlOrdersControls.add(lblOrderControlsTitle, lblOrderControlsTitleConstraints);

        pnlItemControls.add(btnAddItem, btnAddItemConstraints);
        pnlItemControls.add(btnEditItem, btnEditItemConstraints);
        pnlItemControls.add(btnDeleteItem, btnDeleteItemConstraints);
        pnlItemControls.add(lblItemControlsTitle, lblItemControlsTitleConstraints);

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
        DefaultTableModel itemModel = (DefaultTableModel) tblItems.getModel();
        DefaultTableModel orderModel = (DefaultTableModel) tblOrders.getModel();
        int row;
        switch (change.key){
            case "NewStockItemDisplay":
                String[] itemData = (String[]) change.value;
                itemModel.addRow(itemData);
                itemModel.fireTableDataChanged();
                break;
            case "NewStockOrderDisplay":
                String[] orderData = (String[]) change.value;
                orderModel.addRow(orderData);
                orderModel.fireTableDataChanged();
                break;
            case "DeleteStockItem":
                Integer stockIdToDelete = (Integer) change.value;
                row = getRowWithId(stockIdToDelete, tblItems);
                itemModel.removeRow(row);
                itemModel.fireTableDataChanged();
                break;
            case "FulfillStockOrder":
                int orderIdToDelete = (int) change.value;
                row = getRowWithId(orderIdToDelete, tblOrders);
                orderModel.removeRow(row);
                itemModel.fireTableDataChanged();
                break;
            case AbstractController.ITEM_NAME:
                String newName = (String) change.value;
                replaceItemTableValueWithId(change.id, 1, newName, tblItems);
                break;
            case AbstractController.ITEM_PRICE:
                float newPrice = (float) change.value;
                String newPriceString = String.format("%.2f", newPrice);
                replaceItemTableValueWithId(change.id, 2, newPriceString, tblItems);
                break;
            case AbstractController.STOCK_COUNT:
                int newCount = (int) change.value;
                String newCountString = Integer.toString(newCount);
                replaceItemTableValueWithId(change.id, 3, newCountString, tblItems);
                break;
        }
//end of modifiable zone(JavaCode)........E/1f76c533-4e4c-4297-aa9f-4d6645fa2c9a
    }

    // Utility method to replace a value in a given table
    private void replaceItemTableValueWithId(int id, int column, String value, JTable tableToReplace){
        DefaultTableModel model = (DefaultTableModel) tableToReplace.getModel();
        int row = getRowWithId(id, tableToReplace);
        model.setValueAt(value, row, column);
        model.fireTableDataChanged();
    }

    // Utility method to get a row number in the physical table using a given ID
    private int getRowWithId(int id, JTable tableToSearch){
        DefaultTableModel model = (DefaultTableModel) tableToSearch.getModel();
        for (int currentRow = 0; currentRow < model.getRowCount(); currentRow++){
            String currentStringId = (String) model.getValueAt(currentRow, 0);
            int currentId = Integer.parseInt(currentStringId);
            if (currentId == id){
                return currentRow;
            }
        }
        return -1;
    }

    private void setUpEventListeners() {
//begin of modifiable zone(JavaCode)......C/aec23e2f-2de6-431e-ac5d-bd617ba2e6e2
        btnAddItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AddItemDialog addDialog = new AddItemDialog(mainFrameToUse);
                    Object[] results = addDialog.showDialog();
                    addDialog.dispose();
                    if (results.length != 0){
                        controller.getClass().getDeclaredMethod("addStockItem", String.class, float.class, int.class).invoke(controller, (String)results[0], (Float)results[1], (Integer)results[2]);
                    }
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException noSuchMethodException) {
                    noSuchMethodException.printStackTrace();
                }
            }
        });

        btnEditItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int currentRow = tblItems.getSelectedRow();
                    if (currentRow != -1){
                        // Get values ready
                        String selectedName = (String) tblItems.getValueAt(currentRow, 1);
                        String selectedPrice = (String) tblItems.getValueAt(currentRow, 2);
                        String selectedStock = (String) tblItems.getValueAt(currentRow, 3);
                        EditItemDialog editDialog = new EditItemDialog(mainFrameToUse, selectedName, selectedPrice, selectedStock);
                        Object[] results = editDialog.showDialog();
                        if (results.length != 0){
                            String selectedId = (String) tblItems.getValueAt(currentRow, 0);
                            int id = Integer.parseInt(selectedId);
                            controller.getClass().getDeclaredMethod("editStockItem", int.class, String.class, float.class, int.class).invoke(controller, id, (String) results[0], (float) results[1], (int) results[2]);
                        }
                    }
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnDeleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentRow = tblItems.getSelectedRow();
                if (currentRow != -1){
                    String stringCurrentId = (String) tblItems.getValueAt(currentRow, 0);
                    Integer currentId = Integer.parseInt(stringCurrentId);
                    try {
                        controller.getClass().getDeclaredMethod("deleteStockItem", int.class).invoke(controller, currentId);
                    } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        btnAddOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentItemRow = tblItems.getSelectedRow();
                String currentItemId = (String) tblItems.getValueAt(currentItemRow, 0);
                String currentItemName = (String) tblItems.getValueAt(currentItemRow, 1);
                String dialogMessage = "Please input the quantity of " + currentItemName + " ordered.";
                String stringQuantity = JOptionPane.showInputDialog(null, dialogMessage, "Ordering " + currentItemName, JOptionPane.PLAIN_MESSAGE);
                if (stringQuantity != null) {
                    int quantity = Integer.parseInt(stringQuantity);
                    int currentItemIdInt = Integer.parseInt(currentItemId);
                    try {
                        controller.getClass().getDeclaredMethod("createStockOrder", int.class, int.class).invoke(controller, currentItemIdInt, quantity);
                    } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | NumberFormatException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        btnFulfillOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentOrderRow = tblOrders.getSelectedRow();
                String currentOrderIdString = (String) tblOrders.getValueAt(currentOrderRow, 0);
                int currentOrderId = Integer.parseInt(currentOrderIdString);
                try {
                    controller.getClass().getDeclaredMethod("fulfillStockOrder", int.class).invoke(controller, currentOrderId);
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
                    ex.printStackTrace();
                }
            }
        });
//end of modifiable zone(JavaCode)........E/aec23e2f-2de6-431e-ac5d-bd617ba2e6e2
    }

}
