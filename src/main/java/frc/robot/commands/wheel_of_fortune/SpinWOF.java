/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.wheel_of_fortune;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.WheelOfFortune;

public class SpinWOF extends CommandBase {
  
  private final WheelOfFortune m_WheelOfFortune;
  private Color sensorColor;
  private int rotations;
  private SmartDashboard m_dash;
  private Boolean temp;


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_WheelOfFortune.WOFmotor.set(0.5);     // spin up the WOF motor to 50%
    temp = false;
    rotations = 0;
  }

  public void colorChange(){// count the number of times we switch TO yellow.
    Color blue = Constants.WOFConstants.BLUE; // 

    m_dash.putNumber("aprob red", sensorColor.red);
    m_dash.putNumber("aprob green", sensorColor.green);
    m_dash.putNumber("aprob blue", sensorColor.blue);
    m_dash.putNumber("color diff", WOFHelpers.aproximateColor(blue, sensorColor));
    

    boolean isBlue = WOFHelpers.aproximateColor(blue, sensorColor) < Constants.WOFConstants.COLOR_THRESHOLD; // if the color sensor is close to pure yellow

    

    if(isBlue != temp){ // switch temp back and forth, counting up one each time.
      if(isBlue){
        rotations += 1;
      }
      temp = isBlue;
    } 
    m_dash.putNumber("Rotations", rotations);
    m_dash.putBoolean("isBlue", isBlue);
  }

  /**
   * Creates a new SpinWOF.
   */
  public SpinWOF(WheelOfFortune subsystem) {
    m_WheelOfFortune = subsystem;
    addRequirements(m_WheelOfFortune);
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    sensorColor = m_WheelOfFortune.colorSensor.getColor(); // to set this to the output of the sensor
    colorChange();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_WheelOfFortune.WOFmotor.set(0);// turn off the WOF motor
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // once we have seen yellow 7 times (spun 3.25 times) 
    return rotations >= 7;
  }
}
