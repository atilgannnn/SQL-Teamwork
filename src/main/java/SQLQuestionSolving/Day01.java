package SQLQuestionSolving;

import java.sql.*;

public class Day01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Flrnc555*");

        Statement st = con.createStatement();


        String sql1 = "CREATE TABLE patients(patient_id INT," +
                "first_name TEXT," +
                "last_name TEXT," +
                "gender CHAR(1)," +
                "birth_date DATE," +
                "city TEXT," +
                "province_id CHAR(2)," +
                "allergies TEXT," +
                "height INT," +
                "weight INT);";

//        st.execute(sql1);

        String sql2 = "INSERT INTO patients VALUES(1,'Donald','Waterfield','M','1963-02-12','Barrie','ON',NULL,156,65);"+
                "INSERT INTO patients VALUES(2,'Mickey','Baasha','M','1981-05-28','Dundas','ON','Sulfa',185,76);"+
                "INSERT INTO patients VALUES(3,'Jiji','Sharma','M','1957-09-05','Hamilton','ON','Penicillin',194,68);";

//        st.execute(sql2);

//        String sql3 = "Select first_name, last_name, gender From patients Where gender = 'M';";
//
//        ResultSet rs1 = st.executeQuery(sql3);
//
//        while (rs1.next()){
//
//            System.out.printf("%-15s  %15s  %15s  %n",rs1.getString(1),rs1.getString(2),rs1.getString(3));
//            System.out.format("%-15s  %15s  %15s  %n",rs1.getString(1),rs1.getString(2),rs1.getString(3));
//
//        }

//        String sql5 = "Drop Table patients";
//
//        st.execute(sql5);


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

//        st.execute(sql3);

//        String sql4 = "Select first_name, last_name From patients Where allergies IS NULL;";
//
//        ResultSet rs2 = st.executeQuery(sql4);
//
//        while (rs2.next()){
//
//            System.out.println(rs2.getString(1)+" "+rs2.getString(2));
//
//        }

        String sql6 = "Select first_name From patients Where first_name LIKE 'C%' ";

        ResultSet rs3 = st.executeQuery(sql6);

        while (rs3.next()){

            System.out.println(rs3.getString(1));

        }
    }



}
