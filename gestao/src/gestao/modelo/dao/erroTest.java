/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestao.modelo.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
 
public class erroTest {
 
    private final static int TOTAL_RECORDS = 100;
 
    public static void main(String args[]) {
        try{
            List records = new ArrayList(TOTAL_RECORDS);
 
            for(int i=1; i < TOTAL_RECORDS; ++i)
                records.add(new Record(i));
        }
        catch(Throwable t) {
            t.printStackTrace();
            throw t;
        }
    }
}
 
class Record {
    private static Integer ID = getRandomInteger();
 
    public Record(Integer Id){
        this.ID = Id;
    }
 
    private static Integer getRandomInteger() {
        throw new RuntimeException("The method is not implemented...");
        //return new Random.nextInt();
    }
}