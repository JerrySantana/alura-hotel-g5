package controller;

import java.util.List;

import dao.HuespedesDAO;
import factory.ConnectionFactory;
import modelo.Huespedes;

public class HuespedesController {

	private HuespedesDAO huespedesDAO;

	public HuespedesController() {
		this.huespedesDAO = new HuespedesDAO(new ConnectionFactory().recuperarConexion());
	}

	public int guardar(Huespedes huesped) {
		return huespedesDAO.guardar(huesped);
	}

	public int eliminar(Integer id) {
		return huespedesDAO.eliminar(id);
	}

	public int modificar(Integer id, String nacionalidad, String telefono) {
		return huespedesDAO.modificar(id, nacionalidad, telefono);
	}

	public List<Huespedes> listarTodos() {
		return huespedesDAO.listarTodos();
	}

	public List<Huespedes> buscarPorParametro(Object parametro) {
		return huespedesDAO.buscarPorParametro(parametro);
	}
}
