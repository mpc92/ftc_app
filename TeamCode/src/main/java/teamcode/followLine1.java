package teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
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

        this.armSensor = hardwareMap.get(ColorSensor.class, "Arm Sensor");

        this.armServo = hardwareMap.get(Servo.class, "Arm Sensor");




       while (opModeIsActive()){
           
            if (gamepad1.a) {

                telemetry.addData("test", "it worked, bitch");

            }
        }
    } //public void runOpMode()
} //public class followLine1 extends LinearOpMode
