/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorio_telefonico.negocio;

import directorio_telefonico.negocio.Cliente;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Caro_Z
 */
public class Directorio {

   TreeMap<Long, Cliente> directorio = new TreeMap<>();

    public Directorio() {

    }
    
       public boolean agregarCliente(long telefono, Cliente cliente) {

      if (!directorio.containsValue(cliente)) {

            directorio.put(telefono, cliente);
               
            return true;
       }else{
         
          return false;
      }


    }

    public Cliente buscarCliente(long telefono) {

       return directorio.get(telefono);
    }

    public List<Long> buscarTelefono(String apellido) {
        // instancia de variable de retorno

        // para trabajar con claves del mapa se utiliza SET
        ArrayList<Long> telefonos = new ArrayList<>();

        Set<Long> claves = directorio.keySet();
        // no se puede recorrer las parejass con el Iterator, solo las claves solas.

        Iterator<Long> it = claves.iterator();
        while (it.hasNext()) {
            long tel =  it.next();
            // guardar el Next en una variable interna ( telefono)para no repetir tanto la palabra next y que se pasen los datos.
            Cliente c = directorio.get(tel);
            if (c.getApellido().equals(apellido)) { // buscar si el apellido del cliente es el mismo que nos pasan por parametro

                telefonos.add(tel);             // agregamos a la lista todos los telefonos del apellido por parametro
            }
        }
        return telefonos;

    }

    

    public ArrayList<Cliente> buscarClientes(String ciu) {

        //lista con los clientes de dicha ciudad
        ArrayList<Cliente> listacc = new ArrayList<>();
        //  retornar key set y recorren la lista con iterator, obtengo el valor , if ciudad = ciu
        Set<Long> lista = directorio.keySet();

        Iterator<Long> it = lista.iterator();
        while (it.hasNext()) {

            Long t = it.next();
            Cliente c = directorio.get(t);
            {

                if (c.getCiudad().equals(ciu)) {
                    listacc.add(c);
                }
            }
        }
 
        return listacc;
    }

    public Cliente borrarCliente(long telefono) {

        // V remove( Object key)
        Cliente clienteABorrar= directorio.remove(telefono);
        if( clienteABorrar!=null){
            
          JOptionPane.showMessageDialog(null, " EL cliente se ha borrado con éxito");
            
          // mensaje en vistas
//        } 
//        else{
//            
//            JOptionPane.showMessageDialog(null, " No se encontró el teléfono");
            
        } return clienteABorrar;

    }
}
