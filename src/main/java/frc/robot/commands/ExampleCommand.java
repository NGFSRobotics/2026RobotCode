package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CANFuelSubsystem;

public class ExampleCommand extends Command {
    CANFuelSubsystem fuelSubsystem;
    public ExampleCommand(CANFuelSubsystem f) {
        fuelSubsystem = f;
    }

    @Override
    public void execute() {
        if (!fuelSubsystem.isLaunchDebounce()) {
            fuelSubsystem.setFeederSpeed(1d);
        }
    }
}
