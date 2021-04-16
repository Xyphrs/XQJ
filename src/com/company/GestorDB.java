package com.company;

import net.xqj.exist.ExistXQDataSource;

import javax.xml.xquery.*;
import java.util.ArrayList;
import java.util.List;

public class GestorDB {
    public static XQConnection constructor() throws XQException {
        XQDataSource xqs = new ExistXQDataSource();

        xqs.setProperty("serverName", "localhost");
        xqs.setProperty("port", "8080");

        return xqs.getConnection();
    }

    public static Dept getDeptSenseEmp(XQConnection conn, String codi) throws XQException {
        String nom = "doc('/db/emp/empresa.xml')//empresa/departaments/dept[@codi='" + codi + "']/nom/string()";
        String local = "doc('/db/emp/empresa.xml')//empresa/departaments/dept[@codi='" + codi + "']/localitat/string()";

        XQPreparedExpression nomxqe = conn.prepareExpression(nom);
        XQPreparedExpression localxqe = conn.prepareExpression(local);
        XQResultSequence nomxqrs = nomxqe.executeQuery();
        XQResultSequence localxqrs = localxqe.executeQuery();


        while (nomxqrs.next() && localxqrs.next()) {
            return new Dept(codi, nomxqrs.getItemAsString(null), localxqrs.getItemAsString(null), null);
        }
        return new Dept(null, null, null, null);
    }

    public static Dept getDeptAmbEmp(XQConnection conn, String codi) throws XQException {
        List<Emp> empList = new ArrayList<>();

        String nom = "doc('/db/emp/empresa.xml')//empresa/departaments/dept[@codi='" + codi + "']/nom/string()";
        String local = "doc('/db/emp/empresa.xml')//empresa/departaments/dept[@codi='" + codi + "']/localitat/string()";
        String empCodi = "doc('/db/emp/empresa.xml')//empresa/empleats/emp[@dept='" + codi + "']/@codi/string()";
        String empCap = "doc('/db/emp/empresa.xml')//empresa/empleats/emp[@dept='" + codi + "']/@cap/string()";
        String empCognom = "doc('/db/emp/empresa.xml')//empresa/empleats/emp[@dept='" + codi + "']/cognom/string()";
        String empOfici = "doc('/db/emp/empresa.xml')//empresa/empleats/emp[@dept='" + codi + "']/ofici/string()";
        String empDataAlta = "doc('/db/emp/empresa.xml')//empresa/empleats/emp[@dept='" + codi + "']/dataAlta/string()";
        String empSalari = "doc('/db/emp/empresa.xml')//empresa/empleats/emp[@dept='" + codi + "']/salari/string()";
        String empComissio = "doc('/db/emp/empresa.xml')//empresa/empleats/emp[@dept='" + codi + "']/comissio/string()";

        XQPreparedExpression nomxqe = conn.prepareExpression(nom);
        XQPreparedExpression localxqe = conn.prepareExpression(local);
        XQPreparedExpression empCodixqe = conn.prepareExpression(empCodi);
        XQPreparedExpression empCapxqe = conn.prepareExpression(empCap);
        XQPreparedExpression empCognomxqe = conn.prepareExpression(empCognom);
        XQPreparedExpression empOficixqe = conn.prepareExpression(empOfici);
        XQPreparedExpression empDataAltaxqe = conn.prepareExpression(empDataAlta);
        XQPreparedExpression empSalarixqe = conn.prepareExpression(empSalari);
        XQPreparedExpression empComissioxqe = conn.prepareExpression(empComissio);

        XQResultSequence nomxqrs = nomxqe.executeQuery();
        XQResultSequence localxqrs = localxqe.executeQuery();
        XQResultSequence empCodixqrs = empCodixqe.executeQuery();
        XQResultSequence empCapxqrs = empCapxqe.executeQuery();
        XQResultSequence empCognomxqrs = empCognomxqe.executeQuery();
        XQResultSequence empOficixqrs = empOficixqe.executeQuery();
        XQResultSequence empDataAltaxqrs = empDataAltaxqe.executeQuery();
        XQResultSequence empSalarixqrs = empSalarixqe.executeQuery();
        XQResultSequence empComissioxqrs = empComissioxqe.executeQuery();

        if (!empComissioxqrs.next()) {
            while (empCodixqrs.next() && empCapxqrs.next() && empCognomxqrs.next() && empOficixqrs.next() && empDataAltaxqrs.next() && empSalarixqrs.next()) {
                empList.add(new Emp(empCodixqrs.getItemAsString(null), codi, empCapxqrs.getItemAsString(null), empCognomxqrs.getItemAsString(null),
                        empOficixqrs.getItemAsString(null), empDataAltaxqrs.getItemAsString(null), empSalarixqrs.getItemAsString(null)));
            }
        } else {
            while (empCodixqrs.next() && empCapxqrs.next() && empCognomxqrs.next() && empOficixqrs.next() && empDataAltaxqrs.next() && empSalarixqrs.next() && empComissioxqrs.next()) {
                empList.add(new Emp(empCodixqrs.getItemAsString(null), codi, empCapxqrs.getItemAsString(null), empCognomxqrs.getItemAsString(null),
                        empOficixqrs.getItemAsString(null), empDataAltaxqrs.getItemAsString(null), empSalarixqrs.getItemAsString(null), empComissioxqrs.getItemAsString(null)));
            }

        }


        while (nomxqrs.next() && localxqrs.next()) {
            return new Dept(codi, nomxqrs.getItemAsString(null), localxqrs.getItemAsString(null), empList);
        }
        return new Dept(null, null, null, null);
    }

    public static void insertDept(XQConnection conn) throws XQException {
        String deptExpr = "update insert \n" +
                "<dept codi='50'><nom>Compras</nom><localitat>Murcia</localitat></dept> \n" +
                "preceding doc('/db/emp/empresa.xml')//empresa/departaments";
        XQPreparedExpression deptXqe = conn.prepareExpression(deptExpr);
        XQResultSequence deptXqrs = deptXqe.executeQuery();

        while (deptXqrs.next()) {
            System.out.println(deptXqrs);
        }
    }

    public static void deleteDept(XQConnection conn) throws XQException {

    }

    public static void replaceDept(XQConnection conn) throws XQException {

    }

    public static void tancarSessio(XQConnection conn) throws XQException {
        conn.close();
    }
}
