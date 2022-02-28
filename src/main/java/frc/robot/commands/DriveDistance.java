// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Chassis;

public class DriveDistance extends CommandBase {
  private double distance;
  private double dPerCount;
  private int direction;

  private Chassis chassis;

  /** Creates a new DriveDistance. */
  public DriveDistance(int dir, double dist) { 
    distance = dist;
    direction = dir;
    dPerCount = Constants.DRIVE_CONSTANTS.DISTANCE_PER_COUNT;
    
    // Use addRequirements() here to declare subsystem dependencies.
    chassis = RobotContainer.m_chassis;
    addRequirements(chassis);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    chassis.resetEncoder(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    chassis.driveStraight(direction);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    chassis.stopChassis();
    Timer.delay(2);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (Math.abs(chassis.getEncoderPosition(0)) * dPerCount) >= distance;
  }
}
