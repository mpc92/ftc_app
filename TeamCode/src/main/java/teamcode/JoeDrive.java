package teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="JoeDrive", group="Linear Opmode")

public class JoeDrive extends LinearOpMode {
    private DcMotor motor1; // back motor
    private DcMotor motor2; // left motor
    private Servo servo1;
    private ColorSensor sensor1;

    public void runOpMode() {
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");
        servo1 = hardwareMap.get(Servo.class  , "servo1");

        motor1.setDirection(DcMotor.Direction.FORWARD);
        motor2.setDirection(DcMotor.Direction.FORWARD);
        servo1.setDirection(Servo.Direction.FORWARD);

        waitForStart();

        while( opModeIsActive() ) {
            if (gamepad1.right_bumper) {
                motor1.setPower( 1);
                motor2.setPower(-1);
            } else if (gamepad1.left_bumper) {
                motor1.setPower(-1);
                motor2.setPower( 1);
            } else if (gamepad1.x) {
                motor1.setPower( 1);
                motor2.setPower( 1);
            } else {
                motor1.setPower( 0);
                motor2.setPower( 0);
            }
        }
    }
}