package teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;


@Autonomous(name="Pushbot: Auto Drive By Encoder", group="Auto Modes")


public class AutoTest extends LinearOpMode {

    static final double     COUNTS_PER_MOTOR_REV    = 1440 ;    // eg: TETRIX Motor Encoder
    static final double     DRIVE_GEAR_REDUCTION    = 1.0 ;     // This is < 1.0 if geared UP
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;     // For figuring circumference
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) / (WHEEL_DIAMETER_INCHES * 3.1415);


    private DcMotor upRightMotor;
    private DcMotor upLeftMotor;
    private DcMotor downLeftMotor;
    private DcMotor downRightMotor;


    @Override
    public void runOpMode() {

        this.downLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.downRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.upLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.upLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        this.downLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.downRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.upLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.upRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        waitForStart();



    }


    public void move(double direction, double distance){

        /*
        direction 0 is up
        1 is left
        2 is down
        3 is left
         */


        if (direction == 0){



        }




    }

    public int inchesToEncoderSteps(double distance){



        return
    }
}
