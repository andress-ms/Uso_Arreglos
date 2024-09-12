package models;

public class Grade {
    private String student;
    private String subject;
    private double grade;

    //Empty constructor
    public Grade() {
    }

    //Constructor with all parameters
    public Grade(String student, String subject, int grade) {
        this.student = student;
        this.subject = subject;
        this.grade = grade;
    }

    //Getters and Setters
    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
