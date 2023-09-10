package controller;

import java.sql.Date;
import java.util.List;

import dao.ReservasDAO;
import factory.ConnectionFactory;
import modelo.Reservas;

public class ReservasController {
	
	private ReservasDAO reservasDAO;
	
	public ReservasController() {
		this.reservasDAO = new ReservasDAO(new ConnectionFactory().recuperarConexion());
	}
	
	public int guardar(Reservas reserva) {
		return reservasDAO.guardar(reserva);
	}
	
	public int eliminar (Integer id) {
		return reservasDAO.eliminar(id);
	}
	
	public int modificar(Integer id, Date fechaSalida, String valor) {
		return reservasDAO.modificar(id, fechaSalida, valor);
	}
	
	public List<Reservas> listarTodas() {
		return reservasDAO.listarTodas();
	}
	
	public List<Reservas> buscarPorParametro(Object parametro) {
		return reservasDAO.buscarPorParametro(parametro);
	}
}
