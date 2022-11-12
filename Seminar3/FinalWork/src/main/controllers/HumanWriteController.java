package main.controllers;

import main.services.HumanInfo;
import main.services.Writable;
import main.services.impl.HumanInfoAcquisitionService;
import main.services.impl.WritingToFileService;

public class HumanWriteController {

    private HumanInfo humanInfo;
    private Writable writingToFileService;

    public HumanWriteController(){
        writingToFileService = new WritingToFileService();
        humanInfo = new HumanInfoAcquisitionService();
    }

    public void WriteHumanInfo(){
        var human = humanInfo.getHuman();
        writingToFileService.write(human);
    }
}
