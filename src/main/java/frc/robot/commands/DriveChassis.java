// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Chassis;
import frc.robot.Mecanum;

public class DriveChassis extends CommandBase {
  // Creates chassis variable, to be imported in constructor
  Chassis m_chassis;

  // Creates mecanum variable, to be used for mecanum drive
  Mecanum m_mecanum;

  // Creates controllers object(contains 4 chassis motor controllers)
  CANSparkMax[] controllers;

  /** Creates a new DriveTrain. */
  public DriveChassis(Chassis chassis) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(chassis);
    m_chassis = chassis;

    // Imports array of CANSparkMax controllers
    controllers = m_chassis.getControllers();

    // Initializes Mecanum command
    m_mecanum = new Mecanum(controllers);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    m_mecanum.driveMecanum(RobotContainer.m_stick.getRawAxis(0), -RobotContainer.m_stick.getRawAxis(1), RobotContainer.m_stick.getRawAxis(2), RobotContainer.m_stick.getRawButton(1));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
