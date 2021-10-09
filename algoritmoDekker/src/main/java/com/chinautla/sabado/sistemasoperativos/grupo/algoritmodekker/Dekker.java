/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinautla.sabado.sistemasoperativos.grupo.algoritmodekker;

/**
 *
 * @author josea
 */
public class Dekker {
    private volatile  int turno;
    private volatile boolean flag [] = {false,false};
    
    /*Constructor donde se inicializan los valores*/
    public Dekker(){
        this.turno=0;
        this.flag= flag;
    }
	

    /**
    * @param id Identificador del hilo, solo puede ser 0 o 1.
    */
    public void startDekker(int id){

        //Seccion no critica 
        int otro=(id+1)%2;
        for (int i=0;i<20 ; i++) {
            flag[id]= true;
            while (flag[otro]==true){
                if (turno ==otro){
                    flag[id]=false;
                    while (turno!=id){
                        //Se espera al otro hilo
                    }
                    flag[id]=true;
                }

            }
            //Seccion critica
            int suma=0;
            System.out.println("Se inicia la sección critica en el hilo: "+id);

            //Suma de los primero 1000 numeros
            for (int j = 0; j < 1000; j++) {
                suma = suma + j;								
            }
            System.out.println("Suma los primeros 1000 números naturales con 20 iteraciones: "+suma);

            System.out.println("Finalizo sección critica del algoritmo de Dekker en el Hilo: "+ id);
            turno=otro;
            flag[id]=false;
            //Seccion no critica
        }   

    }
                        
                        
                        
                        
}
