/**
Build an array of Periodic Table information

@author dsims 
@version 1.0

CEN3031    Chemistry Calculator
File Name: Element.java
*/

import java.util.*;
/** Collect element data*/
public class Element 
{
   private int elementNumber;          // Element Atomic Number
   private String elementSymbol;       // Element Symbol
   private String elementName;         // Element Name
   private double elementMass;         // Element Atomic Mass
   private int elementPeriod;          // Element Period
   private double elementGroup;        // Element Group
   private String elementFamily;       // Element Famaily
   private String elementEtymology;    // Elelment Etymology
   Element[] element = new Element[10];// Array
   
   /** Sets instance fields to a default value and creates an array*/
   public Element()
   {
      elementNumber = 0;
      elementSymbol = "";
      elementName = "";
      elementMass = 0;
      elementPeriod = 0;
      elementGroup = 0;
      elementFamily = "";
      elementEtymology = "";
   }
      
   /** Sets the Element properties*/
   public Element(int theElementNumber, String theElementSymbol, String theElementName, double theElementMass, int theElementPeriod, double theElementGroup, String theElementFamily, String theElementEtymology)
   {
      setElementNumber(theElementNumber);
      setElementSymbol(theElementSymbol);
      setElementName(theElementName);
      setElementMass(theElementMass);
      setElementPeriod(theElementPeriod);
      setElementGroup(theElementGroup);
      setElementFamily(theElementFamily);
      setElementEtymology(theElementEtymology);           
      
      System.out.println(elementNumber + "\t" + elementSymbol + "\t" + elementName + "\t" + elementMass + "\t" + elementPeriod+ "\t" + elementGroup + "\t" + elementFamily + "\t" + elementEtymology);              
   }  
      
   public void setElementNumber(int theElementNumber)
   {
      elementNumber = theElementNumber;
   }
   
   public int elementNumber()                   // Element Number
   {
      return elementNumber;
   }

   public void setElementName(String theElementName)
   {
      elementName = theElementName;
   }
   
   public String getElementName()               // Element name
   {
      return elementName;
   }
      
   public void setElementSymbol(String theElementSymbol)
   {
      elementSymbol = theElementSymbol;
   }

   public String getElementSymbol()             // Element Symbol
   {
      return elementSymbol;
   }
  
   public void setElementMass(double theElementMass)
   {
      elementMass = theElementMass;
   }
   
   public double getElementMass()               // Ekement Mass
   {
      return elementMass;
   }

   public void setElementPeriod(int theElementPeriod)
   {
      elementPeriod = theElementPeriod;
   }
   
   public double getElementPeriod()               // Element Period
   {
      return elementPeriod;
   }

   public void setElementGroup(double theElementGroup)
   {
      elementGroup = theElementGroup;
   }
   
   public double getElementGroup()               // Element Group
   {
      return elementGroup;
   } 
   
   public void setElementFamily(String theElementFamily)
   {
      elementFamily = theElementFamily;
   }

   public String getElementFamily()             // Element Family
   {
      return elementFamily;
   }
 
   public void setElementEtymology(String theElementEtymology)
   {
      elementEtymology = theElementEtymology;
   }

   public String getElementEtymology()             // Element Etymology
   {
      return elementEtymology;
   }
 
}