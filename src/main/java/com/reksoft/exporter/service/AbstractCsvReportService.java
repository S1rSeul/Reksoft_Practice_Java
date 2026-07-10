package com.reksoft.exporter.service;

import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public abstract class AbstractCsvReportService<T> implements CsvReportService {

    public File generateReport(String filePath) throws IOException {
        List<T> items = getData();
        File file = new File(filePath);

        try (FileOutputStream fos = new FileOutputStream(file);
             Writer writer = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {

            fos.write(new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF}); // Запись BOM

            CSVWriter csvWriter = new CSVWriter(writer);
            csvWriter.writeNext(getHeaders());
            for (T item : items) {
                csvWriter.writeNext(mapToRow(item));
            }
            csvWriter.close();
        }
        return file;
    }

    protected abstract List<T> getData();

    protected abstract String[] getHeaders();

    protected abstract String[] mapToRow(T item);
}