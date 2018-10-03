package teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="LiftTest", group="Linear Opmode")
public class LiftTest extends LinearOpMode {
}
    private DcMotor motor1;
    private DcMotor motor2;

    public void runOpMode() {

        initialize();
        waitForStart();



        //Always True
        while (opModeIsActive() ) {
            float rightjoystickY = gamepad1.right_stick_y;
            motor1.setPower(rightjoystickY);
        }
        while (opModeIsActive() ) {
            float leftjoystickY = gamepad1.left_stick_y;
            motor2.setPower(leftjoystickY);
        }
    }

    public void initialize() {
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");
        motor1.setDirection(DcMotor.Direction.FORWARD);
        motor2.setDirection(DcMotor.Direction.FORWARD);
    }
}
