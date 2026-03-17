package frc.robot.autos;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CANDriveSubsystem;
import frc.robot.subsystems.CANFuelSubsystem;

public class MoveAuto extends Command {
    CANDriveSubsystem driveSubsystem;
    CANFuelSubsystem fuelSubsystem;
    private Timer timer;
    // 15.5 = 2x is speed

    private final double maxTime = 10d;
    private final double driveTime = 2d;

    private final double spinTime = 0.86d;
    //0.86 for full spin

    public MoveAuto(CANDriveSubsystem d,CANFuelSubsystem f) {
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
        
        if (timer.get() < driveTime) {
            driveSubsystem.autoDrive(1, 1, 1);
        } else if (timer.get() > driveTime && timer.get() < driveTime + spinTime) {
            driveSubsystem.autoDrive(-1, 1, 1);
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
