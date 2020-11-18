//package sce.cz2002.yxy;

import java.util.*;
import java.time.*;

public class Student {
    private String Name; 
    private String Username; 
    private char Gender; 
    private String Nationality; 
    private String MatricNo; 
    private String Password; 
    private String Email; 
    private Map<String, Integer> CoursesRegistered; 
    private Map<String, Integer> CoursesWaitlist;
    //private Map<>
    private int SumAU = 0; 
    private LocalDateTime[] AccessPeriod;  
    
    public Student(String name, char gender, String nationality, String matric) {
    	Name = name; 
    	Gender = gender; 
    	Nationality = nationality; 
    	MatricNo = matric; 
    	
    }
    
    public String getStudentName() {
    	return Name; 
    }
    
    public String getStudentUsername() {
    	return Username; 
    }
    
    public String getStudentMatric() {
    	return MatricNo; 
    }
    
    public String getStudentPassword() {
    	return Password; 
    }
    
    public String getStudentEmail() {
    	return Email; 
    }
    
    public void setStudentEmail(String E_mail) {
        Email = E_mail; 
    }
    
    public Map<String, Integer> getCoursesRegistered() {
    	return CoursesRegistered; 
    }
    
    public void printCoursesRegistered() {
    	CoursesRegistered.entrySet().forEach(entry->{System.out.println(entry.getKey()); });
    }
    
    public Map<String, Integer> getCoursesWaitlist() {
    	return CoursesWaitlist; 
    	
    }
    
    //public getTimeTable() {}
    
    //public printTimeTable() {}
    
    public void setAccessPeriod(LocalDateTime[] accessperiod) {
    	AccessPeriod = accessperiod; 
    }
    
}
