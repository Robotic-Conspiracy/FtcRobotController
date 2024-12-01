package org.firstinspires.ftc.teamcode.tests;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
@Config

public class Hand{
    private Servo Hand_rotator;
    private  Servo Hand_Grip;
    private  CRServo hand;
    private final int item;
    /**
     * @param rotator_name the name of the rotation servo
     * @param hand_name the name of the hands grip servo
    */
    public Hand(Servo rotator_name, Servo hand_name){
        this.Hand_Grip = hand_name;
        this.Hand_rotator = rotator_name;
        this.item = 0;
    }
    public Hand(CRServo hand){
        this.hand = hand;
        this.item = 1;
    }

    /**
     * used to update the hands grip the hand
     * */
    public void grip(boolean left, boolean right){
        if (this.item == 0){
            this.Hand_Grip.setPosition(
                    this.Hand_Grip.getPosition() + (left ? 0.1 : (right ? -0.1 : 0))
            );
        } else {
            this.hand.setPower((left ? 0.5 : 0)+(right ? -0.5: 0));
        }

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
