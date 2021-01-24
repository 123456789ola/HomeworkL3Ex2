package com.ola;

import java.io.FileWriter;
import java.io.IOException;

public class Container {
@SaveToFile(s = "a.txt")
    private String s = "Hello!!!";


@SimpleMetka
public void saver (String text,String direction){

    try (FileWriter fw = new FileWriter(direction,false)){
        fw.write(text);
            }catch (IOException e){
        e.printStackTrace();
    }
}

}
