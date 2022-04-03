package model;

import java.util.Date;

public class Worker {
    
    int WORKER_ID;
    String FIRST_NAME;
    String LAST_NAME;
    int SALARY;
    Date JOINING_DATE;
    String DEPARTMENT;

    public Worker() {
    	
    }
    
    public Worker(int wORKER_ID) {
        WORKER_ID = wORKER_ID;
    }


    public Worker(int wORKER_ID, String fIRST_NAME, String lAST_NAME, int sALARY, Date jOINING_DATE,
            String dEPARTMENT) {
        WORKER_ID = wORKER_ID;
        FIRST_NAME = fIRST_NAME;
        LAST_NAME = lAST_NAME;
        SALARY = sALARY;
        JOINING_DATE = jOINING_DATE;
        DEPARTMENT = dEPARTMENT;
    }


    public int getWORKER_ID() {
        return WORKER_ID;
    }

    public void setWORKER_ID(int wORKER_ID) {
        WORKER_ID = wORKER_ID;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public void setFIRST_NAME(String fIRST_NAME) {
        FIRST_NAME = fIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public void setLAST_NAME(String lAST_NAME) {
        LAST_NAME = lAST_NAME;
    }

    public int getSALARY() {
        return SALARY;
    }

    public void setSALARY(int sALARY) {
        SALARY = sALARY;
    }

    public Date getJOINING_DATE() {
        return JOINING_DATE;
    }

    public void setJOINING_DATE(Date jOINING_DATE) {
        JOINING_DATE = jOINING_DATE;
    }

    public String getDEPARTMENT() {
        return DEPARTMENT;
    }

    public void setDEPARTMENT(String dEPARTMENT) {
        DEPARTMENT = dEPARTMENT;
    }

    @Override
    public String toString() {
        return "WORKER_ID: "+WORKER_ID+", FIRST_NAME: "+FIRST_NAME+", LAST_NAME: "+LAST_NAME+
                ", SALARY: "+SALARY+", JOINING_DATE: "+JOINING_DATE+", DEPARTMENT: "+DEPARTMENT;
    }
    

}

