/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TRIKI.UI;

import TRIKI.Juego;
import TRIKI.Jugador;
import java.util.Random;

/**
 *
 * @author Poolker
 */
public class Tipojuego extends javax.swing.JFrame {

    /**
     * Creates new form Tipojuego
     */
    private Juego G1;
    public Jugador j1;
    public Jugador j2;
    public int tipo = 0;
    private int turno = 1;
    private int winer = 0;
    private int jugadas = 1;
    private int TurnoPC = 1;
    private int iniciar = 1;
    private int HistoryStart = 1;
    private Random md;
    private int posP;

    public Tipojuego() {

//        this.game.setVisible(true);
        initComponents();
        G1 = new Juego(3, 3);
        j1 = new Jugador(1, "Jugador 1");
        j2 = new Jugador(2, "Jugador 2");
        md = new Random();
        //mostrarMatriz();
        showTurno(this.j1);
        

    }

    public void IniciaPC(){
         
    }
    private void showTurno(Jugador player) {

        if (player.darTurno() == 1) {
            ShowTurno.setText(player.darNombre() + ": FICHA: X");
        } else {
            ShowTurno.setText(player.darNombre() + ": FICHA: O");
        }

        String Valuejugada;
        if (this.jugadas > 9 || this.winer != 0) {
            Numjugada.setText("9");
        } else {
            Valuejugada = String.valueOf(this.jugadas);
            Valuejugada = Integer.toString(this.jugadas);
            Numjugada.setText(Valuejugada);
        }
    }

    public void Matriz() {
        System.out.println("| " + G1.tablero[0][0] + " | " + G1.tablero[0][1] + " | " + G1.tablero[0][2] + " |");
        System.out.println("| " + G1.tablero[1][0] + " | " + G1.tablero[1][1] + " | " + G1.tablero[1][2] + " |");
        System.out.println("| " + G1.tablero[2][0] + " | " + G1.tablero[2][1] + " | " + G1.tablero[2][2] + " |");
    }

    public void jugadaPC() {
        int posPC = G1.jugadaPC(j2, j1, this.jugadas);
        this.winer = G1.m1.ganador(G1);
        if (this.winer == -1) {
            aviso.setText("ERROR PC no sabe que hacer valor pos: " + posPC);
        } else {
            switch (posPC) {
                case 1:
                    pos1.setText("PC");
                    this.jugadas++;
                    break;
                case 2:
                    pos2.setText("PC");
                    this.jugadas++;
                    break;
                case 3:
                    pos3.setText("PC");
                    this.jugadas++;
                    break;
                case 4:
                    pos4.setText("PC");
                    this.jugadas++;
                    break;
                case 5:
                    pos5.setText("PC");
                    this.jugadas++;
                    break;
                case 6:
                    pos6.setText("PC");
                    this.jugadas++;
                    break;
                case 7:
                    pos7.setText("PC");
                    this.jugadas++;
                    break;
                case 8:
                    pos8.setText("PC");
                    this.jugadas++;
                    break;
                case 9:
                    pos9.setText("PC");
                    this.jugadas++;
                    break;
            }
        }

    }

    public void ModeHuman(int pos, javax.swing.JButton b) {

        aviso.setText(" ");

        //*******************************//
        if (this.jugadas > 9 || this.winer != 0) {
            aviso.setText("Fin del Juego");
        } else {

            if (this.turno == 1) {

                this.winer = G1.jugar(j1, pos);
                if (this.winer == -1) {
                    aviso.setText("ERROR POSICION OCUPADA");
                    this.winer = 0;

                } else {
                    b.setText("X");
                    this.turno += 1;
                    this.jugadas++;
                    showTurno(j2); // PARA MOSTRAR EL TURNO AL SIGUIENTE
                }

            } else if (this.turno == 2) {

                this.winer = G1.jugar(j2, pos);

                if (this.winer == -1) {
                    aviso.setText("ERROR POSICION OCUPADA");
                    this.winer = 0;
                } else {
                    b.setText("O");
                    this.turno -= 1;
                    this.jugadas++;
                    showTurno(j1); // PARA MOSTRAR EL TURNO AL SIGUIENTE
                }

            }

            if (this.winer == 1) {
                nameWin.setText(j1.darNombre());
                this.jugadas = 9;

            } else if (this.winer == 2) {
                nameWin.setText(j2.darNombre());
                this.jugadas = 9;
            }

            // EVALUCION DE NADIE GANADOR
            if ((this.jugadas > 9) && (this.winer == 0)) {
                nameWin.setText("Nadie GANA");
            }

        }

    }

    @SuppressWarnings("empty-statement")
    public void ModePC(int pos, javax.swing.JButton b) {

        this.TurnoPC = 1;
        //############################
        //############################
        //Aqui es el juego del PC Vs Humano
        aviso.setText(" ");

        //*******************************//
        if (this.jugadas > 9 || this.winer != 0) {
            aviso.setText("Fin del Juego");
        } else {
            //con esto evaluo quien comienza 
            // 1 comienza Humano
            // 2 Comeinza PC
            // 0 Varia el comienzo
           
            //aqui ya se comienza a decidir quien juega

            if (this.iniciar == 1) {

                if (this.turno == 1) {

                    this.winer = G1.jugar(j1, pos);
                    if (this.winer == -1) {
                        aviso.setText("ERROR POSICION OCUPADA");
                        this.winer = 0;
                        this.TurnoPC = 0;
                    } else {
                        if (this.winer == 1) {
                            this.TurnoPC = 0;
                        }
                        b.setText("X");
                        this.jugadas++;
                        showTurno(j2); // PARA MOSTRAR EL TURNO AL SIGUIENTE

                    }
                    if (this.TurnoPC == 1) {
                        if (this.jugadas > 9 || this.winer != 0) {
                            aviso.setText("Fin del Juego");
                        } else {
                            jugadaPC();

                        }
                    }
                }

                if (this.winer == 1) {
                    nameWin.setText(j1.darNombre());
                    this.jugadas = 9;
                    this.iniciar = 1;
                    //Si gana tiene derecho a iniciar en la proxima
                } else if (this.winer == 2) {
                    nameWin.setText(j2.darNombre());
                    this.jugadas = 9;
                    this.iniciar = 2;
                    //Si gana tiene derecho a iniciar en la proxima
                }

                // EVALUCION DE NADIE GANADOR
                if ((this.jugadas > 9) && (this.winer == 0)) {
                    nameWin.setText("Nadie GANA");
                    this.iniciar = 0;
                    //se decide al azar;
                }

            } 
            

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Grafico = new javax.swing.JFrame();
        jLabel3 = new javax.swing.JLabel();
        pos1 = new javax.swing.JButton();
        pos4 = new javax.swing.JButton();
        pos5 = new javax.swing.JButton();
        pos2 = new javax.swing.JButton();
        pos3 = new javax.swing.JButton();
        pos6 = new javax.swing.JButton();
        pos9 = new javax.swing.JButton();
        pos8 = new javax.swing.JButton();
        pos7 = new javax.swing.JButton();
        aviso = new javax.swing.JLabel();
        nameWin = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        restart = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ShowTurno = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Numjugada = new javax.swing.JLabel();
        inicio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pc = new javax.swing.JButton();
        humano = new javax.swing.JButton();

        Grafico.setTitle("Juego TRIKI by POOLKER v1.9.0");
        Grafico.setMinimumSize(new java.awt.Dimension(546, 483));
        Grafico.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                GraficoWindowClosing(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel3.setText("JUEGO DE TRIKI By BRYANKER v1.9");

        pos1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        pos1.setText("1");
        pos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pos1ActionPerformed(evt);
            }
        });

        pos4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        pos4.setText("4");
        pos4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pos4ActionPerformed(evt);
            }
        });

        pos5.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        pos5.setText("5");
        pos5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pos5ActionPerformed(evt);
            }
        });

        pos2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        pos2.setText("2");
        pos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pos2ActionPerformed(evt);
            }
        });

        pos3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        pos3.setText("3");
        pos3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pos3ActionPerformed(evt);
            }
        });

        pos6.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        pos6.setText("6");
        pos6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pos6ActionPerformed(evt);
            }
        });

        pos9.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        pos9.setText("9");
        pos9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pos9ActionPerformed(evt);
            }
        });

        pos8.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        pos8.setText("8");
        pos8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pos8ActionPerformed(evt);
            }
        });

        pos7.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        pos7.setText("7");
        pos7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pos7ActionPerformed(evt);
            }
        });

        aviso.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        nameWin.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel4.setText("GANADOR ");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Avisos:");

        restart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        restart.setText("Reiniciar");
        restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("Turno del Jugador:");

        ShowTurno.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Jugadas:");

        Numjugada.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        inicio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        inicio.setText("Inicio");
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GraficoLayout = new javax.swing.GroupLayout(Grafico.getContentPane());
        Grafico.getContentPane().setLayout(GraficoLayout);
        GraficoLayout.setHorizontalGroup(
            GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GraficoLayout.createSequentialGroup()
                .addGroup(GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GraficoLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pos4)
                            .addComponent(pos1)
                            .addComponent(pos7))
                        .addGap(18, 18, 18)
                        .addGroup(GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pos2)
                            .addGroup(GraficoLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(pos5))
                            .addComponent(pos8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GraficoLayout.createSequentialGroup()
                                .addComponent(pos9)
                                .addGap(71, 71, 71)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Numjugada, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 48, Short.MAX_VALUE))
                            .addGroup(GraficoLayout.createSequentialGroup()
                                .addGroup(GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pos6)
                                    .addComponent(pos3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ShowTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20))
                    .addGroup(GraficoLayout.createSequentialGroup()
                        .addGroup(GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameWin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(GraficoLayout.createSequentialGroup()
                                .addComponent(aviso, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(GraficoLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(GraficoLayout.createSequentialGroup()
                .addComponent(restart, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );
        GraficoLayout.setVerticalGroup(
            GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GraficoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GraficoLayout.createSequentialGroup()
                        .addGroup(GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pos1)
                            .addComponent(pos2)
                            .addComponent(pos3))
                        .addGap(18, 18, 18)
                        .addGroup(GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pos4)
                            .addComponent(pos5)
                            .addComponent(pos6)))
                    .addGroup(GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(GraficoLayout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(53, 53, 53))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GraficoLayout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addComponent(ShowTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GraficoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pos7)
                            .addGroup(GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pos9)
                                .addComponent(pos8))))
                    .addGroup(GraficoLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Numjugada, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameWin, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aviso, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(restart, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        setTitle("TRIKI by POOLKER v1.9.0");

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setText("JUEGO DE TRIKI By BRYANKER v1.9");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel2.setText("Selecciona el tipo de Juego");

        pc.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        pc.setText("Humano Vs PC");
        pc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pcActionPerformed(evt);
            }
        });

        humano.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        humano.setText("Humano Vs Humano");
        humano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                humanoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(pc, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(108, 108, 108)
                            .addComponent(humano, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pc, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(humano, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcActionPerformed
        this.setVisible(false);
        Grafico.setVisible(true);
        this.tipo = 2;
        this.j1 = new Jugador(1, "Jugador 1");
        this.j2 = new Jugador(2, "PC");
     

// TODO add your handling code here:
    }//GEN-LAST:event_pcActionPerformed

    private void humanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_humanoActionPerformed
        this.setVisible(false);
        Grafico.setVisible(true);
        this.tipo = 1;
        this.j1 = new Jugador(1, "Jugador 1");
        this.j2 = new Jugador(2, "Jugador 2");
//        this.game=new Grafico();
//        this.game.setVisible(true);
//        this.game.tipo=1;
//        this.game.j1=new Jugador(1,"Jugador 1");
//        this.game.j2=new Jugador(2,"Jugador 2");
        //this.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_humanoActionPerformed
//###  1
    private void pos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pos1ActionPerformed
        Matriz();
        if (this.tipo == 1) {
            ModeHuman(1, pos1);

        } else if (this.tipo == 2) {
            ModePC(1, pos1);
        }
        //Aqui Finaliza el if del tipo de JUego
        // TODO add your handling code here:
    }//GEN-LAST:event_pos1ActionPerformed

//###  4  
    private void pos4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pos4ActionPerformed
        Matriz();
        if (this.tipo == 1) {
            ModeHuman(4, pos4);

        } else if (this.tipo == 2) {
            ModePC(4, pos4);
        }
        //Aqui Finaliza el if del tipo de JUego
        // TODO add your handling code here:
    }//GEN-LAST:event_pos4ActionPerformed
//###  5 
    private void pos5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pos5ActionPerformed
        Matriz();
        if (this.tipo == 1) {
            ModeHuman(5, pos5);

        } else if (this.tipo == 2) {
            ModePC(5, pos5);
        }
        //Aqui Finaliza el if del tipo de JUego
        // TODO add your handling code here:
    }//GEN-LAST:event_pos5ActionPerformed
//###  2 
    private void pos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pos2ActionPerformed
        Matriz();
        if (this.tipo == 1) {
            ModeHuman(2, pos2);

        } else if (this.tipo == 2) {
            ModePC(2, pos2);
        }
        //Aqui Finaliza el if del tipo de JUego
        // TODO add your handling code here:
    }//GEN-LAST:event_pos2ActionPerformed
//###  3
    private void pos3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pos3ActionPerformed
        Matriz();
        if (this.tipo == 1) {
            ModeHuman(3, pos3);

        } else if (this.tipo == 2) {
            ModePC(3, pos3);
        }
        //Aqui Finaliza el if del tipo de JUego
        // TODO add your handling code here:
    }//GEN-LAST:event_pos3ActionPerformed
//###  6
    private void pos6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pos6ActionPerformed
        Matriz();
        if (this.tipo == 1) {
            ModeHuman(6, pos6);

        } else if (this.tipo == 2) {
            ModePC(6, pos6);
        }
        //Aqui Finaliza el if del tipo de JUego
        // TODO add your handling code here:
    }//GEN-LAST:event_pos6ActionPerformed
//###  9
    private void pos9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pos9ActionPerformed
        Matriz();
        if (this.tipo == 1) {
            ModeHuman(9, pos9);

        } else if (this.tipo == 2) {
            ModePC(9, pos9);
        }
        //Aqui Finaliza el if del tipo de JUego
        // TODO add your handling code here:
    }//GEN-LAST:event_pos9ActionPerformed
//###  8
    private void pos8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pos8ActionPerformed
        Matriz();
        if (this.tipo == 1) {
            ModeHuman(8, pos8);

        } else if (this.tipo == 2) {
            ModePC(8, pos8);
        }
        //Aqui Finaliza el if del tipo de JUego
        // TODO add your handling code here:
    }//GEN-LAST:event_pos8ActionPerformed
//###  7
    private void pos7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pos7ActionPerformed
        Matriz();
        if (this.tipo == 1) {
            ModeHuman(7, pos7);

        } else if (this.tipo == 2) {
            ModePC(7, pos7);
        }
        //Aqui Finaliza el if del tipo de JUego
        // TODO add your handling code here:
    }//GEN-LAST:event_pos7ActionPerformed


    private void restartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartActionPerformed
        G1 = new Juego(3, 3);
        this.jugadas = 1;
        this.turno = 1;
        this.winer = 0;
        this.TurnoPC = 1;
        aviso.setText(" ");
        nameWin.setText(" ");
        pos1.setText("1");
        pos2.setText("2");
        pos3.setText("3");
        pos4.setText("4");
        pos5.setText("5");
        pos6.setText("6");
        pos7.setText("7");
        pos8.setText("8");
        pos9.setText("9");
        
         if (this.iniciar == 0) {
                // aqui pongo variable quien comienza osea si el anterior fue PC luego Humano
                if (this.HistoryStart == 1) {
                    this.HistoryStart += 1;
                    this.iniciar = 2;
                } else if (this.HistoryStart == 2) {
                    this.HistoryStart -= 1;
                    this.iniciar = 1;
                }

            }
         if (this.iniciar == 2) {
//···········#########RAMDOM DE PC======================================================================
                                
                                posP = (int) (md.nextDouble() * 9 + 1);
                                
                                int fichaPC = (j2.darTurno() * 10) + j2.darTurno();
                                
                                G1.IncioPC(this.posP, fichaPC);
                                
                                switch (posP) {
                                    case 1:
                                        pos1.setText("PC");
                                        this.jugadas++;
                                        break;
                                    case 2:
                                        pos2.setText("PC");
                                        this.jugadas++;
                                        break;
                                    case 3:
                                        pos3.setText("PC");
                                        this.jugadas++;
                                        break;
                                    case 4:
                                        pos4.setText("PC");
                                        this.jugadas++;
                                        break;
                                    case 5:
                                        pos5.setText("PC");
                                        this.jugadas++;
                                        break;
                                    case 6:
                                        pos6.setText("PC");
                                        this.jugadas++;
                                        break;
                                    case 7:
                                        pos7.setText("PC");
                                        this.jugadas++;
                                        break;
                                    case 8:
                                        pos8.setText("PC");
                                        this.jugadas++;
                                        break;
                                    case 9:
                                        pos9.setText("PC");
                                        this.jugadas++;
                                        break;
                                }

            }
         this.iniciar=1;
        showTurno(j1); // PARA MOSTRAR EL TURNO AL SIGUIENTE

        // TODO add your handling code here:
    }//GEN-LAST:event_restartActionPerformed

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        Grafico.setVisible(false);
        this.setVisible(true);
        restart.doClick();

// TODO add your handling code here:
    }//GEN-LAST:event_inicioActionPerformed

    private void GraficoWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_GraficoWindowClosing
        // TODO add your handling code here:
        this.setVisible(true);
        this.restartActionPerformed(null);
    }//GEN-LAST:event_GraficoWindowClosing

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame Grafico;
    private javax.swing.JLabel Numjugada;
    private javax.swing.JLabel ShowTurno;
    private javax.swing.JLabel aviso;
    private javax.swing.JButton humano;
    private javax.swing.JButton inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel nameWin;
    private javax.swing.JButton pc;
    private javax.swing.JButton pos1;
    private javax.swing.JButton pos2;
    private javax.swing.JButton pos3;
    private javax.swing.JButton pos4;
    private javax.swing.JButton pos5;
    private javax.swing.JButton pos6;
    private javax.swing.JButton pos7;
    private javax.swing.JButton pos8;
    private javax.swing.JButton pos9;
    private javax.swing.JButton restart;
    // End of variables declaration//GEN-END:variables
}
