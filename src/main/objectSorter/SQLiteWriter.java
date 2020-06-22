package main.objectSorter;

import java.io.*;
import java.sql.*;

import org.sqlite.SQLiteException;

/**
 * a lot of code is taken from https://www.tutorialspoint.com/sqlite/sqlite_java.htm
 * The code is just code for reading a folder and putting objects from the folder 
 * into a sqlite database table.
 * @author Karl
 *
 */
public class SQLiteWriter {
	
	public static final String DIRECTORY_TO_WRITE = "main.exampleSerializableClasses.TestClass1_folder";
	
	public static void main( String args[] ) {
		File file = new File(DIRECTORY_TO_WRITE);
//		writeFolderIntoTable(file);
		readAllFromTable(file);
		
	}
	
	/**
	 * This is intended to take in a directory that
	 * consists of one object type, pre-sorted via ObjectSorter
	 * This may or not do the same with an unsorted directory but
	 * the table will not be useful or organized, be cautious
	 */
	public static void writeFolderIntoTable(File directory) { 
		Connection c = getDatabaseConnection();
		try {
			int primaryKey = 1;
			String sql;
			
			//Create table with name of directory
			String name = directory.getName();
			name = name.replaceAll("\\.", "_");
			System.out.println(name);
	         Statement stmt = c.createStatement();
	         try {
		         sql = "CREATE TABLE " + name + " " +
		                        "(ID INT PRIMARY KEY     NOT NULL," +
		                        " FILENAME TEXT     NOT NULL," +
		                        " OBJECTTOSTRING TEXT     NOT NULL)"; 
		         stmt.executeUpdate(sql);
		         System.out.println("Created table successfully");
	         }
	         catch(SQLiteException e) {
	        	 System.out.println("Table exists");
	         }
	         
	         
	         
	         for(File f : directory.listFiles()) {
	        	 
	        	String fileName = f.getName();
	        	//fileName = fileName.replace(".", "DOT");
	        	
	        	FileInputStream fis = new FileInputStream(f);
	        	ObjectInputStream ois = new ObjectInputStream(fis);
	 			Object object = ois.readObject();
	 			String objectToString = object.toString();
	 			fis.close();
	 			ois.close();
	        	 
		         sql = "INSERT INTO " + name + " (ID,FILENAME,OBJECTTOSTRING) " +
	                     "VALUES (" + primaryKey++ + ", \"" + fileName + "\", \"" + objectToString + "\" );"; 
		         stmt.executeUpdate(sql);
	         }
	         
	         System.out.println("Files written");
	         
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Table created successfully");
	}
	
	private static Connection getDatabaseConnection() {
		Connection c = null;
	      
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:ObjectStorage.db");
	         System.out.println("Opened database successfully");
	         return c;
	         
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	         return null;
	      }
	      
	}
	
	private static void readAllFromTable(File directory) {
		Connection c = getDatabaseConnection();
		Statement stmt = null;
		String tableName = null;
		
		String name = directory.getName();
		name = name.replaceAll("\\.", "_");
		tableName = name;
		
		
		try {
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM " + tableName + ";" );
			
			while(rs.next()) {
				int id = rs.getInt("id");
		        String  filename = rs.getString("filename");
		        String toString  = rs.getString("objecttostring");
		        
		        System.out.println("id: " + id + " Filename: " + filename + " object info: " + toString);
			}
			
			rs.close();
		      stmt.close();
		      c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

}
