package teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
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

        this.leftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        this.rightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        runtime.reset();


        while (opModeIsActive()){

            telemetry.addData("Left Power", this.leftMotor.getPower());
            telemetry.addData("Right Power", this.rightMotor.getPower());
            telemetry.addData("Arm Position", this.armServo.getPosition());
            telemetry.addData("Red", this.armSensor.red());
            telemetry.addData("Green", this.armSensor.green());
            telemetry.addData("Blue", this.armSensor.blue());

            telemetry.update();

            if (gamepad1.right_bumper){//manually bump the arm

                armPos = armPos + 0.05;
                this.armServo.setPosition(armPos);
                telemetry.update();

            }

            if (gamepad1.left_bumper){//manually bump the arm

                armPos = armPos - 0.05;
                this.armServo.setPosition(armPos);
                telemetry.update();

            }

            if (gamepad1.b){//force update telemetry

                telemetry.update();

            }

            while (gamepad1.a){//while a is held the robot should follow a blue line

                this.armServo.setPosition(1);

                while (this.armServo.getPosition() > 0){

                    armPos = armPos - 0.01;
                    this.armServo.setPosition(armPos);
                    telemetry.update();

                    if ((armSensor.blue() > armSensor.green()) && (armSensor.blue() > armSensor.red())){ //if blue is the most prominent color, then the robot will give a slight steer based on where the line is

                        if (armPos < 0.75){

                            this.leftMotor.setPower(.1);
                            this.rightMotor.setPower(.15);
                            telemetry.update();

                        }

                        if (armPos == 0.75){

                            this.leftMotor.setPower(.1);
                            this.rightMotor.setPower(.1);
                            telemetry.update();

                        }

                        if (armPos < 0.75){

                            this.leftMotor.setPower(.15);
                            this.rightMotor.setPower(.1);
                            telemetry.update();

                        }

                    }//if ((armSensor.blue() > armSensor.green()) && (armSensor.blue() > armSensor.red()))

                }//while (this.armServo.getPosition() > 0

                while (this.armServo.getPosition() < 1) {

                    armPos = armPos + 0.01;
                    this.armServo.setPosition(armPos);
                    telemetry.update();

                    if ((armSensor.blue() > armSensor.green()) && (armSensor.blue() > armSensor.red())){//if blue is the most prominent color, then the robot will give a slight steer based on where the line is

                        if (armPos < 0.75){

                            this.leftMotor.setPower(.1);
                            this.rightMotor.setPower(.15);
                            telemetry.update();

                        }

                        if (armPos == 0.75){

                            this.leftMotor.setPower(.1);
                            this.rightMotor.setPower(.1);
                            telemetry.update();

                        }

                        if (armPos < 0.75){

                            this.leftMotor.setPower(.15);
                            this.rightMotor.setPower(.1);
                            telemetry.update();

                        }

                    }//if ((armSensor.blue() > armSensor.green()) && (armSensor.blue() > armSensor.red()))

                }//while (this.armServo.getPosition() < 1)

            }//while (gamepad1.a)

            this.leftMotor.setPower(0);
            this.rightMotor.setPower(0);

        }//while (opModeIsActive())

    }//public void runOpMode

}//public class followLine2 extends LinearOpMode