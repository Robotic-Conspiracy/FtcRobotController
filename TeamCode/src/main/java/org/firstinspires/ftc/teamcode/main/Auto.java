package org.firstinspires.ftc.teamcode.main;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(name = "taco")
public class Auto extends LinearOpMode{
    private static Servo Grip;
    private static DcMotor FLeft;
    private static DcMotor FRight;
    private static DcMotor BLeft;
    private static DcMotor BRight;

    public static boolean move = false;

    private static final double speed = 0.5;
    public static final autoTelemetry AutoTelemetry = new autoTelemetry();
    @Override
    public void runOpMode() throws InterruptedException {
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        waitForStart();
        FLeft = hardwareMap.get(DcMotor.class, "front_left_wheel");
        FRight = hardwareMap.get(DcMotor.class, "front_right_wheel");
        BLeft = hardwareMap.get(DcMotor.class, "back_left_wheel");
        BRight = hardwareMap.get(DcMotor.class, "back_right_wheel");
        BLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        BRight.setDirection(DcMotorSimple.Direction.FORWARD);
        FLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        FRight.setDirection(DcMotorSimple.Direction.REVERSE);
        if(opModeIsActive()) {
            while (opModeIsActive()) {
                if (move){
                    FLeft.setTargetPosition((int) ((((autoTelemetry.y_dist_to_move - autoTelemetry.x_dist_to_move)*-1))* speed));
                    FRight.setTargetPosition((int) ((((autoTelemetry.y_dist_to_move - autoTelemetry.x_dist_to_move)*-1))* speed));
                    BLeft.setTargetPosition((int) ((((autoTelemetry.y_dist_to_move - autoTelemetry.x_dist_to_move)*-1))* speed));
                    BRight.setTargetPosition((int) ((((autoTelemetry.y_dist_to_move - autoTelemetry.x_dist_to_move)*-1))* speed));
                }
                telemetry = autoTelemetry.getTelem(telemetry);

                telemetry.update();
            }
        }
    }
    public static Telemetry noodle_code(Telemetry t){
        return t;
    }
}
