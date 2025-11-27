package com.first_mini_project.utility;

import com.first_mini_project.entity.CitizenPlane;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class Excle_Util {

    public static byte[] generateExcel(List<CitizenPlane> list) throws IOException {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Citizen Plan Data");

        // edi Excle loni rows ni difine chesthundi rows and columns wil start from 0
        int rowIdx = 0;

        // HEADER ROW
        Row headerRow = sheet.createRow(rowIdx++);
        String[] headers = {
                "Citizen Name", "Gender", "Plan Name", "Status",
                "Start Date", "End Date", "Benefit Amount", "Denial Reason"
        };

        // edi Excle loni cloumns ni difine chesthundi
        int colIdx = 0;
        for (String h : headers) {
            Cell cell = headerRow.createCell(colIdx++);
            cell.setCellValue(h);
        }

        // DATA ROWS
        for (CitizenPlane cp : list) {
            Row row = sheet.createRow(rowIdx++);
            int c = 0;

            row.createCell(c++).setCellValue(cp.getCitizenName());
            row.createCell(c++).setCellValue(cp.getCitizenGender());
            row.createCell(c++).setCellValue(cp.getCitizenPlaneName());
            row.createCell(c++).setCellValue(cp.getCitizenPlaneStatus());
            row.createCell(c++).setCellValue(cp.getCitizenPlaneStartDate() != null ? cp.getCitizenPlaneStartDate().toString() : "NA");
            row.createCell(c++).setCellValue(cp.getCitizenPlaneEndDate() != null ? cp.getCitizenPlaneEndDate().toString() : "NA");
            row.createCell(c++).setCellValue(cp.getCitizenBenefitAmount() != null ? cp.getCitizenBenefitAmount() : "NA");
            row.createCell(c++).setCellValue(cp.getCitizenPlaneDenialReason() != null ? cp.getCitizenPlaneDenialReason() : "NA");
        }

        // AUTO SIZE
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();

        return out.toByteArray();
    }

}
