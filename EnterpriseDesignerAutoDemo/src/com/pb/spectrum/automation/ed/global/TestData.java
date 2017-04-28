package com.pb.spectrum.automation.ed.global;

import java.util.ResourceBundle;

public class TestData {
    public static ResourceBundle testData = GlobalVars.testData;
    public static String host = testData.getString("host");
    public static String port = testData.getString("port");
    public static String username = testData.getString("username");
    public static String password = testData.getString("password");
    public static String job1Name = testData.getString("job1Name");
    public static String job1Stage1 = testData.getString("job1Stage1");
    public static String recordType = testData.getString("recordType");
    public static String fieldSeperator = testData.getString("fieldSeperator");
    public static String job1Stage2 = testData.getString("job1Stage2");

    public static ResourceBundle masterData = GlobalVars.masterData;
    public static String loginWinTitle = masterData.getString("loginWinTitle");
    public static String loginWinText = masterData.getString("loginWinText");
    public static String serverComboBox = masterData.getString("serverComboBox");
    public static String usernameText = masterData.getString("usernameText");
    public static String passwordText = masterData.getString("passwordText");
    public static String portText = masterData.getString("portText");
    public static String loginButton = masterData.getString("loginButton");
    public static String loginButtonText = masterData.getString("loginButtonText");
    public static String edWindowTitle = masterData.getString("edWindowTitle");
    public static String newJobWinTitle = masterData.getString("newJobWinTitle");
    public static String saveAsWinTitle = masterData.getString("saveAsWinTitle");
    public static String saveAsWinText = masterData.getString("saveAsWinText");
    public static String jobNameText = masterData.getString("jobNameText");
    public static String jobNameSaveButton = masterData.getString("jobNameSaveButton");
    public static String jobStatusWinTitle = masterData.getString("jobStatusWinTitle");
    public static String jobStatusRefreshButton = masterData.getString("jobStatusRefreshButton");
    public static String jobStatusCloseButton = masterData.getString("jobStatusCloseButton");
    public static String readFromFileConfigWinTitle = masterData.getString("readFromFileConfigWinTitle");
    public static String writeFromFileConfigWinTitle = masterData.getString("writeFromFileConfigWinTitle");
    public static String openFileWinTitle = masterData.getString("openFileWinTitle");
    public static String saveFileWinTitle = masterData.getString("saveFileWinTitle");
    public static String tabControl = masterData.getString("tabControl");
    public static String fileNameText = masterData.getString("fileNameText");
    public static String recordTypeComboBox = masterData.getString("recordTypeComboBox");
    public static String characterEncodingComboBox = masterData.getString("characterEncodingComboBox");
    public static String fieldSeperatorComboBox = masterData.getString("fieldSeperatorComboBox");
    public static String recordSeperatorComboBox = masterData.getString("recordSeperatorComboBox");
    public static String textQualifierComboBox = masterData.getString("textQualifierComboBox");
    public static String recordLengthText = masterData.getString("recordLengthText");
    public static String headerRecordCheckBox = masterData.getString("headerRecordCheckBox");
    public static String treatRecordCheckBox = masterData.getString("treatRecordCheckBox");
    public static String fieldAutoGenerateButton = masterData.getString("fieldAutoGenerateButton");
    public static String fieldSettingWinTitle = masterData.getString("fieldSettingWinTitle");
    public static String quickAddButton = masterData.getString("quickAddButton");
    public static String quickAddSettingWinTitle = masterData.getString("quickAddSettingWinTitle");
    public static String selectAllButton = masterData.getString("selectAllButton");
    public static String okButton = masterData.getString("okButton");

}
