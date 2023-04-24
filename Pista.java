//AQUI ESSA CLASSE REFERE-SE A BASE PARA CRIAÇÃO DAS PISTAS
//FOI DEFINIDO AS VARIAVEIS, CONSTRUTOR, GETTERS AND SETTERS E POR FIM OS MÉTODOS

public class Pista {
	private String nome;
	  private Aviao aviaoAtual;
	private boolean ocupada;
	private boolean livre;

	// constructors
	public Pista(String nome) {
		this.nome = nome;
		this.ocupada = false;
		
	}

	// getters and setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}
	
	// methods
	public void desocupar() {
		ocupada = false;
	}

    public Pista() {
        this.livre = true;
    }

    public void ocupar() {
        this.livre = false;
    }

    public void liberar() {
        this.livre = true;
    }

    public boolean estaLivre() {
        return livre;
  
    }
    public void ocupar(Aviao aviao) {
        this.aviaoAtual= aviao;
    }
    
    public int aterrisar(Aviao aviao) {
        ocupar(aviao);
        int tempoEspera = aviao.getTempoEspera();
        aviao.zerarTempoEspera();
        return tempoEspera;
    }
	

}
