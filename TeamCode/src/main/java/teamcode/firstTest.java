package teamcode;

//import these things to make the code work
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

//the name of the Op Mode in the Driver's Station
@TeleOp(name="JessTest1", group="Linear Opmode")

//okay now onto the class finally
public class firstTest extends LinearOpMode {


    // declaring hardware
    // variable type, Hardware type, variable name
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor motor0;
    private DcMotor motor1;
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
            double drive = -gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;

            if (drive !=0){
                leftPower = -drive;
                rightPower = -drive;
                //if drive is not 0, set both motor powers to the value of drive
            }
            else if (turn !=0){
                leftPower = turn;
                rightPower = -turn;
                //if the drive if reports false, it runs this turn block
            }
            else {
                leftPower = 0;
                rightPower = 0;
                //if neither of these if statements report true it sets the motor powers to 0
                // if you don't push a stick, the robot don't move
            }
            this.motor0.setPower(leftPower);
            this.motor1.setPower(rightPower);

        }

    }


    private void initialize(){

        //giving internal hardware an external name for the app config
        //also initializing the hardware?
        this.motor0 = hardwareMap.get (DcMotor.class,"Left Motor");
        this.motor1 = hardwareMap.get (DcMotor.class, "Right Motor");
        this.servo0 = hardwareMap.get (Servo.class, "Arm Servo");

        // makes the motors that face away from each other move the same direction
        this.motor0.setDirection(DcMotor.Direction.FORWARD);
        this.motor1.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Online");
        telemetry.update();
    }


    //code under here


}
