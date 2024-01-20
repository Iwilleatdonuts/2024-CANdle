package frc.robot;

import frc.robot.commands.SetLEDs;
import frc.robot.subsystems.LEDState;
import frc.robot.subsystems.LEDs;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {

  private final CommandXboxController operator = new CommandXboxController(Constants.OperatorConstants.kDriverControllerPort);

  private final LEDs s_LEDs = new LEDs();
  private final Trigger xButton = operator.x();
  private final Trigger yButton = operator.y();
  private final Trigger aButton = operator.a();
  private final Trigger bButton = operator.b();

  public RobotContainer() {
    s_LEDs.setDefaultCommand(new SetLEDs(s_LEDs, LEDState.ENABLED));

    configureBindings();
  }

  private void configureBindings() {
    
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
