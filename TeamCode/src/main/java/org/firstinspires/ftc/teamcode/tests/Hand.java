package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class Hand extends LinearOpMode {
    private final Servo Hand_rotator;
    private Servo Hand_Grip;
    @Override

    public void runOpMode() throws InterruptedException {

    }
    /**
     * @param rotator_name the name of the rotation servo
     * @param hand_name the name of the hands grip servo
    */
    public Hand(String rotator_name, String hand_name){
        this.Hand_Grip = hardwareMap.get(Servo.class, hand_name);
        this.Hand_rotator = hardwareMap.get(Servo.class, rotator_name);
    }

    /**
     * used to update the hands grip the hand
     * */
    public void grip(boolean left, boolean right){
        this.Hand_Grip.setPosition(
                this.Hand_Grip.getPosition() + (gamepad2.a ? 0.1 : (gamepad2.b ? -0.1: 0))
        );
    }
}
