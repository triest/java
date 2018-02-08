/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author triest
 */
import jpcap.JpcapCaptor;

import jpcap.NetworkInterface;


public class Main 

{
      static NetworkInterface [] array ;


public static void main (String[] args)
{System.loadLibrary("<NAME OF THE LIBRARY>");
   array = JpcapCaptor.getDeviceList();

   System.out.println("Available Interfaces: ");

         for (int i=1;  i<array.length ; i++)
                   
              {
                    System.out.println(i+" -> " + array[i].description);        
               }
}

}