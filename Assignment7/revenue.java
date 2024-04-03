import java.util.*;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

public class revenue {
    public static void main(String[] args) {
        List<Product> sales = new ArrayList<>();
        sales.add(new Product("Product 1", 45.99));
        sales.add(new Product("Product 2", 78.50));
        sales.add(new Product("Product 3", 110.25));
        sales.add(new Product("Product 4", 25.75));
        sales.add(new Product("Product 5", 150.00));

        Map<String, Integer> productCounts = new HashMap<>();
        Map<String, Double> revenuePerRange = new HashMap<>();

        for (Product product : sales) {
            double price = product.getPrice();
            String range = getPriceRange(price);
            productCounts.put(range, productCounts.getOrDefault(range, 0) + 1);
            revenuePerRange.put(range, revenuePerRange.getOrDefault(range, 0.0) + price);
        }

        System.out.println("Product Sales Analysis:");
        for (String range : productCounts.keySet()) {
            int count = productCounts.get(range);
            double revenue = revenuePerRange.get(range);
            System.out.printf("Price Range: %s, Number of Products Sold: %d, Total Revenue: $%.2f%n",
                    range, count, revenue);
        }
    }

    private static String getPriceRange(double price) {
        if (price < 50)
            return "$0-$50";
        else if (price < 100)
            return "$50-$100";
        else if (price < 200)
            return "$100-$200";
        else
            return "Over $200";
    }
}