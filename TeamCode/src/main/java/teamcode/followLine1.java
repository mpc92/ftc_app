package teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;

@TeleOp (name="Follow Line 1", group="Linear Opmode")

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

        double leftPower;
        double rightPower;
        double leftStickY;
        double rightStickX;
        double armPos = 0;
        boolean armGoingRight = true;
        boolean followingLine = false;


        this.armServo.setPosition(armPos);


       while (opModeIsActive()){


           if (gamepad1.a && !followingLine) { //if line following is off, turns it on when a is pressed

               followingLine = true;

           }

           if (gamepad1.a && followingLine) { // if line following is on, turns if off when a is pressed

               followingLine = false;

           }


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



                   else if (followingLine) { //if the driver is not controlling, and line follow is on



                        while (followingLine) { //repeat until line follow is disabled

                            armPos = armServo.getPosition();

                            if (armServo.getPosition() == 1) { // if the arm is all the way right, go left

                                armGoingRight = false;

                            }

                            if (armServo.getPosition() == 0) { // if the arm is all the way left, go right

                                armGoingRight = true;

                            }

                            if (armGoingRight) { //makes arm go right

                                armServo.setPosition(armPos + 0.01);

                            }

                            if (!armGoingRight) { //makes arm go left

                                armServo.setPosition(armPos - 0.01);

                            }


                            if (((armSensor.blue() - armSensor.red()) > 30) && (( armSensor.blue() - armSensor.green()) >30)){ //if there is more blue than any other color by a certain threshold

                                if (armServo.getPosition() <.72){ //if the blue is left of the middle, the robot drives slightly to the right

                                    leftPower = 0.15;
                                    rightPower = 0.1;

                                }

                                else if (armServo.getPosition() >=.72) { //if the blue is to the right of the middle, the robot drives slightly to the left

                                    leftPower = 0.1;
                                    rightPower = 0.15;

                                }

                                this.leftMotor.setPower(leftPower); //makes the motors actually move
                                this.rightMotor.setPower(rightPower);

                            } // if (((armSensor.blue() - armSensor.red()) > 30) && (( armSensor.blue() - armSensor.green()) >30))

                        }//while (followingLine == true)
                   }// else if (followingLine == true)

                        else { //if the bot is not controlled, and line follow is off, the robot stops moving

                            leftPower = 0;
                            rightPower = 0;

                        }


                       this.leftMotor.setPower(leftPower);
                       this.rightMotor.setPower(rightPower);

                       telemetry.addData("Left Power", leftPower);
                       telemetry.addData("Right Power", rightPower);
                       telemetry.addData("Arm Position", this.armServo.getPosition());
                       telemetry.addData("ARGB", armSensor.argb());
                       telemetry.addData("Line Following", followingLine);

                       telemetry.update();

        }//while (opModeIsActive())
    } //public void runOpMode()
} //public class followLine1 extends LinearOpMode
