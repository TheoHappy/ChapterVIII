package ModifyingTheInternalDataRepresentationOfAClass;// Fig. 8.5: Time2.java
// Time2 class declaration with overloaded constructors.  

public class Time2 {

    private int secondsSinceMidnight;

    // Time2 no-argument constructor:
    // initializes each instance variable to zero
    public Time2() {
        this.secondsSinceMidnight = 0;
    }

    // Time2 constructor: hour supplied, minute and second defaulted to 0
    public Time2(int hour) {
        this.secondsSinceMidnight = hour * 3600;
    }

    // Time2 constructor: hour and minute supplied, second defaulted to 0
    public Time2(int hour, int minute) {
        this.secondsSinceMidnight = hour * 3600 + minute * 60;
    }

    // Time2 constructor: hour, minute and second supplied
    public Time2(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24)
            throw new IllegalArgumentException("hour must be 0-23");

        if (minute < 0 || minute >= 60)
            throw new IllegalArgumentException("minute must be 0-59");

        if (second < 0 || second >= 60)
            throw new IllegalArgumentException("second must be 0-59");

        this.secondsSinceMidnight = hour * 3600 + minute * 60 + second;



    }

    // Time2 constructor: another Time2 object supplied
    public Time2(Time2 time) {
        // invoke constructor with three arguments
        this(time.getHour(), time.getMinute(), time.getSecond());
    }

    public void setTime(int hour, int minute, int second) {

        this.secondsSinceMidnight = hour * 3600 + minute * 60 + second;

        if (secondsSinceMidnight > 86400)
            throw new IllegalArgumentException("Error");
    }

    // validate and set hour
    public void setHour(int hour) {
        if (hour < 0 || hour >= 24)
            throw new IllegalArgumentException("hour must be 0-23");
        this.secondsSinceMidnight = secondsSinceMidnight / 3600;
    }

    // validate and set minute
    public void setMinute(int minute) {

        if (minute < 0 || minute >= 60)
            throw new IllegalArgumentException("minute must be 0-59");

        this.secondsSinceMidnight = minute * 3600;

    }

    // validate and set second
    public void setSecond(int second) {
        if (second < 0 || second >= 60)
            throw new IllegalArgumentException("second must be 0-59");

        this.secondsSinceMidnight = second * 3600;

    }

    public int getHour() {
        return secondsSinceMidnight / 3600;
    }

    // get minute value
    public int getMinute() {
        return secondsSinceMidnight % 3600 / 60;
    }

    // get second value
    public int getSecond() {
        return secondsSinceMidnight % 3600 % 60;
    }

    // convert to String in universal-time format (HH:MM:SS)
    public String toUniversalString() {
        return String.format(
                "%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    }

//    public long sinceMidnight() {
//        return (hour * 3600 + minute * 60 + second);
//    }

//    public long toMidnight() {
//        return ((60 - second) + ((60 - 1 - minute) * 60) + (24 - 1 - hour) * 3600);
//    }

    // convert to String in standard-time format (H:MM:SS AM or PM)
    public String toString() {
        return String.format("%d:%02d:%02d %s",
                ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
                getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
    }
} // end class Time2


