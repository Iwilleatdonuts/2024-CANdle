package frc.robot.subsystems;

public class LEDState {
    public int red, green, blue, white;
    public boolean strobe;
    public double speed, time;

    public LEDState(int red, int green, int blue, int white){
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.white = white;
    }

    public LEDState(int red, int green, int blue, int white, boolean strobe, double speed, double time){
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.white = white;
        this.strobe = strobe;
        this.speed = speed;
        this.time = time;
    }

    public static final LEDState OFF = new LEDState(0, 0, 0, 0);
    public static final LEDState DISABLED = new LEDState(255, 0, 0, 255);
    public static final LEDState ENABLED = new LEDState(0, 255, 0, 255);
    public static final LEDState HASNOTE = new LEDState(255, 40, 0, 255, true, .2, 2);
}
