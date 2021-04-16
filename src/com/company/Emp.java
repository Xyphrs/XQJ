package com.company;

public class Emp {
    String codi;
    String codiDept;
    String codiCap;
    String cognom;
    String ofici;
    String dataAlta;
    String salari;
    String comissio;

    public Emp(String codi, String codiDept, String codiCap, String cognom, String ofici, String dataAlta, String salari, String comissio) {
        this.codi = codi;
        this.codiDept = codiDept;
        this.codiCap = codiCap;
        this.cognom = cognom;
        this.ofici = ofici;
        this.dataAlta = dataAlta;
        this.salari = salari;
        this.comissio = comissio;
    }

    public Emp(String codi, String codiDept, String codiCap, String cognom, String ofici, String dataAlta, String salari) {
        this.codi = codi;
        this.codiDept = codiDept;
        this.codiCap = codiCap;
        this.cognom = cognom;
        this.ofici = ofici;
        this.dataAlta = dataAlta;
        this.salari = salari;
    }



    @Override
    public String toString() {
        return "\nEmp{" +
                "codi='" + codi + '\'' +
                ", codiDept='" + codiDept + '\'' +
                ", codiCap='" + codiCap + '\'' +
                ", cognom='" + cognom + '\'' +
                ", ofici='" + ofici + '\'' +
                ", dataAlta='" + dataAlta + '\'' +
                ", salari='" + salari + '\'' +
                ", comissio='" + comissio + '\'' +
                '}';
    }
}
