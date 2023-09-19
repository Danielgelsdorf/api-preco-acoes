package br.com.gelsdorf.apiacoes.exceptions;

public class AcaoException extends RuntimeException {
    private String msg;
    public  AcaoException (String msg){
        this.msg=msg;
    }
    public  String getMsg(){
        return msg;
    }

}