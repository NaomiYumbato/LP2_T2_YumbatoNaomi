package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name= "tb_empleado")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoEntity {

	@Id
	@Column(name= "dni_empleado", nullable= false, columnDefinition = "CHAR(8)")
	private Integer dniEmpleado;
	
	@Column(name= "nombre_empleado", nullable= false, columnDefinition = "VARCHAR(45)")
	private String nombreEmpleado;
	
	@Column(name= "apellido_empleado", nullable= false, columnDefinition = "VARCHAR(45)")
	private String apellidoEmpleado;
	
	@Column(name= "fecha_nacimiento", nullable= false, columnDefinition = "DATE")
	private LocalDate fechaNacimiento;
	
	@Column(name= "direccion", nullable= false, columnDefinition = "VARCHAR(45)")
	private String direccion;
	
	@Column(name= "correo", nullable= false, columnDefinition = "VARCHAR(45)")
	private String correo;
	
	@ManyToOne
	@JoinColumn(name= "area_id", nullable= false)
	private AreaEntity areaEntity;
}
