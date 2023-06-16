package com.isands.zip.readers;

import com.isands.service.builder.model.ElectroEmployee;
import com.isands.service.builder.service.*;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.zip.DataFormatException;

public class ElectroEmployeeReader implements CsvReader {
    private static final Log logger = LogFactoryUtil.getLog(ElectroEmployeeReader.class);

    @Override
    public boolean isSuitable(String fileName) {
        return fileName.equalsIgnoreCase("ElectroEmployee.csv");
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
            if (values[0].equals("employeeId") || values[0].equals("etype"))
                continue;
            long employeeId = Long.parseLong(values[0]);
            long etypeId = Long.parseLong(values[1]);
            ElectroEmployee electroEmployee = ElectroEmployeeLocalServiceUtil.createElectroEmployee(ElectroEmployeeLocalServiceUtil.getElectroEmployeesCount() + 1);
            electroEmployee.setEmployeeId(employeeId);
            electroEmployee.setElectroTypeId(etypeId);
            electroEmployee.setCompanyId(1);
            ElectroEmployeeLocalServiceUtil.addElectroEmployee(electroEmployee);
            logger.info("ElectroEmployee was saved");
        }
    }
}
