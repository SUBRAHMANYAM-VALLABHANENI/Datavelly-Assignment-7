import java.util.*;

class MedicalTestResult {
    private String patientName;
    private double resultValue;

    public MedicalTestResult(String patientName, double resultValue) {
        this.patientName = patientName;
        this.resultValue = resultValue;
    }

    public double getResultValue() {
        return resultValue;
    }
}

public class MedicalTestAnalyzer {
    public static void main(String[] args) {
        List<MedicalTestResult> testResults = new ArrayList<>();
        testResults.add(new MedicalTestResult("John", 85.0));
        testResults.add(new MedicalTestResult("Alice", 105.0));
        testResults.add(new MedicalTestResult("Bob", 70.0));
        testResults.add(new MedicalTestResult("Emily", 95.0));
        testResults.add(new MedicalTestResult("David", 115.0));

        Map<String, Integer> resultCounts = new HashMap<>();
        Map<String, Double> averageValues = new HashMap<>();

        for (MedicalTestResult result : testResults) {
            String resultCategory = getResultCategory(result.getResultValue());
            resultCounts.put(resultCategory, resultCounts.getOrDefault(resultCategory, 0) + 1);

            double currentAverage = averageValues.getOrDefault(resultCategory, 0.0);
            averageValues.put(resultCategory, (currentAverage + result.getResultValue()) / 2);
        }

        System.out.println("Medical Test Results Analysis:");
        for (String category : resultCounts.keySet()) {
            int count = resultCounts.get(category);
            double average = averageValues.get(category);
            System.out.printf("Category: %s, Patients: %d, Average Value: %.2f%n", category, count, average);
        }
    }

    private static String getResultCategory(double value) {
        if (value < 90)
            return "Low";
        else if (value < 110)
            return "Normal";
        else
            return "High";
    }
}