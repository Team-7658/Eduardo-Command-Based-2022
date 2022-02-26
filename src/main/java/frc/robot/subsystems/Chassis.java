// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class Chassis extends SubsystemBase {
  // Array holding all CANSparkMax controllers for the Chassis.
  private CANSparkMax[] controllers;

  // Individual CANSparkMax controllers
  private CANSparkMax lFront;
  private CANSparkMax lBack;
  private CANSparkMax rFront;
  private CANSparkMax rBack;

  /** Creates a new ExampleSubsystem. */
  public Chassis() 
  {
    // Initializes the controllers array
    controllers = new CANSparkMax[4];

    // Right side motors are inverted to rotate the same direction as left side
    // Initializes CANSparkMax controllers and adds them to the array
    CANSparkMax lFront = new CANSparkMax(Constants.CAN.LEFT_FRONT_MOTOR, MotorType.kBrushless);
    controllers[Constants.ARRAY_INDEX.LEFT_FRONT_INDEX] = lFront;

    CANSparkMax lBack = new CANSparkMax(Constants.CAN.LEFT_BACK_MOTOR, MotorType.kBrushless);
    controllers[Constants.ARRAY_INDEX.LEFT_BACK_INDEX] = lBack;

    CANSparkMax rFront = new CANSparkMax(Constants.CAN.RIGHT_FRONT_MOTOR, MotorType.kBrushless);
    rFront.setInverted(true);
    controllers[Constants.ARRAY_INDEX.RIGHT_FRONT_INDEX] = rFront;

    CANSparkMax rBack = new CANSparkMax(Constants.CAN.RIGHT_BACK_MOTOR, MotorType.kBrushless);
    rBack.setInverted(true);
    controllers[Constants.ARRAY_INDEX.RIGHT_BACK_INDEX] = rBack;
  }
  
  public CANSparkMax[] getControllers()
  {
    return controllers;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
