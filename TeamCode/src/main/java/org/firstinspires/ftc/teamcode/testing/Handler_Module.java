package org.firstinspires.ftc.teamcode.testing;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
public class Handler_Module {
    public static TestType test;
    public static Tests[] RunningTests = {Tests.autoArm, null, null};
    private static Tests[] last = {Tests.autoArm, null, null};
    private static final int resetDelay = 25;
    private static int delayCount = 0;
    private Arm_Module arm;
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
        if (delayCount >= resetDelay){
            telemetry.clear();
        } else {
            delayCount++;
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
        }
    }

}
