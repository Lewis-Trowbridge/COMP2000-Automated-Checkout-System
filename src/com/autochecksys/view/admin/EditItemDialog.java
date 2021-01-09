package com.autochecksys.view.admin;

import com.autochecksys.view.shared.MainFrame;

public class EditItemDialog extends StockItemDialog {
    public String originalName;

    public String originalPrice;

    public String originalStock;

    public EditItemDialog(MainFrame owner, String currentName, String currentPrice, String currentStock) {
//begin of modifiable zone................T/9f48a5d6-06ad-4bbd-878e-06737cd97f51
        super(owner);

//end of modifiable zone..................E/9f48a5d6-06ad-4bbd-878e-06737cd97f51
//begin of modifiable zone................T/76660120-6df7-4762-9dde-9e966f2acb69
        this.originalName = currentName;
        this.originalPrice = currentPrice;
        this.originalStock = currentStock;
//end of modifiable zone..................E/76660120-6df7-4762-9dde-9e966f2acb69
    }

    @Override
    protected void fillValues() {
//begin of modifiable zone................T/185a71ec-2305-4ed5-af8d-0b31803d1456
        txfName.setText(originalName);
        txfPrice.setText(originalPrice);
        txfStock.setText(originalStock);
//end of modifiable zone..................E/185a71ec-2305-4ed5-af8d-0b31803d1456
    }

}
