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


public class Scorer extends SubsystemBase {
  Pneumatics pneumatics;
  DoubleSolenoid grabber;
  CANSparkMax winch;

  /** Creates a new Scorer. */
  public Scorer() 
  {
    pneumatics = RobotContainer.m_pneumatics;
    grabber = pneumatics.getGrabber();
    winch = new CANSparkMax(Constants.CAN.SCORER_WINCH, MotorType.kBrushed);
  }

  public void openGrabber()
  {
    grabber.set(Value.kReverse);
  }

  public void closeGrabber()
  {
    grabber.set(Value.kForward);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
