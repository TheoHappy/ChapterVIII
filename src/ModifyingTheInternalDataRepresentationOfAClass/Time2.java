package ModifyingTheInternalDataRepresentationOfAClass;// Fig. 8.5: Time2.java

public class Time2 {

    private int secondsSinceMidnight;

    public Time2() {
        this.secondsSinceMidnight = 0;
    }

    public Time2(int hour) {
        this.secondsSinceMidnight = hour * 3600;
    }

    public Time2(int hour, int minute) {
        this.secondsSinceMidnight = hour * 3600 + minute * 60;
    }

    public Time2(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24)
            throw new IllegalArgumentException("hour must be 0-23");

        if (minute < 0 || minute >= 60)
            throw new IllegalArgumentException("minute must be 0-59");

        if (second < 0 || second >= 60)
            throw new IllegalArgumentException("second must be 0-59");

        this.secondsSinceMidnight = hour * 3600 + minute * 60 + second;

    }

    public Time2(Time2 time) {
        this(time.getHour(), time.getMinute(), time.getSecond());
    }

    public void setTime(int hour, int minute, int second) {

        this.secondsSinceMidnight = hour * 3600 + minute * 60 + second;

        if (secondsSinceMidnight > 86400)
            throw new IllegalArgumentException("Error");
    }

    public void setHour(int hour) {
        if (hour < 0 || hour >= 24)
            throw new IllegalArgumentException("hour must be 0-23");

        this.secondsSinceMidnight = secondsSinceMidnight - getHour() * 3600 + hour* 3600;
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute >= 60)
            throw new IllegalArgumentException("minute must be 0-59");

        this.secondsSinceMidnight = secondsSinceMidnight - getMinute() * 60 + minute * 60;

    }

    public void setSecond(int second) {
        if (second < 0 || second >= 60)
            throw new IllegalArgumentException("second must be 0-59");

        this.secondsSinceMidnight = secondsSinceMidnight - getSecond() + second;

    }

    public int getHour() {
        return secondsSinceMidnight / 3600;
    }

    public int getMinute() {
        return secondsSinceMidnight % 3600 / 60;
    }

    public int getSecond() {
        return secondsSinceMidnight % 3600 % 60;
    }

    public String toUniversalString() {
        return String.format(
                "%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    }

    public String toString() {
        return String.format("%d:%02d:%02d %s",
                ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
                getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
    }
}


