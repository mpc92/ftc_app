package teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class KitRobot extends RobotBase {
    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private Servo colorArmServo;
    private ColorSensor colorSensor;

    public KitRobot(HardwareMap hardwareMap, Telemetry telemetry) {
        super(hardwareMap, telemetry);
    }

    @Override
    public void initialize() {
        this.leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        this.rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");

        this.leftMotor.setDirection(DcMotor.Direction.REVERSE);
        this.rightMotor.setDirection(DcMotor.Direction.FORWARD);

        this.leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //this.leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //this.rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        this.colorArmServo = hardwareMap.get(Servo.class  , "colorArmServo");
        this.colorSensor = hardwareMap.get(ColorSensor.class, "colorSensor");

        super.initialize();
    }

    public void drive(double leftPower, double rightPower) {
        this.leftMotor.setPower(leftPower);
        this.rightMotor.setPower(rightPower);
    }

    public void moveArm(double position) {
        this.colorArmServo.setPosition(position);
    }
}