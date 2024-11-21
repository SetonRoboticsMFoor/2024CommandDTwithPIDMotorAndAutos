// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrainSub;

public final class Autos {
 
//-------------------------------Middle auto code------------------------------------//

  public static Command middleAuto(DriveTrainSub subsystem) {
    return Commands.sequence(
      //drive forward: timeout changes for how long
      new AutoDriveCom(subsystem, Constants.MIDDLE_AUTO_FORWARD_SPEED, 0).withTimeout(Constants.MIDDLE_AUTO_FORWARD_TIME)
    );
  }

  //-------------------------------Right auto code------------------------------------//
  public static  Command rightAuto(DriveTrainSub subsystem) {
    return Commands.sequence(
      //turn right for one second
      new AutoDriveCom(subsystem, 0, Constants.RIGHT_AUTO_TURN_SPEED).withTimeout(Constants.RIGHT_AUTO_TURN_TIME),
      //pause for one second
      new AutoDriveCom(subsystem, 0, 0).withTimeout(Constants.RIGHT_AUTO_FORWARD__PAUSE_TIME),
      //go forward for 3 seconds
      new AutoDriveCom(subsystem,Constants.RIGHT_AUTO_FORWARD_SPEED, 0).withTimeout(Constants.RIGHT_AUTO_FORWARD_TIME)

    );
  }
 //-------------------------------Left auto code------------------------------------//
   public static  Command leftAuto(DriveTrainSub subsystem) {
    return Commands.sequence(
      //turn left for one second
      new AutoDriveCom(subsystem, 0, Constants.LEFT_AUTO_TURN_SPEED).withTimeout(Constants.LEFT_AUTO_TURN_TIME),
      //pause for one second
      new AutoDriveCom(subsystem, 0, 0).withTimeout(Constants.LEFT_AUTO_FORWARD__PAUSE_TIME),
      //go forward for 3 seconds
      new AutoDriveCom(subsystem,Constants.LEFT_AUTO_FORWARD_SPEED, 0).withTimeout(Constants.LEFT_AUTO_FORWARD_TIME)

    );
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
