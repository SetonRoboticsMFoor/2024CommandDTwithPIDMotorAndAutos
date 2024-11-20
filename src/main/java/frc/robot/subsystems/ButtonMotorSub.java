// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class ButtonMotorSub extends SubsystemBase {
  /** Creates a new ButtonMotor. */
  CANSparkMax motor;
  RelativeEncoder motorEncoder;
  public ButtonMotorSub() {
    motor = new CANSparkMax(Constants.BUT_MOTOR, MotorType.kBrushless);
    motorEncoder = motor.getEncoder();
  }


 
  public void spinForward() {
    motor.set(Constants.FORWARD_SPEED);
  }
  public void spinPID(double speed){
    motor.set(speed);
  }


  public void spinBackward() {
    motor.set(Constants.BACKWARD_SPEED);
  }
  public void stop() {
    motor.stopMotor();
  }
   public double getButEncoder(){
    return motorEncoder.getPosition();
   }


   public void resetEncoder(){
    motorEncoder.setPosition(0);
   }
}
