package com.company;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQException;

public class ProvaGestorBD {

    public static void main(String[] args) throws XQException {
	    XQConnection conn = GestorDB.constructor();
        System.out.println("Conectado");

        GestorDB.getDeptSenseEmp(conn, "d20");

        GestorDB.tancarSessio(conn);
        System.out.println("Desconectado");
    }
}
