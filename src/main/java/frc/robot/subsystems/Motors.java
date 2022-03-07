// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Motors extends SubsystemBase {
  // Motor Controllers
  private CANSparkMax telescopingWinch;
  private CANSparkMax pivotWinch;
  private CANSparkMax scorerWinch;

  /** Creates a new Motors. */
  public Motors() 
  {
    // Scoring Winch
    scorerWinch = new CANSparkMax(Constants.CAN.SCORER_WINCH, MotorType.kBrushless);
  
    // Telescoping Winch
    telescopingWinch = new CANSparkMax(Constants.CAN.TELESCOPING_ARM_WINCH, MotorType.kBrushless);

    // Pivoting winch
    pivotWinch = new CANSparkMax(Constants.CAN.PIVOT_WINCH, MotorType.kBrushless);
  }

  public CANSparkMax getTelescopingWinch()
  {
    return telescopingWinch;
  }

  public CANSparkMax getPivotWinch()
  {
    return pivotWinch;
  }

  public CANSparkMax getScorerWinch()
  {
    return scorerWinch;
  }

  public void scorerWinchUp()
  {
    scorerWinch.set(Constants.DRIVE_CONSTANTS.WINCH_SPEED);
  }

  public void scorerWinchStop()
  {
    scorerWinch.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
