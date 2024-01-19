package frc.robot.subsystems;

import com.ctre.phoenix.led.Animation;
import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.StrobeAnimation;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotMap;

public class LEDs extends SubsystemBase {

  private final CANdle candle;

  public LEDs() {
    candle = new CANdle(RobotMap.CAN.candleID);
  }

  public void set(LEDState ledstate){
    candle.setLEDs(ledstate.red, ledstate.green, ledstate.blue);
  }

  public void setAnimation(Animation animation){
    candle.animate(animation);
  }

  public void strobe(LEDState state, double speed){
    candle.animate(new StrobeAnimation(state.red, state.green, state.blue, state.white, speed, Constants.CANdleConstants.ledNum));
  }

  @Override
  public void periodic() {
    
  }
}
