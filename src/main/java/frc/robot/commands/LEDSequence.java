package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.LEDState;
import frc.robot.subsystems.LEDs;

public class LEDSequence extends Command {
  
  private final LEDs s_LEDs;
  private final LEDState state;
  private double timeStamp;
  private double seconds;
  private double speed;

  public LEDSequence(LEDs s_LEDs, LEDState state, double speed, double seconds) {
    this.s_LEDs = s_LEDs;
    this.state = state;
    this.seconds = seconds;
    this.speed = speed;

    addRequirements(s_LEDs);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timeStamp = Timer.getFPGATimestamp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    s_LEDs.strobe(state, speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    s_LEDs.set(LEDState.GREEN);
    s_LEDs.setAnimation(null);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Timer.getFPGATimestamp() - timeStamp >= seconds;

  }
}
