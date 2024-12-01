package org.firstinspires.ftc.teamcode.tests;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.tests.Handler;
@TeleOp
public class Main extends LinearOpMode {

    private static final Handler handler = new Handler();
    @Override
    public void runOpMode() throws InterruptedException {
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        waitForStart();
        handler.initilize();
        handler.initilize_hand(hardwareMap.get(Servo.class, "hand_rotator"), hardwareMap.get(Servo.class, "hand_servo"));
        handler.dissableModule("Movement");
        handler.dissableModule("Arm");
        if(opModeIsActive()) {
            while (opModeIsActive()) {
                handler.update(gamepad1, gamepad2);
                telemetry = handler.displayActiveModules(telemetry);
                telemetry.update();
            }
        }
    }
}
