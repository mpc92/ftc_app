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

    public void turnCCW(double rightStickX){

        upRightMotorPower = rightStickX;
        upleftMotorPower = rightStickX;
        downLeftMotorPower = rightStickX;
        downRightMotorPower =  rightStickX;

        setSpeed();

    }

    public void turnCW(double rightStickX){

        upRightMotorPower = -rightStickX;
        upleftMotorPower = -rightStickX;
        downLeftMotorPower = -rightStickX;
        downRightMotorPower = -rightStickX;

        setSpeed();

    }

    public void forwardMovement(double leftStickY) { //up and down movement

        upRightMotorPower = leftStickY;
        upleftMotorPower = -leftStickY;
        downLeftMotorPower = -leftStickY;
        downRightMotorPower = leftStickY;

        setSpeed();

    }

    public void sidewaysMovement(double leftStickX){ // left and right movement

        upRightMotorPower = leftStickX;
        upleftMotorPower = leftStickX;
        downLeftMotorPower = -leftStickX;
        downRightMotorPower = -leftStickX;

        setSpeed();

    }

    public void setSpeed(){ //sets the motor powers, must be called in each movement method

        this.upRightMotor.setPower(upRightMotorPower);
        this.upLeftMotor.setPower(upleftMotorPower);
        this.downLeftMotor.setPower(downLeftMotorPower);
        this.downRightMotor.setPower(downRightMotorPower);

    }
}
