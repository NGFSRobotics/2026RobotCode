// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.CANDriveSubsystem;
import frc.robot.subsystems.CANFuelSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ExampleAuto extends SequentialCommandGroup {
  /** Creates a new ExampleAuto. */
  // private CANDriveSubsystem driveSubsystem;
  // private CANFuelSubsystem ballSubsystem;
  public ExampleAuto(CANDriveSubsystem ds, CANFuelSubsystem bs) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    // driveSubsystem = ds;
    // ballSubsystem = bs;
    // Move(1, 0.8);
  //   addCommands(
  //   // Drive backwards for .25 seconds. The driveArcadeAuto command factory
  //   // intentionally creates a command which does not end which allows us to control
  //   // the timing using the withTimeout decorator

  //   new AutoDrive(driveSubsystem,0.5,  0.0).withTimeout(.25),
  //   // Spin up the launcher for 1 second and then launch balls for 9 seconds, for a
  //   // total of 10 seconds
  //   new Launch(ballSubsystem).withTimeout(10));
  }

  // public void Move(double distance,double speed) {
  //   // speed = t * d
  //   // speed / d = t
  //   // x y z acceleration -> 

  //   double time = speed/distance;
  //   addCommands(
  //    new AutoDrive(driveSubsystem,speed,0.0).withTimeout(time),
  //    null
  //   );
   
  // }
  
}
