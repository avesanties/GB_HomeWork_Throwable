package main;

import main.controllers.HumanWriteController;

public class Main{
    public static void main(String[] args) {
        var hwc = new HumanWriteController();
        hwc.WriteHumanInfo();
    }
}