package teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;



@TeleOp(name = "drive system", group = "Linear Opmode") //making the code appear in the app



public class XdriveSystem extends LinearOpMode{ //make it work right

    private ElapsedTime runtime = new ElapsedTime();

    private DcMotor upRightMotor;
    private DcMotor upLeftMotor;
    private DcMotor downLeftMotor;
    private DcMotor downRightMotor;

    private double upRightMotorPower;
    private double upleftMotorPower;
    private double downLeftMotorPower;
    private double downRightMotorPower;

    double leftStickY = gamepad1.left_stick_y;
    double leftStickX = -gamepad1.left_stick_x;
    double rightStickX = -gamepad1.right_stick_x;

    int controlMode = 1;


/*
put variables above here, but in the class still
 */


    @Override
    public void runOpMode(){

        waitForStart();
        runtime.reset();

        this.upLeftMotor = hardwareMap.get(DcMotor.class, "Up Left Motor");
        this.upRightMotor = hardwareMap.get(DcMotor.class, "Up Right Motor");
        this.downLeftMotor = hardwareMap.get(DcMotor.class, "Down Left Motor");
        this.downRightMotor = hardwareMap.get(DcMotor.class, "Down Right Motor");

        /*
        setup stuff goes here
         */


        while (opModeIsActive()) {

            telemetry.addData("Up Left Motor Power", this.upLeftMotor.getPower());
            telemetry.addData("Up Right Motor Power", this.upRightMotor.getPower());
            telemetry.addData("Down Left Motor Power", this.downLeftMotor.getPower());
            telemetry.addData("Down Right Motor Power", this.downRightMotor.getPower());

            leftStickY = gamepad1.left_stick_y;
            leftStickX = gamepad1.left_stick_x;
            rightStickX = gamepad1.right_stick_x;

            if(controlMode == 1){

                halfSpeedMovement();
                /*
                axis lock mode
                arm controls
                scoop controls
                 */


            }

            if(controlMode == 2){

                /*
                quarter speed movement
                axis lock mode
                arm controls
                scoop controls
                 */

            }

            if(controlMode == 3){

                /*
                tenth speed movement
                axis lock mode
                lift controls
                arm controls
                scoop controls
                 */
            }





            telemetry.update();

        }
    }


    public void halfSpeedMovement(){

        /*
        this method moves the bot at half speed, the fastest we want to go
        it also stops the robot, if the sticks are not moved
         */


        if(rightStickX == 0 & leftStickX !=0 || leftStickY != 0) {

            upleftMotorPower = ((-leftStickY / 2) - (leftStickX / 2));
            downLeftMotorPower = ((-leftStickY / 2) + (leftStickX / 2));
            upRightMotorPower = ((leftStickY / 2) - (leftStickX / 2));
            downRightMotorPower = ((leftStickY / 2) + (leftStickX / 2));

        }


        else if(rightStickX != 0 & leftStickX == 0 & leftStickY == 0){

            upRightMotorPower = (-rightStickX / 2);
            upleftMotorPower = (-rightStickX / 2);
            downLeftMotorPower = (-rightStickX / 2);
            downRightMotorPower =  (-rightStickX / 2);

        }


        else{

            upRightMotorPower = 0;
            upleftMotorPower = 0;
            downLeftMotorPower = 0;
            downRightMotorPower =  0;

        }

        setMotorSpeeds();
    }

    public void setMotorSpeeds(){

        this.upRightMotor.setPower(upRightMotorPower);
        this.upLeftMotor.setPower(upleftMotorPower);
        this.downLeftMotor.setPower(downLeftMotorPower);
        this.downRightMotor.setPower(downRightMotorPower);

    }
}

