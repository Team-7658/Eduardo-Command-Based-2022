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

public class Climber extends SubsystemBase {
  // Motor Controllers
  CANSparkMax telescopingWinch;
  CANSparkMax pivotWinchLeader;
  CANSparkMax pivotWinchFollower;

  // Double Solenoid
  DoubleSolenoid claws;

  Pneumatics pneumatics;

  /** Creates a new Climber. */
  public Climber() 
  {
    pneumatics = RobotContainer.m_pneumatics;

    // Motor Controllers
    telescopingWinch = new CANSparkMax(Constants.CAN.TELESCOPING_ARM_WINCH, MotorType.kBrushless);
    pivotWinchLeader = new CANSparkMax(Constants.CAN.PIVOT_WINCH_LEADER, MotorType.kBrushless);
    pivotWinchFollower = new CANSparkMax(Constants.CAN.PIVOT_WINCH_FOLLOWER, MotorType.kBrushless);
    pivotWinchFollower.follow(pivotWinchLeader);

    // Double Solenoids
    claws = pneumatics.getClaws();
  }

  public void openClaws()
  {
    claws.set(Value.kReverse);
  }

  public void closeClaws()
  {
    claws.set(Value.kForward);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
