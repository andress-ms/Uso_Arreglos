package models;

public class Book {
    private String title;
    private String author;
    private boolean available;

    // Arreglo estático para almacenar los libros
    private static Book[] inventory = new Book[100];
    private static int bookCounter = 0;

    //Empty constructor
    public Book() {
    }

    //Constructor with all parameters
    public Book(String title, String author, boolean available) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    //Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Book{");
        sb.append("title='").append(title).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", available=").append(available);
        sb.append('}');
        return sb.toString();
    }

    // Método estático para añadir un libro al inventario
    public static void addBook(String title, String author) {
        if (bookCounter < inventory.length) {
            inventory[bookCounter] = new Book(title, author, true); // Los libros se añaden como disponibles por defecto
            bookCounter++;
            System.out.println("Libro agregado: " + title);
        } else {
            System.out.println("El inventario de libros está lleno.");
        }
    }

    // Método estático para mostrar todos los libros en el inventario
    public static void showInventory() {
        if (bookCounter == 0) {
            System.out.println("El inventario de libros está vacío.");
        } else {
            System.out.println("Inventario de libros:");
            for (int i = 0; i < bookCounter; i++) {
                Book book = inventory[i];
                System.out.println("Título: " + book.title + ", Autor: " + book.author
                        + ", Disponible: " + (book.available ? "Sí" : "No"));
            }
        }
    }

    // Método estático para actualizar la disponibilidad de un libro
    public static void updateAvailability(String title, boolean newAvailability) {
        boolean found = false;
        for (int i = 0; i < bookCounter; i++) {
            if (inventory[i].title.equalsIgnoreCase(title)) {
                inventory[i].available = newAvailability;
                found = true;
                System.out.println("Disponibilidad actualizada para el libro: " + title);
                break;
            }
        }
        if (!found) {
            System.out.println("Libro no encontrado.");
        }
    }
}
