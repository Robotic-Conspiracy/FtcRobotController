package org.firstinspires.ftc.teamcode.tests;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;

@Config
public class Arm {
    public static double P = 10;
    public static double I = 0;
    public static double D = 0.002;
    public static double F = 46.8201;
    private final DcMotor arm_rotator_motor;
    private final DcMotor arm_extender_motor;

    public Arm(DcMotor arm_rotator_motor, DcMotor arm_extender_motor){
        this.arm_rotator_motor = arm_rotator_motor;
        this.arm_extender_motor = arm_extender_motor;
        arm_rotator_motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm_rotator_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); //Set current pos to 0
        arm_rotator_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER); //allow run to position.

    }
    public Arm(DcMotorEx arm_rotator_motor, DcMotor arm_extender_motor){
        this.arm_rotator_motor = arm_rotator_motor;
        this.arm_extender_motor = arm_extender_motor;
        arm_rotator_motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm_rotator_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); //Set current pos to 0
        arm_rotator_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER); //allow run to position.4
        // THERE IS A BUNCH OF MATH INVOLVED HERE, READ THE FTC DOCS OF PIDF AND ASK @GoldStar184 BEFORE CHANGING

        arm_rotator_motor.setVelocityPIDFCoefficients(P, I, D, F);
        arm_rotator_motor.setPositionPIDFCoefficients(8);
    }
    public void rotate(double left_stick_y){
        int arm_target = (int) (arm_rotator_motor.getTargetPosition() + ((left_stick_y * -1)));
        arm_rotator_motor.setTargetPosition(arm_target);
        arm_rotator_motor.setPower(1);
        arm_rotator_motor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
    }
}
