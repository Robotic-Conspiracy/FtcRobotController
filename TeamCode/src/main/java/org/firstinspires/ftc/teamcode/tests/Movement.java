package org.firstinspires.ftc.teamcode.tests;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


public class Movement extends RobotModule{
    private DcMotor front_left_wheel;
    private DcMotor front_right_wheel;
    private DcMotor back_left_wheel;
    private DcMotor back_right_wheel;
    public static double speed = 0.5;
    public Movement(DcMotor front_left_wheel, DcMotor front_right_wheel, DcMotor back_left_wheel, DcMotor back_right_wheel){
        this.front_left_wheel = front_left_wheel;
        this.back_left_wheel = back_left_wheel;
        this.front_right_wheel = front_right_wheel;
        this.back_right_wheel = back_right_wheel;
        this.back_left_wheel.setDirection(DcMotorSimple.Direction.FORWARD);
        this.back_right_wheel.setDirection(DcMotorSimple.Direction.FORWARD);
        this.front_left_wheel.setDirection(DcMotorSimple.Direction.REVERSE);
        this.front_right_wheel.setDirection(DcMotorSimple.Direction.REVERSE);
        speed = 0.5;
    }
    public void update(double x, double y, double z){
        //double left_stick_x = gamepad1.left_stick_x * -1;
        //double left_stick_y = gamepad1.left_stick_y;
        //double right_stick_x = gamepad1.right_stick_x;
        x *=-1;
        this.back_left_wheel.setPower((((y - x)*-1) + z)* speed);
        this.back_right_wheel.setPower((((y + x)*-1) - z)* speed);
        this.front_left_wheel.setPower((((y + x)*-1) + z)* speed);
        this.front_right_wheel.setPower((((y - x)*-1) - z)* speed);
    }
    public double getSpeed(){
        return speed;
    }
}
