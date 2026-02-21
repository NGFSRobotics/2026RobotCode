package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CANFuelSubsystem;

public class FeederIntake extends Command {
    CANFuelSubsystem fuelSubsystem;
    public FeederIntake(CANFuelSubsystem f) {
        fuelSubsystem = f;
    }

    @Override
    public void execute() {
        fuelSubsystem.setFeederSpeed(-1d);
    }
}
