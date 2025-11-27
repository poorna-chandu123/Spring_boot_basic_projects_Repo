/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Oops_abstaction_topic;

/**
 *
 * @author annapureddy.chandu
 */
public class User {

    public static void main(String[] args) {
        HP ob = new HP();

        ob.past();
        ob.copy();
        ob.cut();
        ob.security();
        ob.audio();

        /* vitini Abstact_MidleBase class dwara impliment chesina vatini call chesam kani abstaction cheyaleka poyamu 
        
        object creation anedi verela chesthe avuthundi eppudu DELL ki chesi chuddam
      
         */
        System.out.println("===============================");
        System.out.println("===============================");

        // Abstaction mening :- aslu abstact ante metod mida click chesthe anduloni implimentation kanapadakudu. a imolimentation anedi ye class lo
        // chesamo a class kadaki vella kudadu appudu adi 100% abstaction avuthundi
        
        
        Abstact_MidleBase ab = new DELL();  // eila object creation ki mundu Abstact_MidleBase class eisthe methods place anedi andulo chupindi 

        ab.past(); // past, copy, cut ane vatini 100% abstact cheyaleka poyanu because vitini commom ga anni class ki vaduthiunnam ani      
        ab.copy(); // E mothad ni Abstact_MidleBase class lo impliment chesamu 
        ab.cut();
        ab.security();  // BUT security,audio ane vatini ye class ki a class vidi vidi ga vadukuntundi ani vatini a class lone implimentaion chesamu
        ab.audio();  // kanuka evi hide avvayi
        
        
        // So esari INTERFACE (Laptop) ni echhi cheddam object creation appuidu 
        
         System.out.println("===============================");
        System.out.println("===============================");
        
            Laptop hide = new Lenova ();
            
             hide.past();
        hide.copy();
        hide.cut();
        hide.security();
        hide.audio();

     /*
        eppudu Lenova ki related avina methods anni 100% abstaction avvavi manam INTERFACE ye implimentation cheyamu kanuka avi a mothods lo yem 
        rasamo kanapadadu
        
        NOTE:- eila 100% implimentation anedi   JAVA 7 dake cheyagalmu yendukante JAVA 8 verstion INTERFACE lo kuda implimentation chesukovachhu
        ane option vachhindi kanuka manam implimentation cheyakunda vunte 100% abstraction lekunte  100% abstraction kadu
        
        */
    }

}
