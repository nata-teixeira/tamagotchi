package Tamagotchi;

// Classe que contém os atributos e métodos do personagem

public class TamagotchiNatanael {

	private String nome;
	private int idade = 0;
	private double peso = 1.0;
	private int acordado = 0;
	private int escolha;
	
	// Método construtor, getters e setters
	
	public TamagotchiNatanael (String nome) {
		
		this.nome = nome;
		
	}
	
	public void setNome (String nome) {
		
		this.nome = nome;
	}
	
	public void setIdade (int idade) {
		
		this.idade = idade;
	}
	
	
	public void setPeso (double peso) {
		
		this.peso = peso;
	}
	
	public String getNome () {
		return nome;
	}
	
	public int getIdade ( ) {
		return idade;
	}
	
	public double getPeso () {
		return peso;
	}
	
	// Método que exibe as informações na tela
	
	public void imprimirInfo() {
		
		System.out.println(nome + "\n" + peso + "\n" + idade);
	}
	
	// Método responsável pelo desejo de sentir sono
	
	public void sentirSono () {
		
		System.out.println("O " + nome + " está sentindo sono.");
		
		
		if (acordado < 5)
			
			escolha = Teclado.leInt("1. Dormir\n2. Ficar acordado");
		else
			escolha = 1;
		
		if (escolha == 1) {
			idade++;
			acordado = 0;
		}
		
		else if (escolha == 2) {
			System.out.println(nome + " ficou acordado.");
			acordado++;
		}
		
		else {
			System.out.println("Escolha inválida.");
			sentirSono();
		}
		
		if (idade > 15) {
			
			System.out.println(nome + " morreu");
			
			// Encerra o programa
			
			System.exit(0);
		}
		
	}
	
	// Método que controla o desejo de sentir fome do personagem
	
	public void sentirFome (int cansado) {
		
		System.out.println("O " + nome + " está com fome.");
		
		if (cansado == 0)
			
			escolha = Teclado.leInt("1. Comer muito\n2. Comer pouco\n3. Não comer");
		
		else
			escolha = 1;
		
		if (escolha == 1) {
			peso += 5;
			acordado = 5;
			sentirSono();
		}
		
		else if (escolha == 2)
			peso ++;
		
		else if (escolha == 3) 
			peso -= 2;
		
		else {
			System.out.println("Escolha inválida.");
			sentirFome(0);
		}
		
		if (peso <= 0) {
			
			System.out.println(nome + " ficou desnutrido e morreu.");
			System.exit(0);
		}
		
		else if (peso > 20) {
			
			System.out.println(nome + " explodiu.");
			System.exit(0);
		}
	}
	
	// Método que controla o status de ficar entediado do personagem
	
	public void ficarEntediado() {
		
		System.out.println("O " + nome + " está entediado.");
		escolha = Teclado.leInt("1. Correr 10 minutos\n2. Caminhar 10 minutos");
		
		if (escolha == 1) {
			
			System.out.println(nome + " correu 10 minutos");
			peso -= 4;
			
			if (peso <=0) {
				
				System.out.println("O " + nome + " morreu.");
				System.exit(0);
			}
			
			sentirFome(1);
		}
		
		else if (escolha == 2) {
			
			System.out.println(nome + " caminhou 10 minutos.");
			peso--;
			
			if (peso <=0) {
				
				System.out.println("O " + nome + " morreu.");
				System.exit(0);
			}
			
			sentirFome(0);
		}
		
		else {
			System.out.println("Escolha inválida.");
			ficarEntediado();
			
		}
		
		
	}	
}