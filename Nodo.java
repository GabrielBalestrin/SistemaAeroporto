// ESSA CLASSE SERVE PARA ALOCAR OS NODOS E SEUS ATRIBUTOS 
// PRIMEIRAMENTE FOI DEFINO SUAS VARIAVEIS, CONSTRUTORES E GETTERS AND SETTERS
// ESSA CLASSE NÃO POSSUI MÉTODOS
public class Nodo {
	private Aviao aviao;
	private Nodo proximo;
	private int tamanho;

	// constructors
	public Nodo(Aviao aviao) {
		this.aviao = aviao;
		this.proximo = null;
		this.tamanho = 1;
	}

	// getter and setters
	public Aviao getAviao() {
		return aviao;
	}

	public Nodo getProximo() {
		return proximo;
	}

	public void setProximo(Nodo proximo) {
		this.proximo = proximo;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}


}
