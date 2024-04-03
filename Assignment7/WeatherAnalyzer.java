import java.util.*;

class WeatherData {
    private double temperature;
    private double humidity;

    public WeatherData(double temperature, double humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }
}

public class WeatherAnalyzer {
    public static void main(String[] args) {
        List<WeatherData> weatherDataList = new ArrayList<>();
        weatherDataList.add(new WeatherData(5.5, 65.0));
        weatherDataList.add(new WeatherData(12.0, 70.0));
        weatherDataList.add(new WeatherData(22.0, 55.0));
        weatherDataList.add(new WeatherData(-3.0, 80.0));
        weatherDataList.add(new WeatherData(8.0, 75.0));
        weatherDataList.add(new WeatherData(18.0, 60.0));

        Map<String, Integer> temperatureCounts = new HashMap<>();
        Map<String, Double> humidityPerRange = new HashMap<>();

        for (WeatherData data : weatherDataList) {
            double temperature = data.getTemperature();
            String temperatureRange = getTemperatureRange(temperature);
            temperatureCounts.put(temperatureRange, temperatureCounts.getOrDefault(temperatureRange, 0) + 1);

            double humidity = data.getHumidity();
            double currentAvgHumidity = humidityPerRange.getOrDefault(temperatureRange, 0.0);
            double newAvgHumidity = (currentAvgHumidity * temperatureCounts.get(temperatureRange) + humidity) /
                                    (temperatureCounts.get(temperatureRange) + 1);
            humidityPerRange.put(temperatureRange, newAvgHumidity);
        }

        System.out.println("Weather Data Analysis:");
        for (String range : temperatureCounts.keySet()) {
            int count = temperatureCounts.get(range);
            double avgHumidity = humidityPerRange.get(range);
            System.out.printf("Temperature Range: %s, Days: %d, Average Humidity: %.2f%%\n",
                    range, count, avgHumidity);
        }
    }

    private static String getTemperatureRange(double temperature) {
        if (temperature < 0)
            return "<0°C";
        else if (temperature < 10)
            return "0-10°C";
        else if (temperature < 20)
            return "10-20°C";
        else if (temperature < 30)
            return "20-30°C";
        else
            return ">30°C";
    }
}
