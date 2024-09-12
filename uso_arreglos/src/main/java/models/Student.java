package models;

public class Student {
    private String name;
    private int age;
    private String[] courses;
    private int coursesCounter;

    private static Student[] students = new Student[100];
    private static int studentsCounter = 0;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
        this.courses = new String[10];
        this.coursesCounter = 0;
    }

    public static void registerStudent(String name, int age){
        if (studentsCounter < students.length){
            students[studentsCounter] = new Student(name, age);
            studentsCounter++;
            System.out.println("Estudiante registrado: " + name);
        } else {
            System.out.println("No se pueden registrar mas estudiantes");
        }
    }

    public static void listStudents(){
        if (studentsCounter == 0){
            System.out.println("No hay estudiantes registrados");
        } else {
            System.out.println("Lista de estudiantes: ");
            for (int i = 0; i < studentsCounter; i++){
                Student student = students[i];
                System.out.println("Nombre: " + student.name + ", Edad: " + student.age);
            }
        }
    }

    public static void addCourse(String studentName, String course){
        boolean found = false;
        for (int i = 0; i < studentsCounter; i++){
            if (students[i].name.equalsIgnoreCase(studentName)){
                Student student = students[i];
                if(student.coursesCounter < student.courses.length){
                    student.courses[student.coursesCounter] = course;
                    student.coursesCounter++;
                    System.out.println("Curso agregado: " + course + " a " + studentName);
                } else {
                    System.out.println("No se pueden agregar mas cursos para el estudiante");
                }
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println("Estudiante no encontrado");
        }
    }
    public static void showCourses(String studentName){
        boolean found = false;
        for (int i = 0; i < studentsCounter; i++){
            if (students[i].name.equalsIgnoreCase(studentName)){
                Student student = students[i];
                System.out.println("Cursos de " + studentName + ":");
                if (student.coursesCounter == 0){
                    System.out.println("El estudiante no tiene cursos inscritos.");
                } else {
                    for (int j = 0; j < student.coursesCounter; j++){
                        System.out.println(student.courses[j]);
                    }
                }
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println("Estudiante no encontrado");
        }
    }
}
