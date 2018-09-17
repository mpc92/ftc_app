package teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode; // imports
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

            double leftStickY = gamepad1.left_stick_y;
            double leftStickX = gamepad1.left_stick_x;

            if(leftStickY != 0 & leftStickX == 0){

                DriveLibrary.forwardMovement(leftStickY);

            }

            if(leftStickX != 0 & leftStickY == 0){

                DriveLibrary.sidewaysMovement(leftStickX);

            }


        }
    }
}
