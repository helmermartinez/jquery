package pe.edu.upeu.alumnos.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.upeu.alumnos.dao.AlumnosDao;
import pe.edu.upeu.alumnos.dao.EscuelasDao;
import pe.edu.upeu.alumnos.daoImp.AlumnosDaoImp;
import pe.edu.upeu.alumnos.daoImp.EscuelaDaoImp;
import pe.edu.upeu.alumnos.entity.Alumno;



/**
 * Servlet implementation class HomeController
 */
@WebServlet("/hc")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AlumnosDao al = new AlumnosDaoImp();
	private EscuelasDao ed = new EscuelaDaoImp();
	private Gson g = new Gson();
	int ida, idescuela,telefono; String nombre, correo;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// TODO Auto-generated method stub
				PrintWriter out = response.getWriter();
				int op = Integer.parseInt(request.getParameter("opc"));
				switch(op) {
				case 1: //listar categoria
						out.println(g.toJson(ed.readAll()));
						break;
				case 2: //Listar productos
						out.println(g.toJson(al.readAll()));
					    break;
				case 3: //registrar producto
						al.create(new Alumno(0,
						Integer.parseInt(request.getParameter("ep")),request.getParameter("name"),
						(request.getParameter("email")),Integer.parseInt(request.getParameter("fono"))));
				       out.println(g.toJson("Registro guardado correctamente"));
					         break;
				case 4: //Buscar produto por ID
						out.println(g.toJson(al.read(Integer.parseInt(request.getParameter("id")))));
			    break; //Eliminar producto
				case 5: out.println(g.toJson(al.delete(Integer.parseInt(request.getParameter("id")))));
			    break;
				case 6: //Modificar producto
						ida = Integer.parseInt(request.getParameter("ida"));
						idescuela = Integer.parseInt(request.getParameter("idescuela"));
						nombre = request.getParameter("nombre");
						correo = request.getParameter("correo");				
						telefono = Integer.parseInt(request.getParameter("telefono"));				
						out.println(g.toJson(al.update(new Alumno(ida, idescuela, nombre, correo, telefono))));
			    break;
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
