package controller;

import java.sql.Date;
import java.util.List;

import dao.ReservasDAO;
import factory.ConnectionFactory;
import modelo.Reservas;

public class ReservasController {

	private ReservasDAO reservasDAO;
	private ConnectionFactory connectionFactory;

	public ReservasController() {
		connectionFactory = new ConnectionFactory();
		this.reservasDAO = new ReservasDAO(connectionFactory.recuperarConexion());
	}

	public int guardar(Reservas reserva) {
		return reservasDAO.guardar(reserva);
	}

	public int eliminar(Integer id) {
		return reservasDAO.eliminar(id);
	}

	public boolean modificar(Integer id, Date fechaSalida, String valor, String formaPago) {
		return reservasDAO.modificar(id, fechaSalida, valor, formaPago);
	}

	public List<Reservas> listarTodas() {
		return reservasDAO.listarTodas();
	}

	public List<Reservas> buscarPorParametro(Object parametro) {
		return reservasDAO.buscarPorParametro(parametro);
	}
}
