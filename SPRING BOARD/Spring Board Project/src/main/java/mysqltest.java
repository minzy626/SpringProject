 
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
        //Á¦¹ß µÅ¶ó
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
 
