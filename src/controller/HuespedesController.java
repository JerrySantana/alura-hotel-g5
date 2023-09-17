package controller;

import java.util.List;

import dao.HuespedesDAO;
import factory.ConnectionFactory;
import modelo.Huespedes;

public class HuespedesController {

	private HuespedesDAO huespedesDAO;
	private ConnectionFactory connectionFactory;

	public HuespedesController() {
		connectionFactory = new ConnectionFactory();
		this.huespedesDAO = new HuespedesDAO(connectionFactory.recuperarConexion());
	}

	public int guardar(Huespedes huesped) {
		return huespedesDAO.guardar(huesped);
	}

	public int eliminar(Integer reserva_id) {
		return huespedesDAO.eliminar(reserva_id);
	}

	public boolean modificar(Integer id, String nacionalidad, String telefono) {
		return huespedesDAO.modificar(id, nacionalidad, telefono);
	}

	public List<Huespedes> listarTodos() {
		return huespedesDAO.listarTodos();
	}

	public List<Huespedes> buscarPorParametro(Object parametro) {
		return huespedesDAO.buscarPorParametro(parametro);
	}
}
