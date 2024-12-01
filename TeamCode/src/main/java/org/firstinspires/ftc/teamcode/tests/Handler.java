package org.firstinspires.ftc.teamcode.tests;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.HashMap;

public class Handler{
    public static HashMap<String, Boolean> activeModules = new HashMap<>();

    private Servo hand_rotator;
    private Servo hand_grip;
    //public Arm arm = new Arm();
    private Hand hand;
    public void initilize(){
        activeModules.put("Arm", true);
        activeModules.put("Hand", true);
        activeModules.put("Movement", true);
    }
    public void initilize_hand(Servo hand_rotator, Servo hand_grip){
        this.hand = new Hand(hand_rotator, hand_grip);
    }
    /***
     *
     * @param Module the module you want to disable
     * used to disable a module
     */
    public void dissableModule(String Module){
        activeModules.replace(Module, false);
    }

    public Telemetry displayActiveModules(Telemetry telemetry){
        telemetry.addData("Arm", activeModules.get("Arm"));
        telemetry.addData("Hand", activeModules.get("Hand"));
        telemetry.addData("Movement", activeModules.get("Movement"));
        return telemetry;
    }

    public void update(Gamepad gamepad1, Gamepad gamepad2){
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