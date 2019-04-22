package com.watson.delegate.simple;

import java.util.HashMap;
import java.util.Map;

public class Leader implements IEmployee {

    private Map<String, IEmployee> register = new HashMap<>();

    public Leader(){
        register.put("加密", new EmployeeA());
        register.put("架构", new EmployeeB());
    }
    @Override
    public void doing(String command){
        register.get(command).doing(command);
    }
}
