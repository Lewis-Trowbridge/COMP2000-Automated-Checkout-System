package com.autochecksys.view.shared;

import java.awt.GridBagConstraints;

public class GridBagConstraintsBuilder {
    private int gridx = 0;

    private int gridy = 0;

    private int gridwidth = 1;

    private int gridheight = 1;

    private int fill = 0;

    public GridBagConstraints build() {
//begin of modifiable zone................T/5abb2f1d-03b5-4267-bb97-33a83552fe30
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = this.gridx;
        this.gridx = 0;
        constraints.gridy = this.gridy;
        this.gridy = 0;
        constraints.gridwidth = this.gridwidth;
        this.gridwidth = 1;
        constraints.gridheight = this.gridheight;
        this.gridheight = 1;
        constraints.fill = this.fill;
        this.fill = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
//end of modifiable zone..................E/5abb2f1d-03b5-4267-bb97-33a83552fe30
//begin of modifiable zone................T/8fb678e0-30df-438c-b503-b81243891897
        return constraints;
//end of modifiable zone..................E/8fb678e0-30df-438c-b503-b81243891897
    }

    public GridBagConstraintsBuilder setGridX(int value) {
//begin of modifiable zone................T/a2069ca2-c716-4554-9461-e3c826fdb160
        this.gridx = value;
//end of modifiable zone..................E/a2069ca2-c716-4554-9461-e3c826fdb160
//begin of modifiable zone................T/69f276d6-f057-40da-abf0-a3f46742f9b2
        return this;
//end of modifiable zone..................E/69f276d6-f057-40da-abf0-a3f46742f9b2
    }

    public GridBagConstraintsBuilder setGridY(int value) {
//begin of modifiable zone................T/5b5e57f2-31ad-48d4-a681-4e1b87d3965d
        this.gridy = value;
//end of modifiable zone..................E/5b5e57f2-31ad-48d4-a681-4e1b87d3965d
//begin of modifiable zone................T/24a15793-a694-40f0-83ad-7110e6c3b505
        return this;
//end of modifiable zone..................E/24a15793-a694-40f0-83ad-7110e6c3b505
    }

    public GridBagConstraintsBuilder setGridWidth(int value) {
//begin of modifiable zone................T/00603642-9547-4627-a7de-bd2fb3d1e697
        this.gridwidth = value;
//end of modifiable zone..................E/00603642-9547-4627-a7de-bd2fb3d1e697
//begin of modifiable zone................T/d52b239b-e099-41a4-b603-b2f53a40dc0e
        return this;
//end of modifiable zone..................E/d52b239b-e099-41a4-b603-b2f53a40dc0e
    }

    public GridBagConstraintsBuilder setGridHeight(int value) {
//begin of modifiable zone................T/bca86a99-d726-4f35-9c85-39ec75b4ac40
        this.gridheight = value;
//end of modifiable zone..................E/bca86a99-d726-4f35-9c85-39ec75b4ac40
//begin of modifiable zone................T/0efdef9b-ecc7-4038-bacb-4c1b100b309c
        return this;
//end of modifiable zone..................E/0efdef9b-ecc7-4038-bacb-4c1b100b309c
    }

    public GridBagConstraintsBuilder setFill(int value) {
//begin of modifiable zone................T/d2cf895a-db5e-4db7-abea-c332374e1672
        this.fill = value;
//end of modifiable zone..................E/d2cf895a-db5e-4db7-abea-c332374e1672
//begin of modifiable zone................T/3bbd8591-3c7b-4b1c-87fa-6a8f1d2927af
        return this;
//end of modifiable zone..................E/3bbd8591-3c7b-4b1c-87fa-6a8f1d2927af
    }

}
