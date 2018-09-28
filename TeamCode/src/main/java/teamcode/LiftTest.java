package teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp(name = "Lift Test", group = "Linear Opmode")

public class LiftTest extends LinearOpMode{

    private ElapsedTime runtime = new ElapsedTime();

    private DcMotor motor;


    @Override
    public void runOpMode(){

        waitForStart();
        runtime.reset();

        this.motor = hardwareMap.get(DcMotor.class, "Motor");

        while(opModeIsActive()){

            telemetry.addData("Motor Power", this.motor.getPower());

            this.motor.setPower(gamepad1.right_trigger);
            this.motor.setPower(-gamepad1.left_trigger);


            telemetry.update();

        }
    }
}

