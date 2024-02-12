package fr.bz.jsfajax.dao;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;

public class ConnectDtb {

    static Connection connexion;

    private ConnectDtb(){}

    public static Connection getInstance() {
        if (connexion == null) {
            try {
                SQLServerDataSource ds = new SQLServerDataSource();
                ds.setServerName("localhost");
                ds.setPortNumber(1433);
                ds.setDatabaseName("SDBM");
                ds.setIntegratedSecurity(false);
                ds.setEncrypt(false);
                ds.setUser("sa");
                ds.setPassword("azerty@123456");
                connexion = ds.getConnection();
            } catch (SQLServerException e) {
                e.printStackTrace();
            }

        }
        return connexion;
    }


}