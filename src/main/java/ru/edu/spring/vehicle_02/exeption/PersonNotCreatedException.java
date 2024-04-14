package ru.edu.spring.vehicle_02.exeption;

public class PersonNotCreatedException extends  RuntimeException{
    public PersonNotCreatedException(String msg){
        super(msg);
    }
}
