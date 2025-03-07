import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

interface Product {
    double calculatePrice();
    String getDetails();
}

abstract class BaseProduct implements Product {
    protected String name;
    protected double price;
    protected int stock;

    public BaseProduct(String name, double price, int stock) {
        try {
            if (price < 0 || stock < 0) {
                throw new IllegalArgumentException("Price and stock must be non-negative.");
            }
            this.name = name;
            this.price = price;
            this.stock = stock;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Product processing complete.");
        }
    }

    @Override
    public String getDetails() {
        return "Name: " + name + ", Price: $" + price + ", Stock: " + stock;
    }

    public boolean isAvailable() {
        return stock > 0;
    }
}

class Electronics extends BaseProduct {
    private int warranty;

    public Electronics(String name, double price, int stock, int warranty) {
        super(name, price, stock);
        this.warranty = warranty;
    }

    @Override
    public double calculatePrice() {
        return (price > 1000) ? price * 0.9 : price;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Warranty: " + warranty + " months";
    }
}

class Clothing extends BaseProduct {
    private String size;
    private String material;

    public Clothing(String name, double price, int stock, String size, String material) {
        super(name, price, stock);
        this.size = size;
        this.material = material;
    }

    @Override
    public double calculatePrice() {
        return (stock < 5) ? price * 0.95 : price;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Size: " + size + ", Material: " + material;
    }
}

class Groceries extends BaseProduct {
    private Date expirationDate;

    public Groceries(String name, double price, int stock, Date expirationDate) {
        super(name, price, stock);
        Date currentDate = new Date();
        if (expirationDate.before(currentDate)) {
            throw new IllegalArgumentException("Cannot add expired groceries.");
        }
        this.expirationDate = expirationDate;
    }

    @Override
    public double calculatePrice() {
        return (stock > 5) ? price * 0.92 : price;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Expiration Date: " + expirationDate;
    }
}

class Books extends BaseProduct {
    private String author;

    public Books(String name, double price, int stock, String author) {
        super(name, price, stock);
        this.author = author;
    }

    @Override
    public double calculatePrice() {
        return (price > 50) ? price * 0.93 : price;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Author: " + author;
    }
}

public class ProductManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select Product Type: 1. Electronics 2. Clothing 3. Groceries 4. Books");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Stock: ");
        int stock = scanner.nextInt();

        Product product = null;

        try {
            switch (choice) {
                case 1:
                    System.out.print("Enter Warranty (months): ");
                    int warranty = scanner.nextInt();
                    product = new Electronics(name, price, stock, warranty);
                    break;
                case 2:
                    System.out.print("Enter Size (S, M, L, XL): ");
                    String size = scanner.next();
                    System.out.print("Enter Material: ");
                    String material = scanner.next();
                    product = new Clothing(name, price, stock, size, material);
                    break;
                case 3:
                    System.out.print("Enter Expiration Date (yyyy-mm-dd): ");
                    String dateStr = scanner.next();
                    Date expirationDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
                    product = new Groceries(name, price, stock, expirationDate);
                    break;
                case 4:
                    System.out.print("Enter Author Name: ");
                    scanner.nextLine();
                    String author = scanner.nextLine();
                    product = new Books(name, price, stock, author);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            if (product != null) {
                System.out.println("Product Details:");
                System.out.println(product.getDetails());
                System.out.println("Final Price: $" + product.calculatePrice());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Product processing complete.");
        }
        scanner.close();
    }
}