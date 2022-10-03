package com.example.f22comp1011s1w1;

import java.sql.*;
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

    /**
     * this method insert a song object to the database
     */

    public static int insertSongDB(Song song) throws SQLException {
        int songID = -1;
        ResultSet resultSet =null;

        String sql = "INSERT INTO songs (name,genre,length,releaseYear,artistID) VALUES (?,?,?,?,?);";

        try(
                Connection con = DriverManager.getConnection(connectUrl,user,password);
                PreparedStatement ps = con.prepareStatement(sql,new String[]{"songID"});

        ) {
            ps.setString(1,song.getName());
            ps.setString(2,song.getGenre());
            ps.setInt(3,song.getLength());
            ps.setInt(4,song.getReleaseYear());
            ps.setInt(5,song.getArtist().getArtistID());

            //run the sql command
            ps.executeUpdate();

            resultSet = ps.getGeneratedKeys();
            while(resultSet.next()){
                songID = resultSet.getInt(1);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (resultSet!=null)
                resultSet.close();
        }
        return songID;
    }


    public static ArrayList<Song> getSongsFromDB(){
        ArrayList<Song> songs = new ArrayList();

        //query the DB to get artists list
        String sql = "select * from songs as s inner join artists as a on a.artistID = s.artistID";
        // try() is called try with resources
        try(
                Connection con = DriverManager.getConnection(connectUrl,user,password);
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while (resultSet.next()) {
                int songID= resultSet.getInt("songID");
                String name = resultSet.getString("name");
                String genre = resultSet.getString("genre");
                int length = resultSet.getInt("length");
                int releaseYear = resultSet.getInt("releaseYear");

                //create a new artist
                int artistID = resultSet.getInt("artistId");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                LocalDate birthday = resultSet.getDate("birthday").toLocalDate();

                Artist newArtist = new Artist(artistID,firstName, lastName, birthday);

                Song newRow = new Song(songID,name,genre,releaseYear,length,newArtist);

                songs.add(newRow);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return songs;
    }
}
