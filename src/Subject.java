
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Subject {
    
    public void insertUpdateDeleteSubject(char operation, String scode, String sname, String grade, int credit, Double fee){
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        if (operation == 'i'){
            try {
                ps = con.prepareStatement("INSERT INTO subject(Subject_Code, Subject_Name, Grade, Credit, Fee) VALUES (?,?,?,?,?)" );
                ps.setString(1, scode);        
                ps.setString(2, sname);
                ps.setString(3, grade);
                ps.setInt(4, credit);
                ps.setDouble(5, fee);
                if (ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "New Subject Added");
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(PgStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (operation == 'u'){
            try {
                ps = con.prepareStatement("UPDATE `subject` SET `Subject_Name`=?,`Grade`=<,`Credit`=?,`Fee`=? WHERE `Subject_Code` = ?" );        
                ps.setString(1, sname);
                ps.setString(2, grade);
                ps.setInt(3, credit);
                ps.setDouble(4, fee);
                ps.setString(5, scode);
                if (ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Subject Data Updated");
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(PgStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        if (operation == 'd'){
            try {
                ps = con.prepareStatement("DELETE FROM `subject` WHERE `Subject_Code` = ?" );
                ps.setString(1, scode);
                if (ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Subject Deleted");
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void fillSubjectJtable (JTable table, String valueToSearch){
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("SELECT * FROM `subject` WHERE CONCAT (Subject_Name, Grade, Credit) LIKE ?");
            ps.setString(1, "%"+ valueToSearch +"%");
            
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object [] row;
            while (rs.next()){
                row = new Object[5];
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getInt(4);
                row[4] = rs.getDouble(5);
                
                
                model.addRow(row);
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PgStudent.class.getName()).log(Level.SEVERE, null, ex);
           
        }
    }

}
