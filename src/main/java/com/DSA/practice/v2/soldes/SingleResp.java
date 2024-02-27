package com.DSA.practice.v2.soldes;

public class SingleResp {

    public void createEmp(){
        System.out.println("emp craeted");
    }

    public void deleteEmp(){
        System.out.println("emp craeted");
    }

    public void updEmp(String type){
        if(type.equals("permanent")) {
            System.out.println("permanent emp craeted");
        }else
        if(type.equals("contract")) {
            System.out.println("contract emp craeted");
        }
    }
}
