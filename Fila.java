//ESSA CLASSE ALOCA AS FUNÇÕES DE FILA 
public class Fila {
	private String nome;
	private int tamanhoMaximo;
	private Nodo inicio;
	private Nodo fim;
	private int tamanhoAtual;
	private int numElementos;

	// constructors
	public Fila(String nome, int tamanhoMaximo) {
		this.nome = nome;
		this.tamanhoMaximo = tamanhoMaximo;
		this.inicio = null;
		this.fim = null;
		this.tamanhoAtual = 0;
		this.numElementos = 0;
	}

	public Fila() {
		this.nome = null;
		this.tamanhoMaximo = 0;
		this.inicio = null;
		this.fim = null;
		this.tamanhoAtual = 0;
	}

	// getters and setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTamanhoMaximo() {
		return tamanhoMaximo;
	}

	public void setTamanhoMaximo(int tamanhoMaximo) {
		this.tamanhoMaximo = tamanhoMaximo;
	}

	public Nodo getInicio() {
		return inicio;
	}

	public void setInicio(Nodo inicio) {
		this.inicio = inicio;
	}

	public Nodo getFim() {
		return fim;
	}

	public void setFim(Nodo fim) {
		this.fim = fim;
	}

	public int getTamanhoAtual() {
		return tamanhoAtual;
	}

	public void setTamanhoAtual(int tamanhoAtual) {
		this.tamanhoAtual = tamanhoAtual;
	}

	// methods

	public void adicionar(Aviao aviao) {
		if(aviao != null) {
			if (tamanhoAtual < tamanhoMaximo) {
				Nodo novoNodo = new Nodo(aviao);
				if (inicio == null) {
					inicio = novoNodo;
				} else {
					fim.setProximo(novoNodo);
				}
				fim = novoNodo;
				tamanhoAtual++;
			} else {
				System.out.println("Fila cheia. Avião não adicionado.");
			}
		}
	}

	public void remover(Aviao aviao) {
		Nodo atual = inicio;
		Nodo anterior = null;
		while (atual != null) {
			if (atual.getAviao().equals(aviao)) {
				if (anterior == null) {
					inicio = atual.getProximo();
				} else {
					anterior.setProximo(atual.getProximo());
				}
				tamanhoAtual--;
				if (inicio == null) {
					fim = null;
				}
				return;
			}
			anterior = atual;
			atual = atual.getProximo();
		}
		System.out.println("Avião não encontrado na fila.");
	}

	public Aviao remover1() {
		if (inicio == null) {
			System.out.println("Fila vazia.");
			return null;
		} else {
			Aviao aviaoRemovido = inicio.getAviao();
			inicio = inicio.getProximo();
			tamanhoAtual--;
			if (inicio == null) {
				fim = null;
			}
			return aviaoRemovido;
		}
	}

	public boolean contem(Aviao aviao) {
		Nodo atual = inicio;
		while (atual != null) {
			if (atual.getAviao().equals(aviao)) {
				return true;
			}
			atual = atual.getProximo();
		}
		return false;
	}

	public void removerAviao(Aviao aviao) {
		Nodo atual = inicio;
		Nodo anterior = null;

		while (atual != null) {
			if (atual.getAviao() == aviao) {
				if (anterior == null) {
					inicio = atual.getProximo();
				} else {
					anterior.setProximo(atual.getProximo());
				}

				if (atual == fim) {
					fim = anterior;
				}

				tamanhoAtual--;
				break;
			}

			anterior = atual;
			atual = atual.getProximo();
		}
	}

	

	public int tamanho() {
		return tamanhoAtual;
	}

	public boolean estaVazia() {
		return inicio == null;
	}

	public boolean estaCheia() {
		return this.numElementos == this.tamanhoMaximo;
	}
}
