//SimpleArray.java
//Classe que gerencia um array de inteiros para ser compartilhado por várias threads

import java.security.SecureRandom;
import java.util.Arrays;


public class SimpleArray{ //NÃO SEGURO PARA THREADS
	private static final SecureRandom generator = new SecureRandom();
	private final int [] array; //array de inteiros compartilhado
	private int writeIndex = 0; //indice compartilhado do proximo elemento a gravar
	
	//cria um SimpleArray de um determinado tamanho
	public SimpleArray(int size){
		array = new int [size];	
	}
	
	//adiciona um valor ao array compartilhado
	public void add (int value){
		int position = writeIndex; //armazena o indice de gravação
		
		try{
			//coloca a thread paradormir durante 0 a 499 milisegundos
			Thread.sleep(generator.nextInt(500));
			
		}
		catch(InterruptedException ex){
			Thread.currentThread().interrupt(); //reinterrompe a thread
		}
		
		//coloca o valor no elemento apropriado
		array[position] = value;
		
		System.out.printf("%s wrote %2d to element %d %n", 
				Thread.currentThread().getName(), value, position);
		
		++writeIndex; //indice de incremento de elemento a ser gravado depois
		System.out.printf("Next write index: %d %n", writeIndex);
		
	}		

}
