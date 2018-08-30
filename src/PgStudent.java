
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import static javax.swing.DropMode.INSERT;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class PgStudent {
    public void insertUpdateDeleteStudent(char operation, int sid, String fname, String lname, String gender, String address, String city, String nic, 
                                          String contact, String email, String dob, String qt, String institute, String yoc, String faculty, String course){
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        if (operation == 'i'){
            try {
                ps = con.prepareStatement("INSERT INTO postgraduate_student(First_Name, Last_Name, Gender, Address, City, NIC, Contact, Email, "
                        + "Date_of_birth, Qualification_Type, Institute, Year_of_completion, Faculty, Course) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)" );
                ps.setString(1, fname);        
                ps.setString(2, lname);
                ps.setString(3, gender);
                ps.setString(4, address);
                ps.setString(5, city);
                ps.setString(6, nic);
                ps.setString(7, contact);
                ps.setString(8, email);
                ps.setString(9, dob);
                ps.setString(10, qt);
                ps.setString(11, institute);
                ps.setString(12, yoc);
                ps.setString(13, faculty);
                ps.setString(14, course);
                if (ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "New Student Added");
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(PgStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (operation == 'u'){
            try {
                ps = con.prepareStatement("UPDATE `postgraduate_student` SET `First_Name`= ?, `Last_Name`= ?, `Gender`= ?, "
                                          + "`Address`= ?, `City`= ?, `NIC`= ?, `Contact`= ?, `Email`= ?, `Date_of_birth`= ?, "
                                          + "`Qualification_Type`= ?, `Institute`= ?, `Year_of_completion`= ?, `Faculty`= ?, "
                                          + "`Course`= ? WHERE `Student_id`= ?" );
                ps.setString(1, fname);        
                ps.setString(2, lname);
                ps.setString(3, gender);
                ps.setString(4, address);
                ps.setString(5, city);
                ps.setString(6, nic);
                ps.setString(7, contact);
                ps.setString(8, email);
                ps.setString(9, dob);
                ps.setString(10, qt);
                ps.setString(11, institute);
                ps.setString(12, yoc);
                ps.setString(13, faculty);
                ps.setString(14, course);
                ps.setInt(15, sid);
                if (ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Student Data Updated");
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(PgStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        if (operation == 'd'){
            try {
                ps = con.prepareStatement("DELETE FROM `postgraduate_student` WHERE `Student_id`= ?" );
                ps.setInt(1, sid);
                if (ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Student Deleted");
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(PgStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void fillPgStudentJtable (JTable table, String valueToSearch){
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("SELECT * FROM `postgraduate_student` WHERE CONCAT (First_Name, Last_Name, Contact, Address) LIKE ?");
            ps.setString(1, "%"+ valueToSearch +"%");
            
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object [] row;
            while (rs.next()){
                row = new Object[15];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                row[7] = rs.getString(8);
                row[8] = rs.getString(9);
                row[9] = rs.getString(10);
                row[10] = rs.getString(11);
                row[11] = rs.getString(12);
                row[12] = rs.getString(13);
                row[13] = rs.getString(14);
                row[14] = rs.getString(15);
                
                model.addRow(row);
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PgStudent.class.getName()).log(Level.SEVERE, null, ex);
           
        }
    }
    
    /*void insertUpdateDeleteStudent(char c, Object object, String fname, String lname, String address, String city, String nic, String contact, String dob, String alresult, String zscore, String rank) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void insertUpdateDeleteStudent(char c, Object object, String fname, String lname, String address, String city, String nic, String contact, String email, String dob, String qt, String institute, String yoc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    void insertUpdateDeleteStudent(char c, Object object, String fname, String lname, String gender, String address, String city, String nic, String contact, String email, String dob, String qt, String institute, String yoc, String[] faculty, String[] course) {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void fillStudentJtable(JTable jTable1, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void insertUpdateDeleteStudent(char c, Object object, String fname, String lname, String gender, String address, String city, String nic, String contact, String email, String dob, String qt, String institute, String yoc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void insertUpdateDeleteStudent(char c, String sid, String fname, String lname, String gender, String address, String city, String nic, String contact, String email, String dob, String qt, String institute, String yoc, String faculty, String course) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void insertUpdateDeleteStudent(char c, Object object, String fname, String lname, String gender, String address, String city, String nic, String contact, String email, String qt, String institute, String yoc, String faculty, String course) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
