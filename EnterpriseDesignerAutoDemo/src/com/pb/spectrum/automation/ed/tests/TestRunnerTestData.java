package com.pb.spectrum.automation.ed.tests;

import com.jacob.com.LibraryLoader;
import com.pb.spectrum.automation.ed.actions.Application;
import com.pb.spectrum.automation.ed.actions.Job;
import com.pb.spectrum.automation.ed.actions.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by Abhishek Yadav
 */
public class TestRunnerTestData {

    public static void main(String args[]){

        if (args.length < 1) {
            System.out.println("Not test case file provided!!");
        }

        File file = new File("lib", "jacob-1.18-M2-x86.dll");
        System.setProperty(LibraryLoader.JACOB_DLL_PATH,
                file.getAbsolutePath());
        LibraryLoader.loadJacobLibrary();

        File testFile = new File("testCases", args[0]+".txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(testFile));
            String line = "";
            String testStep = "";
            String testData = "";
            while ((line = br.readLine())!= null){
                if(line.contains(";")) {
                    testStep = line.split(";")[0];
                    testData = line.split(";")[1];
                } else {
                    testStep = line;
                }
                if (testStep.equalsIgnoreCase("launchED")){
                    File appURL = new File("resources", "StartED.bat");
                    Application.launchED(appURL.getAbsolutePath());
                } else if (testStep.equalsIgnoreCase("loginED")){
                    String host = testData.split(",")[0];
                    String port = testData.split(",")[1];
                    String username = testData.split(",")[2];
                    String password = testData.split(",")[3];
                    Application.loginED(host, port, username, password);
                } else if (testStep.equalsIgnoreCase("createNewJob")){
                    String jobName = testData.split(",")[0];
                    Job.createNewJob(jobName);
                } else if (testStep.equalsIgnoreCase("addStage")){
                    String jobStage = testData.split(",")[0];
                    int jobStagePosX = Integer.parseInt(testData.split(",")[1]);
                    int jobStagePosY = Integer.parseInt(testData.split(",")[2]);
                    Stage.addStage(jobStage, jobStagePosX, jobStagePosY);
                }
            }

        } catch (Exception e){

        }

    }
}
