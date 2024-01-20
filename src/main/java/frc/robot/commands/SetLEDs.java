package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.LEDState;
import frc.robot.subsystems.LEDs;

public class SetLEDs extends Command {
  
  private final LEDs s_LEDs;
  private final LEDState state;
  private double timeStamp;

  public SetLEDs(LEDs s_LEDs, LEDState state) {
    this.s_LEDs = s_LEDs;
    this.state = state;

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
    if(state.strobe){
      s_LEDs.strobe(state);
    } else {
      s_LEDs.set(state);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    s_LEDs.set(LEDState.ENABLED);
    s_LEDs.setAnimation(null);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(state.strobe){
      return Timer.getFPGATimestamp() - timeStamp >= state.time;
    } else {
      return false;
    }
  }
}
