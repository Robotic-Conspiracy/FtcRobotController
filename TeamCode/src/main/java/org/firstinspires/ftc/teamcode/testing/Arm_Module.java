package org.firstinspires.ftc.teamcode.testing;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.tests.RobotModule;

@Config
public class Arm_Module extends RobotModule {
    private final DcMotor ArmRotationMotor;
    private final DcMotor ArmExtensionMotor;
    public static displayData dataToDisplay = displayData.objectiveInfo;
    private static displayData lastdataToDisplay = displayData.objectiveInfo;
    public static int armRotationTargetPos;
    public static int armExtensionTargetPos;
    public static int armSpeed = 100;

    public Arm_Module(DcMotor armRotation, DcMotor armExtension){
        this.ArmExtensionMotor = armExtension;
        this.ArmRotationMotor = armRotation;

    }
    public Telemetry getDisplayData(Telemetry telemetry){

        switch (dataToDisplay){
            case objectiveInfo:
                telemetry.addData("Arm rotation target", armRotationTargetPos);
                telemetry.addData("Arm rotation current", this.ArmRotationMotor.getCurrentPosition());
                telemetry.addData("Arm extension target", armExtensionTargetPos);
                telemetry.addData("Arm extension current", this.ArmExtensionMotor.getCurrentPosition());
                break;
            case statictics:
                telemetry.addData("Arm rotation current pos", this.ArmRotationMotor.getCurrentPosition());
                telemetry.addData("Arm extension current pos", this.ArmExtensionMotor.getCurrentPosition());
                telemetry.addData("Arm rotation zero power behavior", this.ArmRotationMotor.getZeroPowerBehavior());
                telemetry.addData("Arm rotation target position", this.ArmRotationMotor.getTargetPosition());
                telemetry.addData("Arm rotation mode", this.ArmRotationMotor.getMode());
            case staticticsAdv:
                telemetry.addData("Arm rotation current pos", this.ArmRotationMotor.getCurrentPosition());
                telemetry.addData("Arm rotation zero power behavior", this.ArmRotationMotor.getZeroPowerBehavior());
                telemetry.addData("Arm rotation target position", this.ArmRotationMotor.getTargetPosition());
                telemetry.addData("Arm rotation mode", this.ArmRotationMotor.getMode());
                telemetry.addData("Arm rotation power", this.ArmRotationMotor.getPower());
                telemetry.addData("Arm rotation power float", this.ArmRotationMotor.getPowerFloat());
                telemetry.addData("is Arm rotation busy", this.ArmRotationMotor.isBusy());
                telemetry.addData("Arm extension target", armExtensionTargetPos);
                telemetry.addData("Arm extension current pos", this.ArmExtensionMotor.getCurrentPosition());
                telemetry.addData("Arm extension zero power behavior", this.ArmExtensionMotor.getZeroPowerBehavior());
                telemetry.addData("Arm extension target position", this.ArmExtensionMotor.getTargetPosition());
                telemetry.addData("Arm extension mode", this.ArmExtensionMotor.getMode());
                telemetry.addData("Arm extension power", this.ArmExtensionMotor.getPower());
                telemetry.addData("Arm extension power float", this.ArmExtensionMotor.getPowerFloat());
                telemetry.addData("is Arm extension busy", this.ArmExtensionMotor.isBusy());
                break;
            case all:
                telemetry.addData("Arm rotation target", armRotationTargetPos);
                telemetry.addData("Arm rotation current pos", this.ArmRotationMotor.getCurrentPosition());
                telemetry.addData("Arm rotation zero power behavior", this.ArmRotationMotor.getZeroPowerBehavior());
                telemetry.addData("Arm rotation target position", this.ArmRotationMotor.getTargetPosition());
                telemetry.addData("Arm rotation mode", this.ArmRotationMotor.getMode());
                telemetry.addData("Arm rotation power", this.ArmRotationMotor.getPower());
                telemetry.addData("Arm rotation power float", this.ArmRotationMotor.getPowerFloat());
                telemetry.addData("is Arm rotation busy", this.ArmRotationMotor.isBusy());
                telemetry.addData("Arm extension current pos", this.ArmExtensionMotor.getCurrentPosition());
                telemetry.addData("Arm extension zero power behavior", this.ArmExtensionMotor.getZeroPowerBehavior());
                telemetry.addData("Arm extension target position", this.ArmExtensionMotor.getTargetPosition());
                telemetry.addData("Arm extension mode", this.ArmExtensionMotor.getMode());
                telemetry.addData("Arm extension power", this.ArmExtensionMotor.getPower());
                telemetry.addData("Arm extension power float", this.ArmExtensionMotor.getPowerFloat());
                telemetry.addData("is Arm extension busy", this.ArmExtensionMotor.isBusy());
                break;
            default:
                telemetry.addData("wrong type", dataToDisplay);
                break;
        }
        return telemetry;
    }
    public  void updatePositions(){
        if (armRotationTargetPos != this.ArmRotationMotor.getCurrentPosition()){
            this.ArmRotationMotor.setTargetPosition(armRotationTargetPos);
            this.ArmRotationMotor.setPower(armSpeed/100.0);
            this.ArmRotationMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        }
        if(armExtensionTargetPos != this.ArmExtensionMotor.getCurrentPosition()){
            this.ArmExtensionMotor.setTargetPosition(armExtensionTargetPos);
            this.ArmExtensionMotor.setPower(50);
            this.ArmExtensionMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
    }
    public static boolean updateDisplay(){
        if(lastdataToDisplay != dataToDisplay){
            lastdataToDisplay = dataToDisplay;
            return true;
        } else {
            return false;
        }
    }
    public enum displayData{
        objectiveInfo,
        statictics,
        staticticsAdv,
        all
    }
}
