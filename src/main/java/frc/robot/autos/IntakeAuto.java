// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.FeederIntake;
import frc.robot.commands.Intake;
import frc.robot.subsystems.CANFuelSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class IntakeAuto extends ParallelCommandGroup {
  /** Creates a new Drive. */
  CANFuelSubsystem fuelSubsystem;
  Intake intakeCommand;
  FeederIntake feederIntakeCommand;
  public IntakeAuto(CANFuelSubsystem fuelSystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    fuelSubsystem = fuelSystem;
    addCommands(
      new Intake(fuelSubsystem).withTimeout(5d)
      //new FeederIntake(fuelSubsystem)
    );
   
  }
}
