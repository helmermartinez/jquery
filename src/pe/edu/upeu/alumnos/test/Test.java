package pe.edu.upeu.alumnos.test;

import com.google.gson.Gson;

import pe.edu.upeu.alumnos.dao.AlumnosDao;
import pe.edu.upeu.alumnos.dao.EscuelasDao;
import pe.edu.upeu.alumnos.daoImp.AlumnosDaoImp;
import pe.edu.upeu.alumnos.daoImp.EscuelaDaoImp;
import pe.edu.upeu.alumnos.entity.Alumno;

public class Test {
	private static EscuelasDao ed = new EscuelaDaoImp();
	private static Gson g = new Gson();
	private static AlumnosDao alumnosDao = new AlumnosDaoImp();
	
	public static void main(String[] args) {
		//crearalumno();
		//prueba();
		//listarescuela();
		listalumno();
		//listalumnoid();
		//deletealumno();
		//updatealumno();
		
	}

	static void crearalumno() {
		System.out.println(alumnosDao.create(new Alumno(0, 2, "Rojas", "rojin@gmail.com", 9169752 )));
	}
	
	static void listarescuela() {
		System.out.println(g.toJson(ed.readAll()));
	}
	
	static void deletealumno() {
		System.out.println(g.toJson(alumnosDao.delete(4)));
	}
	
	static void listalumnoid() {
		System.out.println(g.toJson(alumnosDao.read(3)));
	}
	
	static void listalumno() {
		System.out.println(g.toJson(alumnosDao.readAll()));
	}
	
	static void updatealumno() {
		System.out.println(g.toJson(alumnosDao.update(new Alumno(5, 1, "raul", "verdin@gmail.com", 852055))));
	}
	
	static void prueba() {
		int a = 2;
		int b = 3;
		int c = a + b;
		a = 5;
		System.out.println("Tu respuesta es: "+c);
	}
}
