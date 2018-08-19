package teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;

@TeleOp (name="Follow Line 2", group="Linear Opmode")

public class followLine2 extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    private DcMotor leftMotor;
    private DcMotor rightMotor;

    private Servo armServo;

    private ColorSensor armSensor;

    double armPos = 0;

    @Override
    public void runOpMode() {

        this.leftMotor = hardwareMap.get(DcMotor.class, "Left Motor");
        this.rightMotor = hardwareMap.get(DcMotor.class, "Right Motor");

        this.armServo = hardwareMap.get(Servo.class, "Arm Servo");

        this.armSensor = hardwareMap.get(ColorSensor.class, "Arm Sensor");

        waitForStart();
        runtime.reset();

        telemetry.addData("Left Power", this.leftMotor.getPower());
        telemetry.addData("Right Power", this.rightMotor.getPower());
        telemetry.addData("Arm Position", this.armServo.getPosition());
        telemetry.addData("Color Data", this.armSensor.argb());

        while (opModeIsActive()){

            while (gamepad1.right_trigger > 0){

                this.armServo.setPosition(1);

                while (this.armServo.getPosition() > 0){

                    armPos = armPos - 0.01;
                    this.armServo.setPosition(armPos);

                    if (((armSensor.blue() - armSensor.red()) > 30) && (( armSensor.blue() - armSensor.green()) >30)) {

                        this.leftMotor.setPower(.05);
                        this.rightMotor.setPower(.15);
                        telemetry.update();

                    }//if (((armSensor.blue() - armSensor.red()) > 30) && (( armSensor.blue() - armSensor.green()) >30))

                }//while (this.armServo.getPosition() > 0

                while (this.armServo.getPosition() < 1) {

                    armPos = armPos + 0.01;
                    this.armServo.setPosition(armPos);

                    if (((armSensor.blue() - armSensor.red()) > 30) && (( armSensor.blue() - armSensor.green()) >30)) {

                        this.leftMotor.setPower(.15);
                        this.rightMotor.setPower(.05);
                        telemetry.update();

                    }//if (((armSensor.blue() - armSensor.red()) > 30) && (( armSensor.blue() - armSensor.green()) >30))

                }//while (this.armServo.getPosition() < 1)

            }//while (gamepad1.right_trigger > 0)

        }//while (opModeIsActive())

    }//public void runOpMode

}//public class followLine2 extends LinearOpMode