package main.objectSorter;

import java.io.File;
import java.sql.*;

/**
 * a lot of code is taken from https://www.tutorialspoint.com/sqlite/sqlite_java.htm
 * The code is just code for reading a folder and putting objects from the folder 
 * into a sqlite database table.
 * @author Karl
 *
 */
public class SQLiteWriter {
	
	public static void main( String args[] ) {
	      Connection c = null;
	      
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:ObjectStorage.db");
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Opened database successfully");
	   }
	
	/**
	 * This is intended to take in a directory that
	 * consists of one object type, pre-sorted via ObjectSorter
	 * This may or not do the same with an unsorted directory but
	 * the table will not be useful or organized, be cautious
	 */
	public void writeFolderIntoTable(File directory) {
		
	}

}
