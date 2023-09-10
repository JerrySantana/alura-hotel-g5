package factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	private DataSource dataSource;
	private Properties properties;
	
	public ConnectionFactory() {
		properties = new Properties();
		var poolDataSource = new ComboPooledDataSource();
		try {
			properties.load(new FileInputStream(new File("application.properties")));
			poolDataSource.setJdbcUrl(properties.getProperty("db.url"));
			poolDataSource.setUser(properties.getProperty("db.user"));
			poolDataSource.setPassword(properties.getProperty("db.password"));
			poolDataSource.setMaxPoolSize(10);
			
			this.dataSource = poolDataSource;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Connection recuperarConexion() {
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
