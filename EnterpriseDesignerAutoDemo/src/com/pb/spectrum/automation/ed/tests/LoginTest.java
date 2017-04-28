package com.pb.spectrum.automation.ed.tests;

/**
 * Created by Abhishek Yadav
 */

import autoitx4java.AutoItX;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.LibraryLoader;
import com.pb.spectrum.automation.ed.actions.Application;

import java.io.File;
import java.util.ResourceBundle;

public class LoginTest {

    public static void main(String[] args) {

        ResourceBundle testDataMain = ResourceBundle
                .getBundle("test-data");
        String host = testDataMain.getString("host");
        String port = testDataMain.getString("port");
        String username = testDataMain.getString("username");
        String password = testDataMain.getString("password");

        File file = new File("lib", "jacob-1.18-M2-x86.dll");
        System.setProperty(LibraryLoader.JACOB_DLL_PATH,
                file.getAbsolutePath());
        LibraryLoader.loadJacobLibrary();
        AutoItX autoItX = new AutoItX();
        ActiveXComponent autoItActiveX = new ActiveXComponent(
                "AutoItX3.Control");
        File appURL = new File("resources", "StartED.bat");
        Application.launchED(appURL.getAbsolutePath());
        Application.loginED(host, port, username, password);
        Application.exitED();

    }
}
