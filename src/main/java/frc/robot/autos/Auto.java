package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.FeederIntake;
import frc.robot.commands.Intake;
import frc.robot.subsystems.CANDriveSubsystem;
import frc.robot.subsystems.CANFuelSubsystem;

public class Auto extends Command {
    CANDriveSubsystem driveSubsystem;
    CANFuelSubsystem fuelSubsystem;
    public Auto(CANDriveSubsystem d,CANFuelSubsystem f) {
        driveSubsystem = d;
        fuelSubsystem = f;
        addRequirements(driveSubsystem);
        addRequirements(fuelSubsystem);
        System.out.println("constructor");

    }

    @Override
    public void initialize() {
        System.out.println("auto");
        
       
    }

    @Override
    public void execute() {
       


        
    }
    @Override
    public void end(boolean interrupted) {
        System.out.println("end");
    }
}
