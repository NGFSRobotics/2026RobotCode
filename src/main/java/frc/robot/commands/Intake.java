package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CANFuelSubsystem;

public class Intake extends Command {
    CANFuelSubsystem fuelSubsystem;
    public Intake(CANFuelSubsystem f) {
        fuelSubsystem = f;
    }

    @Override
    public void execute() {
        fuelSubsystem.setIntakeSpeed(.75d);
    }

}
