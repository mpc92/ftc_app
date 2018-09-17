package teamcode.libraries;

import com.qualcomm.robotcore.hardware.DcMotor;


public class DriveLibrary {

    private double upRightMotorPower;
    private double upleftMotorPower;
    private double downLeftMotorPower;
    private double downRightMotorPower;

    private DcMotor upRightMotor;
    private DcMotor upLeftMotor;
    private DcMotor downLeftMotor;
    private DcMotor downRightMotor;

    public DriveLibrary(DcMotor upRightMotor, DcMotor upLeftMotor, DcMotor downLeftMotor, DcMotor downRightMotor){

        // this 'constructor' gives me direct control of the motors in my library class

        this.upRightMotor = upRightMotor;
        this.upLeftMotor = upLeftMotor;
        this.downLeftMotor = downLeftMotor;
        this.downRightMotor = downRightMotor;

    }


    //below here goes movement methods, methods i can call that control the movement of the robot
    //for all intents and purposes, all the motors "forward" direction is counter-clockwise

    public void turn(double rightStickX){

        upRightMotorPower = -rightStickX;
        upleftMotorPower = -rightStickX;
        downLeftMotorPower = -rightStickX;
        downRightMotorPower =  -rightStickX;

        setSpeed();

    }


    public void cartesianMove(double leftStickX, double leftStickY){

        upleftMotorPower = ((-leftStickY / 2) - (leftStickX / 2));
        downLeftMotorPower = ((-leftStickY / 2) + (leftStickX / 2));
        upRightMotorPower = ((leftStickY / 2) - (leftStickX / 2));
        downRightMotorPower = ((leftStickY / 2) + (leftStickX / 2));

        setSpeed();

    }

    public void setSpeed(){ //sets the motor powers, must be called in each movement method

        this.upRightMotor.setPower(upRightMotorPower);
        this.upLeftMotor.setPower(upleftMotorPower);
        this.downLeftMotor.setPower(downLeftMotorPower);
        this.downRightMotor.setPower(downRightMotorPower);

    }

    public void stop(){// stops the robot from moving

        this.upRightMotor.setPower(0);
        this.upLeftMotor.setPower(0);
        this.downLeftMotor.setPower(0);
        this.downRightMotor.setPower(0);

    }
}
