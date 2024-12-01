package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.tests.Handler;
@TeleOp
public class Main extends LinearOpMode {
    private static Handler handler = new Handler();
    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart();
        handler.initilize();
        if(opModeIsActive()) {
            while (opModeIsActive()) {
                handler.update();
            }
        }
    }
}
