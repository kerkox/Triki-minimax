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
public class Movimiento {

    public Movimiento() {

    }

    public int valorPos(int pos, Juego g){
        int x=0, y=0, id;
        switch (pos) {
            case 1:
                id = 1;
                x = 0;
                y = 0;
                break;
            case 2:
                id = 2;
                x = 0;
                y = 1;
                break;
            case 3:
                id = 3;
                x = 0;
                y = 2;
                break;
            case 4:
                id = 4;
                x = 1;
                y = 0;
                break;
            case 5:
                id = 5;
                x = 1;
                y = 1;
                break;
            case 6:
                id = 6;
                x = 1;
                y = 2;
                break;
            case 7:
                id = 7;
                x = 2;
                y = 0;
                break;
            case 8:
                id = 8;
                x = 2;
                y = 1;
                break;
            case 9:
                id = 9;
                x = 2;
                y = 2;
                break;

        }

        return g.tablero[x][y];
        
    }
    public int ganador(Juego g) {
        int winer = 0;
        // REVISION DE FORMA HORIZONTAL
        for (int i = 0; i < 3; i++) {
            if ((g.tablero[0][i] == 11) && (g.tablero[1][i] == 11) && (g.tablero[2][i] == 11)) {
                winer = 1;
            }
            if ((g.tablero[0][i] == 22) && (g.tablero[1][i] == 22) && (g.tablero[2][i] == 22)) {
                winer = 2;
            }
        }

        // REVISION DE FORMA VERTICAL
        for (int i = 0; i < 3; i++) {
            if ((g.tablero[i][0] == 11) && (g.tablero[i][1] == 11) && (g.tablero[i][2] == 11)) {
                winer = 1;
            }
            if ((g.tablero[i][0] == 22) && (g.tablero[i][1] == 22) && (g.tablero[i][2] == 22)) {
                winer = 2;
            }
        }

        // DIAGONALES
        //Diagonal de izquierda a derecha
        if ((g.tablero[0][0] == 22) && (g.tablero[1][1] == 22) && (g.tablero[2][2] == 22)) {
            winer = 2;
        }
        if ((g.tablero[0][0] == 11) && (g.tablero[1][1] == 11) && (g.tablero[2][2] == 11)) {
            winer = 1;
        }
        //diagonal de derecha a izquierda
        if ((g.tablero[0][2] == 22) && (g.tablero[1][1] == 22) && (g.tablero[2][0] == 22)) {
            winer = 2;
        }
        if ((g.tablero[0][2] == 11) && (g.tablero[1][1] == 11) && (g.tablero[2][0] == 11)) {
            winer = 1;
        }

        return winer;

    }
    
    
    public void Mover2(int pos, Juego g, int ficha) {
        int x = 0, y = 0;
        switch (pos) {
            case 1:
                x = 0;
                y = 0;
                break;
            case 2:
                x = 0;
                y = 1;
                break;
            case 3:
                x = 0;
                y = 2;
                break;
            case 4:
                x = 1;
                y = 0;
                break;
            case 5:
                x = 1;
                y = 1;
                break;
            case 6:
                x = 1;
                y = 2;
                break;
            case 7:
                x = 2;
                y = 0;
                break;
            case 8:
                x = 2;
                y = 1;
                break;
            case 9:
                x = 2;
                y = 2;
                break;

        }

       
                g.tablero[x][y] = ficha;
            
        

       
    }
    
    
//    public int Mover(int pos,int tab[][],int turno)
    public int Mover(int pos, Juego g, int ficha) {
        int x = 0, y = 0;
        switch (pos) {
            case 1:
                x = 0;
                y = 0;
                break;
            case 2:
                x = 0;
                y = 1;
                break;
            case 3:
                x = 0;
                y = 2;
                break;
            case 4:
                x = 1;
                y = 0;
                break;
            case 5:
                x = 1;
                y = 1;
                break;
            case 6:
                x = 1;
                y = 2;
                break;
            case 7:
                x = 2;
                y = 0;
                break;
            case 8:
                x = 2;
                y = 1;
                break;
            case 9:
                x = 2;
                y = 2;
                break;

        }

        if ((posFree(pos, g) == false)) {
            // Error devuelto con 1 o 0
            return 1;
            //throw Posicion_Ocupada;
            // Lanzar ERROR ######
        } else {
            
                g.tablero[x][y] = ficha;
            
        }
        return 0;

       
    }

    //Evalua si la posicion pasada esta libre
    public boolean posFree(int pos, Juego g) {
        int x = 0, y = 0, id = 0;
        boolean free;
        switch (pos) {
            case 1:
                id = 1;
                x = 0;
                y = 0;
                break;
            case 2:
                id = 2;
                x = 0;
                y = 1;
                break;
            case 3:
                id = 3;
                x = 0;
                y = 2;
                break;
            case 4:
                id = 4;
                x = 1;
                y = 0;
                break;
            case 5:
                id = 5;
                x = 1;
                y = 1;
                break;
            case 6:
                id = 6;
                x = 1;
                y = 2;
                break;
            case 7:
                id = 7;
                x = 2;
                y = 0;
                break;
            case 8:
                id = 8;
                x = 2;
                y = 1;
                break;
            case 9:
                id = 9;
                x = 2;
                y = 2;
                break;

        }

        if (g.tablero[x][y] == 0) {
            // 1 si esta libre
            free = true;
            //throw Posicion_Ocupada;
            // Lanzar ERROR ######
        } else {
            free = false;
        }
        return free;
    }

    //Evalua si almenos queda una casilla libre devuelve TRUE
    //si todas estan ocupadas devuevle FALSE   
    public boolean posicionesFree(Juego g) {
        int i;
        
        for(i=1;i<10;i++)
        {
                       
        if(posFree(i,g)){

            return true;
            
        }
        }

        return false;

    }

    public int moverPC(Juego g, Jugador j1, Jugador PC)
    {
        int pos=0, k;
        int FichaPC=(PC.darTurno()*10)+PC.darTurno();
        int FichaJ1=(j1.darTurno()*10)+j1.darTurno();
        int aux, mejor=-9999;
        
        for(int i=1;i<10;i++){
            if(posFree(i,g))
            {
                Mover2(i,g,FichaPC);
                
                aux=min(g,j1,PC);
                if(aux>mejor)
                {
                    mejor=aux;
                    pos=i;
                }
                
                Mover2(i,g,0);
                
            }
            
        }
        Mover2(pos,g,FichaPC);//Marca PC
      
        return pos;
    }
    
    public int min(Juego g, Jugador j1, Jugador PC)
    {
        int FichaJ1=(j1.darTurno()*10)+j1.darTurno();
         //Si gana PC
        if(ganador(g)==2) return 1;
        if(!posicionesFree(g)) return 0;
        int aux, mejor=9999;
        for(int i=1;i<10;i++)
        {
            if(posFree(i,g)){
                Mover2(i,g,FichaJ1);
                aux=max(g,j1,PC);
                System.out.println("Valor aux +++Max: " + aux);
                if(aux<mejor)
                {
                    mejor=aux;
                }
               
                Mover2(i,g,0);
                
            }
        }
        
        return mejor;
    }
   
    
      public int max(Juego g, Jugador j1, Jugador PC)
    {
        int FichaPC=(PC.darTurno()*10)+PC.darTurno();
        //Si gana PC
        if(ganador(g)==1) return -1;
        if(!posicionesFree(g)) return 0;
        int aux, mejor=-9999;
        for(int i=1;i<10;i++)
        {
            if(posFree(i,g)){
                Mover2(i,g,FichaPC);
                aux=min(g,j1,PC);
                System.out.println("Valor aux ---Min: " + aux);
                if(aux>mejor)
                {
                    mejor=aux;
                }
                
                Mover2(i,g,0);
                
            }
        }
        
        return mejor;
    }
   

}
