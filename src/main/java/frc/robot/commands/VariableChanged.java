// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.SpeedVariables;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class VariableChanged extends Command {
  /** Creates a new Intake. */
  char keypressed;
  SpeedVariables speedVariables;

  public VariableChanged(SpeedVariables vars,char key) {
    speedVariables = vars;
    keypressed = key;
  }

  // Called when the command is initially scheduled. Set the rollers to the
  // appropriate values for intaking
  @Override
  public void initialize() {
    if (keypressed == 'b') {
      speedVariables.toggleIntake();
    } else if (keypressed == 'x') {
      speedVariables.toggleLaunch();
    }
  }

  // Called every time the scheduler runs while the command is scheduled. This
  // command doesn't require updating any values while running
  @Override
  public void execute() {
   
  }

  // Called once the command ends or is interrupted. Stop the rollers
  @Override
  public void end(boolean interrupted) {
    if (interrupted) {return;}
    if (keypressed == 'b') {
      speedVariables.toggleIntake();
    } else if (keypressed == 'x') {
      speedVariables.toggleLaunch();
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
