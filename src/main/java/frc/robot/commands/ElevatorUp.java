// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Motors;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.DigitalInput;

public class ElevatorUp extends CommandBase {
  private Motors motors;

  private DigitalInput limitSwitch;

  /** Creates a new ElevatorUp. */
  public ElevatorUp() {
    // Use addRequirements() here to declare subsystem dependencies.
    motors = RobotContainer.m_motors;
    addRequirements(motors);

    limitSwitch = new DigitalInput(Constants.DIGITAL.SCORE_LIM);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    motors.scorerWinchUp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    motors.scorerWinchStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return limitSwitch.get();
  }
}
