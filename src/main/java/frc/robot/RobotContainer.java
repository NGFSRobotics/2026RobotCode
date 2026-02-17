// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.Timer;
import java.util.TimerTask;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import static frc.robot.Constants.OperatorConstants.*;

import frc.robot.commands.Drive;
import frc.robot.commands.Eject;
import frc.robot.commands.ExampleAuto;
import frc.robot.commands.FeederRoller;
import frc.robot.commands.IntakeRoller;
import frc.robot.commands.VariableChanged;
import frc.robot.subsystems.CANDriveSubsystem;
import frc.robot.subsystems.CANFuelSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and trigger mappings) should be declared here.
 */
//import frc.robot.subsystems.NavXSubsystem;
public class RobotContainer {
  // The robot's subsystems
    private final DataSystem dataSystem = new DataSystem();

  private final CANDriveSubsystem driveSubsystem = new CANDriveSubsystem(dataSystem);
  private final CANFuelSubsystem fuelSubsystem = new CANFuelSubsystem();
  private SpeedVariables speedVariables = new SpeedVariables();
  //private final NavXSubsystem navXSubsystem = new NavXSubsystem();
  // The driver's controller
  private final CommandXboxController driverController = new CommandXboxController(
      DRIVER_CONTROLLER_PORT);

  // The operator's controller
  private final CommandXboxController operatorController = new CommandXboxController(
      OPERATOR_CONTROLLER_PORT);

  // The autonomous chooser
  private final SendableChooser<Command> autoChooser = new SendableChooser<>();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    configureBindings();
    // SmartDashboard.putNumber("DriverX", driverController.getLeftX());
    // SmartDashboard.putNumber("DriverY", driverController.getLeftY());
    // Set the options to show up in the Dashboard for selecting auto modes. If you
    // add additional auto modes you can add additional lines here with
    // autoChooser.addOption
    autoChooser.setDefaultOption("Autonomous", new ExampleAuto(driveSubsystem, fuelSubsystem));

  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be
   * created via the {@link Trigger#Trigger(java.util.function.BooleanSupplier)}
   * constructor with an arbitrary predicate, or via the named factories in
   * {@link edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses
   * for {@link CommandXboxController Xbox}/
   * {@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller PS4}
   * controllers or
   * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {

    // While the left bumper on operator controller is held, intake Fuel
    operatorController.leftBumper().whileTrue(new IntakeRoller(fuelSubsystem,speedVariables));
    // While the right bumper on the operator controller is held, spin up for 1
    // second, then launch fuel. When the button is released, stop.
    operatorController.rightBumper().whileTrue(new FeederRoller(fuelSubsystem,speedVariables));
    // While the A button is held on the operator controller, eject fuel back out
    // the intake
    operatorController.x().whileTrue(new VariableChanged(speedVariables, 'x'));
    operatorController.b().whileTrue(new VariableChanged(speedVariables, 'b'));

    operatorController.leftStick().whileTrue(new Eject(fuelSubsystem));

    // operatorController.x().whileTrue(new ChangeSpeed(12.d));
    // operatorController.y().whileTrue(new ChangeSpeed(9.d));
    // operatorController.b().whileTrue(new ChangeSpeed(6.d));
    // operatorController.a().whileTrue(new ChangeSpeed(3.d));
    // Set the default command for the drive subsystem to the command provided by
    // factory with the values provided by the joystick axes on the driver
    // controller. The Y axis of the controller is inverted so that pushing the
    // stick away from you (a negative value) drives the robot forwards (a positive
    // value)
    driveSubsystem.setDefaultCommand(new Drive(driveSubsystem, driverController));

    fuelSubsystem.setDefaultCommand(fuelSubsystem.run(() -> fuelSubsystem.stop()));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return autoChooser.getSelected();
  }
  private boolean debounce = false;
  public void Rumble() {
    if (debounce == true) {return;}
    debounce = true;
     
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
      @Override
      public void run() {
        
        driverController.setRumble(RumbleType.kBothRumble, 0);
        debounce = false;
      }
    };

    driverController.setRumble(RumbleType.kBothRumble, 1);

    timer.schedule(task, 2000);

  }
}
