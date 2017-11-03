package clock;

//
// First, write test cases. Then write code here.
//
public class Clock {
    // There are several bugs below.
    // How many do you reveal when you run your test cases
    // on my Clock implementation?
    private int hour;
    private int minutes;
    private int seconds;

    public Clock(int hour, int minutes, int seconds) {
        if (hour > 24 || minutes > 60 || seconds > 60) {
            throw new IllegalArgumentException();
        }
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHour() {
        return hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return minutes;
    }

    // Return the clock in th 24-hour HH:MM:SS format.
    // E.g. 15:45:09
    public String toString() {
        return hour + ":" + minutes + ":" + seconds;
    }

    // Return the clock in the 12-hour HH:MM:SS AM/PM format.
    // E.g. 03:45:09 PM
    public String toUSString() {
        String ampm = (hour < 12) ? "AM" : "PM";
        return (hour % 12) + ":" + minutes + ":" + seconds + " " + ampm;
    }

    // Advance the clock by 1 second.
    public void tick() {
        seconds++;
        if (seconds >= 60) {
            minutes++;
        }
        if (minutes >= 60) {
            hour++;
        }
    }
}
