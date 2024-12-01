package org.firstinspires.ftc.teamcode.tests;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class Main extends LinearOpMode {

    private static final Handler handler = new Handler();
    @Override
    public void runOpMode() throws InterruptedException {
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        waitForStart();
        handler.initialize_hand(hardwareMap.get(Servo.class, "hand_rotator"), hardwareMap.get(Servo.class, "hand_servo"));
        handler.initialize_movement(
                hardwareMap.get(DcMotor.class, "front_left_wheel"),
                hardwareMap.get(DcMotor.class, "front_right_wheel"),
                hardwareMap.get(DcMotor.class, "back_left_wheel"),
                hardwareMap.get(DcMotor.class, "back_right_wheel")
        );
        handler.disableModule("Movement");
        handler.disableModule("Arm");
        if(opModeIsActive()) {
            while (opModeIsActive()) {
                handler.update(gamepad1, gamepad2);
                telemetry = handler.displayActiveModules(telemetry);
                telemetry = handler.displayChangableVars(telemetry);
                telemetry.update();
            }
        }
    }
}
