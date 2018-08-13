package teamcode;

//import these things to make the code work
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

//the name of the Op Mode in the Driver's Station
@TeleOp(name="JessTest2", group="Linear Opmode")

//okay now onto the class finally
public class secondTest extends LinearOpMode {


    // declaring hardware
    // variable type, Hardware type, variable name
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private Servo servo0;

    @Override
    public void runOpMode() {

        //run the initialize block
        this.initialize();

        waitForStart();
        runtime.reset();

        while(opModeIsActive()){
            //double is a variable type that supports decimals
            double leftPower;
            double rightPower;
            double leftStick = gamepad1.left_stick_y;
            double rightStick = gamepad1.right_stick_x;
            //defining a variable is just stating the type, and giving it a value, if applicable

            if (rightStick < 0) {
                leftPower = leftStick + (2 * rightStick);
                rightPower = leftStick;
            }
            else if (rightStick > 0) {
                leftPower = leftStick;
                rightPower = leftStick - ( 2 * rightStick);
            }
            else {
                leftPower = 0;
                rightPower = 0;
                //if neither of these if statements report true it sets the motor powers to 0
                // if you don't push a stick, the robot don't move
            }
            this.leftMotor.setPower(leftPower);
            this.rightMotor.setPower(rightPower);

        }

    }


    private void initialize(){

        //giving internal hardware an external name for the app config
        //also initializing the hardware?
        this.leftMotor = hardwareMap.get (DcMotor.class,"Left Motor");
        this.rightMotor = hardwareMap.get (DcMotor.class, "Right Motor");
        this.servo0 = hardwareMap.get (Servo.class, "Arm Servo");

        // makes the motors that face away from each other move the same direction
        this.leftMotor.setDirection(DcMotor.Direction.FORWARD);
        this.rightMotor.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Online");
        telemetry.update();
    }


    //code under here


}
