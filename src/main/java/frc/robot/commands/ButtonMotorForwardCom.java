// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot.commands;


import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ButtonMotorSub;


public class ButtonMotorForwardCom extends Command {
   private final ButtonMotorSub m_subsystem;
   private final PIDController m_PidController;
  /** Creates a new ButtonMotorForward. */


  public ButtonMotorForwardCom(ButtonMotorSub subsystem, double setPoint) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_subsystem = subsystem;
    m_PidController = new PIDController(.01, 0 , 0);
    m_PidController.setSetpoint(setPoint);


    addRequirements(subsystem);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_PidController.reset();
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = m_PidController.calculate(m_subsystem.getButEncoder());
    m_subsystem.spinPID(speed);
    SmartDashboard.putNumber("Encoder Value", m_subsystem.getButEncoder());
    SmartDashboard.putNumber("setPoint", m_PidController.getSetpoint());
    SmartDashboard.putNumber("speed", speed);
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.stop();
  }


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //if (m_subsystem.getButEncoder() > 200)
     // return true;
    return false;
  }
}
