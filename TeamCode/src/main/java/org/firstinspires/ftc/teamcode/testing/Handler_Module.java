package org.firstinspires.ftc.teamcode.testing;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.tests.Hand;

@Config
public class Handler_Module {
    public static TestType test;
    public static Tests[] RunningTests = {Tests.autoArm, Tests.none, Tests.none};
    private static Tests[] last = {Tests.autoArm, Tests.none, Tests.none};
    private static final int resetDelayMs = 5000;
    private Hand_module hand;
    private static long time = System.currentTimeMillis();
    private static long newTime = 0;
    private Arm_Module arm;
    private Wheels_Module wheels;
    public Telemetry ResetTelemetry(Telemetry telemetry){
        telemetry.clear();
        return telemetry;
    }
    public Telemetry GetTelemetry(Telemetry telemetry){
        /*for (int i = 0; i < last.length; i++){
            if(last[i] != RunningTests[i]){
                last = RunningTests;
                telemetry = ResetTelemetry(telemetry);
            }
        }*/
        if (resetDelayMs <= newTime-time){
            telemetry.clear();
            time = System.currentTimeMillis();
        } else {
            newTime = System.currentTimeMillis();
        }

        for (int i = 0; i < RunningTests.length; i++) {
            if(RunningTests[i] == Tests.autoArm){
                telemetry = this.arm.getDisplayData(telemetry);
            }
        }
        return telemetry;
    }
    public void init_arm(DcMotor armExtension, DcMotor armRotation){
        this.arm = new Arm_Module(armRotation, armExtension);
    }
    public void init_hand(Servo servo){
        this.hand = new Hand_module(servo);
    }
    public void init_wheels(DcMotor front_left_wheel, DcMotor front_right_wheel, DcMotor back_left_wheel, DcMotor back_right_wheel){
        this.wheels = new Wheels_Module(front_left_wheel, front_right_wheel, back_left_wheel, back_right_wheel);
    }
    public enum Tests{
        autoWheels(0),
        autoArm(1),
        autoGrip(2),
        none(-1);

        Tests(int i) {

        }
    }
    public void update(){
        for (int i = 0; i < RunningTests.length; i++) {

            if(RunningTests[i] == Tests.autoArm){
                this.arm.updatePositions();
            }
            if(RunningTests[i] == Tests.autoGrip){
                this.hand.updateHand();
            }
            if(RunningTests[i] == Tests.autoWheels){
                this.wheels.update();
            }
        }
    }

}
