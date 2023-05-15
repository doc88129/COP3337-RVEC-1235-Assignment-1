import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class ABCInventory {
    static ArrayList<Product> activeProducts = new ArrayList<Product>();
    static ArrayList<Transaction> inactiveProducts = new ArrayList<Transaction>();
    static ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userInput = "1";
        System.out.println("Welcome to ABC Inventory System");

        while (userInput.compareTo("0") != 0) {
            System.out.println("Please select an option:");
            System.out.println("1. Add a product");
            System.out.println("2. Remove a product");
            System.out.println("3. Update a product");
            System.out.println("4. View all active products");
            System.out.println("5. View all inactive products");
            System.out.println("6. View a product");
            System.out.println("7. Sell a product");
            System.out.println("8. Restock a product");
            System.out.println("9. View transactions");
            System.out.println("0. Exit");
            System.out.println();

            userInput = input.nextLine();
            System.out.println();
            if (userInput.compareTo("1") == 0) {
                addProduct(input);
            } else if (userInput.compareTo("2") == 0) {
                removeProduct(input);
            } else if (userInput.compareTo("3") == 0) {
                updateProduct(input);
            } else if (userInput.compareTo("4") == 0) {
                viewAllProducts();
            } else if (userInput.compareTo("5") == 0) {
                viewInactiveProducts();
            } else if (userInput.compareTo("6") == 0) {
                viewProduct(input);
            } else if (userInput.compareTo("7") == 0) {
                sellProduct(input);
            } else if (userInput.compareTo("8") == 0) {
                restockProduct(input);
            } else if (userInput.compareTo("9") == 0) {
                viewTransactions();
            } else if (userInput.compareTo("0") == 0) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid input");
            }
            System.out.println();

        }
        
    }

    private static void addProduct(Scanner input) {
        System.out.println("Please enter the product name:");
        String productName = input.nextLine();

        for (Product product : activeProducts) {
            if (product.getProductName().compareTo(productName) == 0) {
                System.out.println("Product already exists");
                return;
            }
        }

        System.out.println("Please enter the product quantity:");
        Integer quantity = input.nextInt();
        System.out.println("Please enter the product unit price:");
        Double unitPrice = input.nextDouble();
        input.nextLine();
        System.out.println("Please enter the manufacturer name:");
        String manufacturerName = input.nextLine();
        System.out.println("Please enter the manufacturer address:");
        String manufacturerAddress = input.nextLine();

        Manufacturer manufacturer = new Manufacturer(manufacturerName, manufacturerAddress);
        Product product = new Product(manufacturer, productName, quantity, unitPrice);
        activeProducts.add(product);
    }

    private static void removeProduct(Scanner input) {
        System.out.println("Please enter the product name:");
        String productName = input.nextLine();
        Product productToRemove = null;
        for (Product product : activeProducts) {
            if (product.getProductName().compareTo(productName) == 0) {
                productToRemove = product;
            }
        }

        if (productToRemove != null) {
            System.out.println("Requested product found.");
            activeProducts.remove(productToRemove);
            inactiveProducts.add(new Transaction(productToRemove, new Date()));
        } else {
            System.out.println("No product found with that name.");
        }
    }

    private static void updateProduct(Scanner input) {
        System.out.println("Please enter the product name:");
        String productName = input.nextLine();
        
        for (Product product : activeProducts) {
            if (product.getProductName().compareTo(productName) == 0) {
                System.out.println("Requested product found.");
                System.out.println("Please enter the product quantity:");
                Integer quantity = input.nextInt();
                System.out.println("Please enter the product unit price:");
                Double unitPrice = input.nextDouble();
                input.nextLine();
                System.out.println("Please enter the manufacturer name:");
                String manufacturerName = input.nextLine();
                System.out.println("Please enter the manufacturer address:");
                String manufacturerAddress = input.nextLine();

                product.setQuantity(quantity);
                product.setUnitPrice(unitPrice);
                product.setManufacturerName(manufacturerName);
                product.setManufacturerAddress(manufacturerAddress);
                return;
            }
        }
        System.out.println("No product found with that name.");
    }

    private static void viewAllProducts() {
        System.out.println("Product Price Quantity Manufacturer");

        for (Product product : activeProducts) {
            System.out.println(product.getProductName() + " " + product.getUnitPrice() + " " + product.getQuantity() + " " + product.getManufacturerName());
        }
    }

    private static void viewInactiveProducts() {
        System.out.println("Product Date Manufacturer");

        for (Transaction transaction : inactiveProducts) {
            System.out.println(transaction.getProduct().getProductName() + " " + transaction.getTransactionDate() + " " + transaction.getProduct().getManufacturerName());
        }
    }

    private static void viewProduct(Scanner input) {
        System.out.println("Please enter the product name:");
        String productName = input.nextLine();

        for (Product product : activeProducts) {
            if (product.getProductName().compareTo(productName) == 0) {
                System.out.println("Product Price Quantity");
                System.out.println(product.getProductName() + " " + product.getUnitPrice() + " " + product.getQuantity());
                return;
            }
        }
        System.out.println("No product found with that name.");
    }

    private static void sellProduct(Scanner input) {
        System.out.println("Please enter the product name:");
        String productName = input.nextLine();

        for (Product product : activeProducts) {
            if (product.getProductName().compareTo(productName) == 0) {
                System.out.println("Requested product found.");
                System.out.println("Please enter the quantity:");
                Integer quantity = input.nextInt();
                input.nextLine();

                if (quantity > product.getQuantity()) {
                    System.out.println("Not enough product in stock.");
                    return;
                }

                product.setQuantity(product.getQuantity() - quantity);
                Transaction transaction = new Transaction(product.Clone(), new Date());
                transactions.add(transaction);
                return;
            }
        }
        System.out.println("No product found with that name.");
    }

    private static void restockProduct(Scanner input) {
        System.out.println("Please enter the product name:");
        String productName = input.nextLine();

        for (Product product : activeProducts) {
            if (product.getProductName().compareTo(productName) == 0) {
                System.out.println("Requested product found.");
                System.out.println("Please enter the quantity:");
                Integer quantity = input.nextInt();
                input.nextLine();

                product.setQuantity(product.getQuantity() + quantity);
                System.out.println("Product restocked.");
                return;
            }
        }
        System.out.println("No product found with that name.");
    }

    private static void viewTransactions() {
        System.out.println("Product Purchase Date Quantity Price Manufacturer State");

        for (Transaction transaction : transactions) {
            System.out.println(transaction.getProduct().getProductName() + " " + transaction.getTransactionDate() + " " + transaction.getProduct().getQuantity() + " " + transaction.getProduct().getUnitPrice() + " " + transaction.getProduct().getManufacturerName() + " " + transaction.getProduct().getManufacturerAddress());
        }
    }
}