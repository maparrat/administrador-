package logica;
/**
 * Esta es la clase dueña de la logica de la aplicacion. Esta se encarga de ser el pico de las clases
 * @author Miguel Armando Parra cc 1019150704
 *
 */

import java.sql.Date;
import java.util.ArrayList;

public class AdministradorUsuarios {
	//------------------------------------------------------------------------------------
	//                         ATRIBUTOS
	//-----------------------------------------------------------------------------------

	//Nombre del autor del proyecto
	private String creador;
	//Version de la aplicacion
	private String version;
	//Array de usuarios registrados en la aplicacion
	private ArrayList<Persona> usuarios ;
	//------------------------------------------------------------------------------------
	//                         CONSTRUCTOR
	//-----------------------------------------------------------------------------------
	public AdministradorUsuarios()
	{
		creador = "Miguel Armando Parra";
		version = "V1.0";
		usuarios = new ArrayList<Persona>();

	}

	//------------------------------------------------------------------------------------
	//                        GETERS AND SETTERS 
	//-----------------------------------------------------------------------------------
	/**
	 * @return the creador
	 */
	public String getCreador() {
		return creador;
	}
	/**
	 * @param creador the creador to set
	 */
	public void setCreador(String creador) {
		this.creador = creador;
	}
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * @return the usuarios
	 */
	public ArrayList<Persona> getUsuarios() {
		return usuarios;
	}
	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(ArrayList<Persona> usuarios) {
		this.usuarios = usuarios;
	}

	//------------------------------------------------------------------------------------
	//                         METODOS
	//-----------------------------------------------------------------------------------

	/**
	 * Crea un usuario nuevo
	 * @param pNombre
	 * @param pFecha
	 * @param pCedula
	 * @param pEmail
	 * @param pContrasenia
	 */
	public void agregarUsuario(String pNombre, Date pFecha,long pCedula, String pEmail,String pContrasenia)
	{
		try {
			Persona nuevo = new Persona(pNombre,pFecha,pCedula, pEmail,pContrasenia);
			usuarios.add(nuevo);
		}
		catch( Exception e)
		{
			System.out.println("Los datos no son coherentes"+e);
		}
	}
	
	/**
	 * Verifica las credenciales de un usuario
	 * @param pCorreo
	 * @param pContrasenia
	 * @return
	 */
	public boolean inicioSecion(String pCorreo , String pContrasenia)
	{
		boolean respuesta = false;
		try {
			Persona encontrado = getPersonaCorreo(pCorreo);
			if(encontrado.getContrasenia().equals(pContrasenia))
			{
				respuesta = true;
			}
		}
		catch(Exception e)
		{
			
		}
		return respuesta;
	}
	
	/**
	 * Retorna una persona por su correo
	 * @param pCorreo
	 * @return
	 */
	public Persona getPersonaCorreo(String pCorreo)
	{
		Persona encontrado= null; 
		for(int i = 0; i < usuarios.size() && encontrado == null; i++)
		{
			if (usuarios.get(i).getCorreo().equals(pCorreo) )
			{
				encontrado = usuarios.get(i);
			}
		}
		return encontrado;
	}
}
