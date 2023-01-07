package SQLQuestionSolving;

import java.sql.*;

public class Day04 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Flrnc555*");
        Statement st = con.createStatement();
        System.out.println("DatabaseMetaData");
//
//        String sql1 = "create table patients(patient_id INT," +
//                "first_name TEXT," +
//                "last_name TEXT," +
//                "gender CHAR(1)," +
//                "birth_date DATE," +
//                "city TEXT," +
//                "province_id CHAR(2)," +
//                "allergies TEXT," +
//                "height INT," +
//                "weight INT);";
        // System.out.println(st.execute(sql1));
        //String sql2 = "drop table patients";
        //System.out.println(st.execute(sql2));
//
//        String sql3 = "insert into patients values (1,'Donald','Waterfield','M','1963-02-12','Barrie','ON',NULL,156,65);" +
//                "insert into patients values (2,'Mickey','Baasha','M','1981-05-28','Dundas','ON','Sulfa',185,76);" +
//                "insert into patients values (3,'Jiji','Sharma','M','1957-09-05','Hamilton','ON','Penicillin',194,106);" +
//                "insert into patients values (4,'Blair','Diaz','M','1967-01-07','Hamilton','ON',NULL,191,104);" +
//                "insert into patients values (5,'Charles','Wolfe','M','2017-11-19','Orillia','ON','Penicillin',47,10);" +
//                "insert into patients values (6,'Sue','Falcon','F','2017-09-30','Ajax','ON','Penicillin',43,5);" +
//                "insert into patients values (7,'Thomas','ONeill','M','1993-01-31','Burlington','ON',NULL,180,117);" +
//                "insert into patients values (8,'Sonny','Beckett','M','1952-12-11','PortHawkesbury','NS',NULL,174,105);" +
//                "insert into patients values (9,'Sister','Spitzer','F','1966-10-15','Toronto','ON','Penicillin',173,95);" +
//                "insert into patients values (10,'Cedric','Coltrane','M','1961-11-10','Toronto','ON',NULL,157,61);"+
//                "insert into patients values (11,'Sister','Spitzer','F','1966-10-15','Toronto','ON','Penicillin',173,95)";
//        st.execute(sql3);

        /*  1)Display every patient's first_name.
         Order the list by the length of each name and then by alphbetically */

        String s1="SELECT first_name FROM patients  ORDER BY LENGTH (first_name),first_name ";
        ResultSet rs1=st.executeQuery(s1);
        while (rs1.next()){
            System.out.println(rs1.getString(1));
        }

        /*
        2)Show the total amount of male patients and the total amount of female patients in the patients table.
        Display the two results in the same row. */

        String s2="SELECT count (gender ) FROM patients GROUP BY gender";

        /*
        3)Show first and last name, allergies from patients which have allergies to either 'Penicillin' or 'Morphine'. Show results ordered ascending
        by allergies then by first_name then by last_name. */

        String s3="SELECT first_name, last_name,allergies FROM patients WHERE allergies IN ('Penicillin' , 'Morphine') ORDER BY allergies, first_name,last_name";
        ResultSet rs3=st.executeQuery(s3);
        while (rs3.next()){
            System.out.println(rs3.getString(1)+ "---"+ rs3.getString(2)+ "---"+rs3.getString(3));
        }


    }




}
