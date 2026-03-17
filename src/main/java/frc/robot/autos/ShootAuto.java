package frc.robot.autos;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CANDriveSubsystem;
import frc.robot.subsystems.CANFuelSubsystem;

public class ShootAuto extends Command {
    CANDriveSubsystem driveSubsystem;
    CANFuelSubsystem fuelSubsystem;
    private Timer timer;
    // 15.5 = 2x is speed

    private final double revUpTime = 0.5d;
    private final double shoot = 2d;

    private final double spinTime = 0.86d;
    //0.86 for full spin

    public ShootAuto(CANDriveSubsystem d,CANFuelSubsystem f) {
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
    }

    @Override
    public void execute() {
        
        if (timer.get() < shoot) {
            fuelSubsystem.setFeederSpeed(1d);
        }
        else {
            fuelSubsystem.setFeederSpeed(0d);
            fuelSubsystem.setIntakeSpeed(0d);
        }
        if (timer.get() > revUpTime && timer.get() < shoot) {
            fuelSubsystem.setIntakeSpeed(-1d);
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
        return (timer.get() > shoot);
    }
}
