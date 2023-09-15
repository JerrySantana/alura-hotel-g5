package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.security.crypto.bcrypt.BCrypt;

import modelo.Usuarios;

public class UsuariosDAO {

	final private Connection connection;

	public UsuariosDAO(Connection connection) {
		this.connection = connection;
	}

	public Integer guardar(Usuarios usuario) {
		try {
			final PreparedStatement statement = connection.prepareStatement(
					"insert into usuarios " + "(usuario, contraseña)" + " values(?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			try (statement) {
				statement.setString(1, usuario.getUser());
				statement.setString(2, usuario.getPassword());

				statement.execute();

				final ResultSet resultSet = statement.getGeneratedKeys();

				try (resultSet) {
					while (resultSet.next()) {
						usuario.setId(resultSet.getInt(1));
					}
				}
				return usuario.getId();
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Integer eliminar(Integer id) {
		try {
			final PreparedStatement statement = connection.prepareStatement("delete from usuarios where id = ?");

			try (statement) {
				statement.setInt(1, id);

				statement.execute();

				int updateCount = statement.getUpdateCount();

				return updateCount;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean verificar(String user, String password) {
		try {
			final PreparedStatement statement = connection
					.prepareStatement("select usuario, contraseña from usuarios where usuario = ?");

			try (statement) {
				statement.setString(1, user);

				statement.execute();

				final ResultSet resultSet = statement.getResultSet();

				try (resultSet) {
					while (resultSet.next()) {
						return BCrypt.checkpw(password, resultSet.getString("contraseña"));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return false;
	}

}
