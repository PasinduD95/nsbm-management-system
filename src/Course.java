
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Course {
    
    public void insertUpdateDeleteStudent(char operation, String cid, String cname, int duration, String credit){
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        if (operation == 'i'){
            try {
                ps = con.prepareStatement("INSERT INTO course (Course_id, Course_name, Duration, Credit) VALUES (?,?,?,?)" );
                ps.setString(1, cid);        
                ps.setString(2, cname);
                ps.setInt(3, duration);
                ps.setString(4, credit);
                if (ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "New Course Added");
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(PgStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (operation == 'u'){
            try {
                ps = con.prepareStatement("UPDATE `course` SET `Course_name`= ?,`Duration`= ?,`Credit`= ? WHERE `Course_id` = ?" );        
                ps.setString(1, cname);
                ps.setInt(2, duration);
                ps.setString(3, credit);
                ps.setString(4, cid);
                
                if (ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Course Data Updated");
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(PgStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        if (operation == 'd'){
            try {
                ps = con.prepareStatement("DELETE FROM `course` WHERE `Course_id` = ?" );
                ps.setString(1, cid);
                if (ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Course Deleted");
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean isCourseExist(String courseName){
        
        boolean isExist = false;
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("SELECT * FROM `course` WHERE `Course_name` = ?");
            ps.setString(1, courseName);
            
            ResultSet rs = ps.executeQuery();
                  
            
            if (rs.next()){
              isExist = true;
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PgStudent.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        return isExist;
        
    }
    
    public void fillCourseJtable (JTable table){
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("SELECT * FROM `course`");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object [] row;
            while (rs.next()){
                row = new Object[4];
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getInt(3);
                row[3] = rs.getString(4);
                
                model.addRow(row);
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PgStudent.class.getName()).log(Level.SEVERE, null, ex);
           
        }
    }

    void insertUpdateDeleteStudent(char c, String cid, Object object, Object object0, Object object1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
