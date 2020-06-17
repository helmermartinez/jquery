package pe.edu.upeu.alumnos.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pe.edu.upeu.alumnos.dao.AlumnosDao;
import pe.edu.upeu.alumnos.entity.Alumno;
import pe.edu.upeu.alumnos.util.Conexion;

public class AlumnosDaoImp implements AlumnosDao{
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;
	public int create(Alumno u) {
		// TODO Auto-generated method stub
		int x = 0;
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement("insert into alumno(idescuela,apellnombres,correo,telefono) values(?,?,?,?)");
			ps.setInt(1, u.getIdescuela());
			ps.setString(2, u.getNombre());
			ps.setString(3, u.getCorreo());
			ps.setInt(4, u.getTelefono());
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return x;
	}
	@Override
	public int update(Alumno u) {
		// TODO Auto-generated method stub
				int x = 0;
				String sql = "UPDATE alumno SET idescuela = ?, apellnombres = ?, correo = ?, telefono = ? WHERE idalumno = ?";
				try {
					cx = Conexion.getConexion();
					ps = cx.prepareStatement(sql);
					ps.setInt(1, u.getIdescuela());
					ps.setString(2, u.getNombre());
					ps.setString(3, u.getCorreo());
					ps.setInt(4, u.getTelefono());
					ps.setInt(5, u.getIdalumno());
					x = ps.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
				return x;
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
				int x = 0;
				// TODO Auto-generated method stub
				String sql= "DELETE FROM alumno WHERE idalumno= ?";
				try {
					cx = Conexion.getConexion();
					ps = cx.prepareStatement(sql);
					ps.setInt(1, id);
					x = ps.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
				}
				return x;
	}
	@Override
	public List<Map<String, Object>> read(int id) {
		// TODO Auto-generated method stub
				List<Map<String,Object>> list = new ArrayList<>();
				String sql = "select c.idescuela, c.nombrecat, "+
				             "p.idalumno, p.apellnombres, "+ 
						     "p.correo, p.telefono from alumno as p,"+
				             " escuela as c where c.idescuela= p.idescuela and p.idalumno=?";
				try {
					cx = Conexion.getConexion();
					ps = cx.prepareStatement(sql);
					ps.setInt(1, id);
					rs = ps.executeQuery();
					while(rs.next()) {
						Map<String,Object> map = new HashMap<String, Object>();
		                map.put("idescuela", rs.getInt("idescuela"));
		                map.put("nombrecat", rs.getString("nombrecat"));
		                map.put("idlumno", rs.getInt("idalumno"));
		                map.put("apellnombres", rs.getString("apellnombres"));
		                map.put("correo", rs.getString("correo"));
		                map.put("telefono", rs.getInt("telefono"));
					    list.add(map);
					    
					}
					
				} catch (Exception e) {
					System.out.println(e);
				}
				return list;
	}
	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
				List<Map<String,Object>> list = new ArrayList<>();
				String sql = "select c.idescuela, c.nombrecat, "+
				             "p.idalumno, p.apellnombres, "+ 
						     "p.correo, p.telefono from alumno as p,"+
				             " escuela as c where c.idescuela= p.idescuela";
				try {
					cx = Conexion.getConexion();
					ps = cx.prepareStatement(sql);
					rs = ps.executeQuery();
					while(rs.next()) {
						Map<String,Object> map = new HashMap<String, Object>();
		                map.put("idescuela", rs.getInt("idescuela"));
		                map.put("nombrecat", rs.getString("nombrecat"));
		                map.put("idalumno", rs.getInt("idalumno"));
		                map.put("apellnombres", rs.getString("apellnombres"));
		                map.put("correo", rs.getString("correo"));
		                map.put("telefono", rs.getInt("telefono"));
					    list.add(map);
					    
					}
					
				} catch (Exception e) {
					System.out.println(e);
				}
				return list;
	}
}
