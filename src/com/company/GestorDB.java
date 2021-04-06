package com.company;

import net.xqj.exist.ExistXQDataSource;

import javax.xml.xquery.*;

public class GestorDB {

    public static XQConnection constructor() throws XQException {
        XQDataSource xqs = new ExistXQDataSource();

        xqs.setProperty("serverName", "localhost");
        xqs.setProperty("port", "8080");

        XQConnection conn = xqs.getConnection();

        String expr = "doc('/db/emp/empresa.xml')//empresa/departaments";
        XQPreparedExpression xqe = conn.prepareExpression(expr);
        XQResultSequence xqrs = xqe.executeQuery();


        return conn;
    }

    public static void getDeptSenseEmp(XQConnection conn, String codi) throws XQException {
        String expr = "doc('/db/emp/empresa.xml')//empresa/departaments/dept[@codi='"+ codi +"']";
        XQPreparedExpression xqe = conn.prepareExpression(expr);

        XQResultSequence xqrs = xqe.executeQuery();
        while (xqrs.next()){
            System.out.println(xqrs.getItemAsString(null));
        }
    }

    public static void getDeptAmbEmp(XQConnection conn) throws XQException {

    }

    public static void insertDept(XQConnection conn) throws XQException {

    }

    public static void deleteDept(XQConnection conn) throws XQException {

    }

    public static void replaceDept(XQConnection conn) throws XQException {

    }

    public static void tancarSessio(XQConnection conn) throws XQException {
        conn.close();
    }
}
