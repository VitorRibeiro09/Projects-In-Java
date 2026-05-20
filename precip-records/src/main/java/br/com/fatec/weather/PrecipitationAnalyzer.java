package br.com.fatec.weather;

import java.util.*;
import java.util.stream.Collectors;

public class PrecipitationAnalyzer {

    public Map<Integer, Double> getTotalPrecipitationByMonth(List<PrecipitationRecord> records) {
        Map<Integer, Double> totals = new TreeMap<>();
        for (PrecipitationRecord record : records) {
            int month = record.getDate().getMonthValue();
            totals.put(month, totals.getOrDefault(month, 0.0) + record.getAmount());
        }
        return totals;
    }

    public double getTotalForSpecificMonth(List<PrecipitationRecord> records, int month) {
        return getTotalPrecipitationByMonth(records).getOrDefault(month, 0.0);
    }

    public PrecipitationRecord getHighestPrecipitationDay(List<PrecipitationRecord> records) {
        return Collections.max(records, Comparator.comparingDouble(PrecipitationRecord::getAmount));
    }

    public PrecipitationRecord getLowestPrecipitationDay(List<PrecipitationRecord> records) {
        return Collections.min(records, Comparator.comparingDouble(PrecipitationRecord::getAmount));
    }

    public int getMonthWithHighestPrecipitation(Map<Integer, Double> monthlyTotals) {
        return Collections.max(monthlyTotals.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public int getMonthWithLowestPrecipitation(Map<Integer, Double> monthlyTotals) {
        return Collections.min(monthlyTotals.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public double getYearlyAverage(List<PrecipitationRecord> records) {
        if (records.isEmpty()) return 0.0;
        double sum = records.stream().mapToDouble(PrecipitationRecord::getAmount).sum();
        return sum / records.size();
    }

    public Map<Integer, Double> getMonthlyAverages(List<PrecipitationRecord> records) {
        Map<Integer, List<Double>> groupedByMonth = new HashMap<>();
        
        for(PrecipitationRecord rec : records) {
            groupedByMonth.computeIfAbsent(rec.getDate().getMonthValue(), k -> new ArrayList<>())
                          .add(rec.getAmount());
        }
        
        Map<Integer, Double> averages = new TreeMap<>();
        for (Map.Entry<Integer, List<Double>> entry : groupedByMonth.entrySet()) {
            double avg = entry.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            averages.put(entry.getKey(), avg);
        }
        return averages;
    }

    public List<PrecipitationRecord> getTop10HighestDays(List<PrecipitationRecord> records) {
        List<PrecipitationRecord> sorted = new ArrayList<>(records);
        sorted.sort(Comparator.comparingDouble(PrecipitationRecord::getAmount).reversed());
        return sorted.size() > 10 ? sorted.subList(0, 10) : sorted;
    }
}
