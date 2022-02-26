// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.DigitalInput;

public class Climber extends SubsystemBase {
  // Motor Controllers
  CANSparkMax telescopingWinch;
  CANSparkMax pivotWinch;

  // Double Solenoid
  DoubleSolenoid claws;

  Pneumatics pneumatics;

  // Limit switch
  DigitalInput climbLim;

  // Pre-set speeds
  double pivotSpeed = 0.05;
  double winchSpeed = 1;

  /** Creates a new Climber. */
  public Climber() 
  {
    pneumatics = RobotContainer.m_pneumatics;

    // Motor Controllers
    telescopingWinch = new CANSparkMax(Constants.CAN.TELESCOPING_ARM_WINCH, MotorType.kBrushless);
    pivotWinch = new CANSparkMax(Constants.CAN.PIVOT_WINCH, MotorType.kBrushless);

    // Double Solenoids
    claws = pneumatics.getClaws();
    claws.set(Value.kForward);

    // Limit switch
    climbLim = new DigitalInput(Constants.DIGITAL.CLIMB_LIM);
  }

  public void openClaws()
  {
    claws.set(Value.kReverse);
  }

  public void closeClaws()
  {
    claws.set(Value.kForward);
  }

  public void toggle()
  {
    claws.toggle();
  }

  public void pivotForward()
  {
    pivotWinch.set(pivotSpeed);
  }

  public void pivotBackward()
  {
    pivotWinch.set(-pivotSpeed);
  }

  public void stopPivot()
  {
    pivotWinch.set(0);
  }

  public void raise()
  {
    telescopingWinch.set(-winchSpeed);
  }

  public void lower()
  {
    telescopingWinch.set(winchSpeed);
  }

  public void stopWinch()
  {
    telescopingWinch.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
