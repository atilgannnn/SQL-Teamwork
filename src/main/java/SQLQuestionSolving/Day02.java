package SQLQuestionSolving;

import java.sql.*;

public class Day02 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Flrnc555*");
        Statement st = con.createStatement();


      /*  String sql1 = "create table patients(patient_id INT," +
                "first_name TEXT," +
                "last_name TEXT," +
                "gender CHAR(1)," +
                "birth_date DATE," +
                "city TEXT," +
                "province_id CHAR(2)," +
                "allergies TEXT," +
                "height INT," +
                "weight INT);";

        System.out.println(st.execute(sql1));

        // String sql2 = "drop table patients";
        // System.out.println(st.execute(sql2));

        String sql3 = "insert into patients values (1,'Donald','Waterfield','M','1963-02-12','Barrie','ON',NULL,156,65);" +
                "insert into patients values (2,'Mickey','Baasha','M','1981-05-28','Dundas','ON','Sulfa',185,76);" +
                "insert into patients values (3,'Jiji','Sharma','M','1957-09-05','Hamilton','ON','Penicillin',194,106);" +
                "insert into patients values (4,'Blair','Diaz','M','1967-01-07','Hamilton','ON',NULL,191,104);" +
                "insert into patients values (5,'Charles','Wolfe','M','2017-11-19','Orillia','ON','Penicillin',47,10);" +
                "insert into patients values (6,'Sue','Falcon','F','2017-09-30','Ajax','ON','Penicillin',43,5);" +
                "insert into patients values (7,'Thomas','ONeill','M','1993-01-31','Burlington','ON',NULL,180,117);" +
                "insert into patients values (8,'Sonny','Beckett','M','1952-12-11','PortHawkesbury','NS',NULL,174,105);" +
                "insert into patients values (9,'Sister','Spitzer','F','1966-10-15','Toronto','ON','Penicillin',173,95);" +
                "insert into patients values (10,'Cedric','Coltrane','M','1961-11-10','Toronto','ON',NULL,157,61);";

        st.execute(sql3);
        */

//        String s1 = "update patients set allergies='NKA'  where allergies is null;  ";
//        int dergisenSatir = st.executeUpdate(s1);
//        System.out.println("dergisenSatir = " + dergisenSatir);
        String s2 = "select first_name,last_name from patients where weight between 100 and  120; ";

        ResultSet rs2 = st.executeQuery(s2);
        //1.yol
//          while (rs2.next()) {
//              System.out.println(rs2.getString("first_name")+"---"+rs2.getString("last_name"));
//          }

        //2.yol

        for (; rs2.next(); ) {
            System.out.println(rs2.getString("first_name") + "---" + rs2.getString("last_name"));
        }

        //  String s3 = "select concat('sayin ',first_name,'_',last_name) as fullName  from patients";
        String s3 = "select first_name|| '_' || last_name as fullName  from patients";

        ResultSet rs3 = st.executeQuery(s3);

        while (rs3.next()){
            System.out.println(rs3.getString("fullName"));
        }

        String s4 = "select count(*) as sayi  from patients where extract(year from birth_date)='2017' ";

        ResultSet rs4 = st.executeQuery(s4);
        while (rs4.next()){
            System.out.println(rs4.getInt("sayi"));
        }

        String s5 = "select first_name,last_name,height  from patients where height=(select max(height) from patients)";
//        ResultSet rs5 = st.executeQuery(s5);
//        while (rs5.next()){
//            System.out.println(rs5.getString(1)+"--"+rs5.getString(2)+"--"+rs5.getString(3));
//        }
        String s6 = " select first_name,patient_id  from patients where patient_id  in (1,5,6)";
        ResultSet rs5 = st.executeQuery(s6);
        while (rs5.next()) {
            System.out.println(rs5.getString(1) + "--" + rs5.getString(2));

        }

    }








}
