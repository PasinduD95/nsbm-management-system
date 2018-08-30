
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pasindu Dilshan
 */
public class Instructor {
    
    public void insertUpdateDeleteInstructor(char operation, int Insid, String fname, String lname, String address, String contact, 
                                            String room, String teachsub){
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        if (operation == 'i'){
            try {
                ps = con.prepareStatement("INSERT INTO instructor(Fname, Lname, Address, Contact, Room, Teach_sub) VALUES (?,?,?,?,?,?)" );
                ps.setString(1, fname);        
                ps.setString(2, lname);
                ps.setString(3, address);
                ps.setString(4, contact);
                ps.setString(5, room);
                ps.setString(6, teachsub);
                if (ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "New Instructor Added");
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(PgStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (operation == 'u'){
            try {
                ps = con.prepareStatement("UPDATE `instructor` SET `Fname`= ?,`Lname`= ?,`Address`= ?,`Contact`= ?,`Room`= ?,`Teach_sub`= ? WHERE `Ins_id` = ?" );
                ps.setString(1, fname);        
                ps.setString(2, lname);
                ps.setString(3, address);
                ps.setString(4, contact);
                ps.setString(5, room);
                ps.setString(6, teachsub);
                ps.setInt(7, Insid);
                if (ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Instructor Data Updated");
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(PgStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        if (operation == 'd'){
            try {
                ps = con.prepareStatement("DELETE FROM `instructor` WHERE `Ins_id` = ?" );
                ps.setInt(1, Insid);
                if (ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Instructor Deleted");
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(PgStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void fillInstructorJtable (JTable table, String valueToSearch){
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("SELECT * FROM `instructor` WHERE CONCAT (Fname, Lname, Contact, Address) LIKE ?");
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

    
    
}


