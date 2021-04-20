package com.company;

import net.xqj.exist.ExistXQDataSource;
import net.xqj.exist.bin.E;

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
        XQExpression xqExpression = conn.createExpression();

        String empCodi = "doc('/db/emp/empresa.xml')/empresa/empleats/emp[@dept='" + codi + "']/@codi/string()";
        String nom = "doc('/db/emp/empresa.xml')/empresa/departaments/dept[@codi='" + codi + "']/nom/string()";
        String local = "doc('/db/emp/empresa.xml')/empresa/departaments/dept[@codi='" + codi + "']/localitat/string()";

        XQResultSequence empCodixqrs = xqExpression.executeQuery(empCodi);
        XQResultSequence nomxqrs = xqExpression.executeQuery(nom);
        XQResultSequence localxqrs = xqExpression.executeQuery(local);

        while (empCodixqrs.next()) {
            Emp emp = new Emp();

            emp.setCodi(empCodixqrs.getItemAsString(null));

            String empCap = "doc('/db/emp/empresa.xml')/empresa/empleats/emp[@codi='" + emp.getCodi() + "']/@cap/string()";
            String empDept = "doc('/db/emp/empresa.xml')/empresa/empleats/emp[@codi='" + emp.getCodi() + "']/@dept/string()";
            String empCognom = "doc('/db/emp/empresa.xml')/empresa/empleats/emp[@codi='" + emp.getCodi() + "']/cognom/string()";
            String empOfici = "doc('/db/emp/empresa.xml')/empresa/empleats/emp[@codi='" + emp.getCodi() + "']/ofici/string()";
            String empDataAlta = "doc('/db/emp/empresa.xml')/empresa/empleats/emp[@codi='" + emp.getCodi() + "']/dataAlta/string()";
            String empSalari = "doc('/db/emp/empresa.xml')/empresa/empleats/emp[@codi='" + emp.getCodi() + "']/salari/string()";
            String empComissio = "doc('/db/emp/empresa.xml')/empresa/empleats/emp[@codi='" + emp.getCodi() + "']/comissio/string()";

            XQResultSequence empCapxqrs = xqExpression.executeQuery(empCap);
            XQResultSequence empDeptxqrs = xqExpression.executeQuery(empDept);
            XQResultSequence empCognomxqrs = xqExpression.executeQuery(empCognom);
            XQResultSequence empOficixqrs = xqExpression.executeQuery(empOfici);
            XQResultSequence empDataAltaxqrs = xqExpression.executeQuery(empDataAlta);
            XQResultSequence empSalarixqrs = xqExpression.executeQuery(empSalari);
            XQResultSequence empComissioxqrs = xqExpression.executeQuery(empComissio);


            while (empCapxqrs.next()) {
                emp.setCodiCap(empCapxqrs.getItemAsString(null));
            }

            while (empDeptxqrs.next()) {
                emp.setCodiDept(empDeptxqrs.getItemAsString(null));
            }

            while (empCognomxqrs.next()) {
                emp.setCognom(empCognomxqrs.getItemAsString(null));
            }

            while (empOficixqrs.next()) {
                emp.setOfici(empOficixqrs.getItemAsString(null));
            }

            while (empDataAltaxqrs.next()) {
                emp.setDataAlta(empDataAltaxqrs.getItemAsString(null));
            }

            while (empSalarixqrs.next()) {
                emp.setSalari(empSalarixqrs.getItemAsString(null));
            }

            while (empComissioxqrs.next()) {
                emp.setComissio(empComissioxqrs.getItemAsString(null));
            }

            empList.add(emp);

        }

        while (nomxqrs.next() && localxqrs.next()) {
            return new Dept(codi, nomxqrs.getItemAsString(null), localxqrs.getItemAsString(null), empList);
        }
        return new Dept(null, null, null, null);
    }

    public static void insertDept(XQConnection conn, String codi, String nom, String localidad) throws XQException {
        String deptExpr = "update insert \n" +
                "<dept codi='" + codi + "'><nom>" + nom + "</nom><localitat>" + localidad + "</localitat></dept> \n" +
                "preceding doc('/db/emp/empresa.xml')//empresa/departaments/dept[1]";
        System.out.println(deptExpr);
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
