/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TRIKI;

/**
 *
 * @author bryanker
 */
public class Jugador {
    
    int turno;
    String nombre;
    
    
    public Jugador()
    {
        this.turno=0;
        this.nombre="";
    }
    
    public Jugador(int turno,String name)
    {
        this.turno=turno;
        this.nombre=name;
        
    }
    public int darTurno()
    {
        return turno;
    }
    public String darNombre()
    {
        return nombre;
    }
    
    
    
}
