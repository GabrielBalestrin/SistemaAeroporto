
// ESSA CLASSE É RESERVADA A ALOCAR AS FUNÇÕES DE AVIÕES  
// PRIMEIRO FOI DEFINIDO OS ATRIBUTOS  COM SEUS CONTRUTORES JUNTAMENTE COM GETTERS AND SETTERS
// NOS MÉTODOS FORAM PARA USAR E ANALISAR OS TEMPOS 
public class Aviao {
	private int idAviao;
	private int quantidadeCombustivel;
	private String flagFila;
	private int prioridade;
	private int tempoChegada;
	private int tempoDecolagem;
	private int tempoEspera;
	private int tempoEsperaDecolagem;
	private int tempoTotal;
	private Pista pista;
	
	// constructors
	public Aviao(int idAviao, int quantidadeCombustivel, String flagFila) {
		this.idAviao = idAviao;
		this.quantidadeCombustivel = quantidadeCombustivel;
		this.flagFila = flagFila;
	}

	
	public void setTempoTotal(int tempoTotal) {
		this.tempoTotal = tempoTotal;
	}

	public Aviao(int prioridade) {
		this.prioridade = prioridade;
	}

	public int getTempoEspera() {
		return this.tempoEspera;
	}

	public void zerarTempoEspera() {
		this.tempoEspera = 0;
	}

	// getters and setters
	
	public int getIdAviao() {
		return idAviao;
	}

	public void setIdAviao(int idAviao) {
		this.idAviao = idAviao;
	}

	public int getQuantidadeCombustivel() {
		return quantidadeCombustivel;
	}

	public void setQuantidadeCombustivel(int quantidadeCombustivel) {
		this.quantidadeCombustivel = quantidadeCombustivel;
	}

	public String getFlagFila() {
		return flagFila;
	}

	public void setFlagFila(String flagFila) {
		this.flagFila = flagFila;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public int getTempoChegada() {
		return tempoChegada;
	}

	public void setTempoChegada(int tempoChegada) {
		this.tempoChegada = tempoChegada;
	}

	public int getTempoDecolagem() {
		return tempoDecolagem;
	}

	public void setTempoDecolagem(int tempoDecolagem) {
		this.tempoDecolagem = tempoDecolagem;
	}

	public Pista getPista() {
		return pista;
	}


	public void setPista(Pista pista) {
		this.pista = pista;
	}
	
	// methods

	public int getTempoEsperaDecolagem() {
		return tempoEsperaDecolagem;
	}

	public int getTempoVoo() {
		return tempoDecolagem - tempoChegada;
	}

	public void setTempoEspera(int tempoEspera) {
		this.tempoEspera = tempoEspera;
	}

	public void setTempoEsperaDecolagem(int tempoEsperaDecolagem) {
		this.tempoEsperaDecolagem = tempoEsperaDecolagem;
	}


	public int getTempoTotal() {
		return tempoTotal;
	}

}
