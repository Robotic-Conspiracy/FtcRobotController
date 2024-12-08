package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.tests.Handler;
import org.firstinspires.ftc.teamcode.tests.Movement;

import java.util.HashMap;

@Autonomous(name="Drive ???")
public class Auto extends LinearOpMode {
    private static final Handler handler = new Handler();
    private Movement movement;

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        this.movement = new Movement(
                hardwareMap.get(DcMotor.class, "front_left_wheel"),
                hardwareMap.get(DcMotor.class, "front_right_wheel"),
                hardwareMap.get(DcMotor.class, "back_left_wheel"),
                hardwareMap.get(DcMotor.class, "back_right_wheel")
        );
        ElapsedTime time = new ElapsedTime();
        waitForStart();
        if(opModeIsActive()){
            time.reset();
            while (opModeIsActive()){
                movement.update(0.3, 0, 0);
                if (time.seconds() > 3){
                    break;
                }
            }
        }
    }
}
