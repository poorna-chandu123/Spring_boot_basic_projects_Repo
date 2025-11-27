package com.first_mini_project.services;

import com.first_mini_project.entity.CitizenPlane;
import com.first_mini_project.repo.CitizenRepo;
import com.first_mini_project.searchDTO.CitizenSpecification;
import com.first_mini_project.searchDTO.Citizen_Search_DTO;
import com.first_mini_project.utility.Email_Util;
import com.first_mini_project.utility.Excle_Util;
import com.first_mini_project.utility.PDF_Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
public class Citizen_service_imp implements Citizen_service_in{


@Autowired
    private CitizenRepo citizenRepo;


    public Citizen_service_imp(CitizenRepo citizenRepo) {
        this.citizenRepo = citizenRepo;
    }

    @Autowired
    private Email_Util emailUtil;

    @Override
    public List<String> getCitizenPlaneNameDistinct() {
        return citizenRepo.findDistinctCitizenPlaneNames();
    }

    @Override
    public List<String> getCitizenPlaneStatusDistinct() {
        return citizenRepo.findDistinctCitizenPlaneStatus();
    }

    @Override
    public List<CitizenPlane> searchCitizens(Citizen_Search_DTO dto) {
        return citizenRepo.findAll(CitizenSpecification.search(dto));
    }

    @Override
    public byte[] exportToExcel() throws IOException {
        List<CitizenPlane> list = citizenRepo.findAll();  // fetch all table data
        return Excle_Util.generateExcel(list);
    }

    @Override
    public byte[] exportToPDF() throws IOException {
        List<CitizenPlane> list = citizenRepo.findAll();
        return PDF_Util.generatePDF(list);    }

    @Override
    public byte[] exportExcelAndSendMail() throws Exception {

        // calling DB to get the data
        List<CitizenPlane>  list = citizenRepo.findAll();
        // generating exle file with existing excle code
        byte[] excelData = Excle_Util.generateExcel(list);

        String usermail = "poornachandu.javasoft@gmail.com";
        // seding mail with excle attachment by calling email util class
        emailUtil.sendExcel(usermail, excelData,
                "Citizen Plan Excle Data",
                "Please find the attached excle file with citizen plan data",
                "citizen_plans.xlsx");
        //returning the excle data to the controller
        return excelData;


    }

    @Override
    public byte[] exportPDFAndSendMail() throws Exception {
        List<CitizenPlane> pdflist = citizenRepo.findAll();
        byte[] pdfData = PDF_Util.generatePDF(pdflist);
        String usermail = "poornachandu.javasoft@gmail.com";
        emailUtil.sendExcel(usermail, pdfData,
                "Citizen Plan PDF Data",
                "Please find the attached PDF file with citizen plan data",
                "citizen_plans.pdf");
        return pdfData;
    }


}
