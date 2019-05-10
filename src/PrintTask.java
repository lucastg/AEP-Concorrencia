//Figura 23.3: PrintTask.java
//Classe PrintTask dorme por tempo alet�rio de 0 a 5 segundos


import java.security.SecureRandom;

public class PrintTask implements Runnable{
	private static final SecureRandom generator = new SecureRandom();
	private final int sleepTime; // tempo de adormecimento aleatorio para a thread private final String taskName;
	private final String taskName;
	
	//construtor
	public PrintTask(String taskName){
		this.taskName = taskName;

		//seleciona tempo de adormecimento aleatorio entre 0 e 5 segundos
		sleepTime = generator.nextInt(5000); // milissegundos
	}

 	//metodo run contém o código que uma thread executará
	public void run(){
	 	try
	 	{ //coloca a thread para dormir pela quantidade de tempo sleepTime 
	 		
			System.out.printf("%s going to sleep for %d milliseconds.%n", taskName, sleepTime);
			Thread.sleep(sleepTime); // coloca a thread para dormir
		}
	 	
	 	catch(InterruptedException exception){
			exception.printStackTrace();
			Thread.currentThread().interrupt(); // reinterrompe a thread
	 	}

		//imprime o nome da tarefa
		System.out.printf("%s done sleeping%n", taskName);
	}
} // fim da classe PrintTask