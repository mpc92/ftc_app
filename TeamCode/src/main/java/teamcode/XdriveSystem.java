package teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.util.ElapsedTime;

import teamcode.libraries.DriveLibrary;

@TeleOp(name = "drive system", group = "Linear Opmode") //making the code appear in the app

public class XdriveSystem extends LinearOpMode{ //make it work right

    private ElapsedTime runtime = new ElapsedTime();

    private DcMotor upRightMotor;
    private DcMotor upLeftMotor;
    private DcMotor downLeftMotor;
    private DcMotor downRightMotor;

    private DriveLibrary DriveLibrary = new DriveLibrary(upRightMotor, upLeftMotor, downRightMotor, downRightMotor);

    @Override
    public void runOpMode(){

        waitForStart();
        runtime.reset();


        while (opModeIsActive()) {

            telemetry.addData("Up Left Motor Power", this.upLeftMotor.getPower());
            telemetry.addData("Up Right Motor Power", this.upRightMotor.getPower());
            telemetry.addData("Down Left Motor Power", this.downLeftMotor.getPower());
            telemetry.addData("Down Right Motor Power", this.downRightMotor.getPower());

            double leftStickY = gamepad1.left_stick_y;
            double leftStickX = gamepad1.left_stick_x;
            double rightStickX = gamepad1.right_stick_x;

            if(rightStickX != 0 & leftStickX == 0 & leftStickY == 0) { // if only the right stick is moved

                DriveLibrary.turn(rightStickX);
                telemetry.update();

            }

            if(rightStickX == 0 & leftStickX !=0 || leftStickY != 0){

                DriveLibrary.cartesianMove(leftStickX, leftStickY);
                telemetry.update();

            }

            DriveLibrary.stop();
            telemetry.update();

        }
    }
}
