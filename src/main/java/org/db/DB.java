package org.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.nio.channels.ConnectionPendingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

    private static Connection con = null;

    public static Connection getConnection () {

        if (con == null) {

            try {

                Properties prop = loadProperties();
                String url = prop.getProperty("dburl");
                con = DriverManager.getConnection(url, prop);

            }

            catch (SQLException e) {

                throw new DbException(e.getMessage());

            }

        }

        return con;

    }

    public static void closeConnection () {

        if(con != null) {

            try{

                con.close();

            }catch (SQLException e){

                throw new DbException(e.getMessage());

            }

        }

    }

    private static Properties loadProperties() {

      try(FileInputStream fis = new FileInputStream("src/main/resources/db.properties")){

          Properties prop = new Properties();
          prop.load(fis);
          return prop;

      }catch(IOException e){

          throw new DbException(e.getMessage());

      }

    }

}
