package com.isands.zip.readers;

import com.isands.service.builder.model.PurchaseType;
import com.isands.service.builder.service.PurchaseTypeLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.zip.DataFormatException;

public class PurchaseTypeReader implements CsvReader {
    private static final Log logger = LogFactoryUtil.getLog(PurchaseTypeReader.class);

    @Override
    public boolean isSuitable(String fileName) {
        return fileName.equalsIgnoreCase("PurchaseType.csv");
    }

    @Override
    public void readCsvFile(ServiceContext serviceContext, BufferedReader reader) throws IOException, DataFormatException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(";");
            if (values.length != 2) {
                logger.error("Invalid params count in csv string. Excepted length is 1 but given: " + values.length);
                throw new DataFormatException("Invalid params count in csv file string");
            }
            if (values[0].equals("id"))
                continue;
            long purchaseTypeId = Long.parseLong(values[0]);
            String name = values[1];
            PurchaseType purchaseType = PurchaseTypeLocalServiceUtil.createPurchaseType(PurchaseTypeLocalServiceUtil.getPurchaseTypesCount() + 1);
            purchaseType.setName(name);
            purchaseType.setCompanyId(1);
            PurchaseTypeLocalServiceUtil.addPurchaseType(purchaseType);
            logger.info("PurchaseType was saved");
        }
    }
}
