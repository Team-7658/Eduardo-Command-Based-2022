// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
// import frc.robot.RobotContainer;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Auton extends SequentialCommandGroup {
  /** Creates a new Auton. */
  public Auton() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      // Raise elevator command


      // Drive forward a set distance
      new DriveDistance(0, Constants.DRIVE_CONSTANTS.FWD_DIST),
    
      // Open arm command
      
      // Drive backward a set distance
      new DriveDistance(1, Constants.DRIVE_CONSTANTS.BACK_DIST)
    );
  }
}
