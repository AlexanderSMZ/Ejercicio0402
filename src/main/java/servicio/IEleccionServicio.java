/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servicio;

import java.io.IOException;
import java.util.List;
import modelo.Dignidad;
import modelo.Eleccion;

/**
 *
 * @author ASUS
 */
public interface IEleccionServicio {
    public Eleccion crear(Eleccion eleccion);
    public Eleccion buscarPorCodigo(int codigoEleccion);
    public List<Eleccion> listar();
    public boolean almacenarEnArchivo(Eleccion eleccion, String rutaArchivo)throws Exception;
//    public List<Eleccion> recuperarDeArchivo(String rutaArchivo) throws IOException;    
}
