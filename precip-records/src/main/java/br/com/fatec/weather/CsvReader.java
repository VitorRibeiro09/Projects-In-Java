package br.com.fatec.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public List<PrecipitationRecord> readData(String folderPath, String targetCity, int targetYear) {
        List<PrecipitationRecord> records = new ArrayList<>();
        File folder = new File(folderPath);

        // Verifica se o que você passou é realmente uma pasta e se ela existe
        if (!folder.exists() || !folder.isDirectory()) {
            System.err.println("Erro: A pasta '" + folderPath + "' não foi encontrada na raiz do projeto ou não é um diretório válido.");
            return records;
        }

        // Pega todos os arquivos que estão dentro dessa pasta
        File[] files = folder.listFiles();
        if (files == null) return records;

        // Passa por cada arquivo .txt
        for (File file : files) {
            if (file.isFile()) {
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;
                    boolean isFirstLine = true;

                    while ((line = br.readLine()) != null) {
                        if (isFirstLine) {
                            isFirstLine = false;
                            continue;
                        }

                        String[] parts = line.split(";");
                        if (parts.length < 38) continue; // Pula linhas defeituosas

                        String city = parts[0].trim();
                        int year = Integer.parseInt(parts[4].trim());

                        // Se encontrou a cidade e o ano corretos em algum dos arquivos, extrai os dados
                        if (city.equalsIgnoreCase(targetCity) && year == targetYear) {
                            int month = Integer.parseInt(parts[5].trim());
                            YearMonth ym = YearMonth.of(year, month);

                            for (int day = 1; day <= ym.lengthOfMonth(); day++) {
                                String valueStr = parts[6 + day].trim();
                                if (!valueStr.isEmpty() && !valueStr.equals("-") && !valueStr.equals("888.0")) {
                                    double amount = Double.parseDouble(valueStr.replace(",", "."));
                                    records.add(new PrecipitationRecord(LocalDate.of(year, month, day), amount));
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    System.err.println("Erro ao ler o arquivo " + file.getName() + ": " + e.getMessage());
                }
            }
        }

        return records;
    }
}