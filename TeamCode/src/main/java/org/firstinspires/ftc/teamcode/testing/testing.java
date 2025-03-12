package org.firstinspires.ftc.teamcode.testing;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
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
        if(opModeIsActive()) {
            while (opModeIsActive()) {
                handler.update();
                telemetry = handler.GetTelemetry(telemetry);
                telemetry.update();

            }
        }
    }
}
