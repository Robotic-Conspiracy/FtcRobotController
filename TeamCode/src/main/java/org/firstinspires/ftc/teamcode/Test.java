package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(group = "tests")
public class Test  extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        if(opModeIsActive()){
            while(opModeIsActive()){
                telemetry.addData("Test", false);
                telemetry.update();
            }
            //DataUpdate.active = false;
        }
    }
}
