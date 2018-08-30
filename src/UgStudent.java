
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class UgStudent {
    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
        public void insertUpdateDeleteStudent(char operation, Integer sid, String fname, String lname, String gender, 
                                              String address, String city, String nic, String contact, String email, 
                                              String dob, String alstream, String indexno, String rank, String zscore, 
                                              String faculty, String course){
        
        if (operation == 'i'){
            try {
                
                ps = con.prepareStatement("INSERT INTO undergraduate_student(First_Name, Last_Name, Gender, Address, City, "
                                          + "NIC, Contact, Email, Date_of_birth, AL_Stream, Index_No, Rank, ZScore, faculty, "
                                          + "course) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" );
                ps.setString(1, fname);        
                ps.setString(2, lname);
                ps.setString(3, gender);
                ps.setString(4, address);
                ps.setString(5, city);
                ps.setString(6, nic);
                ps.setString(7, contact);
                ps.setString(8, email);
                ps.setString(9, dob);
                ps.setString(10, alstream);
                ps.setString(11, indexno);
                ps.setString(12, rank);
                ps.setString(13, zscore);
                ps.setString(14, faculty);
                ps.setString(15, course);
                
                if (ps.executeUpdate() > 0){
                   JOptionPane.showMessageDialog(null, "New Student Added");
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(PgStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (operation == 'u'){
            try {
                
                ps = con.prepareStatement("UPDATE `undergraduate_student` SET `First_Name`= ?, `Last_Name`= ?, `Gender`= ?, "
                                          + "`Address`= ?, `City`= ?, `NIC`= ?, `Contact`= ?, `Email`= ?, `Date_of_birth`= ?, "
                                          + "`AL_Stream`= ?, `Index_No`= ?, `Rank`= ?, `ZScore`= ?, `Faculty`= ?, `Course`= ? "
                                          + "WHERE `Student_id` =?" );
                ps.setString(1, fname);        
                ps.setString(2, lname);
                ps.setString(3, gender);
                ps.setString(4, address);
                ps.setString(5, city);
                ps.setString(6, nic);
                ps.setString(7, contact);
                ps.setString(8, email);
                ps.setString(9, dob);
                ps.setString(10, alstream);
                ps.setString(11, indexno);
                ps.setString(12, rank);
                ps.setString(13, zscore);
                ps.setString(14, faculty);
                ps.setString(15, course);
                ps.setInt(7, sid);
                
                if (ps.executeUpdate() > 0){
                   JOptionPane.showMessageDialog(null, "Student Data Updated");
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(PgStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (operation == 'd'){
            try {
                
                ps = con.prepareStatement("DELETE FROM `undergraduate_student` WHERE `Student_id` = ?" );
                ps.setInt(1, sid);
                
                if (ps.executeUpdate() > 0){
                   JOptionPane.showMessageDialog(null, "Student Dele ted");
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(PgStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        
    public void fillUgStudentJtable (JTable table, String valueToSearch){
        
        try {
            ps = con.prepareStatement("SELECT * FROM `undergraduate_student` WHERE CONCAT (First_Name, Last_Name, Contact, Address) LIKE ?");
            ps.setString(1, "%"+ valueToSearch +"%");

            ResultSet rs = ps.executeQuery();
            DefaultTableModel model2 = (DefaultTableModel)table.getModel();
            
            Object [] row;
            while (rs.next()){
                row = new Object[16];
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
                row[15] = rs.getString(16);
               
                
                model2.addRow(row);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PgStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public ResultSet get(){
        String sql = "SELECT * FROM `undergraduate_student` INNER JOIN `al_result` ON `al_result`.Student_id = undergraduate_student.Student_id";
        try {
            ps = con.prepareStatement(sql);
            return ps.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(UgStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ResultSet getAlResult (int id) {
        String sql = "SELECT * FROM `al_result` WHERE Student_Id = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeQuery();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public void insertUpdateDeleteSubject(char operation, String subject1, String alresult1, String subject2, String alresult2, String subject3, String alresult3){
        
        
        if (operation == 'j'){
            try {
                ps = con.prepareStatement("INSERT INTO al_result(Subject_1, Result_1, Subject_2, Result_2, Subject_3, Result_3) VALUES(?,?,?,?,?,?)" );
            
                ps.setString(1, subject1);
                ps.setString(2, alresult1);
                ps.setString(3, subject2);
                ps.setString(4, alresult2);
                ps.setString(5, subject3);
                ps.setString(6, alresult3);
            } catch (SQLException ex) {
                Logger.getLogger(UgStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
               
        }
    }
    
     
            
    
    

//    void insertUpdateDeleteStudent(char c, Object object, String fname, String lname, String address, String city, String nic, String contact, String dob, String alresult, String zscore, String rank) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    void insertUpdateDeleteStudent(char c, Object object, String fname, String lname, String gender, String address, String city, String nic, String contact, String email, String dob, String indexno, String rank, String zscore) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    void fillStudentJTable(JTable jTable2, String string) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    void insertUpdateDeleteStudent(char c, Object object, String fname, String lname, String gender, String address, String city, String nic, String contact, String email, String dob, String alstream, String indexno, String rank, String zscore, String faculty, String course) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void insertUpdateDeleteStudent(char c, Object object, String fname, String lname, String gender, String address, String city, String nic, String contact, String email, String dob, String alstream, String subject1, String subject2, String subject3, String alresult1, String alresult2, String alresult3, String indexno, String rank, String zscore, String faculty, String course) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    void fillUgStudentJTable(JTable jTable2, String string) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    void drawTable(JTable jTable1, String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    void fillUgStudentJTable(JTable jTable2, String string) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    void fillPgStudentJtable(JTable jTable1, String text) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    void fillUgStudentJTable(JTable jTable2, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    void fillUgStudentJTable(JTable jTable2, String string) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    void fillUgStudentJTable(JTable jTable2, String string) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    
            
}

    

