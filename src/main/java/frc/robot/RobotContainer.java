package frc.robot;

import frc.robot.commands.LEDSequence;
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
    s_LEDs.setDefaultCommand(new RunCommand(() -> {
      s_LEDs.set(LEDState.GREEN);
    }, s_LEDs));

    configureBindings();
  }

  private void configureBindings() {
    xButton.onTrue(new LEDSequence(s_LEDs,LEDState.ORANGE, .2, 2));
    yButton.onTrue(new LEDSequence(s_LEDs,LEDState.RED, .2, 2));
    aButton.onTrue(new LEDSequence(s_LEDs,LEDState.BLUE, .2, 2));
    bButton.onTrue(new LEDSequence(s_LEDs,LEDState.YELLOW, .2, 2));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
