// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.kinematics.MecanumDriveMotorVoltages;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;
import frc.robot.Mecanum;

import com.revrobotics.RelativeEncoder;

public class Chassis extends SubsystemBase {
  // Array holding all CANSparkMax controllers for the Chassis.
  private CANSparkMax[] controllers;

  // Array holding all Encoders for the chassis
  private RelativeEncoder[] encoders;

  // Drive speed
  private double speed;

  // Individual CANSparkMax controllers
  private CANSparkMax lFront;
  private CANSparkMax lBack;
  private CANSparkMax rFront;
  private CANSparkMax rBack;

  // CANSparkMax encoders
  private RelativeEncoder lFrontEncoder;
  private RelativeEncoder lBackEncoder;
  private RelativeEncoder rFrontEncoder;
  private RelativeEncoder rBackEncoder;

  // Mecanum class
  Mecanum mecanum;

  /** Creates a new ExampleSubsystem. */
  public Chassis() 
  {
    // Initializes the controllers array
    controllers = new CANSparkMax[4];

    // Initializes the endocers array
    encoders = new RelativeEncoder[4];

    // Right side motors are inverted to rotate the same direction as left side
    // Initializes CANSparkMax controllers and adds them to the array
    CANSparkMax lFront = new CANSparkMax(Constants.CAN.LEFT_FRONT_MOTOR, MotorType.kBrushless);
    controllers[Constants.ARRAY_INDEX.LEFT_FRONT_INDEX] = lFront;
    lFrontEncoder = lFront.getEncoder();
    encoders[Constants.ARRAY_INDEX.LEFT_FRONT_INDEX] = lFrontEncoder;

    CANSparkMax lBack = new CANSparkMax(Constants.CAN.LEFT_BACK_MOTOR, MotorType.kBrushless);
    controllers[Constants.ARRAY_INDEX.LEFT_BACK_INDEX] = lBack;
    lBackEncoder = lBack.getEncoder();
    encoders[Constants.ARRAY_INDEX.LEFT_BACK_INDEX] = lBackEncoder;


    CANSparkMax rFront = new CANSparkMax(Constants.CAN.RIGHT_FRONT_MOTOR, MotorType.kBrushless);
    rFront.setInverted(true);
    controllers[Constants.ARRAY_INDEX.RIGHT_FRONT_INDEX] = rFront;
    rFrontEncoder = rFront.getEncoder();
    encoders[Constants.ARRAY_INDEX.RIGHT_FRONT_INDEX] = rFrontEncoder;

    CANSparkMax rBack = new CANSparkMax(Constants.CAN.RIGHT_BACK_MOTOR, MotorType.kBrushless);
    rBack.setInverted(true);
    controllers[Constants.ARRAY_INDEX.RIGHT_BACK_INDEX] = rBack;
    rBackEncoder = rBack.getEncoder();
    encoders[Constants.ARRAY_INDEX.RIGHT_BACK_INDEX] = rBackEncoder;

    // Sets encoder conversion for position
    for(int i = 0; i < 4; i++)
    {
      encoders[i].setPositionConversionFactor(Constants.DRIVE_CONSTANTS.COUNTS_PER_REV);
    }

    // Autonomous drive speed
    speed = Constants.DRIVE_CONSTANTS.AUTO_SPEED;
  }
  
  public CANSparkMax[] getControllers()
  {
    return controllers;
  }

  public void resetEncoder(int index)
  {
    encoders[index].setPosition(0);
  }

  public double getEncoderPosition(int index)
  {
    return encoders[index].getPosition(); 
  }

  public void driveStraight(int value)
  {
    if(value == 0)
    {
      for(int i = 0; i < 4; i++)
      {
        controllers[i].set(speed);
      }
    }
    else if(value == 1)
    {
      for(int i = 0; i < 4; i++)
      {
        controllers[i].set(-speed);
      }
    }
  }

  public void stopChassis()
  {
    for(int i = 0; i < 4; i++)
    {
      controllers[i].stopMotor();
    }
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
