package pe.edu.upeu.alumnos.dao;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.alumnos.entity.Alumno;

public interface AlumnosDao {
	
	public int create(Alumno u);
	public int update(Alumno u);
	public int delete(int id);
	public List<Map<String,Object>> read(int id);
	public List<Map<String,Object>> readAll();

	}
