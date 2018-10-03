package teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;


@Autonomous(name="Auto Test", group="Auto Modes")


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

        //COMMAND LINE BELOW HERE

        move(1500);
        turn(0, 1500);
        move(1500);



    }


    public void move(int distance){

        this.upLeftMotor.setTargetPosition(-distance);
        this.upRightMotor.setTargetPosition(distance);
        this.downRightMotor.setTargetPosition(distance);
        this.downLeftMotor.setTargetPosition(-distance);

    }

    public void turn(int direction, int distance){

        if(direction == 0){// left

            this.upRightMotor.setTargetPosition(distance);
            this.upLeftMotor.setTargetPosition(distance);
            this.downLeftMotor.setTargetPosition(distance);
            this.downRightMotor.setTargetPosition(distance);

        }

        if(direction == 1){// right

            this.upRightMotor.setTargetPosition(-distance);
            this.upLeftMotor.setTargetPosition(-distance);
            this.downLeftMotor.setTargetPosition(-distance);
            this.downRightMotor.setTargetPosition(-distance);

        }

    }
}
