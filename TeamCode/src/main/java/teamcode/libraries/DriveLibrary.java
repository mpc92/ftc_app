package teamcode.libraries;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


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

    /*


    methods past here are used universally for functions, and do not directly control any motor powers, but are more just utilities


     */

    public void setSpeed(){ //sets the motor powers, must be called in each movement method

        this.upRightMotor.setPower(upRightMotorPower);
        this.upLeftMotor.setPower(upleftMotorPower);
        this.downLeftMotor.setPower(downLeftMotorPower);
        this.downRightMotor.setPower(downRightMotorPower);

    }

<<<<<<< HEAD
    public void setDirection(String upRightMotor, String upLeftMotor, String downLeftMotor, String downRightMotor){

        if(upRightMotor == "CCW"){

            this.upRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        }

        if(upRightMotor == "CW"){

            this.upRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        }



        if(upLeftMotor == "CCW"){

            this.upLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        }

        if(upLeftMotor == "CW"){

            this.upLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        }



        if(downLeftMotor == "CCW"){

            this.downLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        }

        if(downLeftMotor == "CW"){

            this.downLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        }



        if(downRightMotor == "CCW"){

            this.downRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        }

        if(downRightMotor == "CW"){

            this.downRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        }
        // this if chain makes it easier to set motor directions in the future
    }


    /*
    methods past here are used for the polar movement system
    they should probably get a new class, but oops
    also I don't wanna write another constructor bc I don't know how
     */



    private double r;
    private double theta;


    public void polarMovement(Double leftStickX, Double leftStickY){

        //this mehtod is the command line for polar movement, and should only call other claasses

        polarConvert(leftStickX, leftStickY);


    }

    public void polarConvert(double X, double Y){ // give this method (x,y) cartesian, and it will return (r, theta) polar

        r = Math.sqrt((X * X)*(Y * Y));

        theta = Math.atan(Y / X);

        r = (r / ((Math.sqrt(2) / 45) * Math.abs(theta)));
        // this simple equation scales r, so that the maximum value is 1, and r can be used directly on the motor powers

    }

    public void setWheelDirections(){

        // this method will make some motor powers negative if they need to be based on direction
        //there are four directions, right left up and down, and they end on the 45's

        if(theta >= 315 || theta <= 45){//right

            setDirection("CW", "CW", "CCW", "CCW");

        }

        if(theta >= 45 & theta <= 135){//up

            setDirection("CCW", "CW", "CW", "CCW");

        }

        if(theta >= 135 & theta <= 225){//left

            setDirection("CCW", "CCW", "CW", "CW");

        }

        if(theta >= 225 & theta <= 315){//down

            setDirection("CW", "CCW", "CCW", "CW");

        }

=======
    public void stop(){// stops the robot from moving

        this.upRightMotor.setPower(0);
        this.upLeftMotor.setPower(0);
        this.downLeftMotor.setPower(0);
        this.downRightMotor.setPower(0);
>>>>>>> 13f5a86231b685aea8cb35c7e33610b4b8b223ba

    }
}
