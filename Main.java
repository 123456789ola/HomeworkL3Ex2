package com.ola;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import  java.lang.Exception.*;
import  java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
 Container container = new Container();
 Class<?> cl = container.getClass();


 Field f = null;
 String textForWriter  = " ";
 try{
    f = cl.getDeclaredField("s");
    f.setAccessible(true);
     textForWriter = (String) f.get(container);


 }catch (NoSuchFieldException|SecurityException|IllegalAccessException
 |IllegalArgumentException exception){
     exception.printStackTrace();
 }
        System.out.println(textForWriter);

 String inWhichFileSave = "";

 try{
   Field field = cl.getDeclaredField("s");
   if (field.isAnnotationPresent(SaveToFile.class)){

    SaveToFile sf = field.getAnnotation(SaveToFile.class);

       inWhichFileSave =  sf.s();


   }


 }catch (NoSuchFieldException exception){
     exception.printStackTrace();
 }

System.out.println(inWhichFileSave);

 Method[] methodList = cl.getDeclaredMethods();

        for (Method met:methodList) {
            if(met.isAnnotationPresent(SimpleMetka.class)){

                try {

                   met.invoke(container,textForWriter,inWhichFileSave);


                }catch (SecurityException|IllegalAccessException
                |IllegalArgumentException|InvocationTargetException exception){
                    exception.printStackTrace();
                }







            }
       else {
           System.out.println("there are no such method");
            }

        }




    }
}
