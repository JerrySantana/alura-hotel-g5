package modelo;

import java.sql.Date;

public class Reservas {
	private Integer id;
	private Date fechaEntrada;
	private Date fechaSalida;
	private String valor;
	private String formaDePago;

	public Reservas(Date fechaEntrada, Date fechaSalida, String valor, String formaDePago) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaDePago = formaDePago;
	}

	public Reservas(int id, Date fechaEntrada, Date fechaSalida, String valor, String formaDePago) {
		this.id = id;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaDePago = formaDePago;
	}

	public Reservas(int id, Date fechaEntrada, Date fechaSalida) {
		this.id = id;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public String getValor() {
		return valor;
	}

	public String getFormaDePago() {
		return formaDePago;
	}
}
