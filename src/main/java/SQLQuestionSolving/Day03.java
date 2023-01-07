package SQLQuestionSolving;

import java.sql.*;

public class Day03 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Flrnc555*");
        Statement st = con.createStatement();

       /* String sql1 = "create table patients(patient_id INT," +
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
      //  System.out.println(st.execute(sql2));

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
        //1)Based on the cities that our patients live in, show unique cities that are in province_id 'NS'?
        //Translate :Hastalarımızın yaşadığı şehirlere dayanarak,ilde bulunan benzersiz şehirleri gösterin_id 'NS'?

/*
String s1="select distinct city, province_id from patients where province_id='ON'";

ResultSet rs1= st.executeQuery(s1);
        while (rs1.next()){
            System.out.println(rs1.getString(1)+"---"+rs1.getString(2));
        }
*/

        //2)write a query to find the first_name, last name, and birth date of patients who have height more than 160 and weight more than 70
        //Translate :boyu 160'ın üzerinde, kilosu 70'in üzerinde olan hastaların adı, soyadı ve doğum tarihini bulmak için bir sorgu yazın

      /*  String s2 = "select first_name, last_name, birth_date from patients where weight>70 and height>160";
        ResultSet rs2 = st.executeQuery(s2);
        while (rs2.next()){
            System.out.println(rs2.getString(1)+"---"+rs2.getString(2)+"---"+rs2.getString(3));
        }
*/
        //3) write a Query to find list of patients firs_name, last_name, and allergies from city  'Hamilton' where allergies is not null
        //Translate :alerjilerin boş olmadığı 'Hamilton' şehrinden firs_name, last_name ve alerji hastalarının listesini bulmak için bir Sorgu yazın
        //  ==> hamilton şehrinde allerjilerin not null olduğu kayıtların isim, soy isim bilgilerini getir.

      /*  String s3="select first_name, last_name, allergies from patients where city='Hamilton' and allergies is not null";

        ResultSet rs3= st.executeQuery(s3);

        while (rs3.next()){
            System.out.println(rs3.getString(1)+"---"+rs3.getString(2)+"---"+rs3.getString(3));
        }*/

        //4) Based on cities where our patient lives in write a query to display the list of unique city starting with a vowel(a, e, i, o, u).
        // Show the result order in ascending by city.
        //Translate :Hastamızın yaşadığı şehirlere dayanarak, sesli harfle (a, e, i, o, u) başlayan benzersiz şehir listesini görüntülemek için bir sorgu yazın.
        // Sonuç sırasını şehre göre artan olarak göster.

        /*String s4="select distinct city from patients where  city ~ '^[AEIOU]' order by city";
        ResultSet rs4= st.executeQuery(s4);
        while (rs4.next()){
            System.out.println(rs4.getString(1));
        }
*/
        //5) show unique birth years from patients and order them by ascending
        //Translate :hastalardan benzersiz doğum yıllarını gösterin ve onları yükselerek sipariş edin

       /* String s5="select distinct extract(year from birth_date) as year from patients order by year";
        ResultSet rs5= st.executeQuery(s5);
        while(rs5.next()){
            System.out.println(rs5.getString(1));
        }
*/
        //6) show unique first names from the  patients table which only occurs once in the list.
        //For example, if two or more people are named John'in the first_name column then don't  include them in the output.
        //Translate :listede yalnızca bir kez oluşan hastalar tablosundan benzersiz adlar gösterin.
        //Örneğin, first_name sütununda iki veya daha fazla kişiye John adı verilirse, bunları çıktıya eklemeyin.

     /*   String s6="select  distinct city, sum(weight) from patients group by city";

        ResultSet rs6= st.executeQuery(s6);

        while (rs6.next()){
            System.out.println(rs6.getString(1)+"---"+rs6.getString(2));
        }*/

        //7) show patient_id and first_name from patients where their first _name start and ends with  's' and ia at least 6 characters long.
        //Translate :ilk _name'lerinin 's' ile başlayıp bittiği ve en az 6 karakter uzunluğunda olduğu hastalardan patient_id ve first_name göster.

        String s7="select patient_id, first_name from patients where first_name ~~ 'C____%c' ";

        ResultSet rs7= st.executeQuery(s7);

        while (rs7.next()){
            System.out.println(rs7.getString(1)+"---"+rs7.getString(2));
        }

        //8) Show patient_id, first_name, last_name from patients whos diagnosis is 'Dementia'.
        //Primary diagnosis is stored in the admissions table.
        //Translate :Tanısı 'Demans' olan hastalardan patient_id, first_name, last_name göster.
        // Birincil tanı kabul tablosunda saklanır.



    }


}
