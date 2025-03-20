package org.firstinspires.ftc.teamcode.testing;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Config")
public class testing extends LinearOpMode {
    private Handler_Module handler;

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        handler = new Handler_Module();

        waitForStart();
        handler.init_arm(
                //for slower speed but steady change arm_rotator_motor to be DcMotorEx.class
                hardwareMap.get(DcMotor.class, "arm_extender" ),
                hardwareMap.get(DcMotor.class, "arm_control")

        );
        handler.init_hand(hardwareMap.get(Servo.class, "hand_servo"));
        handler.init_wheels(
                hardwareMap.get(DcMotor.class, "front_left_wheel"),
                hardwareMap.get(DcMotor.class, "front_right_wheel"),
                hardwareMap.get(DcMotor.class, "back_left_wheel"),
                hardwareMap.get(DcMotor.class, "back_right_wheel")
        );
        if(opModeIsActive()) {
            while (opModeIsActive()) {
                handler.update();
                telemetry = handler.GetTelemetry(telemetry);
                telemetry.update();

            }
        }
    }
}
