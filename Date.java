public class Date {
    private int year;
    private int month;
    private int day;
    private int hours;
    private int minutes;
    private int seconds;

    public Date(int year, int month, int day, int hours, int minutes, int seconds) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }    
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    // ==========Getters
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHours() {
        return hours;
    }

    public int getminutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    // ==========Setters
    public void setYear(int year) {
        this.year = year;
    }

    public void setminutes(int minutes) {
        this.minutes = minutes;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    // =====date methods
    public boolean equals(Date reserveDate) {
        return reserveDate.getYear() == year &&
                reserveDate.getMonth() == month &&
                reserveDate.getDay() == day &&
                reserveDate.getHours() == hours &&
                reserveDate.getminutes() == minutes &&
                reserveDate.getSeconds() == seconds;
    }

    public boolean after(Date reserveDate) {
        if (year > reserveDate.getYear()) {
            return true;
        } else if (year == reserveDate.getYear()) {
            if (month > reserveDate.getMonth()) {
                return true;
            } else if (month == reserveDate.getMonth()) {
                if (day > reserveDate.getDay()) {
                    return true;
                } else if (day == reserveDate.getDay()) {
                    if (hours > reserveDate.getHours()) {
                        return true;
                    } else if (hours == reserveDate.getHours()) {
                        if (minutes > reserveDate.getminutes()) {
                            return true;
                        } else if (minutes == reserveDate.getminutes()) {
                            if (seconds > reserveDate.getSeconds()) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean before(Date reserveDate) {
        return !this.after(reserveDate) && !this.equals(reserveDate);
    }

    public String toString() {
        return year + "/" + month + "/" + day + " " + hours + ":" + minutes + ":" + seconds;
    }
}