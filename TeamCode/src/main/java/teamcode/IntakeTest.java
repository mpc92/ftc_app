package teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp(name = "Intake Test", group = "Linear Opmode")

public class IntakeTest extends LinearOpMode{

    private ElapsedTime runtime = new ElapsedTime();

    private DcMotor leftMotor;
    private DcMotor rightMotor;


    @Override
    public void runOpMode(){

        waitForStart();
        runtime.reset();

        this.leftMotor = hardwareMap.get(DcMotor.class, "Left Motor");
        this.rightMotor = hardwareMap.get(DcMotor.class, "Right Motor");
        this.rightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        telemetry.addData("lspeed", this.leftMotor.getPower());
        telemetry.addData("rSpeed", this.rightMotor.getPower());

        while (opModeIsActive()){

            this.leftMotor.setPower( - gamepad1.right_trigger);
            this.rightMotor.setPower(gamepad1.right_trigger);
            telemetry.update();

            }
        }
    }

