package pe.edu.upeu.alumnos.dao;

import java.util.List;

import pe.edu.upeu.alumnos.entity.Escuela;

public interface EscuelasDao {
	public int create(Escuela u);
	public int update(Escuela u);
	public int delete(int id);
	public Escuela read(int id);
	public List<Escuela> readAll();
}
