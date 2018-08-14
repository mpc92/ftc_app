package teamcode;

//import these things to make the code work
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

//the name of the Op Mode in the Driver's Station
@TeleOp(name="JessTest2", group="Linear Opmode")

public class driveSystem extends LinearOpMode {

    // declaring hardware
    // variable type, Hardware type, variable name
    // private means the variable is only available in this class, public would be program wide

    private ElapsedTime runtime = new ElapsedTime();

    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private DcMotor testMotor;

    @Override
    public void runOpMode() {

        //run the initialize block
        //giving internal hardware an external name for the app config
        //also initializing the hardware?

        this.leftMotor = hardwareMap.get(DcMotor.class, "Left Motor");
        this.rightMotor = hardwareMap.get(DcMotor.class, "Right Motor");
        this.testMotor = hardwareMap.get(DcMotor.class, "Test Motor");

        // makes the motors that face away from each other move the same direction
        this.leftMotor.setDirection(DcMotor.Direction.FORWARD);
        this.rightMotor.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Online");
        telemetry.update();

        waitForStart();
        runtime.reset();

        double leftPower = 0;
        double rightPower = 0;
        double leftStickY;
        double rightStickX;


        //double is a variable type that supports decimals
        //defining a variable is just stating the type, and giving it a value, if applicable

        while (opModeIsActive()) {

           leftStickY = -gamepad1.left_stick_y;
           rightStickX = gamepad1.right_stick_x;

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

                if (rightStickX < 0) {
                    leftPower = -rightStickX;
                    rightPower = rightStickX;
                    // turn left faster
                }

                else if (rightStickX > 0) {
                    leftPower = rightStickX;
                    rightPower = -rightStickX;
                    // turn right faster
                }
            }
            else { // just in case, the robot will hold still
                leftPower = 0;
                rightPower = 0;
            }

            this.leftMotor.setPower(leftPower);
            this.rightMotor.setPower(rightPower);

            telemetry.addData("Left Power", leftPower);
            telemetry.addData("Right Power", rightPower);

            telemetry.update();

        }
    }
}
