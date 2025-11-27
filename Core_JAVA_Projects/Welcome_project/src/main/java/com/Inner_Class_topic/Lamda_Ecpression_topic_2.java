/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Inner_Class_topic;

/**
 *
 * @author annapureddy.chandu
 */
public class Lamda_Ecpression_topic_2 {
    
    public static void main(String[] args) {
     
        // 1st model
        car o1 = s->{  // mrthod name evvalisina avasaram ledu and  method refrences ade evvalsina avasaram ledu
            
            System.out.println("car sppend = "+s);
            
        };
        o1.drive(100);
        
        System.out.println("1st modal");
        
      // 2nd modael
      
        car o2 = speed -> {
         System.out.println("car sppend = "+speed);
    };
      o2.drive(300);
      
     // 3rd modal 
      car2 o3 = () ->{
          return "bmw" ;
             
      };
        System.out.println(o3.getmodal());
        
        // 4th modal
        car2 o5 = () -> "tvs"; // return tyepe ni direct ga value laga echeyachhu
        System.out.println(o5.getmodal());
        
 /*
       Lambda Expressions lo 3components vuntayi
        1) argument list 2)arrow token 3) function body
        */
        
        
       // anonymous class ni vadi return type rayatam
        car2 o4 = new car2(){
            @Override
            public String getmodal() {
               
                String name ="honda";
               
                return name;
                
              // OR   return "honda";
                
                
            }  
        };
        
        System.out.println(o4.getmodal());
      
    }
    
    interface car {
            public void drive(int speed);
            
    }
    
    interface car2{
        
         public String getmodal();
    }
    
}
