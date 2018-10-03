package teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import static java.lang.Math.sqrt;

@TeleOp(name="CobaltClawsArm", group="Linear Opmode")
public class CobaltClawsArm extends LinearOpMode {
    //teleOPFinal

    // Declare OpMode members.


    private Servo armServo;
    private Servo leftClampServo;
    private Servo rightClampServo;
    private boolean armServoOpen;
    private boolean leftClampServoOpen;
    private boolean rightClampServoOpen;
    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");

        telemetry.update();

        waitForStart();

        //Always True
        while (opModeIsActive()) {
            if(gamepad1.y && armServoOpen == false)
                armServo.setPosition(1);
                armServoOpen = true;

            if(gamepad1.y && armServoOpen == true)
                armServo.setPosition(0);
            armServoOpen = false;

            if(gamepad1.b && leftClampServoOpen == false)
                leftClampServo.setPosition(.5);
                leftClampServoOpen = true;

            if(gamepad1.b && leftClampServoOpen == true)
                leftClampServo.setPosition(0);
            leftClampServoOpen = false;

            if(gamepad1.a && rightClampServoOpen == false)
                rightClampServo.setPosition(.5);
                rightClampServoOpen = true;
                
             if(gamepad1.a && rightClampServoOpen == true)
                 rightClampServo.setPosition(0);
                 rightClampServoOpen = false;





            // Show the elapsed game time and wheel power

            //updateTelemetry();
        }
    }

    public void initialize() {
        armServo = hardwareMap.servo.get("armservo");
        leftClampServo = hardwareMap.servo.get("leftClampServo");
        rightClampServo = hardwareMap.servo.get("rightClampServo");
        armServo.setPosition(0);
        leftClampServo.setPosition(0);
        rightClampServo.setPosition(0);
        armServoOpen = false;
        rightClampServoOpen = false;
        leftClampServoOpen = false;

    }


}

