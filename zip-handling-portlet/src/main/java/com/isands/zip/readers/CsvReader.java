package com.isands.zip.readers;

import com.liferay.portal.kernel.service.ServiceContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.zip.DataFormatException;

public interface CsvReader {
    boolean isSuitable(String fileName);

    void readCsvFile(ServiceContext serviceContext, BufferedReader reader) throws IOException, DataFormatException;
}
