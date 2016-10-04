import ISobrenome.ISobrenome;


public class Pessoa implements INome, ISobrenome {
	
	String nome;
	String sobrenome;
	
	public Pessoa() {
		super();
	}

	@Override
	public ISobrenome setNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	
	
	public static void main(String[] args) {
		
		INome p = new Pessoa();
		p.setNome("A").setSobrenome("O");
		
	}

	@Override
	public ISobrenome setSobrenome(String sobrenome) {
		this.sobrenome = nome;
		return this;
	}




}
