package modelo;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Usuarios {
	private Integer id;
	private String user;
	private String password;

	public Usuarios(String user, String password) {
		var salt = BCrypt.gensalt();
		var psswrd = BCrypt.hashpw(password, salt);
		this.user = user;
		this.password = psswrd;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}
}
