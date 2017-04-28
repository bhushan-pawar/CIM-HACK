package com.pb.spectrum.automation.ed.tests;

/**
 * Created by Abhishek Yadav
 */

import com.jacob.com.LibraryLoader;
import com.pb.spectrum.automation.ed.actions.Application;
import com.pb.spectrum.automation.ed.actions.Job;
import com.pb.spectrum.automation.ed.actions.Stage;
import com.pb.spectrum.automation.ed.actions.StageConfig;
import com.pb.spectrum.automation.ed.global.TestData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class E2E_Test {
    
    String host = TestData.host;
    String port = TestData.port;
    String username = TestData.username;
    String password = TestData.password;
    String job1Name = TestData.job1Name;
    String job1Stage1 = TestData.job1Stage1;
    String recordType = TestData.recordType;
    String fieldSeperator = TestData.fieldSeperator;
    String job1Stage2 = TestData.job1Stage2;

    @BeforeClass
    public void beforeClass() {
        File file = new File("lib", "jacob-1.18-M2-x86.dll");
        System.setProperty(LibraryLoader.JACOB_DLL_PATH,
                file.getAbsolutePath());
        LibraryLoader.loadJacobLibrary();
    }

    @Test(priority = 1)
    public void launchEnterpriseDesigner() {
        File appURL = new File("resources", "StartED.bat");
        Application.launchED(appURL.getAbsolutePath());
    }

    @Test(priority = 2)
    public void loginEnterpriseDesigner() {
        Application.loginED(host, port, username, password);
    }

    @Test(priority = 3)
    public void createNewJob() {
        Job.createNewJob(job1Name);
    }

    @Test(priority = 4)
    public void addReadFromFileStage() {
        Stage.addStage(job1Stage1, 350, 300);
    }

    @Test(priority = 5)
    public void setReadFromFileStageConfig() {
        Stage.openStageConfig(350, 300);
        File input = new File("resources", "sample_input.txt");
        StageConfig.readFromFileConfig(input.getAbsolutePath(), recordType, fieldSeperator);
    }

    @Test(priority = 6)
    public void addWriteToFileStage() {
        Stage.addStage(job1Stage2, 700, 300);
    }

    @Test(priority = 7)
    public void setWriteToFileStageConfig() {
        Stage.openStageConfig(700, 300);
        File output = new File("resources", "sample_output.txt");
        StageConfig.writeToFileConfig(output.getAbsolutePath(), recordType, fieldSeperator);
    }

    @Test(priority = 8)
    public void createChannelForReadAndWriteStage() {
        Stage.stageChannelInputPort(350, 300, 700, 300);
    }

    @Test(priority = 9)
    public void saveAndRunJob() {
        Job.saveJob();
        Job.runJob();
        Job.refreshJobStatus(5000);
        Job.closeJobStatus();
    }

    @Test(priority = 10)
    public void exitEnterpriseDesigner() {
//        Application.exitED();
    }

    @Test(priority = 0)
    public void test() {
//        autoItX.winActivate("Enterprise Designer", "");
//        autoItX.winWaitActive("Enterprise Designer", "");
    }

}
