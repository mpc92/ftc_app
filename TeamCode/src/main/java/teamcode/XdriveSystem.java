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

    public DcMotor upRightMotor;
    public DcMotor upLeftMotor;
    public DcMotor downLeftMotor;
    public DcMotor downRightMotor;

    double leftStickY = gamepad1.left_stick_y;



    @Override
    public void runOpMode(){

        waitForStart();
        runtime.reset;

        while (opModeIsActive()) {

            forwardMovement(gamepad1.left_stick_y);
            



        }


    }




}
