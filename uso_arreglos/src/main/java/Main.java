import models.Book;
import models.Grade;

public class Main {
    public static void main(String[] args) {
        // Arreglos para manejar libros y notas
        Book[] books = new Book[3];
        Grade[] grades = new Grade[4];

        // Añadiendo libros de ejemplo al arreglo
        books[0] = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        books[1] = new Book("1984", "George Orwell");
        books[2] = new Book("To Kill a Mockingbird", "Harper Lee");

        // Añadiendo notas de ejemplo al arreglo
        grades[0] = new Grade("Alice", "Math", 95);
        grades[1] = new Grade("Alice", "Science", 85);
        grades[2] = new Grade("Bob", "Math", 78);
        grades[3] = new Grade("Bob", "Science", 82);

        // Escáner para interacción de usuario
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Menu principal
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Show All Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Show Grades of a Student");
            System.out.println("5. Calculate Average of a Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (choice) {
                case 1:
                    showBooks(books);
                    break;
                case 2:
                    System.out.print("Enter the title of the book to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    borrowBook(books, borrowTitle);
                    break;
                case 3:
                    System.out.print("Enter the title of the book to return: ");
                    String returnTitle = scanner.nextLine();
                    returnBook(books, returnTitle);
                    break;
                case 4:
                    System.out.print("Enter the student's name to list grades: ");
                    String studentName = scanner.nextLine();
                    listGrades(grades, studentName);
                    break;
                case 5:
                    System.out.print("Enter the student's name to calculate average: ");
                    String studentAverageName = scanner.nextLine();
                    double average = calculateAverage(grades, studentAverageName);
                    System.out.println("Average for " + studentAverageName + ": " + average);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
        scanner.close();
    }

    // Método para mostrar todos los libros
    public static void showBooks(Book[] books) {
        System.out.println("\n--- List of Books ---");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Método para prestar un libro
    public static void borrowBook(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title) && book.available) {
                book.available = false;
                System.out.println("Book borrowed: " + title);
                return;
            }
        }
        System.out.println("Book not available: " + title);
    }

    // Método para devolver un libro
    public static void returnBook(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title) && !book.available) {
                book.available = true;
                System.out.println("Book returned: " + title);
                return;
            }
        }
        System.out.println("Book was not borrowed: " + title);
    }

    // Método para listar todas las notas de un estudiante
    public static void listGrades(Grade[] grades, String student) {
        System.out.println("\n--- Grades for " + student + " ---");
        boolean found = false;
        for (Grade grade : grades) {
            if (grade.student.equalsIgnoreCase(student)) {
                System.out.println(grade);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No grades found for student: " + student);
        }
    }

    // Método para calcular el promedio de un estudiante
    public static double calculateAverage(Grade[] grades, String student) {
        double total = 0;
        int count = 0;
        for (Grade grade : grades) {
            if (grade.student.equalsIgnoreCase(student)) {
                total += grade.score;
                count++;
            }
        }
        return count > 0 ? total / count : 0;
    }
    }