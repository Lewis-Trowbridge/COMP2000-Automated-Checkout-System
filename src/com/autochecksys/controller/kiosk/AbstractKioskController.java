package com.autochecksys.controller.kiosk;

import com.autochecksys.controller.shared.AbstractController;

public abstract class AbstractKioskController extends AbstractController {
    public abstract void scanItem(int id);

}
