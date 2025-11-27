package com.welcome.welcome_project;

public class Welcome_project {
    
    static  int currentBalance =1000;
 
public static void greetCustomer (){
    System.out.println("welocme customer");
}

public void deposite(int amount){
    
    currentBalance =currentBalance+amount;
    System.out.println("deposite success");
}

public static  void withdrawal(int amount){
    currentBalance =currentBalance-amount;
    System.out.println("with dra sucess");
}
public int  getCurrentBalance(){
    return currentBalance;
}
    public static void main(String[] args) {
        Welcome_project s =new Welcome_project();
         
        greetCustomer();
        System.out.println("current balence"+s.getCurrentBalance());
        
       s.deposite(500);
        System.out.println("current balewnxce"+s.getCurrentBalance());
        s.withdrawal(300);
     System.out.println("current balewnxce"+s.getCurrentBalance());
    }
}
