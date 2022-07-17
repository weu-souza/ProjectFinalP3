package Dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {
//    essa classe e a area aonde eu mexo com o banco de dados
    private static Connection conn = null;
//abre a conexão com o banco de dados de acordo com o que eu coloquei dentro  do arquivo db.propeties
    public static Connection getConnection(){
        if (conn == null){
            try{

                Properties props = loadPropeties();
                String url = props.getProperty("dburl");
                conn =  DriverManager.getConnection(url,props);
            }
            catch(SQLException e ){
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }
//fecha a conexão com o banco de dados, eu igualo o conn a null para não dar o SQLNonTransientConnectionException, isso estava quebrando o aplicativo
    public static void CloseConnection(){
        if (conn != null){
            try{
                conn.close();
                conn = null;
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

//acessa o arquivo db.propeties e le o que esta la dentro
    private static Properties loadPropeties(){
        try (FileInputStream fs = new FileInputStream("db.propeties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        }
        catch(IOException e) {
            throw new DbException(e.getMessage());

        }
    }
//fecha o statment
    public static void closeStatement(Statement st){
if (st != null){
    try {
        st.close();
    } catch (SQLException e) {
        throw new DbException(e.getMessage());
    }
}
    }
// fecha o resultSet
public static void closeResultSet(ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }

    }
}