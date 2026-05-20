package br.com.fatec.weather;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CsvReader reader = new CsvReader();
        PrecipitationAnalyzer analyzer = new PrecipitationAnalyzer();

        // Passando parametros na chamada do metodo
        String arquivo = "dados_chuvas.csv"; 
        String cidadeAlvo = "Acarau"; 
        int anoAlvo = 2025;

        System.out.println("Lendo dados de " + cidadeAlvo + " para o ano " + anoAlvo + "...\n");
        List<PrecipitationRecord> records = reader.readData(arquivo, cidadeAlvo, anoAlvo);

        if (records.isEmpty()) {
            System.out.println("Nenhum dado encontrado para os parametros informados. Verifique o arquivo CSV.");
            return;
        }

        Map<Integer, Double> totaisPorMes = analyzer.getTotalPrecipitationByMonth(records);
        System.out.println("--- Total de Precipitacao por Mes ---");
        totaisPorMes.forEach((mes, total) -> System.out.printf("Mes %02d: %.2f mm\n", mes, total));
        
        System.out.println("\n--- Extremos Diarios ---");
        System.out.println("Maior precipitacao: " + analyzer.getHighestPrecipitationDay(records));
        System.out.println("Menor precipitacao: " + analyzer.getLowestPrecipitationDay(records) + "\n");

        System.out.println("--- Extremos Mensais ---");
        System.out.println("Mes de Maior Precipitacao: " + analyzer.getMonthWithHighestPrecipitation(totaisPorMes));
        System.out.println("Mes de Menor Precipitacao: " + analyzer.getMonthWithLowestPrecipitation(totaisPorMes) + "\n");

        System.out.printf("Media de precipitacao diaria do ano: %.2f mm\n\n", analyzer.getYearlyAverage(records));

        System.out.println("--- Media de Precipitacao por Mes ---");
        Map<Integer, Double> mediasPorMes = analyzer.getMonthlyAverages(records);
        mediasPorMes.forEach((mes, media) -> System.out.printf("Mes %02d: %.2f mm\n", mes, media));
        System.out.println();

        System.out.println("--- Top 10 Dias de Maior Chuva ---");
        List<PrecipitationRecord> top10 = analyzer.getTop10HighestDays(records);
        top10.forEach(System.out::println);
    }
}
