package frc.robot;


import frc.robot.commands.Autos;

//import frc.robot.Constants.OperatorConstants;

import frc.robot.commands.ButtonMotorForwardCom;
import frc.robot.commands.ButtonMotorReverseCom;
import frc.robot.commands.TeleDriveCom;
import frc.robot.subsystems.ButtonMotorSub;
import frc.robot.subsystems.DriveTrainSub;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;



/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
   private final DriveTrainSub m_DriveTrainSub;
   private final ButtonMotorSub m_ButtonMotorSub;
  private Joystick m_Joystick;
  private JoystickButton fButton;
  private JoystickButton rButton;

  private final SendableChooser<Command> auto_chooser;
    final Command leftAuto;
    final Command rightAuto;
    final Command middleAuto;

  public RobotContainer() {
    m_DriveTrainSub = new DriveTrainSub();
    m_ButtonMotorSub = new ButtonMotorSub();
    m_Joystick = new Joystick(Constants.JOYSTICK_CHANNEL);
    fButton = new JoystickButton(m_Joystick, Constants.FORWARD_BUT);
    rButton = new JoystickButton(m_Joystick, Constants.BACKWARD_BUT);
    m_ButtonMotorSub.resetEncoder();

    //Instantiate the autonomous commands and chooser
    auto_chooser = new SendableChooser<>();
    leftAuto = Autos.leftAuto(m_DriveTrainSub);
    rightAuto = Autos.rightAuto(m_DriveTrainSub);
    middleAuto = Autos.middleAuto(m_DriveTrainSub);

    //Add the options for middle, left, and right into the chooser
    auto_chooser.setDefaultOption("Middle Auto", middleAuto);
    auto_chooser.addOption("Right Auto", rightAuto);
    auto_chooser.addOption("Left Auto", leftAuto);
  
    // Put the chooser into the SmartDashboard
    SmartDashboard.putData(auto_chooser);


    m_DriveTrainSub.setDefaultCommand(new TeleDriveCom(
        m_DriveTrainSub,
        () -> m_Joystick.getZ() * Constants.Z_SPEED_MULTIPLIER,
        () -> m_Joystick.getY() * Constants.Y_SPEED_MULTIPLIER));


    configureBindings();
    fButton.toggleOnTrue(new ButtonMotorForwardCom(m_ButtonMotorSub, Constants.FORWARD_SETPOINT));
    rButton.toggleOnTrue(new ButtonMotorReverseCom(m_ButtonMotorSub, Constants.BACKWARD_SETPOINT));
  }


  private void configureBindings() {
  }

// This method takes the selected auto command from the chooser and returns it into autonomous.init
  public Command getAutonomousCommand() {
    return auto_chooser.getSelected();
  }

}
