package org.firstinspires.ftc.teamcode.tests;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.HashMap;
@Config
public class Handler{
    public static HashMap<String, Boolean> activeModules = new HashMap<>();

    private Servo hand_rotator;
    private Servo hand_grip;

    private Hand hand;
    private Movement movement;
    private Arm arm;
    public static boolean Arm_active = true;
    public static boolean Hand_active = true;
    public static boolean Movement_active = true;

    public void initialize_hand(Servo hand_rotator, Servo hand_grip){
        this.hand = new Hand(hand_rotator, hand_grip);
    }
    public void initialize_movement(DcMotor front_left_wheel, DcMotor front_right_wheel, DcMotor back_left_wheel, DcMotor back_right_wheel){
        this.movement = new Movement(front_left_wheel, front_right_wheel, back_left_wheel, back_right_wheel);
    }
    public void initialize_arm(DcMotor arm_rotator_motor, DcMotor arm_extender_motor){
        this.arm = new Arm(arm_rotator_motor, arm_extender_motor);
    }
    /***
     *
     * @param Module the module you want to disable
     * used to disable a module
     */
    public void disableModule(String Module){
        switch (Module){
            case "Arm":
                Arm_active = false;
                break;
            case "Hand":
                Hand_active = false;
                break;
            case "Movement":
                Movement_active = false;
                break;
            default:
                break;
        }
    }

    public Telemetry displayActiveModules(Telemetry telemetry){
        telemetry.addData("Arm module", Arm_active);
        telemetry.addData("Hand module", Hand_active);
        telemetry.addData("Movement module", Movement_active);
        return telemetry;
    }

    public Telemetry displayChangableVars(Telemetry telemetry){
        telemetry.addData("Wheel speed", movement.getSpeed());
        return telemetry;
    }

    public void update(Gamepad gamepad1, Gamepad gamepad2){
        if (Arm_active){
            arm.rotate(gamepad2.left_stick_y);
        }
        if (Hand_active){
            hand.grip(gamepad2.a, gamepad2.b);

        }
        if(Movement_active){
            movement.update(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);
        }
    }
}