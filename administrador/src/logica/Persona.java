package logica;

import java.sql.Date;
import java.util.ArrayList;
/**
 * Clase que representa los usuarios dueños de sus anios financieros 
 * @author Miguel Armando Parra cc 10191507004
 *
 */
public class Persona {
	//--------------------------------------------------------------------------------
	//                           ATRIBUTOS
	//-------------------------------------------------------------------------------
	//Nombre del usuario
	private String nombre;
	//Fecha de nacimiento
	private Date fechaNacimiento;
	//Numero de cedula del usuario
	private long cedula;
	//Correo electronico
	private String correo;
	//Contrasenia del usuartio
	private String contrasenia;
	//lista de anios financieros
	private ArrayList<Anio> anios;
	//----------------------------------------------------------------------------------
	//                      CONSTRUCTOR
	//---------------------------------------------------------------------------------
	/**
	 * Constructor de un usuario
	 * @param pNombre
	 * @param pFecha
	 * @param pCedula
	 * @param pEmail
	 * @param pContrasenia
	 */
	public Persona (String pNombre, Date pFecha,long pCedula, String pEmail,String pContrasenia)
	{
		nombre = pNombre;
		fechaNacimiento=pFecha;
		cedula = pCedula;
		correo = pEmail;
		contrasenia = pContrasenia;
		anios = new ArrayList<Anio>();
		Anio primerAnio= new Anio(fechaNacimiento.getYear());
		anios.add(primerAnio);
	}
	//---------------------------------------------------------------------------------
	//                  GETTERS AND SETTERS
	//--------------------------------------------------------------------------------
	
	/**
	 * @return the anios
	 */
	public ArrayList<Anio> getAnios() {
		return anios;
	}

	/**
	 * @param anios the anios to set
	 */
	public void setAnios(ArrayList<Anio> anios) {
		this.anios = anios;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the contrasenia
	 */
	public String getContrasenia() {
		return contrasenia;
	}

	/**
	 * @param contrasenia the contrasenia to set
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the cedula
	 */
	public long getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}
	//----------------------------------------------------------------
	//                     METODOS
	//----------------------------------------------------------------
	/**
	 * Retorna el anio financiero 
	 * @param pAnio
	 * @return null si no existe
	 */
	public Anio getAnio(int pAnio)
	{
		Anio respuesta = null;
		for(int i = 0; i < anios.size() && respuesta == null; i++)
		{
			if (anios.get(i).getAnio() ==(pAnio) )
			{
				respuesta = anios.get(i);
			}
		}
		return respuesta; 
	}
	/**
	 * Agrega un anio financiero
	 */
	public void agregarAnio()
	{
		int anio = anios.get(anios.size()-1).getAnio();
		Anio nuevo = new Anio(anio+1);
		anios.add(nuevo);
	}
}
