package edu.upc.dsa;

import edu.upc.dsa.models.Usuario;

public interface IUsuarioDAO {

    public String addUsuario(String correo, String apodo, String nombre, String apellido, String password);
    public Usuario getUsuario(String apodo);
    public Usuario getUsuarioByCorreo(String correo);
    public void updateUsuario(String correo, String apodo, String name, String apellido, String password);
    public void deleteUsuario(String correo);
    public Usuario login(String apodo, String password);

    /*public List<Employee> getEmployees();
    public List <Employee> getEmployeeByDept(int deptId);*/
}
