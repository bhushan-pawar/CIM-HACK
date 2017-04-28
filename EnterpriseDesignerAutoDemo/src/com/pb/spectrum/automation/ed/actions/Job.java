package com.pb.spectrum.automation.ed.actions;

import autoitx4java.AutoItX;
import com.jacob.activeX.ActiveXComponent;
import com.pb.spectrum.automation.ed.global.GlobalVars;
import com.pb.spectrum.automation.ed.global.TestData;

public class Job {

    static AutoItX autoItX = GlobalVars.autoItX;
    static ActiveXComponent autoItActiveX = GlobalVars.autoItActiveX;

    static String edWindowTitle = TestData.edWindowTitle;
    static String newJobWinTitle = TestData.newJobWinTitle;
    static String saveAsWinTitle = TestData.saveAsWinTitle;
    static String saveAsWinText = TestData.saveAsWinText;
    static String jobNameText = TestData.jobNameText;
    static String jobNameSaveButton = TestData.jobNameSaveButton;
    static String jobStatusWinTitle = TestData.jobStatusWinTitle;
    static String jobStatusRefreshButton = TestData.jobStatusRefreshButton;
    static String jobStatusCloseButton = TestData.jobStatusCloseButton;

    /** 
     * @param jobName
     */

    public static void createNewJob(String jobName) {
        try {
            autoItX.winActivate(edWindowTitle);
            autoItX.winWaitActive(edWindowTitle);
            autoItActiveX.invoke("Send", "!F");
            Thread.sleep(1000);
            autoItActiveX.invoke("Send", "{RIGHT}");
            autoItActiveX.invoke("Send", "{RIGHT}");
            autoItActiveX.invoke("Send", "!J");
            Thread.sleep(2000);
            autoItX.winWait(edWindowTitle, newJobWinTitle);
            autoItActiveX.invoke("Send", "!F");
            Thread.sleep(1000);
            autoItActiveX.invoke("Send", "A");
            autoItX.winWait(saveAsWinTitle);
            autoItX.winActivate(saveAsWinTitle, saveAsWinText);
            autoItX.winWaitActive(saveAsWinTitle, saveAsWinText);
            autoItX.controlClick(saveAsWinTitle, saveAsWinText, jobNameText);
            autoItActiveX.invoke("Send", "{BS}");
            autoItActiveX.invoke("Send", jobName);
//            autoItX.ControlSetText(saveAsWinTitle, saveAsWinText,
//                    "[NAME:nameTextEditor]");
//            autoItX.controlSend(saveAsWinTitle, saveAsWinText, "[NAME:nameTextEditor]",
//                    jobName);
            autoItX.controlClick(saveAsWinTitle, saveAsWinText, jobNameSaveButton);
            autoItX.winWait(edWindowTitle);
            autoItX.winActivate(edWindowTitle);
            autoItX.winWaitActive(edWindowTitle);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Exception is - " + e);
        }
    }

    public static void saveJob(){
        try {
            autoItX.winActivate(edWindowTitle);
            autoItX.winWaitActive(edWindowTitle);
            autoItActiveX.invoke("Send", "!F");
            Thread.sleep(1000);
            autoItActiveX.invoke("Send", "S");
            Thread.sleep(1000);
            autoItActiveX.invoke("Send", "{ENTER}");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Exception is - " + e);
        }
    }

    public static void runJob(){
        try {
            autoItX.winActivate(edWindowTitle);
            autoItX.winWaitActive(edWindowTitle);
            autoItActiveX.invoke("Send", "{F12}");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Exception is - " + e);
        }
    }

    /**
     * @param refreshWaitTime
     */

    public static void refreshJobStatus(int refreshWaitTime){
        try {
            autoItX.winActivate(jobStatusWinTitle);
            autoItX.winWaitActive(jobStatusWinTitle);
            Thread.sleep(refreshWaitTime);
            autoItX.controlClick(jobStatusWinTitle, "", jobStatusRefreshButton);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Exception is - " + e);
        }
    }

    public static void closeJobStatus(){
        try {
            autoItX.winActivate(jobStatusWinTitle);
            autoItX.winWaitActive(jobStatusWinTitle);
            autoItX.winClose(jobStatusWinTitle);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Exception is - " + e);
        }
    }
}
