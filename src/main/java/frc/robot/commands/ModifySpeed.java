package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CANDriveSubsystem;

public class ModifySpeed extends Command {
    CANDriveSubsystem driveSubsystem;
    double speed;
    public ModifySpeed(CANDriveSubsystem d,double s) {
        driveSubsystem = d;
        speed = s;
    }

    @Override
    public void initialize() {
      driveSubsystem.setSpeedModifier(speed);
    }

    @Override
    public void end(boolean interrupted) {
      driveSubsystem.setSpeedModifier(1d);;
    }
}
