package com.example.f22comp1011s1w1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class DBUtility {
    private static String user = "root";
    private static String password = "MySQL@25";

    //jdbc:mysql - this piece tells java which sql driver to load
    private static String connectUrl = "jdbc:mysql://127.0.0.1:3306/F22";

    /**
     * This method will return a list of Artist objects
     */

     public static ArrayList<Artist> getArtistsFromDB(){
         ArrayList<Artist> artists = new ArrayList();

         //query the DB to get artists list
         String sql = "SELECT * FROM artists";
         // try() is called try with resources
         try(
                 Connection con = DriverManager.getConnection(connectUrl,user,password);
                 Statement statement = con.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql);
                ) {
             while (resultSet.next()) {
                 int artistID = resultSet.getInt("artistId");
                 String firstName = resultSet.getString("firstName");
                 String lastName = resultSet.getString("lastName");
                 LocalDate birthday = resultSet.getDate("birthday").toLocalDate();

                 Artist newArtist = new Artist(artistID,firstName, lastName, birthday);
                 artists.add(newArtist);
             }

         }

         catch (Exception e){
             e.printStackTrace();
         }
         return artists;
     }



}
