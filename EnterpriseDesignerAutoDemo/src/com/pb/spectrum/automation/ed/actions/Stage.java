package com.pb.spectrum.automation.ed.actions;

import autoitx4java.AutoItX;
import com.jacob.activeX.ActiveXComponent;
import com.pb.spectrum.automation.ed.global.GlobalVars;
import com.pb.spectrum.automation.ed.global.TestData;

public class Stage {

    static AutoItX autoItX = GlobalVars.autoItX;
    static ActiveXComponent autoItActiveX = GlobalVars.autoItActiveX;

    static String edWindowTitle = TestData.edWindowTitle;

    /**
     * @param stageName
     * @param moveToPosX
     * @param moveToPosY
     */

    public static void addStage(String stageName, int moveToPosX, int moveToPosY) {
        try {
            autoItX.winActivate(edWindowTitle);
            autoItX.winWaitActive(edWindowTitle);
            int winHeight = autoItX.winGetPosHeight(edWindowTitle);
            autoItX.mouseClick("", 50, winHeight / 2);
            autoItActiveX.invoke("Send", "+{HOME}");
            autoItActiveX.invoke("Send", "{DEL}");
            autoItActiveX.invoke("Send", stageName);
            autoItActiveX.invoke("Send", "{ENTER}");
            Thread.sleep(2000);
            int stagePosX = 100;
            int stagePosY = (winHeight / 2) + 100;
            autoItX.mouseClickDrag("", stagePosX, stagePosY, moveToPosX, moveToPosY, 2);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Exception is - " + e);
        }
    }

    /**
     * @param posX
     * @param posY
     */

    public static void openStageConfig(int posX, int posY) {
        try {
            autoItX.winActivate(edWindowTitle);
            autoItX.winWaitActive(edWindowTitle);
            autoItX.mouseClick("", posX, posY);
            autoItX.mouseClick("", posX, posY);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Exception is - " + e);
        }
    }

    /**
     * @param stage1PosX
     * @param stage1PosY
     * @param stage2PosX
     * @param stage2PosY
     */

    public static void stageChannelInputPort(int stage1PosX, int stage1PosY, int stage2PosX, int stage2PosY) {
        try {
            autoItX.winActivate(edWindowTitle);
            autoItX.winWaitActive(edWindowTitle);
            autoItX.mouseClickDrag("", stage1PosX+15, stage1PosY-10, stage2PosX, stage2PosY, 2);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Exception is - " + e);
        }
    }
}
