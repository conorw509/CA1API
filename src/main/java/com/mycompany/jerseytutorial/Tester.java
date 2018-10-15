/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam; 
import javax.ws.rs.core.Response;

					
@Path("/convert") 
public class Tester {
					
  @GET
  @Path("/roman/{rom}")
  public Response romToDec(@PathParam("rom") String roman ) {
      
    int decimal = 0;

    String romanNumeral = roman.toUpperCase();
    for(int x = 0;x<romanNumeral.length();x++)
    {
        char convertToDecimal = roman.charAt(x);

        switch (convertToDecimal) 
        {
        case 'M':
            decimal += 1000;
            break;

        case 'D':
            decimal += 500;
            break;

        case 'C':
            decimal += 100;
            break;

        case 'L':
            decimal += 50;
            break;

        case 'X':
            decimal += 10;
            break;

        case 'V':
            decimal += 5;
            break;

        case 'I':
            decimal += 1;
            break;
        }
    }
    if (romanNumeral.contains("IV"))
    {
        decimal-=2;
    }
    if (romanNumeral.contains("IX"))
    {
        decimal-=2;
    }
    if (romanNumeral.contains("XL"))
    {
        decimal-=10;
    }
    if (romanNumeral.contains("XC"))
    {
        decimal-=10;
    }
    if (romanNumeral.contains("CD"))
    {
        decimal-=100;
    }
    if (romanNumeral.contains("CM"))
    {
        decimal-=100;
    }
        return Response.status(200).entity(decimal).build(); 
}
  
  
  
    @GET
  @Path("/decimal/{dec}")
  public Response decToRom(@PathParam("dec") float input) { 
         String s = " ";
if (input < 1 || input > 3999)
     
 
    while (input >= 1000) {
        s += "M"; 
        input -= 1000;        }

    while (input >= 900) { 
        s += "CM";
        input -= 900;
    }
    while (input >= 500) {
        s += "D";
        input -= 500;
    }
    while (input >= 400) {
        s += "CD";
        input -= 400;
    }
    while (input >= 100) {
        s += "C";
        input -= 100;
    }
    while (input >= 90) {
        s += "XC";
        input -= 90;
    }
    while (input >= 50) {
        s += "L";
        input -= 50;
    }
    while (input >= 40) {
        s += "XL";
        input -= 40;
    }
    while (input >= 10) {
        s += "X";
        input -= 10;
    }
    while (input >= 9) {
        s += "IX";
        input -= 9;
    }
    while (input >= 5) {
        s += "V";
        input -= 5;
    }
    while (input >= 4) {
        s += "IV";
        input -= 4;
    }
    while (input >= 1) {
        s += "I";
        input -= 1;
    }    
   return Response.status(200).entity(s).build();  
}
   
}
 


 
  
   

  
      
  				


