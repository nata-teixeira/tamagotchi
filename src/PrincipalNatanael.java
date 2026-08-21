package Tamagotchi;

// Classe principal responsável pela lógica do programa

public class PrincipalNatanael {
	
	// Método main responsável por inicializar o programa
	
	public static void main (String[] args) {
		
		// Cria o objeto ta
		
		TamagotchiNatanael ta = new TamagotchiNatanael(Teclado.leString("Digite o nome: "));
		
		int math;
		
		while(true) {
			
			ta.imprimirInfo();
			
			// Método que controla a aleatoriedade que os métodos da classe Tamagotchi serão invocados
			
			math = (int)(Math.random()*3);
			
			if (math == 0)
				 ta.sentirSono();
			
			else if (math == 1)
				ta.sentirFome(0);
			
			else if (math == 2)
				ta.ficarEntediado();	
		}
	}

}
