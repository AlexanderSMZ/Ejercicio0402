/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servicio;

import java.util.List;
import modelo.Dignidad;

/**
 *
 * @author ASUS
 */
public interface IDignidadServicio {
    public Dignidad crear(Dignidad dignidad);
    public Dignidad modificar(int codigoDignidad, Dignidad dignidadNueva);
    public Dignidad eliminar(int codigoDignidad);
    public Dignidad buscarPorCodigo(int codigoDignidad);
    public int buscarPosicion(Dignidad dignidad);
    public List<Dignidad> listar();
    public boolean almacenarEnArchivo(Dignidad dignidad, String rutaArchivo)throws Exception;
    public List<Dignidad> recuperarDeArchivo(String rutaArchivo) throws Exception;
    
}
