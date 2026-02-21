package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CANDriveSubsystem;

public class Sprint extends Command {
    CANDriveSubsystem driveSubsystem;

    public Sprint(CANDriveSubsystem d) {
        driveSubsystem = d;
    }

    @Override
    public void initialize() {
      driveSubsystem.setSprint(true);
    }
    
    @Override
    public void end(boolean interrupted) {
      driveSubsystem.setSprint(false);
    }
}
