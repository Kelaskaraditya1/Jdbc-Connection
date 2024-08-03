package Singleton;
import Keys.Keys;
import java.sql.Connection;
import java.sql.DriverManager;
public class JdbcSingleton {
    public static void getConnectionInstance(){
        try {
            Class.forName(Keys.DRIVER);
            Connection connection = DriverManager.getConnection(Keys.URL,Keys.USERNAME,Keys.PASSWORD);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
