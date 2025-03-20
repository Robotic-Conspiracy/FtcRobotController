package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.hardware.Servo;
import com.acmerobotics.dashboard.config.Config;
@Config
public class Hand_module {
    private final Servo Hand_Grip;
    public static double grip = 0;
    public Hand_module(Servo hand_Grip){
        Hand_Grip = hand_Grip;

    }
    public void updateHand(){
        if(Hand_Grip.getPosition() != grip && grip <=1 && grip >= 0.3){
            Hand_Grip.setPosition(grip);
        }
        if(grip <0.3){
            grip = 0.3;
        }
    }
}
