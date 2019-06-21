package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.validation;

public class MyForm {

    private String pattern;

    public  boolean ID_Validatio(String text){
        pattern = "^\\p{L}+[0-9][0-9][0-9][0-9]";
        if(text.matches(pattern)){
           return true ;
        }
        return false;

    }

    public boolean NAME_Validation(String text){
        pattern = "[a-z]*";
        if(text.matches(pattern)){
            return true ;
        }
        return false;
    }

    public boolean Duration_Validation(String text){
        pattern = "[0-9]*\\s[A-Za-z]*";
        if(text.matches(pattern)){
            return true ;
        }
        return false;
    }

    public boolean Amount_Validation(String text){
        pattern = "[0-9]*";
        if(text.matches(pattern)){
            return true ;
        }
        return false;
    }



}
