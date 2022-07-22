/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.Eleccion;

/**
 *
 * @author ASUS
 */
public class EleccionServicio implements IEleccionServicio{
    
    private static List<Eleccion> eleccionList = new ArrayList<>();

    @Override
    public Eleccion crear(Eleccion eleccion) {
        var eleccionBuscado=this.buscarPorCodigo(eleccion.getCodigo());
        if(eleccionBuscado==null){
            this.eleccionList.add(eleccion);
            try{
                this.almacenarEnArchivo(eleccion,"C:/carpeta1/archivoEleccion.dat");
            }catch(IOException ex){
//            throw new IOException("Eleccion no se pudo almacenar en el "
//                    + " archivo de objetos"+ex.getMessage());                
            }
        }else{
            throw new RuntimeException("El código ingresado ya se encuentra "
                    + "asignado al Servicio: "+eleccionBuscado.getDescripcion());            
        }

        return eleccion;
    }    
    
    
    @Override
    public List<Eleccion> listar() {
        return this.eleccionList;
    }

    @Override
    public Eleccion buscarPorCodigo(int codigoEleccion) {
        Eleccion eleccion=null;
        for(var c:this.eleccionList){
            if(codigoEleccion==c.getCodigo()){
                eleccion=c;
                break;
            }
        }
        return eleccion;
    }

    @Override
    public boolean almacenarEnArchivo(Eleccion eleccion,String rutaArchivo) throws IOException {
        var retorno=false;
        DataOutputStream salida = null;        
        try{
            salida = new DataOutputStream(new FileOutputStream(rutaArchivo,true));
            salida.writeInt(eleccion.getCodigo());
            salida.writeUTF(eleccion.getDescripcion());
            salida.writeUTF(eleccion.getForma());
            salida.close();
            retorno=true;
        }catch(IOException e){
            salida.close();
        }
        return retorno;
    }

//    @Override
//    public List<Eleccion> recuperarDeArchivo(String rutaArchivo) throws IOException {
//        return new ArrayList<Eleccion>();
//    }
 
    
}
