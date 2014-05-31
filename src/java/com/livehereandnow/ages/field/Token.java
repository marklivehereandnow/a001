/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livehereandnow.ages.field;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author mark
 */
public class Token {
    private String color;
    private int totalNumbers;
    private Map<Integer,Integer> map;
    //

    public Token() {
        color="Unknown";
        totalNumbers=0;
//        map=new LinkedHashMap<>();
        map=new LinkedHashMap<>();
        
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTotalNumbers() {
        return totalNumbers;
    }

    public void setTotalNumbers(int totalNumbers) {
        this.totalNumbers = totalNumbers;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map distribution) {
        this.map = distribution;
    }
    
    
//    public boolean addLocation(int id){
//       Integer aVal=map.get(id);
//        if (aVal==null){
//            System.out.println("...going to add entry to map. ID="+id);
//            map.put(id, 0);
//            return true;
//        }else{
//            System.out.println("ID is existing, fail to add!. ID="+id);
//            return false;
//            
//        }
//        
//    }
    /**
     * 
     * 
     * @param a
     * @param b
     * @return 
     */
    public boolean moveTokensFromAtoB(int tokens,int a, int b){
       Integer aVal=map.get(a);
       Integer bVal=map.get(b);
        if (aVal==null){
            System.out.println("A is not existing. A="+a);
            return false;
        }
        if (bVal==null){
            System.out.println("B is not existing. Create it with default 0. B="+a);
//            return false;
            map.put(b, 0);
            bVal=0;
        }
        
//        if (aVal<tokens){
//            System.out.println("A has not enough tokens to move. A="+a+" require tokens="+tokens+" current tokens="+aVal);
//            return false;            
//        }
        map.put(a, aVal-tokens);
        map.put(b, bVal+tokens);        
        return true;
    }
}
