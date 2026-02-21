package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.CANFuelSubsystem;

public class Launch extends Command {
    Thread this_thread;
    CANFuelSubsystem fuelSubsystem;
    CommandXboxController operatorController;
    public Launch(CANFuelSubsystem f, CommandXboxController c) {
        fuelSubsystem = f;
        operatorController = c;
    }

    @Override
    public void initialize() {
        this_thread = new Thread() {
        @Override
        public void run() {
            fuelSubsystem.setLauchDebounce(true);
            try {
               Thread.sleep(1000);
            } catch (InterruptedException interuption) {
             
            }
            fuelSubsystem.setLauchDebounce(false);
            
        }
        };
        this_thread.start();

    }
    @Override
        public void execute() {
        fuelSubsystem.setIntakeSpeed(operatorController.getRightTriggerAxis());
    }
    @Override
    public void end(boolean interrupted) {
        this_thread.interrupt();
        fuelSubsystem.setLauchDebounce(false);

    }
}
