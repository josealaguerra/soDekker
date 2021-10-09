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
public class Principal {
 
    
    static Dekker d= new Dekker();
    
    public static void main(String[] args) throws InterruptedException{

        
//Dekker
		//Hilos aplicando exclución mutua.
		Thread h1= new Thread(new Runnable(){
			@Override
			public void run(){				
                            d.startDekker( 0 );
			}
		});		
		h1.start();
		//Hilos aplicando exclución mutua.
		Thread h2= new Thread(new Runnable(){
			@Override
			public void run(){				
                            d.startDekker( 1 );
			}			
		});
		h2.start();
		
		h1.join();
		h2.join();        
        
        
        
    }
}
