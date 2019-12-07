package TrafficLightEnum;

public enum TrafficLight {
    RED(60),
    GREEN(30),
    YELLOW(15);

    private final int duration;

    TrafficLight(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }


}
