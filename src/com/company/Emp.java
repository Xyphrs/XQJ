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

    public Emp() {}

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getCodiDept() {
        return codiDept;
    }

    public void setCodiDept(String codiDept) {
        this.codiDept = codiDept;
    }

    public String getCodiCap() {
        return codiCap;
    }

    public void setCodiCap(String codiCap) {
        this.codiCap = codiCap;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getOfici() {
        return ofici;
    }

    public void setOfici(String ofici) {
        this.ofici = ofici;
    }

    public String getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(String dataAlta) {
        this.dataAlta = dataAlta;
    }

    public String getSalari() {
        return salari;
    }

    public void setSalari(String salari) {
        this.salari = salari;
    }

    public String getComissio() {
        return comissio;
    }

    public void setComissio(String comissio) {
        this.comissio = comissio;
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
