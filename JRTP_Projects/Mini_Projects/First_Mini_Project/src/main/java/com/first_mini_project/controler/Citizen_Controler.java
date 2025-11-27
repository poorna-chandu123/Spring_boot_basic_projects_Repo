package com.first_mini_project.controler;


import com.first_mini_project.entity.CitizenPlane;
import com.first_mini_project.repo.CitizenRepo;
import com.first_mini_project.searchDTO.Citizen_Search_DTO;
import com.first_mini_project.services.Citizen_service_in;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/citizen")
public class Citizen_Controler {

    @Autowired
    private Citizen_service_in citizenServiceIn;

    public Citizen_Controler(Citizen_service_in citizenServiceIn) {
        this.citizenServiceIn = citizenServiceIn;
    }

    // endpoint to get distinct citizen plan names
    @GetMapping("/distinct-names")
    public List<String> getDistinctCitizenPlaneNames() {
        return citizenServiceIn.getCitizenPlaneNameDistinct();
    }

    // endpoint to get distinct citizen plan status
    @GetMapping("/distinct-status")
    public List<String> getDistinctCitizenPlaneStatus() {
        return citizenServiceIn.getCitizenPlaneStatusDistinct();
    }

    @PostMapping("/search")
    public List<CitizenPlane> search(@RequestBody Citizen_Search_DTO dto) {
        return citizenServiceIn.searchCitizens(dto);
    }

    @GetMapping ("/Excel")
    public ResponseEntity<byte[]> exportExcel() throws IOException {

        byte[] data = citizenServiceIn.exportToExcel();

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=citizen_plans.xlsx")
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(data);
    }

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> exportPDF() throws IOException {

        byte[] pdfData = citizenServiceIn.exportToPDF();

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=citizen_plans.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfData);
    }
    // exportExcelAndSendMail endpoint
    @GetMapping("/export-and-send-mail")
    public ResponseEntity <byte[]> exportExcelAndSendMail() throws Exception {
        byte[] data = citizenServiceIn.exportExcelAndSendMail();
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=citizen_plans.xlsx")
                .contentType(MediaType.parseMediaType(
                        "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(data);

    }

    // exportPDFAndSendMail endpoint
    @GetMapping("/export-pdf-and-send-mail")
    public ResponseEntity <byte[]> exportPDFAndSendMail() throws Exception {
        byte[] pdfData = citizenServiceIn.exportPDFAndSendMail();
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=citizen_plans.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfData);
    }



}
