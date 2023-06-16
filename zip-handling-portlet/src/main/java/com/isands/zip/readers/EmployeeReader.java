package com.isands.zip.readers;


import com.isands.service.builder.model.Employee;
import com.isands.service.builder.service.EmployeeLocalServiceUtil;
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

public class EmployeeReader implements CsvReader {
    private static final Log logger = LogFactoryUtil.getLog(EmployeeReader.class);

    @Override
    public boolean isSuitable(String fileName) {
        return fileName.equalsIgnoreCase("Employee.csv");
    }

    @Override
    public void readCsvFile(ServiceContext serviceContext, BufferedReader reader) throws IOException, DataFormatException {
        String line;
        while ((line = reader.readLine()) != null) {
            try {
                String[] values = line.split(";");
                if (values.length != 7) {
                    logger.error("Invalid params count in csv string. Excepted 7, but given " + values.length);
                    throw new DataFormatException("Invalid params count in csv file string");
                }
                if (values[0].equals("id"))
                    continue;
                long employeeId = Long.parseLong(values[0]);
                String lastName = values[1];
                String firstName = values[2];
                String patronymic = values[3];
                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                Date birthDate = dateFormat.parse(values[4]);
                long positionId = Long.parseLong(values[5]);
                int gender = Integer.parseInt(values[6]);

                Employee employee = EmployeeLocalServiceUtil.createEmployee(EmployeeLocalServiceUtil.getEmployeesCount() + 1);
                employee.setLastName(lastName);
                employee.setFirstName(firstName);
                employee.setPatronymic(patronymic);
                employee.setBirthDay(birthDate);
                employee.setPositionId(positionId);
                employee.setGender(gender);
                employee.setCompanyId(1);
                EmployeeLocalServiceUtil.addEmployee(employee);
                logger.info("Employee was saved");
            } catch (ParseException exception) {
                logger.error("Invalid param formatting");
                throw new DataFormatException("Error when parsing param values in the csv file");
            }
        }
    }
}
