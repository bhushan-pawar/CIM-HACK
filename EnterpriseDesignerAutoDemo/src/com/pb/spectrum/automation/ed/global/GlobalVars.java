package com.pb.spectrum.automation.ed.global;

import autoitx4java.AutoItX;
import com.jacob.activeX.ActiveXComponent;

import java.util.ResourceBundle;

public class GlobalVars {
    public static AutoItX autoItX = new AutoItX();
    public static ActiveXComponent autoItActiveX = new ActiveXComponent(
            "AutoItX3.Control");
    public static ResourceBundle masterData = ResourceBundle
            .getBundle("master-data");
    public static ResourceBundle testData = ResourceBundle
            .getBundle("test-data");
}
