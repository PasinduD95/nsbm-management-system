
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Lecturer {
    
    public void insertUpdateDeleteLecturer(char operation, int lecid, String fname, String lname, String address, String contact, 
                                            String room, String teachsub){
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        if (operation == 'i'){
            try {
                ps = con.prepareStatement("INSERT INTO lecturer(Fname, Lname, Address, Contact, Room, Teach_sub) VALUES (?,?,?,?,?,?)" );
                ps.setString(1, fname);        
                ps.setString(2, lname);
                ps.setString(3, address);
                ps.setString(4, contact);
                ps.setString(5, room);
                ps.setString(6, teachsub);
                if (ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "New Lecturer Added");
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(Lecturer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (operation == 'u'){
            try {
                ps = con.prepareStatement("UPDATE `lecturer` SET `Fname`= ?,`Lname`= ?,`Address`= ?,`Contact`= ?,`Room`= ?,`Teach_sub`= ? WHERE `Lec_id` = ?" );
                ps.setString(1, fname);        
                ps.setString(2, lname);
                ps.setString(3, address);
                ps.setString(4, contact);
                ps.setString(5, room);
                ps.setString(6, teachsub);
                ps.setInt(7, lecid);
                if (ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Lecturer Data Updated");
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(PgStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        if (operation == 'd'){
            try {
                ps = con.prepareStatement("DELETE FROM `lecturer` WHERE `Lec_id` = ?" );
                ps.setInt(1, lecid);
                if (ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Lecturer Deleted");
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(PgStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void fillLecturerJtable (JTable table, String valueToSearch){
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("SELECT * FROM `lecturer` WHERE CONCAT (Fname, Lname, Contact, Address) LIKE ?");
            ps.setString(1, "%"+ valueToSearch +"%");
            
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object [] row;
            while (rs.next()){
                row = new Object[7];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                
                
                model.addRow(row);
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PgStudent.class.getName()).log(Level.SEVERE, null, ex);
           
        }
    }

    void insertUpdateDeleteStudent(char c, Object object, String fname, String lname, String address, String contact, String room, String teachsub) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
