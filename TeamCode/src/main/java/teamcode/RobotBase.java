package teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class RobotBase {
    protected boolean DebugMode = false;

    protected HardwareMap hardwareMap;
    protected Telemetry telemetry;

    public RobotBase(HardwareMap hardwareMap, Telemetry telemetry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;
    }

    public void addTelemetry(String msg){
        if (this.DebugMode) {
            telemetry.addData("Status", msg);
        }
    }

    public void updateTelemetry() {
        if (this.DebugMode) {
            telemetry.update();
        }
    }

    public void writeTelemetry(String msg) {
        this.writeTelemetry(msg);
        this.updateTelemetry();
    }

    public void initialize() {
        this.writeTelemetry("Initialized");
        this.updateTelemetry();
    }
}
