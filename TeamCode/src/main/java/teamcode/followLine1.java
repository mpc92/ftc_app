package teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;

@TeleOp (name="Follow Line", group="Linear Opmode")

public class followLine1 extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    private DcMotor leftMotor;
    private DcMotor rightMotor;

    private Servo armServo;

    private ColorSensor armSensor;


    @Override
    public void runOpMode() {

        this.leftMotor = hardwareMap.get(DcMotor.class, "Left Motor");
        this.rightMotor = hardwareMap.get(DcMotor.class, "Right Motor");

        this.armServo = hardwareMap.get(Servo.class, "Arm Servo");

        this.armSensor = hardwareMap.get(ColorSensor.class, "Arm Sensor");

        waitForStart();
        runtime.reset();

        double armPostion = 0;
        double leftPower = 0;
        double rightPower = 0;
        double leftStickY;
        double rightStickX;

        this.armServo.setPosition(-.125);


       while (opModeIsActive()){

            armPostion = this.armServo.getPosition();
            leftStickY = -gamepad1.left_stick_y;
            rightStickX = gamepad1.right_stick_x;
            leftPower = 0;
            rightPower = 0;

               if (leftStickY != 0) { //if driving

                   if (rightStickX < 0) {
                       // turn left
                       leftPower = leftStickY + rightStickX;
                       rightPower = leftStickY;
                   }

                   else if (rightStickX > 0) {
                       // turn right
                       leftPower = leftStickY;
                       rightPower = leftStickY - rightStickX;
                   }

                   else {
                       // go straight
                       leftPower = leftStickY;
                       rightPower = leftStickY;
                   }
               }

               else if (leftStickY == 0) { //if the left stick is not pressed, the robot will turn faster

                   leftPower = rightStickX;
                   rightPower = -rightStickX;
                   // turn left or right faster!

               }

               else { // if the user does not have input, the robot will attempt to follow a line

               }

               this.leftMotor.setPower(leftPower);
               this.rightMotor.setPower(rightPower);

               telemetry.addData("Left Power", leftPower);
               telemetry.addData("Right Power", rightPower);

               telemetry.update();

        }
    } //public void runOpMode()
} //public class followLine1 extends LinearOpMode
