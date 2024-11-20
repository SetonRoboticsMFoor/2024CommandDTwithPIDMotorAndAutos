package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrainSub;

public class AutoDriveCom extends Command {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final DriveTrainSub m_subsystem;
  private final double ySpeed;
  private final double zSpeed;

  public AutoDriveCom(DriveTrainSub subsystem, double ySpeed, double zSpeed) {
    m_subsystem = subsystem;
    this.ySpeed = ySpeed;
    this.zSpeed = zSpeed;

    addRequirements(subsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    
    m_subsystem.arcadeDrive(zSpeed, ySpeed);
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.arcadeDriveStop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}