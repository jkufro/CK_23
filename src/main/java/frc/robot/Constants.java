/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.ColorSensorV3.RawColor;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class WOFConstants {

    public static final int WOFMOTOR = 420; // WOF motor (victor)
    
		public static final int PISTONIN = 0; // piston for wof deployment 
    public static final int PISTONOUT = 1;
    public static final RawColor RED = new RawColor(255, 0, 0, 0);
    public static final RawColor GREEN = new RawColor(0, 255, 0, 0);
    public static final RawColor BLUE = new RawColor(0, 255, 255, 0);
    public static final RawColor YELLOW = new RawColor(255, 255, 0, 0);

    public static final RawColor[] wheelColors ={
      RED, // red
      GREEN, // green
      BLUE, // blue
      YELLOW // Yellow
    };

	public static final double COLOR_THRESHOLD = 50; // how close the color sensor must be to a target color (TBD)

    }

    public static final class DriveConstants {

    }

    public static final class OIConstants {

    // joysticks
		public static final int DRIVER = 0;
    public static final int OPERATOR = 1;

    
    // driver buttons

    // operatior buttons 
      // WOF
      public static final int EXTEND_WOF = 0; // push up
      public static final int RETRACT_WOF = 0; // pull down
      public static final int SPIN_WOF = 0; // spin 3 times
      public static final int HOLD_WOF = 0; // hold on color

    }
}
