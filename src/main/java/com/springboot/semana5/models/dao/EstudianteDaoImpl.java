package com.springboot.semana5.models.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.semana5.models.entitys.Estudiante;
@Repository
public class EstudianteDaoImpl implements IEstudianteDao {
	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public List<Estudiante> listar() {
		String sql = "Select * from estudiante";
		List<Estudiante>lista= jdbc.query(sql,BeanPropertyRowMapper.newInstance(Estudiante.class));
		return lista;
	}

	@Override
	public int guardar(Estudiante est) {
		String sql = "Insert into estudiante(nombre,apellido,telefono,correo) values(?,?,?,?)";
		return jdbc.update(sql, est.getNombre(),est.getApellido(),est.getTelefono(),est.getCorreo());
	}

	@Override
	public Estudiante buscarID(int id) {
		String sql = "select * from estudiante where idestudiante = ?";
		Estudiante est = jdbc.queryForObject(sql, new Object[] {id},BeanPropertyRowMapper.newInstance(Estudiante.class));
		return est;
	}

	@Override
	public int borrar(int id) {
		String sql = "delete from estudiante where idestudiante =?";
		return jdbc.update(sql, id);
	}

	@Override
	public int actualizar(Estudiante est) {
		String sql = "update estudiante set nombre=?, apellido=?, telefono=?, correo=? where idestudiante=?";
		return jdbc.update(sql,est.getNombre(),est.getApellido(),est.getTelefono(),est.getCorreo(), est.getIdestudiante());
	}

}
