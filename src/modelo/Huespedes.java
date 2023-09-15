package modelo;

import java.sql.Date;

public class Huespedes {

	private Integer id;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String nacionalidad;
	private String telefono;
	private Integer reserva_id;

	public Huespedes(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
	}

	public Huespedes(Integer id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad,
			String telefono, Integer reserva_id) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.reserva_id = reserva_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getReserva_id() {
		return reserva_id;
	}

	public void setReserva_id(Integer reserva_id) {
		this.reserva_id = reserva_id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

}
