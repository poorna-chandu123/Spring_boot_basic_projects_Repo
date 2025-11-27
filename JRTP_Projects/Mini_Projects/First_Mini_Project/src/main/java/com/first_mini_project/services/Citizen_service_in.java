package com.first_mini_project.services;



import com.first_mini_project.entity.CitizenPlane;
import com.first_mini_project.searchDTO.Citizen_Search_DTO;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.io.IOException;
import java.util.List;


public interface Citizen_service_in {


// i need citizenPlaneName  as a distint value
    public List<String> getCitizenPlaneNameDistinct();
    // plane status as a distinct value
    public List<String> getCitizenPlaneStatusDistinct();

    List<CitizenPlane> searchCitizens(Citizen_Search_DTO dto);

    // Excle file download method
    byte[] exportToExcel() throws IOException;
// PDF file download method
    byte[] exportToPDF() throws IOException;

    //exportExcelAndSendMail method
   byte [] exportExcelAndSendMail() throws Exception;

   // pdf send mail method
    byte [] exportPDFAndSendMail() throws Exception;

}
