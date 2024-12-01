package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class Hand{
    private final Servo Hand_rotator;
    private final Servo Hand_Grip;
    /**
     * @param rotator_name the name of the rotation servo
     * @param hand_name the name of the hands grip servo
    */
    public Hand(Servo rotator_name, Servo hand_name){
        this.Hand_Grip = hand_name;
        this.Hand_rotator = rotator_name;
    }

    /**
     * used to update the hands grip the hand
     * */
    public void grip(boolean left, boolean right){

        this.Hand_Grip.setPosition(
                this.Hand_Grip.getPosition() + (left ? 0.1 : (right ? -0.1 : 0))
        );
    }

    /**
     *
     * @param left the thing used decrease grip strength
     * @param right the thing used to increase grip strength
     * dont use a var that can range from -1 to 1 though might add that option later
     */
    public void grip(double left, double right){
        this.Hand_Grip.setPosition(
                this.Hand_Grip.getPosition() + (left+ (right*-1))*0.01
        );

    }
    public void rotate(double left, double right){
        Hand_rotator.setPosition(
                Hand_rotator.getPosition() + (left + (right)*-1)*0.005
        );
    }
    public void rotate(boolean left, boolean right){
        Hand_rotator.setPosition(
                Hand_rotator.getPosition() + (left ? 1 : right ? -1: 0)*0.005
        );
    }
}
