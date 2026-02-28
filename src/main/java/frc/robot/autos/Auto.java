package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.FeederIntake;
import frc.robot.commands.Intake;
import frc.robot.subsystems.CANDriveSubsystem;
import frc.robot.subsystems.CANFuelSubsystem;

public class Auto extends Command {
    CANDriveSubsystem driveSubsystem;
    CANFuelSubsystem fuelSubsystem;
    public Auto(CANDriveSubsystem d,CANFuelSubsystem f) {
        addRequirements(driveSubsystem,fuelSubsystem);
        driveSubsystem = d;
        fuelSubsystem = f;
    }

    @Override
    public void initialize() {
        new Intake(fuelSubsystem).withTimeout(10d);
        new FeederIntake(fuelSubsystem).withTimeout(10d);
        new SequentialCommandGroup(new DriveAuto(driveSubsystem).withTimeout(4d));
    }

    @Override
    public void execute() {
       


        
    }
}
