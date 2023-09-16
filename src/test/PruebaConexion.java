package test;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import controller.ReservasController;
import modelo.Reservas;

public class PruebaConexion {

	public static void main(String[] args) throws SQLException {
		LocalDate fE = LocalDate.of(2023, 9, 27);
		LocalDate fS = LocalDate.of(2023, 10, 17);
		LocalDate fSE = LocalDate.of(2023, 10, 29);
		String value = String.valueOf(fE.datesUntil(fSE).count() * 100);
		String formaDePago = "Tarjeta de Crédito";
		Integer id = 7;

		ReservasController reservasController = new ReservasController();
//		reservasController.guardar(reserva1);
//		Reservas reserva2 = new Reservas(Date.valueOf(fN), Date.valueOf(fS), "1500", "Efectivo");
//		reservasController.guardar(reserva2);
//		huesped1.setReserva_id(reserva1.getId());
//		huesped2.setReserva_id(reserva2.getId());
//		huespedesController.guardar(huesped1);
//		huespedesController.guardar(huesped2);
		System.out.println(Period.between(fE, fSE).getYears());

		if (reservasController.modificar(id, Date.valueOf(fSE), value, formaDePago)) {
			var lista = reservasController.listarTodas();

			for (Reservas reserva : lista) {
				System.out.println(reserva.getId() + ", " + reserva.getFechaEntrada() + ", " + reserva.getFechaSalida()
						+ ", " + reserva.getValor() + ", " + reserva.getFormaDePago());
			}
		}
	}
}
