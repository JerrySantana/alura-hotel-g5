package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Reservas;

public class ReservasDAO {

	final private Connection connection;

	public ReservasDAO(Connection connection) {
		this.connection = connection;
	}

	public Integer guardar(Reservas reserva) {
		try {
			final PreparedStatement statement = connection.prepareStatement(
					"insert into reservas " + "(fechaEntrada, fechaSalida, valor, formaPago)" + " values (?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			try (statement) {
				statement.setString(1, reserva.getFechaEntrada().toString());
				statement.setString(2, reserva.getFechaSalida().toString());
				statement.setString(3, reserva.getValor());
				statement.setString(4, reserva.getFormaDePago());

				statement.execute();

				final ResultSet resultSet = statement.getGeneratedKeys();

				try (resultSet) {
					while (resultSet.next()) {
						reserva.setId(resultSet.getInt(1));
					}
				}
				return reserva.getId();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Integer eliminar(Integer id) {
		try {
			final PreparedStatement statement = connection.prepareStatement("delete from reservas where id = ?");

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

	public Integer modificar(Integer id, Date fechaSalida, String valor, String formaPago) {
		try {
			final PreparedStatement statement = connection
					.prepareStatement("update reservas set " + "fechaSalida = ?" + ", valor = ?" + ", formaPago = ?" + " where id = ?");

			try (statement) {
				statement.setString(1, fechaSalida.toString());
				statement.setString(2, valor);
				statement.setString(3, formaPago);
				statement.setInt(4, id);

				return statement.getUpdateCount();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Reservas> listarTodas() {
		List<Reservas> resultado = new ArrayList<>();

		try {
			final PreparedStatement statement = connection
					.prepareStatement("select id, fechaEntrada, fechaSalida, valor, formaPago from reservas");

			try (statement) {
				statement.execute();

				final ResultSet resultSet = statement.getResultSet();

				try (resultSet) {
					while (resultSet.next()) {
						Reservas fila = new Reservas(resultSet.getInt("id"), resultSet.getDate("fechaEntrada"),
								resultSet.getDate("fechaSalida"), resultSet.getString("valor"),
								resultSet.getString("formaPago"));

						resultado.add(fila);
					}

					return resultado;
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Reservas> buscarPorParametro(Object parametro) {
		if (parametro == null) {
			return null;
		}
		List<Reservas> resultado = new ArrayList<>();
		try {
			var string = "";
			if (parametro.getClass() == Date.class) {
				string = "fechaEntrada = ? or fechaSalida = ?";
			}
			if (parametro.getClass() == Integer.class) {
				string = "id = ?";
			}
			String query = "select id, fechaEntrada, fechaSalida, valor, formaPago from reservas where " + string;

			final PreparedStatement statement = connection.prepareStatement(query);

			try (statement) {
				final ResultSet resultSet;
				if (parametro.getClass() == Date.class) {
					statement.setString(1, ((Date) parametro).toString());
					statement.setString(2, ((Date) parametro).toString());
				} else if (parametro.getClass() == Integer.class) {
					statement.setInt(1, (Integer) parametro);
				}
				statement.execute();

				resultSet = statement.getResultSet();

				try (resultSet) {
					while (resultSet.next()) {
						Reservas fila = new Reservas(resultSet.getInt("id"), resultSet.getDate("fechaEntrada"),
								resultSet.getDate("fechaSalida"), resultSet.getString("valor"),
								resultSet.getString("formaPago"));

						resultado.add(fila);
					}

					return resultado;
				}

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
