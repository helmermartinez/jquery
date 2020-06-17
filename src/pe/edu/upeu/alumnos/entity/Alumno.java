package pe.edu.upeu.alumnos.entity;

public class Alumno {
	
	private int idalumno;
	private int idescuela;
	private String nombre;
	private String correo;
	private int telefono;
	public Alumno() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Alumno(int idalumno, int idescuela, String nombre, String correo, int telefono) {
		super();
		this.idalumno = idalumno;
		this.idescuela = idescuela;
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
	}
	public int getIdalumno() {
		return idalumno;
	}
	public void setIdalumno(int idalumno) {
		this.idalumno = idalumno;
	}
	public int getIdescuela() {
		return idescuela;
	}
	public void setIdescuela(int idescuela) {
		this.idescuela = idescuela;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
}


