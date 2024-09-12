package models;

public class Product {
    private Sting name;
    private double price;
    private int quantity;

    private static Product[] inventory = new Product[100];
    private static int productCounter = 0;

    public Product() {
    }

    public Product(Sting name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public static void addProduct(String name, double price, int quantity) {
        if (productCounter < inventory.length) {
            inventory[productCounter] = new Product(name, price, quantity);
            productCounter++;
            System.out.println("Producto agregado: " + name);
        } else {
            System.out.println("El inventario esta lleno");
        }
    }

    public static void showInventory() {
        if (productCounter == 0) {
            System.out.println("El inventario esta vacio");
        } else {
            System.out.println("Inventario completo:");
            for (int i = 0; i < productCounter; i++) {
                Product product = inventory[i];
                System.out.println("Nombre: " + product.name + ", Precio: $" + product.price
                        + ", Cantidad: " + product.quantity);
            }
        }
    }

    public static void updateQuantity(String name, int newQuantity) {
        boolean found = false;
        for (int i = 0; i < productCounter; i++) {
            if(inventory[i].name.equalsIgnoreCase(name)){
                inventory[i].quantity = newQuantity;
                found = true;
                System.out.println("Cantidad actualizada para el prodcto: " + name);
                break;
            }
        }
        if (!found) {
            System.out.println("Producto no encontrado");
        }
    }
}
