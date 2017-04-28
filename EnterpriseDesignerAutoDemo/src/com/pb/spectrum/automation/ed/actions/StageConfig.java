package com.pb.spectrum.automation.ed.actions;

import autoitx4java.AutoItX;
import com.jacob.activeX.ActiveXComponent;
import com.pb.spectrum.automation.ed.global.GlobalVars;
import com.pb.spectrum.automation.ed.global.TestData;

public class StageConfig {

    static AutoItX autoItX = GlobalVars.autoItX;
    static ActiveXComponent autoItActiveX = GlobalVars.autoItActiveX;

    static String readFromFileConfigWinTitle = TestData.readFromFileConfigWinTitle;
    static String writeFromFileConfigWinTitle = TestData.writeFromFileConfigWinTitle;
    static String openFileWinTitle = TestData.openFileWinTitle;
    static String saveFileWinTitle = TestData.saveFileWinTitle;
    static String tabControl = TestData.tabControl;
    static String fileNameText = TestData.fileNameText;
    static String recordTypeComboBox = TestData.recordTypeComboBox;
    static String characterEncodingComboBox = TestData.characterEncodingComboBox;
    static String fieldSeperatorComboBox = TestData.fieldSeperatorComboBox;
    static String recordSeperatorComboBox = TestData.recordSeperatorComboBox;
    static String textQualifierComboBox = TestData.textQualifierComboBox;
    static String recordLengthText = TestData.recordLengthText;
    static String headerRecordCheckBox = TestData.headerRecordCheckBox;
    static String treatRecordCheckBox = TestData.treatRecordCheckBox;
    static String fieldAutoGenerateButton = TestData.fieldAutoGenerateButton;
    static String fieldSettingWinTitle = TestData.fieldSettingWinTitle;
    static String quickAddButton = TestData.quickAddButton;
    static String quickAddSettingWinTitle = TestData.quickAddSettingWinTitle;
    static String selectAllButton = TestData.selectAllButton;
    static String okButton = TestData.okButton;

    /**
     * @param filepath
     * @param recordType
     * @param fieldSeperator
     */

    public static void readFromFileConfig(String filepath, String recordType, String fieldSeperator) {
        try {
            autoItX.winWait(readFromFileConfigWinTitle);
            autoItX.winActivate(readFromFileConfigWinTitle);
            autoItX.winWaitActive(readFromFileConfigWinTitle);
            autoItX.winSetState(readFromFileConfigWinTitle, "", autoItX.SW_MAXIMIZE);
            int winWidth = autoItX.winGetPosWidth(readFromFileConfigWinTitle);
            int winHeight = autoItX.winGetPosHeight(readFromFileConfigWinTitle);
            System.out.println(winWidth + ", " + winHeight);
            int fileInputPosX = (winWidth * 96) / 100;
            autoItX.mouseClick("", fileInputPosX, 110);
            autoItX.winWait(openFileWinTitle);
            autoItX.winActivate(openFileWinTitle);
            autoItX.winWaitActive(openFileWinTitle);
            autoItActiveX.invoke("Send", "{TAB 2}");
            autoItActiveX.invoke("Send", filepath);
            autoItActiveX.invoke("Send", "{ENTER}");
            autoItX.winWait(readFromFileConfigWinTitle);
            autoItX.winActivate(readFromFileConfigWinTitle);
            autoItX.winWaitActive(readFromFileConfigWinTitle);
            autoItX.controlSend(readFromFileConfigWinTitle, "", recordTypeComboBox,
                    recordType);
            Thread.sleep(5000);
            autoItX.controlSend(readFromFileConfigWinTitle, "", fieldSeperatorComboBox,
                    fieldSeperator);
            autoItActiveX.invoke("Send", "!F");
            autoItActiveX.invoke("Send", "+{TAB 8}");
            autoItActiveX.invoke("Send", "{RIGHT}");
            autoItX.controlClick(readFromFileConfigWinTitle, "", fieldAutoGenerateButton);
            autoItX.winWait(fieldSettingWinTitle);
            autoItActiveX.invoke("Send", "{ENTER}");
            autoItX.controlClick(readFromFileConfigWinTitle, "", okButton);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Exception is - " + e);
        }
    }

    /**
     * @param filepath
     * @param recordType
     * @param fieldSeperator
     */

    public static void writeToFileConfig(String filepath, String recordType, String fieldSeperator) {
        try {
            autoItX.winWait(writeFromFileConfigWinTitle);
            autoItX.winActivate(writeFromFileConfigWinTitle);
            autoItX.winWaitActive(writeFromFileConfigWinTitle);
            autoItX.winSetState(writeFromFileConfigWinTitle, "", autoItX.SW_MAXIMIZE);
            int winWidth = autoItX.winGetPosWidth(writeFromFileConfigWinTitle);
            int winHeight = autoItX.winGetPosHeight(writeFromFileConfigWinTitle);
            System.out.println(winWidth + ", " + winHeight);
            int fileInputPosX = (winWidth * 96) / 100;
            autoItX.mouseClick("", fileInputPosX, 110);
            autoItX.winWait(saveFileWinTitle);
            autoItX.winActivate(saveFileWinTitle);
            autoItX.winWaitActive(saveFileWinTitle);
            autoItActiveX.invoke("Send", "{TAB 2}");
            autoItActiveX.invoke("Send", filepath);
            autoItActiveX.invoke("Send", "{ENTER}");
            autoItX.winWait(writeFromFileConfigWinTitle);
            autoItX.winActivate(writeFromFileConfigWinTitle);
            autoItX.winWaitActive(writeFromFileConfigWinTitle);
            autoItX.controlSend(writeFromFileConfigWinTitle, "", recordTypeComboBox,
                    recordType);
            Thread.sleep(5000);
            autoItX.controlSend(writeFromFileConfigWinTitle, "", fieldSeperatorComboBox,
                    fieldSeperator);
            autoItActiveX.invoke("Send", "!F");
            autoItActiveX.invoke("Send", "+{TAB 8}");
            autoItActiveX.invoke("Send", "{RIGHT}");
            autoItX.controlClick(writeFromFileConfigWinTitle, "", fieldAutoGenerateButton);
            autoItX.winWait(fieldSettingWinTitle);
            autoItActiveX.invoke("Send", "{ENTER}");
            autoItX.controlClick(writeFromFileConfigWinTitle, "", okButton);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Exception is - " + e);
        }
    }
}
