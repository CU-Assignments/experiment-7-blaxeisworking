import java.util.*;
import java.util.stream.*;
import java.util.function.Function;

class Product {
    String name;
    String category;
    double price;

    Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " | Category: " + category + " | Price: $" + price;
    }
}

public class Exp6_HardProblem {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 800),
            new Product("Phone", "Electronics", 500),
            new Product("Shirt", "Clothing", 40),
            new Product("Jeans", "Clothing", 60),
            new Product("Fridge", "Appliances", 700)
        );

        Map<String, List<Product>> groupedByCategory = products.stream()
                .collect(Collectors.groupingBy(p -> p.category));
        System.out.println("Products Grouped by Category:");
        groupedByCategory.forEach((category, items) -> {
            System.out.println(category + ": " + items);
        });

        System.out.println("\nMost Expensive Product in Each Category:");
        products.stream()
                .collect(Collectors.groupingBy(
                    p -> p.category,
                    Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingDouble(p -> p.price)),
                        Optional::get
                    )
                ))
                .forEach((category, product) -> System.out.println(category + ": " + product));

        double avgPrice = products.stream()
                .mapToDouble(p -> p.price)
                .average()
                .orElse(0.0);
        System.out.println("\nAverage Price of All Products: $" + avgPrice);
    }
}
