package frc.robot.subsystems;

import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase{
  // Declares variables
  private Compressor compressor;
  private CAN pcm;

  // Creates solenoid objects
  private DoubleSolenoid armSolenoid;
  private DoubleSolenoid claws;

  // Pneumatics Class Constructor
  public Pneumatics() 
  {
    // Initializes compressor
    compressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
    compressor.enableDigital();

    // Initializes PCM
    pcm = new CAN(Constants.CAN.PCM_ID, 4, 9);

    // Initializes solenoids
    // Arm Solenoid
    armSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.PNEUMATICS.ARM_SOLENOID_ONE, Constants.PNEUMATICS.ARM_SOLENOID_TWO);
    armSolenoid.set(Value.kOff);
    
    // Claws
    claws = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.PNEUMATICS.CLAWS_SOLENOID_FIRST, Constants.PNEUMATICS.CLAWS_SOLENOID_SECOND);
    claws.set(Value.kOff);
  }

  public DoubleSolenoid getGrabber()
  {
    return armSolenoid;
  }

  public DoubleSolenoid getClaws()
  {
    return claws;
  }

  public Compressor getCompressor()
  {
    return compressor;
  }

  public void toggleGrabber()
  {
    armSolenoid.toggle();
  }

  public void openGrabber()
  {
    armSolenoid.set(Value.kForward);
  }
}
