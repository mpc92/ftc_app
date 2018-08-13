package teamcode;

//import these things to make the code work
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

//the name of the Op Mode in the Driver's Station
@TeleOp(name="JessTest2", group="Linear Opmode")

public class secondTest extends LinearOpMode {

    // declaring hardware
    // variable type, Hardware type, variable name
    // private means the variable is only available in this class, public would be program wide

    private ElapsedTime runtime = new ElapsedTime();

    private DcMotor leftMotor;
    private DcMotor rightMotor;

    @Override
    public void runOpMode() {

        //run the initialize block
        //giving internal hardware an external name for the app config
        //also initializing the hardware?
        this.leftMotor = hardwareMap.get(DcMotor.class, "Left Motor");
        this.rightMotor = hardwareMap.get(DcMotor.class, "Right Motor");

        // makes the motors that face away from each other move the same direction
        this.leftMotor.setDirection(DcMotor.Direction.FORWARD);
        this.rightMotor.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Online");
        telemetry.update();

        waitForStart();
        runtime.reset();

        //double is a variable type that supports decimals
        //defining a variable is just stating the type, and giving it a value, if applicable
        while (opModeIsActive()) {

            double leftPower;
            double rightPower;
            double leftStickY = gamepad1.left_stick_y;
            double rightStickX = gamepad1.right_stick_x;

            if (rightStickX < 0) {
                leftPower = leftStickY + (2 * rightStickX);
                rightPower = leftStickY;
            } else if (rightStickX > 0) {
                leftPower = leftStickY;
                rightPower = leftStickY - (2 * rightStickX);
            } else {
                leftPower = 0;
                rightPower = 0;
                //if neither of these if statements report true it sets the motor powers to 0
                // if you don't push a stick, the robot don't move
            }

            this.leftMotor.setPower(leftPower);
            this.rightMotor.setPower(rightPower);

            telemetry.addData("Left Power", leftPower);
            telemetry.addData("Right Power", rightPower);

            telemetry.update();

        }
    }
}
