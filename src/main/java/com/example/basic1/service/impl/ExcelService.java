package com.example.basic1.service.impl;

import com.example.basic1.entity.AttendeeEntity;
import com.example.basic1.entity.ImportExcelEntity;
import com.example.basic1.repository.AttendeeRepository;
import com.example.basic1.repository.ImportExcelRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    private AttendeeRepository attendeeRepository;

    @Autowired
    private ImportExcelRepository importExcelRepository;

    @Transactional
    public void importAttendees() throws IOException {
//        String pathFile = "templates/attendees.xlsx";
        String pathFile = "attendees.xlsx";
        if (importExcelRepository.countByName(pathFile) > 0) {
            return;
        }
        Long id = 1L;
        // Mở file excel
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(pathFile).getFile());
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(inputStream);

        // Đọc sheet đầu tiên
        Sheet sheet = workbook.getSheetAt(0);

        List<AttendeeEntity> attendeeEntityList = new ArrayList<>();
        // Lặp qua các row của sheet và lưu vào database
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Bỏ qua row đầu tiên chứa tiêu đề cột
            if (row.getRowNum() == 0) {
                continue;
            }

            // Đọc giá trị từ các cell và lưu vào object Attendee
            AttendeeEntity attendee = new AttendeeEntity();
            List<String> cellValues = new ArrayList<>();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                String cellValue = "";
                switch (cell.getCellType()) {
                    case STRING:
                        cellValue = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            cellValue = cell.getDateCellValue().toString();
                        } else {
                            cellValue = Double.toString(cell.getNumericCellValue());
                        }
                        break;
                    case BOOLEAN:
                        cellValue = Boolean.toString(cell.getBooleanCellValue());
                        break;
                    case BLANK:
                        cellValue = "";
                        break;
                }
                cellValues.add(cellValue);
            }
            attendee.setId(id);
            attendee.setName(cellValues.get(1));
            attendee.setYearOfBirth((long) Double.parseDouble(cellValues.get(2)));
            attendee.setSex(cellValues.get(3));
            attendee.setSchool(cellValues.get(4));
            attendee.setMajor(cellValues.get(5));

            id++;
            attendeeEntityList.add(attendee);
        }

        // Lưu attendee vào database
        attendeeRepository.saveAll(attendeeEntityList);
        importExcelRepository.save(new ImportExcelEntity(pathFile));

        // Đóng workbook và inputStream
        workbook.close();
        inputStream.close();
    }
}