import java.util.*;

class House {
    private double price;
    private double squareFootage;

    public House(double price, double squareFootage) {
        this.price = price;
        this.squareFootage = squareFootage;
    }

    public double getPrice() {
        return price;
    }

    public double getSquareFootage() {
        return squareFootage;
    }
}

public class HousingAnalyzer {
    public static void main(String[] args) {
        List<House> houses = new ArrayList<>();
        houses.add(new House(150000, 1200));
        houses.add(new House(220000, 1500));
        houses.add(new House(180000, 1350));
        houses.add(new House(280000, 2000));
        houses.add(new House(120000, 1000));

        Map<String, Integer> houseCounts = new HashMap<>();
        Map<String, Double> avgSquareFootage = new HashMap<>();

        for (House house : houses) {
            double price = house.getPrice();
            String priceRange = getPriceRange(price);
            houseCounts.put(priceRange, houseCounts.getOrDefault(priceRange, 0) + 1);

            double currentTotalSquareFootage = avgSquareFootage.getOrDefault(priceRange, 0.0);
            avgSquareFootage.put(priceRange, currentTotalSquareFootage + house.getSquareFootage());
        }

        System.out.println("Housing Analysis:");
        for (String range : houseCounts.keySet()) {
            int count = houseCounts.get(range);
            double totalSquareFootage = avgSquareFootage.get(range);
            double averageSquareFootage = totalSquareFootage / count;
            System.out.printf("Price Range: %s, Houses Sold: %d, Average Square Footage: %.2f%n",
                    range, count, averageSquareFootage);
        }
    }

    private static String getPriceRange(double price) {
        if (price < 100000)
            return "< $100,000";
        else if (price < 200000)
            return "$100,000 - $200,000";
        else if (price < 300000)
            return "$200,000 - $300,000";
        else if (price < 400000)
            return "$300,000 - $400,000";
        else
            return ">= $400,000";
    }
}