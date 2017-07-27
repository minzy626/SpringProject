 
import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
 
public class mysqltest {
 
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://127.0.0.1/board";
    private final String USER ="root";
    private final String PW = "tiger";
    
    @Test
    public void test() {
        //제발 돼라 더ㅙ라더래ㅑㄴㅇ;ㄹ
        try {
            Class.forName(DRIVER);
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection con = DriverManager.getConnection(URL, USER, PW)){
            System.out.println(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
 
}
 
