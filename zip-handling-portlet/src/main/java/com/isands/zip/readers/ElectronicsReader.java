package com.isands.zip.readers;


import com.isands.service.builder.model.Electronics;
import com.isands.service.builder.service.ElectronicsLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.zip.DataFormatException;

public class ElectronicsReader implements CsvReader {
    private static final Log logger = LogFactoryUtil.getLog(ElectronicsReader.class);

    @Override
    public boolean isSuitable(String fileName) {
        return fileName.equalsIgnoreCase("Electronics.csv");
    }


    @Override
    public void readCsvFile(ServiceContext serviceContext, BufferedReader reader) throws IOException, DataFormatException {
        String line;
        while ((line = reader.readLine()) != null) {
            try {
                String[] values = line.split(";");
                if (values.length != 8) {
                    logger.error("Invalid params count in csv string. Excepted length is 7 but given: " + values.length);
                    throw new DataFormatException("Invalid params count in csv file string");
                }
                if (values[0].equals("id"))
                    continue;
                long electronicsId = Long.parseLong(values[0]);
                String name = values[1];
                long electroTypeId = Long.parseLong(values[2]);
                long price = Long.parseLong(values[3]);
                int count = Integer.parseInt(values[4]);
                boolean isStock = Integer.parseInt(values[5]) == 1;
                boolean archive = Integer.parseInt(values[6]) == 1;
                String description = values[7];
                Electronics electronics = ElectronicsLocalServiceUtil.createElectronics(ElectronicsLocalServiceUtil.getElectronicsesCount() + 1);
                electronics.setName(name);
                electronics.setPrice(price);
                electronics.setElectroTypeId(electroTypeId);
                electronics.setCount(count);
                electronics.setInStock(isStock);
                electronics.setArchive(archive);
                electronics.setDescription(description);
                electronics.setCompanyId(1);
                ElectronicsLocalServiceUtil.addElectronics(electronics);
                logger.info("Electronics was saved");
            } catch (NumberFormatException exception) {
                logger.error("Invalid param formatting");
                throw new DataFormatException("Error when parsing param values in the csv file");
            }
        }
    }
}
