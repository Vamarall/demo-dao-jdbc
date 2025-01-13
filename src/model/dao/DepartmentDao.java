package model.dao;

import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public interface DepartmentDao {

    void insert(Department obj); //Operacao responsavel por inserir o obj no BD
    void update(Department obj); // Operação responsável por atualizar os dados de um objeto `obj` existente no banco de dados.
    void deleteById(Integer id); // Operação responsável por remover do banco de dados o registro associado ao identificador `id`.
    Department findById(Integer id); // Operação responsável por buscar no banco de dados um registro do tipo `Department` com base no identificador `id` fornecido.
    List<Department> findALl();// Operação responsável por retornar uma lista com todos os registros do tipo `Department` presentes no banco de dados.

}
