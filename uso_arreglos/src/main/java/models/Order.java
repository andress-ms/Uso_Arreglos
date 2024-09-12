package models;

public class Order {
    private int orderId;
    private String[] products;
    private boolean isProcessed;
    private int productCount;

    public Order(int orderId, int maxProducts){
        this.orderId = orderId;
        this.products = new String[maxProducts];
        this.isProcessed = false;
        this.productCount = 0;
    }
    public void addProduct(String product){
        if(productCount < products.length){
            products[productCount] = product;
            productCount++;
            System.out.println("Se agrego el producto: " + product);
        } else {
            System.out.println("No se pueden agregar mas productos");
        }
    }

    public void changeOrderState(boolean newState){
        this.isProcessed = newState;
        String state = isProcessed ? "Procesado" : "No procesado";
        System.out.println("Se cambio el estado de la orden a: " + state);
    }

    public void displayOrder(){
        System.out.println("ID de la orden: " + orderId);
        System.out.println("Productos: ");
        for(int i = 0; i < productCount; i++){
            System.out.println(products[i] + (i < productCount - 1 ? ", " : ""));
        }
        System.out.println();
        System.out.println("Estado de la oden: " + (isProcessed ? "Procesado" : "No procesado"));
        System.out.println("-------------------");
    }
}
