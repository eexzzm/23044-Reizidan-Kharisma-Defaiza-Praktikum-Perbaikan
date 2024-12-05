/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import java.sql.Statement;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.PreparedStatement;

import java.util.Scanner;
/**
 *
 * @author reizi
 */
public class loginLagi {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan username: ");
        String uname = input.nextLine();
        System.out.print("Masukkan password: ");
        String passwd = input.nextLine();
    
        try {
        Connection connection = connectionClass.konek();
        System.out.println("Koneksi berhasil!");
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM user WHERE username = '" + uname + "' AND password = '" + passwd+"'";
        System.out.println(query);
        ResultSet resultSet = statement.executeQuery(query);

        if(resultSet.next()){
                System.out.println("Login berhasil");
            }else{
                System.out.println("Username atau password salah");
            }
        
        resultSet.close();
        statement.close();
        connection.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(loginLagi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
