package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp()
public class GNRTWorkshopCh1Basic extends OpMode {

    private DcMotorEx leftDrive;
    private DcMotorEx rightDrive;

    @Override
    public void init() {
        leftDrive = hardwareMap.get(DcMotorEx.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotorEx.class, "right_drive");
        rightDrive.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        double leftPower = -gamepad1.left_stick_y + gamepad1.right_stick_x;
        double rightPower = -gamepad1.left_stick_y - gamepad1.right_stick_x;

        double denominator = Math.max(Math.max(Math.abs(leftPower), Math.abs(rightPower)), 1);
        leftPower /= denominator;
        rightPower /= denominator;

        leftDrive.setPower(leftPower);
        rightDrive.setPower(rightPower);
    }
}
