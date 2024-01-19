package frc.robot.subsystems;

public class LEDState {
    public int red;
    public int green;
    public int blue;
    public int white;

    public LEDState(int red, int green, int blue, int white){
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.white = white;
    }

    public static final LEDState OFF = new LEDState(0, 0, 0, 0);
    public static final LEDState RED = new LEDState(255, 0, 0, 255);
    public static final LEDState GREEN = new LEDState(0, 255, 0, 255);
    public static final LEDState BLUE = new LEDState(0, 0, 255, 255);
    public static final LEDState YELLOW = new LEDState(255, 255, 0, 255);
    public static final LEDState ORANGE = new LEDState(255, 40, 0, 255);
}
