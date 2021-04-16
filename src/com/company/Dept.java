package com.company;

import java.util.List;

public class Dept {
    String codi;
    String nom;
    String localitat;
    List<Emp> empList;

    public Dept(String codi, String nom, String localitat, List<Emp> empList) {
        this.codi = codi;
        this.nom = nom;
        this.localitat = localitat;
        this.empList = empList;
    }

    public String noEmps() {
        return "Dept{" +
                "codi='" + codi + '\'' +
                ", nom='" + nom + '\'' +
                ", localitat='" + localitat + '\'' +
                '}';
    }

    public String withEmps() {
        return "Dept{" +
                "codi='" + codi + '\'' +
                ", nom='" + nom + '\'' +
                ", localitat='" + localitat + '\'' +
                ", emps='" + empList + '\'' +
                '}';
    }
}
