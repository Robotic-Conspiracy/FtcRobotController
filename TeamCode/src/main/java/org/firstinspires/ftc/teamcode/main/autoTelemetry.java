package org.firstinspires.ftc.teamcode.main;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class autoTelemetry{
    public static int x_dist_to_move = 0;
    public static int y_dist_to_move = 0;

    public static Telemetry getTelem(Telemetry telemetry){
        telemetry.addData("x_dist_to_move", x_dist_to_move);
        telemetry.addData("y_dist_to_move", y_dist_to_move);
        return telemetry;
    }
}
