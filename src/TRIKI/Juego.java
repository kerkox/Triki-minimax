/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TRIKI;

public class Juego {

    public int tablero[][];
    //Jugador j1;
    //Jugador j2;
    public Movimiento m1;

    public Juego(int ancho, int largo) {
        this.m1 = new Movimiento();
        this.tablero = new int[ancho][largo];
        int valor = 1;
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < largo; y++) {
                this.tablero[x][y] = 0;
            }
        }
        //0,0,0,0,0,0,0,0,0;
        //cosntructor
    }

    public void IncioPC(int pos, int fichaP) {
        m1.Mover2(pos, this, fichaP);
    }

    public int jugar(Jugador player, int pos) {
        m1 = new Movimiento();
        int win = 0;
        int fichaP = player.darTurno() * 10 + player.darTurno();
        if (m1.Mover(pos, this, fichaP) == 1) {
            return -1;
        } else {
            m1.Mover(pos, this, fichaP);
        }

        win = m1.ganador(this);
        if (m1.ganador(this) == 1) {
            return win;
        } else if (m1.ganador(this) == 2) {
            return win;
        }

        return win;

    }

    public int jugadaPC(Jugador pc, Jugador j1, int jugadas) {
        int pos = 0;
        pos = m1.moverPC(this, j1, pc);
        return pos;

    }

}
