package teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="KitDrive", group="Linear Opmode")
public class KitDrive extends LinearOpMode {
    private KitRobot robot;
    private double speedScale = 1;

    public KitDrive() {
        this.robot = new KitRobot(this.hardwareMap, this.telemetry);
        this.robot.initialize();
    }

    public void runOpMode() {
        waitForStart();

        while( opModeIsActive() ) {
            updateMode();
            arm();
            drive();
        }
    }

    private void arm() {
        double position = (gamepad1.right_stick_x + 1)/2;
        this.robot.moveArm(position);
    }

    private void drive() {
        double left_trigger = gamepad1.left_trigger;
        double right_trigger = gamepad1.right_trigger;
        double left_stick_y = gamepad1.left_stick_y;
        double right_stick_y = gamepad1.right_stick_y;


        if (left_trigger > 0) {
            // We are pivoting left
            double p = left_trigger;
            this.robot.drive(-p, p);
        }
        else if (right_trigger > 0) {
            // We are pivoting right
            double p = right_trigger;
            this.robot.drive(p, -p);
        }
        else if (left_stick_y != 0 || right_stick_y != 0) {
            // We are in regular drive
            this.robot.drive(this.getLeftPower(), this.getRightPower());
        }
        else {
            // No drive
            this.robot.drive(0, 0);
        }

    }

    private double getLeftPower() {
        double p = this.gamepad1.left_stick_y;
        return this.adjustMotorPower(p);
    }

    private double getRightPower() {
        double p = this.gamepad1.right_stick_y;
        return this.adjustMotorPower(p);
    }

    private void updateMode() {
        double scaleFactor = 0.1;
        if (gamepad1.left_bumper && gamepad1.right_bumper) {
            // Reset
            speedScale = 1;
        }
        else if (gamepad1.left_bumper) {
            speedScale -= scaleFactor;
        }
        else if (gamepad1.right_bumper) {
            speedScale += scaleFactor;
        }

        if (scaleFactor < 0) {
            scaleFactor = 0;
        }

        if (scaleFactor > 2) {
            scaleFactor = 2;
        }
    }

    private double capMotorPower(double power) {
        if (power < -1) {
            power = -1;
        }
        else if (power > 1) {
            power = 1;
        }

        return power;
    }

    private double adjustMotorPower(double power) {
        // scale the power
        power = power * this.speedScale;

        // Make sure the power stays within range: -1 to 1
        power = capMotorPower(power);

        return power;
    }
}