package factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.swing.JOptionPane;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvException;

public class ConnectionFactory {

	private DataSource dataSource;
	private Dotenv dotenv;

	public ConnectionFactory() {
//		properties = new Properties();
		ComboPooledDataSource poolDataSource = new ComboPooledDataSource();
		try {
			dotenv = Dotenv.configure().directory("./src/resources").load();
			poolDataSource.setJdbcUrl(dotenv.get("db.url"));
			poolDataSource.setUser(dotenv.get("db.user"));
			poolDataSource.setPassword(dotenv.get("db.password"));
			poolDataSource.setMaxPoolSize(10);

			this.dataSource = poolDataSource;
		} catch (DotenvException e) {
			JOptionPane.showMessageDialog(null, "Hubo un error al intentar acceder a los datos, contacta al administrador.");
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
