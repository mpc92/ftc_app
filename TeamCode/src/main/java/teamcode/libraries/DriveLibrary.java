package teamcode.libraries;


import java.lang.reflect.Array;


public class DriveLibrary {

    public double upRightMotorPower;
    public double upleftMotorPower;
    public double downLeftMotorPower;
    public double downRightMotorPower;

    public double[] motorPowers = new double[4];

    public Array forwardMovement(double leftStickY){

        upRightMotorPower = leftStickY;
        upleftMotorPower = -leftStickY;
        downLeftMotorPower = -leftStickY;
        downRightMotorPower = leftStickY;

        motorPowers[0] = upRightMotorPower;
        motorPowers[1] = upleftMotorPower;
        motorPowers[2] = downLeftMotorPower;
        motorPowers[0] = downRightMotorPower;

        return motorPowers;
    }
}
