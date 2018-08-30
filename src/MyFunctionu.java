
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



public class MyFunctionu {
    
    public static int countData(String tableName){
        int total2 = 0;
        Connection con = MyConnection.getConnection();
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS 'total2' FROM "+tableName);
            while (rs.next()){
                total2 = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyFunctionp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return total2;
    }
    
}

