package com.springboot.semana5.models.dao;

import java.util.List;

import com.springboot.semana5.models.entitys.Estudiante;

public interface IEstudianteDao {
//METODOS CRUD
	public List<Estudiante>listar();
	
	public int guardar(Estudiante est);
	public Estudiante buscarID(int id);
	public int borrar(int id);
	public int actualizar(Estudiante est);
	
}
