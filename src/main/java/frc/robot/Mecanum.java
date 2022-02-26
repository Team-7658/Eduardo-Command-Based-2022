package frc.robot;

import com.revrobotics.CANSparkMax;

import frc.robot.subsystems.Chassis;

public class Mecanum {
    // Creates Controllers array
    private CANSparkMax[] m_controllers;

    // Doubles to calculate speed of motors
    double lF;
    double lB;
    double rF;
    double rB;
    double max;

    // Creates motor opjects, to be initialized in constructor
    CANSparkMax leftFront;
    CANSparkMax leftBack;
    CANSparkMax rightFront;
    CANSparkMax rightBack;

    // Constructs Mecanum Class
    public Mecanum(CANSparkMax[] controllers)
    {
        // Initializes controllers array
        m_controllers = controllers;

        // Sets calculation doubles to 0
        lF = 0;
        lB = 0;
        rF = 0;
        rB = 0;
        max = 0;

        // Initializes CANSparkMax controllers using array
        leftFront = controllers[Constants.ARRAY_INDEX.LEFT_FRONT_INDEX];
        leftBack = controllers[Constants.ARRAY_INDEX.LEFT_BACK_INDEX];
        rightFront = controllers[Constants.ARRAY_INDEX.RIGHT_FRONT_INDEX];
        rightBack = controllers[Constants.ARRAY_INDEX.RIGHT_BACK_INDEX];
    }

    public void temp(double axis)
    {
        for(int i = 0; i < 4; i++)
        {
            m_controllers[i].set(axis);
        }
    }

    public void driveMecanum(double xAxis, double yAxis, double zAxis)
    {
        // Corrects potential drift using the driftThreshold method
        xAxis = driftThreshold(xAxis, 0.1);
        yAxis = driftThreshold(yAxis, 0.1);
        zAxis = driftThreshold(zAxis, 0.25);

        // Sets calculatoins to yAxis(forwards and backwards)
        lF = yAxis;
        lB = yAxis;
        rF = yAxis;
        rB = yAxis;

        // Adds xAxis(left and right) to calculations
        lF += xAxis;
        lB += -xAxis;
        rF += -xAxis;
        rB += xAxis;

        // Adds zAxis(rotate) to calculations
        zAxis = zAxis / 2.5;
        lF += zAxis;
        lB += zAxis;
        rF += -zAxis;
        rB += -zAxis;

        // Finds max value, used to scale down calculations
        max = Math.max(Math.max(Math.abs(lF), Math.abs(rF)), Math.max(Math.abs(lB), Math.abs(rB)));

        // Scales down calculations
        if (max > 1)
        {
            lF = lF / max;
            lB = lB / max;
            rF = rF / max;
            rB = rB / max;
        }

        // // Corrects potential drifting using driftThreshold method
        // lF = driftThreshold(lF, 0.1);
        // lB = driftThreshold(lB, 0.1);
        // rF = driftThreshold(rF, 0.1);
        // rB = driftThreshold(rB, 0.1);

        // Sets motors to calculated values
        leftFront.set(lF);
        leftBack.set(lB);
        rightFront.set(rF);
        rightBack.set(rB);
    }

    // Checks drift threshold to eliminate potential drift
    private double driftThreshold(double value, double drift)
    {
        if(Math.abs(value) < drift)
        {
            value = 0;
        }
        return value;
    }
}
