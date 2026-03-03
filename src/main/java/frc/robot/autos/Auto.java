package frc.robot.autos;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CANDriveSubsystem;
import frc.robot.subsystems.CANFuelSubsystem;

public class Auto extends Command {
    CANDriveSubsystem driveSubsystem;
    CANFuelSubsystem fuelSubsystem;
    private Timer timer;

    private final double maxTime = 10d;
    private final double spinTime = 5d;

    public Auto(CANDriveSubsystem d,CANFuelSubsystem f) {
        driveSubsystem = d;
        fuelSubsystem = f;
        timer = new Timer();
        addRequirements(driveSubsystem);
        addRequirements(fuelSubsystem);
        System.out.println("constructor");

    }

    @Override
    public void initialize() {
        timer.restart();
        timer.start();
    }

    @Override
    public void execute() {
        System.out.print("Timer time: " + timer.get());
        if (timer.get() < spinTime) {
            fuelSubsystem.setIntakeSpeed(0.75d);
            fuelSubsystem.setFeederSpeed(-1d);
        } else {
            fuelSubsystem.setIntakeSpeed(0);
            fuelSubsystem.setFeederSpeed(0);
        }

        if (timer.get() < maxTime) {
            driveSubsystem.autoDrive(1, 1, 1);
        }
            

        
    }
    @Override
    public void end(boolean interrupted) {
        fuelSubsystem.setIntakeSpeed(0);
        fuelSubsystem.setFeederSpeed(0);
        driveSubsystem.autoDrive(0, 0, 67);
        timer.stop();
    }
    @Override
    public boolean isFinished() {
        return (timer.get() > maxTime);
    }
}
