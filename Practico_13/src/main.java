import java.sql.Connection;

import javax.swing.*;
import java.sql.*;

public class main {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Qatar2022", "root", "");
			Statement miStatement = miConexion.createStatement();
			
			/*
			// 1. INSERTAR UN NUEVO EMPLEADO
			
			String instruccion1 = "insert into empleados (DNI, apellido, nombre, nacion, depto_id_depto) values (11224455,'Flores','Maria','Peruano',3)";
			miStatement.executeUpdate(instruccion1);
			System.out.println("datos insertados correctamente");

			// 2. MODIFICAR LA NACIONALIDAD
			
			String instruccion2 = "update empleados set nacion='Brasilero' where id_empl=2";
			miStatement.executeUpdate(instruccion2);
			System.out.println("datos modificados correctamente");

			// 3. ELIMINAR UN DEPARTAMENTO
			String instruccion3 = "delete from depto where id_depto=5";
			miStatement.executeUpdate(instruccion3);
			System.out.println("datos eliminados correctamente");

			
			String tabla = "SELECT * from empleados, depto where depto_id_depto=id_depto";
			ResultSet miResultset = miStatement.executeQuery(tabla);
			
			while (miResultset.next()) {
				System.out.println(miResultset.getString("DNI") + " - " + miResultset.getString("apellido") + ", " + miResultset.getString("nombre")
				+ " - " + miResultset.getString("nacion") + " - " + miResultset.getString("descrip"));
			}
			
			
			// 4. EMPLEADOS QUE TRABAJAN EN LOGISTICA
			ventana ventana1 = new ventana();
			JPanel panel = new JPanel();
			ventana1.getContentPane().add(panel);
			String instruccion4 = "select * from empleados where depto_id_depto=2";
			ResultSet miResultset2 = miStatement.executeQuery(instruccion4);
			while (miResultset2.next()) {
				String texto = miResultset2.getString("DNI") + " - " + miResultset2.getString("apellido") + ", " + miResultset2.getString("nombre")
				+ " - " + miResultset2.getString("nacion");
				
				JLabel etiqueta = new JLabel();
				etiqueta.setText(texto);
				etiqueta.setVisible(true);
				panel.add(etiqueta);
			}
			
			ventana1.setVisible(true);
			
			
			*/
			// 5. DEPARTAMENTOS ORDENADOS ALFABETICAMENTE
			ventana ventana1 = new ventana();
			JPanel panel = new JPanel();
			ventana1.getContentPane().add(panel);
			String instruccion5 = "select * from depto order by descrip ASC";
			ResultSet miResultset2 = miStatement.executeQuery(instruccion5);
			while (miResultset2.next()) {
				String texto = miResultset2.getString("descrip") + " - " + miResultset2.getString("presup");
				
				JLabel etiqueta = new JLabel();
				etiqueta.setText(texto);
				etiqueta.setVisible(true);
				panel.add(etiqueta);
			}
			ventana1.setVisible(true);
			

			
			
		} catch (Exception e) {
			System.out.println("Sin conexion a la BD");
			e.printStackTrace();
		}  

	}
	
	

}
