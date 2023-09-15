package test;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import controller.HuespedesController;
import controller.ReservasController;
import modelo.Huespedes;
import modelo.Reservas;

public class PruebaConexion {

	public static void main(String[] args) throws SQLException {
		LocalDate fE = LocalDate.of(2023, 12, 1);
		LocalDate fS = LocalDate.of(2023, 12, 20);
		LocalDate fN = LocalDate.of(1997, 02, 10);
		Reservas reserva1 = new Reservas(Date.valueOf(fE), Date.valueOf(fS), "1500", "Efectivo");
		Huespedes huesped1 = new Huespedes("Gerardo", "Santana", Date.valueOf(fN), "Mexicana", "5535031272");
		Huespedes huesped2 = new Huespedes("Gabriel", "Amezcua", Date.valueOf(fN), "Mexicana", "5535031272");

		HuespedesController huespedesController = new HuespedesController();
		ReservasController reservasController = new ReservasController();
//		reservasController.guardar(reserva1);
//		Reservas reserva2 = new Reservas(Date.valueOf(fN), Date.valueOf(fS), "1500", "Efectivo");
//		reservasController.guardar(reserva2);
//		huesped1.setReserva_id(reserva1.getId());
//		huesped2.setReserva_id(reserva2.getId());
//		huespedesController.guardar(huesped1);
//		huespedesController.guardar(huesped2);

		Object id = Integer.valueOf("20");

		List<Huespedes> resultado = huespedesController.buscarPorParametro(id);

		if (resultado != null) {
			resultado.forEach(huesped -> {
				System.out.println(huesped.getId() + ", " + huesped.getNombre() + ", " + huesped.getApellido() + ", "
						+ huesped.getFechaNacimiento() + ", " + huesped.getNacionalidad() + ", " + huesped.getTelefono()
						+ ", " + huesped.getReserva_id());
			});
		}

		System.out.println("Cerrando conexion.");
	}
}
