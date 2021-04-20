package com.company;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQException;
import java.util.Scanner;

public class ProvaGestorBD {

    public static void main(String[] args) throws XQException {
        Scanner scanner = new Scanner(System.in);
	    XQConnection conn = GestorDB.constructor();
	    String codi;
	    String nom;
	    String localidad;
        System.out.println("Conectando");

        System.out.println("\nIntroduce un codigo para ver el Departamento. (10, 20, 30 y 40)");
        System.out.println(GestorDB.getDeptSenseEmp(conn, "d" + scanner.next()).noEmps());

        System.out.println("\nIntroduce un codigo para ver el Departamento y sus Empleados. (10, 20, 30 y 40)");
        System.out.println(GestorDB.getDeptAmbEmp(conn, "d" + scanner.next()).withEmps());

        System.out.println("\nInsertando un nuevo departamento... Introduce un codigo nuevo");
        codi = scanner.next();
        System.out.println("... Introduce un nombre al departamento");
        nom = scanner.next();
        System.out.println("... Introduce la localidad del departamento");
        localidad = scanner.next();
        GestorDB.insertDept(conn,  "d" + codi, nom, localidad);

        GestorDB.tancarSessio(conn);
        System.out.println("\nDesconectando");
    }
}
