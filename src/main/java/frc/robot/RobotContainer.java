// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Auton;
import frc.robot.commands.DriveChassis;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Pneumatics;
import frc.robot.subsystems.Scorer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final Chassis m_chassis = new Chassis();

  public final Climber m_climber = new Climber();

  public final Scorer m_scorer = new Scorer();

  public static Joystick m_stick = new Joystick(Constants.JOYSTICK.MAIN_JOYSTICK_PORT);

  public static ButtonStation m_station = new ButtonStation();

  private final Auton m_autoCommand = new Auton(m_chassis);

  private final DriveChassis m_chassisCommand = new DriveChassis(m_chassis);

  public final static Pneumatics m_pneumatics = new Pneumatics();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // Set default commands on subsystems
    this.m_chassis.setDefaultCommand(m_chassisCommand);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() 
  {
    // Climber claws
    m_station.blueOne.whenPressed(new InstantCommand(m_climber::openClaws, m_climber));
    m_station.blueTwo.whenPressed(new InstantCommand(m_climber::closeClaws, m_climber));

    // Grabber
    m_station.redOne.whenPressed(new InstantCommand(m_scorer::openGrabber, m_scorer));
    m_station.redTwo.whenPressed(new InstantCommand(m_scorer::closeGrabber, m_scorer));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}