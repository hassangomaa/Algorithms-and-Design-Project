 
package code_rectangles;
 
import java.util.Vector;

import java.net.*;
import com.sun.jndi.ldap.Connection;
import java.awt.*;
import java.beans.*;
import java.io.*; 
import java.sql.*;
import java.util.*;
import java.util.stream.*;
import java.util.logging.*;
import java.util.logging.Logger;
import javafx.util.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

     

/**
 *
 * @author H
 */
public class Code_Rectangles {
 
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Vector<Integer> vect1 = new Vector <Integer>();
    Vector<Integer> vect2= new Vector <Integer>();
        Vector<Integer> vect11 = new Vector <Integer>();
    Vector<Integer> vect22= new Vector <Integer>();
        Vector<Integer> vect = new Vector <Integer>();
    Vector<Integer> vectt= new Vector <Integer>();

     
    vect.add(2);
    vect.add(3);
    vect.add(2);
    vect.add(3);
    vect.add(5);


    vectt.add(3);
    vectt.add(4);
    vectt.add(2);
    vectt.add(4);
    vectt.add(2);
         
     vect11.add(2);
    vect11.add(3);
    vect11.add(1);
    vect11.add(3);
     
    
                vect22.add(2);
                vect22.add(3);
                vect22.add(1);
                vect22.add(3);
    
  




    vect1.add(2);
    vect1.add(10);
    vect1.add(4);
    vect1.add(1);
    vect1.add(4);
     
    
                vect2.add(4);
                vect2.add(1);
                vect2.add(2);
                vect2.add(2);
                vect2.add(5);
    
    
     
    
         

    
    System.out.println("1#Answer is :  "+MaxRectangleSide(vect,vectt));
   System.out.println("2#Answer is :  "+MaxRectangleSide(vect11,vect22));
    System.out.println("3#Answer is :  "+MaxRectangleSide(vect1,vect2));
    }
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 static int MaxRectangleSide(Vector<Integer> Vector1 , Vector <Integer> Vector2)
 {
                                //initilization Part
                int sizeOfVector = Vector1.size();
                Integer hh;
                int counter;
                HashMap<Integer,Integer> Map_Frequenced =new HashMap<Integer,Integer>() ;
                Vector  <Pair<Integer,Integer>> vec = new Vector  <Pair<Integer,Integer>>();
                int biggestRepeatedNum = 0;
                int take = 0;

                
                //Loops in which all element in the both vectors
                //will mapped into HashMap
                
                    for ( Object var : Vector1)//for each
                    {
                             //check if counter is null then      
                             if (Map_Frequenced.containsKey(var))
                             {
                                 counter = Map_Frequenced.get(var) ;
                              
                             }
                            else 
                             {
                                counter =0 ;
                             }

                Map_Frequenced.put( (Integer) var , counter+1 ); 
                   }
                    
                    for ( Object var :  Vector2)
                    {    
                           //check if counter is null then      
                             if (Map_Frequenced.containsKey(var))
                             {
                                 counter = Map_Frequenced.get(var) ;
                              
                             }
                            else 
                             {
                                counter =0 ;
                             }                   Map_Frequenced.put( (Integer) var , counter+1 );         
                    }
                
   //fill the Vector with new pairs of inputs values  --> value1:value2
     for (int i = 0; i < sizeOfVector; i++)
     {
         vec.add(new Pair <Integer,Integer> (Vector1.get(i),  Vector2.get(i)) ) ;
     }
      
      //for loop from Entry (begain) → //to Entry Set of given #Hashmap (end)
     for (  Map.Entry<Integer,Integer> e : Map_Frequenced.entrySet())        
     {
         //Get the Max of current value and biggestRepeatedNum //Default is 0
         biggestRepeatedNum = Math.max(biggestRepeatedNum, e.getValue() );     
     }

     
        //loop among whole #Hash Map
       for (Map.Entry  e : Map_Frequenced.entrySet())
      {
          //if the given value == biggestRepeatedNum
               if ( e.getValue().equals( biggestRepeatedNum) ) 
          {
                take = (int)e.getKey(); 
             break ;
          }

     }

     int numberOf_theAnswer = 0;
     for (int i = 0; i < vec.size(); i++) 
     {
          Pair<Integer,Integer> p = vec.get(i);
         if (p.getKey() == take || p.getValue() == take)
         {
             numberOf_theAnswer++;
         }   
     }
     return numberOf_theAnswer;
 }
    
}
