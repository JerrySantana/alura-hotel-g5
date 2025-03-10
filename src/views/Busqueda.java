package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.HuespedesController;
import controller.ReservasController;
import modelo.Huespedes;
import modelo.Reservas;

@SuppressWarnings({ "serial", "unused" })
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modeloReserva;
	private DefaultTableModel modeloHuesped;
	private JLabel labelAtras;
	private JLabel labelExit;
	int xMouse, yMouse;
	private HuespedesController huespedesController = new HuespedesController();
	private ReservasController reservasController = new ReservasController();

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Busqueda frame = new Busqueda();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Busqueda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);

		txtBuscar = new JTextField();
		txtBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtBuscar.setFocusable(true);
				txtBuscar.setText("");
				txtBuscar.setForeground(Color.BLACK);
			}
		});
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		txtBuscar.setText("Id, Apellido o Fecha (yyyy-mm-dd).");
		txtBuscar.setForeground(Color.gray);
		txtBuscar.setToolTipText(
				"Busqueda por Apellido, Id de reserva o de huesped o por fecha con formato (yyyy-mm-dd).");
		txtBuscar.setFocusable(false);

		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(320, 60, 300, 42);
		contentPane.add(lblNewLabel_4);

		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);

		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		tbReservas.setRowSelectionAllowed(true);
		modeloReserva = (DefaultTableModel) tbReservas.getModel();
		modeloReserva.addColumn("Numero de Reserva");
		modeloReserva.addColumn("Fecha Check In");
		modeloReserva.addColumn("Fecha Check Out");
		modeloReserva.addColumn("Valor");
		modeloReserva.addColumn("Forma de Pago");
		JScrollPane scroll_table = new JScrollPane(tbReservas);
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scroll_table,
				null);
		scroll_table.setVisible(true);

		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		tbHuespedes.setRowSelectionAllowed(true);
		modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
		modeloHuesped.addColumn("Número de Huesped");
		modeloHuesped.addColumn("Nombre");
		modeloHuesped.addColumn("Apellido");
		modeloHuesped.addColumn("Fecha de Nacimiento");
		modeloHuesped.addColumn("Nacionalidad");
		modeloHuesped.addColumn("Telefono");
		modeloHuesped.addColumn("Número de Reserva");
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")),
				scroll_tableHuespedes, null);
		scroll_tableHuespedes.setVisible(true);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);

		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);

			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);

		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);

		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);

		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) { // Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) { // Al usuario quitar el mouse por el botón este volverá al estado
													// original
				btnexit.setBackground(Color.white);
				labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);

		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);

		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtBuscar.getText().equals("Id, Apellido o Fecha (yyyy-mm-dd).")
						|| txtBuscar.getText().equals("")) {
					listar();
				} else {
					buscar();
				}
			}
		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);

		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));

		JPanel btnEditar = new JPanel();
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tbHuespedes.isFocusOwner()) {
					editarHuesped();
				} else if (tbReservas.isFocusOwner()) {
					editarReserva();
				}
			}
		});

		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);

		JPanel btnEliminar = new JPanel();
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tbHuespedes.isFocusOwner()) {
					eliminarHuesped();
				} else if (tbReservas.isFocusOwner()) {
					eliminarReserva();
				}
			}
		});

		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
		listar();
	}

	private void listar() {
		var huespedes = huespedesController.listarTodos();
		var reservas = reservasController.listarTodas();
		modeloHuesped.setRowCount(0);
		modeloReserva.setRowCount(0);
		try {
			huespedes.forEach(huesped -> {
				modeloHuesped.addRow(new Object[] { huesped.getId(), huesped.getNombre(), huesped.getApellido(),
						huesped.getFechaNacimiento(), huesped.getNacionalidad(), huesped.getTelefono(),
						huesped.getReserva_id() });
			});
			reservas.forEach(reserva -> {
				modeloReserva.addRow(new Object[] { reserva.getId(), reserva.getFechaEntrada(),
						reserva.getFechaSalida(), reserva.getValor(), reserva.getFormaDePago() });
			});
		} catch (Exception e) {
			throw e;
		}
	}

	private void buscar() {
		modeloHuesped.setRowCount(0);
		modeloReserva.setRowCount(0);
		Object parametro;
		List<Huespedes> huespedes = new ArrayList<>();
		List<Reservas> reservas = new ArrayList<>();

		if (verificarInteger()) {
			parametro = Integer.parseInt(txtBuscar.getText());
			huespedes = huespedesController.buscarPorParametro(parametro);
			reservas = reservasController.buscarPorParametro(parametro);
		} else if (verificarDate()) {
			parametro = Date.valueOf(txtBuscar.getText());
			reservas = reservasController.buscarPorParametro(parametro);
		} else {
			parametro = txtBuscar.getText();
			huespedes = huespedesController.buscarPorParametro(parametro);
		}

		try {
			huespedes.forEach(huesped -> {
				modeloHuesped.addRow(new Object[] { huesped.getId(), huesped.getNombre(), huesped.getApellido(),
						huesped.getFechaNacimiento(), huesped.getNacionalidad(), huesped.getTelefono(),
						huesped.getReserva_id() });
			});
			reservas.forEach(reserva -> {
				modeloReserva.addRow(new Object[] { reserva.getId(), reserva.getFechaEntrada(),
						reserva.getFechaSalida(), reserva.getValor(), reserva.getFormaDePago() });
			});
		} catch (Exception e) {
			throw e;
		}
	}

	private void eliminarReserva() {
		try {
			var reserva = tbReservas.getSelectedRow();
			var idReserva = (Integer) modeloReserva.getValueAt(reserva, 0);
			if (reserva >= 0 && idReserva != null) {
				huespedesController.eliminar(idReserva);
				reservasController.eliminar(idReserva);
				JOptionPane.showMessageDialog(null, "Datos eliminados correctamente.");
			} else {
				JOptionPane.showMessageDialog(null, "Hubo un error al eliminar los datos, intenta nuevamente.");
			}
			listar();
		} catch (NullPointerException e) {
			listar();
			throw new RuntimeException(e);
		}
	}

	private void eliminarHuesped() {
		try {
			var huesped = tbHuespedes.getSelectedRow();
			var idReserva = (Integer) modeloHuesped.getValueAt(huesped, 6);
			if (huesped >= 0 && idReserva != null) {
				huespedesController.eliminar(idReserva);
				reservasController.eliminar(idReserva);
				JOptionPane.showMessageDialog(null, "Datos eliminados correctamente.");
			} else {
				JOptionPane.showMessageDialog(null, "Hubo un error al eliminar los datos, intenta nuevamente.");
			}
			listar();
		} catch (NullPointerException e) {
			listar();
			throw new RuntimeException(e);
		}
	}

	private void editarReserva() {
		try {
			var reserva = tbReservas.getSelectedRow();
			var id = (Integer) modeloReserva.getValueAt(reserva, 0);
			var fechaSalidaEditada = modeloReserva.getValueAt(reserva, 2).toString();
			var formaPagoEditada = modeloReserva.getValueAt(reserva, 4).toString();
			var fechaEntrada = modeloReserva.getValueAt(reserva, 1).toString();
			var valor = calcularValor(LocalDate.parse(fechaEntrada), LocalDate.parse(fechaSalidaEditada));
			if (!valor.equals("") && !formaPagoEditada.equals("")) {
				reservasController.modificar(id, Date.valueOf(fechaSalidaEditada), valor, formaPagoEditada);
				JOptionPane.showMessageDialog(null, "Datos modificados correctamente.");
			} else {
				JOptionPane.showMessageDialog(null,
						"Hubo un error al modificar los datos, intenta nuevamente, no dejes campos vacíos.");
			}
			listar();
		} catch (DateTimeParseException e) {
			listar();
			JOptionPane.showMessageDialog(null, "Asegurate de escribir un formato correcto.");
		}
	}

	private void editarHuesped() {
		try {
			var huesped = tbHuespedes.getSelectedRow();
			var id = (Integer) modeloHuesped.getValueAt(huesped, 0);
			var nacionalidadEditada = modeloHuesped.getValueAt(huesped, 4).toString();
			var telefonoEditado = modeloHuesped.getValueAt(huesped, 5).toString();
			if (!nacionalidadEditada.equals("") && !telefonoEditado.equals("")) {
				huespedesController.modificar(id, nacionalidadEditada, telefonoEditado);
				JOptionPane.showMessageDialog(null, "Datos modificados correctamente.");
			} else {
				JOptionPane.showMessageDialog(null,
						"Hubo un error al modificar los datos, intenta nuevamente, no dejes campos vacíos.");
			}
			listar();
		} catch (IllegalArgumentException e) {
			listar();
			JOptionPane.showMessageDialog(null, "Asegurate de escribir un formato correcto.");
			throw new RuntimeException(e);
		}
	}

	private boolean compararFechas(LocalDate fechaEntrada, LocalDate fechaSalida) {
		if (fechaEntrada == null && fechaSalida == null) {
			return false;
		}
		if (!fechaSalida.isAfter(fechaEntrada)) {
			return false;
		}
		if (!fechaSalida.isEqual(LocalDate.now()) && !fechaSalida.isAfter(LocalDate.now())) {
			return false;
		}
		return true;
	}

	private String calcularValor(LocalDate fechaEntrada, LocalDate fechaSalida) {
		if (!compararFechas(fechaEntrada, fechaSalida)) {
			return "";
		}
		try {
			return String.valueOf(fechaEntrada.datesUntil(fechaSalida).count() * 100);
		} catch (NumberFormatException e) {
			throw new RuntimeException(e);
		}
	}

	private boolean verificarInteger() {
		try {
			Integer.parseInt(txtBuscar.getText());
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private boolean verificarDate() {
		try {
			Date.valueOf(txtBuscar.getText());
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}
}
