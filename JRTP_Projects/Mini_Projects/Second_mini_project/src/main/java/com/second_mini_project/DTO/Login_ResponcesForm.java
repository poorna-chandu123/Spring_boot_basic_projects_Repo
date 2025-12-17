package com.second_mini_project.DTO;


import lombok.Data;

@Data
public class Login_ResponcesForm {

    private String UserName;
    private String massage;
    private String sataus; /* edi add cheyataniki reason controller class ni use chesi nenu create chesina
    // custom msg ni bad request ga retun cheyataniki yendukante neunu coustom msg ni "private String massage;"
    lo set chesi send chesthunna kanuka JAVA edi kuda oka responces ye anukoni always 200 OK ani chupistundi
    so adi bad request ga chupinchali ani edi add chesi deniki default value ni peeti bad request ni chupinchanu
*/
}