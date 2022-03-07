// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.DigitalInput;


public class Scorer extends SubsystemBase {
  Pneumatics pneumatics;
  Motors motors;
  DoubleSolenoid grabber;
  CANSparkMax winch;
  private double winchSpeed;

  /** Creates a new Scorer. */
  public Scorer() 
  {
    pneumatics = RobotContainer.m_pneumatics;
    motors = RobotContainer.m_motors;
    grabber = pneumatics.getGrabber();
    winch = motors.getScorerWinch();
    winchSpeed = Constants.DRIVE_CONSTANTS.WINCH_SPEED;

    grabber.set(Value.kReverse);
  }

  public void openGrabber()
  {
    grabber.set(Value.kReverse);
  }

  public void closeGrabber()
  {
    grabber.set(Value.kForward);
  }

  public void toggle()
  {
    grabber.toggle();
  }

  public void raise()
  {
    winch.set(winchSpeed);
  }

  public void lower()
  {
    winch.set(-winchSpeed);
  }

  public void stop()
  {
    winch.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
