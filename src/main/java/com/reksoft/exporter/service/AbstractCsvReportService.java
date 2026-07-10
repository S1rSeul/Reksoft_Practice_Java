package com.reksoft.exporter.service;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public abstract class AbstractCsvReportService<T> implements CsvReportService {

    public File generateReport(String filePath) throws IOException {
        List<T> items = getData();
        File file = new File(filePath);

        try (CSVWriter writer = new CSVWriter(new FileWriter(file))) {
            writer.writeNext(getHeaders());
            for (T item : items) {
                writer.writeNext(mapToRow(item));
            }
        }
        return file;
    }

    protected abstract List<T> getData();

    protected abstract String[] getHeaders();

    protected abstract String[] mapToRow(T item);
}