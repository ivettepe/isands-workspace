package com.isands.zip.readers;


import com.isands.service.builder.model.Purchase;
import com.isands.service.builder.service.PurchaseLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.DataFormatException;

public class PurchaseReader implements CsvReader {
    private static final Log logger = LogFactoryUtil.getLog(PurchaseReader.class);

    @Override
    public boolean isSuitable(String fileName) {
        return fileName.equalsIgnoreCase("Purchase.csv");
    }

    @Override
    public void readCsvFile(ServiceContext serviceContext, BufferedReader reader) throws IOException, DataFormatException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(";");
            if (values.length != 5) {
                logger.error("Invalid params count in csv string");
                throw new DataFormatException("Invalid params count in csv file string");
            }
            if (values[0].equals("id"))
                continue;
            long purchaseId = Long.parseLong(values[0]);
            long electroId = Long.parseLong(values[1]);
            long employeeId = Long.parseLong(values[2]);
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date purchaseDate;
            try {
                purchaseDate = dateFormat.parse(values[3]);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            long purchaseType = Long.parseLong(values[4]);
            Purchase purchase = PurchaseLocalServiceUtil.createPurchase(PurchaseLocalServiceUtil.getPurchasesCount() + 1);
            purchase.setElectronicsId(electroId);
            purchase.setEmployeeId(employeeId);
            purchase.setPurchaseDate(purchaseDate);
            purchase.setPurchaseTypeId(purchaseType);
            purchase.setCompanyId(1);
            purchase.setCount(1);
            PurchaseLocalServiceUtil.addPurchase(purchase);
            logger.info("Purchase was saved");
        }
    }
}
