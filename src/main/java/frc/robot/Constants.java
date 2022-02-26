// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // CAN Constants
    public static class CAN
    {
		// Motor controler CAN IDs
        public static int LEFT_FRONT_MOTOR = 1;
        public static int LEFT_BACK_MOTOR = 2;
        public static int RIGHT_FRONT_MOTOR = 3;
        public static int RIGHT_BACK_MOTOR = 4;
        public static int SCORER_WINCH = 5;
        public static int TELESCOPING_ARM_WINCH = 6;
        public static int PIVOT_WINCH_LEADER = 7;
        public static int PIVOT_WINCH_FOLLOWER = 8;

        // PCM CAN ID
        public static int PCM_ID = 0;
    }

    // Joystick Constants
    public static class JOYSTICK
    {
        public static int MAIN_JOYSTICK_PORT = 0;
        public static int BUTTON_STATION = 1;
    }

    // Motor Controller array index values
    public static class ARRAY_INDEX
    {
        public static int LEFT_FRONT_INDEX = 0;
        public static int LEFT_BACK_INDEX = 1;
        public static int RIGHT_FRONT_INDEX = 2;
        public static int RIGHT_BACK_INDEX = 3;
    }

    // Pneumatics port values
    public static class PNEUMATICS
    {
        // Ports for arm solenoids
        public static int ARM_SOLENOID_ONE = 0;
        public static int ARM_SOLENOID_TWO = 1;

        // Ports for claw solenoids
        public static int CLAWS_SOLENOID_FIRST = 2;
        public static int CLAWS_SOLENOID_SECOND = 3;
    }
}
