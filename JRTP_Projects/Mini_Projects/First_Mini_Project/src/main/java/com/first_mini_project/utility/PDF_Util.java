package com.first_mini_project.utility;


import com.first_mini_project.entity.CitizenPlane;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/* // commeted code will return PDF file data in just raw format without any table structure
public class PDF_Util {

    public static byte[] generatePDF(List<CitizenPlane> list) throws IOException {

        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream cs = new PDPageContentStream(document, page);
        cs.setFont(PDType1Font.HELVETICA_BOLD, 12);

        int y = 750; // Start position (top of page)

        // Header
        cs.beginText();
        cs.newLineAtOffset(50, y);
        cs.showText("Citizen Plans Report");
        cs.endText();

        y -= 30;

        cs.setFont(PDType1Font.HELVETICA, 10);

        // Column Headers
        cs.beginText();
        cs.newLineAtOffset(50, y);
        cs.showText("UserName | Gender | PlanName | Status | StartDate | EndDate | Benefit | DenialReason");
        cs.endText();

        y -= 20;

        // Data Rows
        for (CitizenPlane cp : list) {

            if (y <= 60) {
                // New page if full
                cs.close();
                page = new PDPage();
                document.addPage(page);
                cs = new PDPageContentStream(document, page);
                cs.setFont(PDType1Font.HELVETICA, 10);
                y = 750;
            }

            cs.beginText();
            cs.newLineAtOffset(50, y);

            String row = cp.getCitizenName() + " | "
                    + cp.getCitizenGender() + " | "
                    + cp.getCitizenPlaneName() + " | "
                    + cp.getCitizenPlaneStatus() + " | "
                    + (cp.getCitizenPlaneStartDate() != null ? cp.getCitizenPlaneStartDate() : "") + " | "
                    + (cp.getCitizenPlaneEndDate() != null ? cp.getCitizenPlaneEndDate() : "") + " | "
                    + (cp.getCitizenBenefitAmount() != null ? cp.getCitizenBenefitAmount() : "") + " | "
                    + (cp.getCitizenPlaneDenialReason() != null ? cp.getCitizenPlaneDenialReason() : "");

            cs.showText(row);
            cs.endText();

            y -= 20;
        }

        cs.close();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        document.save(out);
        document.close();

        return out.toByteArray();
    }
}


 */

  // code to generate PDF with table structure

public class PDF_Util {

    public static byte[] generatePDF(List<CitizenPlane> list) throws IOException {

        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);

        PDPageContentStream cs = new PDPageContentStream(document, page);

        float margin = 30;
        float yStart = 770;
        float y = yStart;

        float rowHeight = 20;
        float tableWidth = page.getMediaBox().getWidth() - (2 * margin);

        float[] colWidths = {80, 40, 60, 60, 60, 60, 70, 80};

        String[] headers = {
                "UserName", "Gender", "PlanName", "Status",
                "StartDate", "EndDate", "Benefit", "DenialReason"
        };

        // Title
        cs.beginText();
        cs.setFont(PDType1Font.HELVETICA_BOLD, 16);
        cs.newLineAtOffset(margin, y);
        cs.showText("Citizen Plans Report");
        cs.endText();

        y -= 30;

        float x = margin;

        //------------------------------------------
        // 1) DRAW HEADER BACKGROUND FIRST (WHITE)
        //------------------------------------------
        cs.setNonStrokingColor(255, 255, 255); // white
        cs.addRect(x, y - rowHeight, tableWidth, rowHeight);
        cs.fill();

        //------------------------------------------
        // 2) DRAW HEADER BORDERS
        //------------------------------------------
        cs.setStrokingColor(0, 0, 0); // black border
        cs.addRect(x, y - rowHeight, tableWidth, rowHeight);
        cs.stroke();

        //------------------------------------------
        // 3) DRAW HEADER TEXT (RED OR BLACK)
        //------------------------------------------
        cs.setNonStrokingColor(0, 0, 0);  // black text (you can change to red)
        cs.setFont(PDType1Font.HELVETICA_BOLD, 10);

        float textX = x + 5;

        for (int i = 0; i < headers.length; i++) {
            cs.beginText();
            cs.newLineAtOffset(textX, y - 15);
            cs.showText(headers[i]);
            cs.endText();
            textX += colWidths[i];
        }

        y -= rowHeight;

        //------------------------------------------
        // Table data rows
        //------------------------------------------
        cs.setFont(PDType1Font.HELVETICA, 9);
        cs.setNonStrokingColor(0, 0, 0); // text black

        for (CitizenPlane cp : list) {

            if (y <= 50) {   // page break
                cs.close();
                page = new PDPage(PDRectangle.A4);
                document.addPage(page);
                cs = new PDPageContentStream(document, page);
                y = yStart;
            }

            x = margin;

            String[] rowData = {
                    cp.getCitizenName(),
                    cp.getCitizenGender(),
                    cp.getCitizenPlaneName(),
                    cp.getCitizenPlaneStatus(),
                    cp.getCitizenPlaneStartDate() != null
                            ? cp.getCitizenPlaneStartDate().toString().substring(0, 10) : "",
                    cp.getCitizenPlaneEndDate() != null
                            ? cp.getCitizenPlaneEndDate().toString().substring(0, 10) : "",
                    cp.getCitizenBenefitAmount() != null ? cp.getCitizenBenefitAmount() : "NA",
                    cp.getCitizenPlaneDenialReason() != null ? cp.getCitizenPlaneDenialReason() : "NA"
            };

            // Draw white background for data row
            drawRowBorders(cs, x, y - rowHeight, tableWidth, rowHeight);

            // Draw row text
            float cellTextX = x + 5;
            for (int i = 0; i < rowData.length; i++) {
                cs.beginText();
                cs.newLineAtOffset(cellTextX, y - 15);
                cs.showText(rowData[i]);
                cs.endText();

                cellTextX += colWidths[i];
            }

            y -= rowHeight;
        }

        cs.close();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        document.save(out);
        document.close();

        return out.toByteArray();
    }


    // Draw white background + cell borders
    private static void drawRowBorders(
            PDPageContentStream cs, float x, float y, float width, float height
    ) throws IOException {

        // Background white
        cs.setNonStrokingColor(255, 255, 255);
        cs.addRect(x, y, width, height);
        cs.fill();

        // Border black
        cs.setStrokingColor(0, 0, 0);
        cs.addRect(x, y, width, height);
        cs.stroke();

        cs.setNonStrokingColor(0, 0, 0); // reset for text
    }
}
