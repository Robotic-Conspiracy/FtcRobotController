package org.firstinspires.ftc.teamcode.tests;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.HashMap;

public class Handler extends LinearOpMode {
    public static HashMap<String, Boolean> activeModules = new HashMap<>();
    private final FtcDashboard dashboard = FtcDashboard.getInstance();
    private final Telemetry dashboardTelemetry = dashboard.getTelemetry();
    public Arm arm = new Arm();
    public Hand hand = new Hand("hand_rotator", "hand_servo");
    @Override
    public void runOpMode() throws InterruptedException {

    }
    public void initilize(){
        activeModules.put("Arm", true);
        activeModules.put("Hand", true);
        activeModules.put("Movement", true);
    }
    public void dissableModule(String Module){

    }

    public void displayActiveModules(){
        telemetry.addData("Arm", activeModules.get("Arm"));
        telemetry.addData("Hand", activeModules.get("Hand"));
        telemetry.addData("Movement", activeModules.get("Movement"));
        dashboardTelemetry.addData("Arm", activeModules.get("Arm"));
        dashboardTelemetry.addData("Hand", activeModules.get("Hand"));
        dashboardTelemetry.addData("Movement", activeModules.get("Movement"));
    }
    public void update(){
        if (Boolean.TRUE.equals(activeModules.get("Arm"))){
            //nothing yet
        }
        if (Boolean.TRUE.equals(activeModules.get("Hand"))){
            hand.grip(gamepad2.a, gamepad2.b);
        }
        if(Boolean.TRUE.equals(activeModules.get("Movement"))){
            // nothing yet
        }
    }
}
