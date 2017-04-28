package com.pb.spectrum.automation.ed.actions;

import autoitx4java.AutoItX;
import com.jacob.activeX.ActiveXComponent;
import com.pb.spectrum.automation.ed.global.GlobalVars;
import com.pb.spectrum.automation.ed.global.TestData;

public class Application {

    static AutoItX autoItX = GlobalVars.autoItX;
    static ActiveXComponent autoItActiveX = GlobalVars.autoItActiveX;

    static String loginWinTitle = TestData.loginWinTitle;
    static String loginWinText = TestData.loginWinText;
    static String serverComboBox = TestData.serverComboBox;
    static String usernameText = TestData.usernameText;
    static String passwordText = TestData.passwordText;
    static String portText = TestData.portText;
    static String loginButton = TestData.loginButton;
    static String loginButtonText = TestData.loginButtonText;
    static String edWindowTitle = TestData.edWindowTitle;

    /**
     * @param appURL
     */

    public static void launchED(String appURL) {
        try {
            autoItX.run(appURL);
            autoItX.winWait(loginWinTitle, loginWinText);
            autoItX.winActivate(loginWinTitle, loginWinText);
            autoItX.winWaitActive(loginWinTitle, loginWinText);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Exception is - " + e);
        }
    }

    /**
     * @param host
     * @param port
     * @param username
     * @param password
     */

    public static void loginED(String host, String port, String username, String password) {
        try {
            autoItX.winActivate(loginWinTitle, loginWinText);
            autoItX.winWaitActive(loginWinTitle, loginWinText);
            autoItX.ControlSetText(loginWinTitle, "", serverComboBox, "");
            autoItX.controlSend(loginWinTitle, "", serverComboBox,
                    host);
            autoItX.ControlSetText(loginWinTitle, "", usernameText, "");
            autoItX.controlSend(loginWinTitle, "", usernameText,
                    username);
            autoItX.ControlSetText(loginWinTitle, "",
                    passwordText, "");
            autoItX.controlSend(loginWinTitle, "", passwordText,
                    password);
            autoItX.ControlSetText(loginWinTitle, "",
                    portText, "");
            autoItX.controlSend(loginWinTitle, "", portText,
                    port);
            autoItX.controlClick(loginWinTitle, loginButtonText, loginButton);
            autoItX.winWait(edWindowTitle);
            autoItX.winActivate(edWindowTitle);
            autoItX.winWaitActive(edWindowTitle);
            autoItX.winSetState(edWindowTitle, "", autoItX.SW_MAXIMIZE);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Exception is - " + e);
        }
    }

    public static void exitED() {
        try {
            autoItX.winActivate(edWindowTitle);
            autoItX.winWaitActive(edWindowTitle);
            autoItActiveX.invoke("Send", "!F");
            autoItActiveX.invoke("Send", "X");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Exception is - " + e);
        }
    }

    public static void closeED() {
        try {
            autoItX.winActivate(edWindowTitle);
            autoItX.winWaitActive(edWindowTitle);
            autoItActiveX.invoke("Send", "!F4");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Exception is - " + e);
        }
    }
}
