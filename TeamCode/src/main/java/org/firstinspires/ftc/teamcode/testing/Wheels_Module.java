package org.firstinspires.ftc.teamcode.testing;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Config
public class Wheels_Module {
    public static int x_target = 0;
    public static int z_target = 0;
    private final DcMotor back_left_wheel;
    //private final DcMotor front_right_wheel;
    //private final DcMotor back_right_wheel;
    //private final DcMotor front_left_wheel;
    public static double speed = 0;

    public Wheels_Module(DcMotor front_left_wheel, DcMotor front_right_wheel, DcMotor back_left_wheel, DcMotor back_right_wheel){
        this.back_left_wheel = back_left_wheel;
        //this.front_right_wheel = front_right_wheel;
        //this.back_right_wheel = back_right_wheel;
        //this.front_left_wheel = front_left_wheel;
        //this.back_left_wheel.setDirection(DcMotorSimple.Direction.FORWARD);
        //this.back_right_wheel.setDirection(DcMotorSimple.Direction.FORWARD);
        //this.front_left_wheel.setDirection(DcMotorSimple.Direction.REVERSE);
        //this.front_right_wheel.setDirection(DcMotorSimple.Direction.REVERSE);
        speed = 0.5;
    }
    public void update(){
        //double left_stick_x = gamepad1.left_stick_x * -1;
        //double left_stick_y = gamepad1.left_stick_y;
        //double right_stick_x = gamepad1.right_stick_x;
        x_target *=-1;
        //this.back_left_wheel.setPower((((z_target - x_target)*-1) + z)* speed);
        //this.back_right_wheel.setPower((((z_target + x_target)*-1) - z)* speed);
        //this.front_left_wheel.setPower((((z_target + x_target)*-1) + z)* speed);
        //this.front_right_wheel.setPower((((z_target - x_target)*-1) - z)* speed);
        this.back_left_wheel.setPower((((z_target - x_target)*-1))* speed);
        //this.back_right_wheel.setPower((((z_target + x_target)*-1))* speed);
        //this.front_left_wheel.setPower((((z_target + x_target)*-1))* speed);
        //this.front_right_wheel.setPower((((z_target - x_target)*-1))* speed);
    }
}
