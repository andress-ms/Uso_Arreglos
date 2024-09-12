package models;

public class Attendance {
    private String date;
    private String student;
    private boolean isPresent;

    public Attendance(String date, String student, boolean isPresent) {
        this.date = date;
        this.student = student;
        this.isPresent = isPresent;
    }

    public String getDate() {
        return date;
    }
    public String getStudent() {
        return student;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        this.isPresent = present;
    }
}
