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
    private final double shoot =  20d;

    private final double backwardstime = 2.5d;
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
        
        fuelSubsystem.setIntakeSpeed(1d);
        if (timer.get() > backwardstime && timer.get() < shoot) {
            fuelSubsystem.setFeederSpeed(1d);
        } else {
            fuelSubsystem.setFeederSpeed(0d);
        }
        if (timer.get() < backwardstime) {
            driveSubsystem.autoDrive(1, 1, 0.6);
        } else {
            driveSubsystem.autoDrive(0,0, 67);
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
