package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "tb_empleado")
public class EmpleadoEntity {

	public EmpleadoEntity(String dniEmpleado, String nombreEmpleado, String apellidoEmpleado,
			LocalDate fechaNacimiento, String direccion, String correo, AreaEntity areaEntity) {
		super();
		this.dniEmpleado = dniEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.apellidoEmpleado = apellidoEmpleado;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.correo = correo;
		this.areaEntity = areaEntity;
	}

	public EmpleadoEntity() {
	}

	@Id
	@Column(name = "dni_empleado", nullable = false, columnDefinition = "CHAR(8)", unique= true)
	private String dniEmpleado;

	@Column(name = "nombre_empleado", nullable = false, columnDefinition = "VARCHAR(45)")
	private String nombreEmpleado;

	@Column(name = "apellido_empleado", nullable = false, columnDefinition = "VARCHAR(45)")
	private String apellidoEmpleado;

	@Column(name = "fecha_nacimiento", nullable = false, columnDefinition = "DATE")
	private LocalDate fechaNacimiento;

	@Column(name = "direccion", nullable = false, columnDefinition = "VARCHAR(45)")
	private String direccion;

	@Column(name = "correo", nullable = false, columnDefinition = "VARCHAR(45)")
	private String correo;

	@ManyToOne
	@JoinColumn(name = "area_id", nullable = false)
	private AreaEntity areaEntity;

	public String getDniEmpleado() {
		return dniEmpleado;
	}

	public void setDniEmpleado(String dniEmpleado) {
		this.dniEmpleado = dniEmpleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getApellidoEmpleado() {
		return apellidoEmpleado;
	}

	public void setApellidoEmpleado(String apellidoEmpleado) {
		this.apellidoEmpleado = apellidoEmpleado;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public AreaEntity getAreaEntity() {
		return areaEntity;
	}

	public void setAreaEntity(AreaEntity areaEntity) {
		this.areaEntity = areaEntity;
	}

	@Override
	public String toString() {
		return "EmpleadoEntity [dniEmpleado=" + dniEmpleado + ", nombreEmpleado=" + nombreEmpleado
				+ ", apellidoEmpleado=" + apellidoEmpleado + ", fechaNacimiento=" + fechaNacimiento + ", direccion="
				+ direccion + ", correo=" + correo + ", areaEntity=" + areaEntity + "]";
	}

}
