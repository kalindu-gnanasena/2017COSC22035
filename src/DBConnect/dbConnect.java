package DBConnect;
import java.sql.*;
public class dbConnect {
    //public String url = "localhost";
    private String url = "172.16.20.180";
    private String port = "3306"; //8889
    private String oport="1521";
    private String ourl="orcl.ictc.kln.ac.lk";

    private String database = "hacklnjava";
    private String user = "admin";
    private String ouser="stcs_tcw";
    private String opw = "hello";
    private String oSID="STCS";
    private String password = "stcs";//root
    private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    Connection conn = null;

    //Function to Connect to DB
    public void Connect2DB() {
        String DB_URL = "jdbc:mysql://" + url + ":" + port + "/" + database;
        Statement dbstmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL, user, password);//Connect
            //dbstmt = conn.createStatement();
            System.out.println("Connected");
        } catch (SQLException se) {
            se.printStackTrace();
        }
        //return dbstmt;
    }

    public void conn2DBOrcl()
    {
        String DB_URL="jdbc:oracle:thin@" +ourl + ":" + oport+":"+oSID;
        try {
            conn = DriverManager.getConnection(DB_URL,ouser,opw);
            System.out.println("connected to oracle db");
        }
        catch (SQLException SE)
        {
            SE.printStackTrace();
        }
    }


    public Statement Conn2DB() {
        String DB_URL = "jdbc:mysql://" + url + ":" + port + "/" + database;
        Statement dbstmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL, user, password);//Connect
            dbstmt = conn.createStatement();
            System.out.println("Connected");
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return dbstmt;
    }

    public void closeDB() {
        try {
            conn.close();
        } catch (SQLException SE) {
            SE.printStackTrace();
        }
    }
}