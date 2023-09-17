package controller;

import dao.UsuariosDAO;
import factory.ConnectionFactory;
import modelo.Usuarios;

public class UsuariosController {

	private UsuariosDAO usuariosDAO;
	private ConnectionFactory connectionFactory;

	public UsuariosController() {
		connectionFactory = new ConnectionFactory();
		this.usuariosDAO = new UsuariosDAO(connectionFactory.recuperarConexion());
	}

	public int guardar(Usuarios usuario) {
		return usuariosDAO.guardar(usuario);
	}

	public int eliminar(Integer id) {
		return usuariosDAO.eliminar(id);
	}

	public boolean verificar(String user, String password) {
		return usuariosDAO.verificar(user, password);
	}

}
