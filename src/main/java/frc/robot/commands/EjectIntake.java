package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CANFuelSubsystem;

public class EjectIntake extends Command {
    CANFuelSubsystem fuelSubsystem;
    public EjectIntake(CANFuelSubsystem f) {
        fuelSubsystem = f;
    }

    @Override
    public void execute() {
      fuelSubsystem.setIntakeSpeed(-1);
    }
}
