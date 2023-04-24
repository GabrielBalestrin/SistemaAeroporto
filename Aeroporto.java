
import java.util.Arrays;

public class Aeroporto {
	public static final int RESERVA_COMBUSTIVEL_PRIORITARIO = 2;
	private final int INTERVALO_IMPRESSAO = 10;
	private Pista pista1;
	private Pista pista2;
	
	private Fila filaAterrissagem1;
	private Fila filaAterrissagem2;
	private Fila filaDecolagem1;
	
	private Fila filaDecolagem2;
	private Fila filaAterrissagemPrioritaria;
	private int tempoTotal;
	private int tempoAtual;
	private int tempoTotalEsperaAterrissagem1;
	private int tempoTotalEsperaAterrissagem2;
	private int tempoTotalEsperaDecolagem1;
	private int tempoTotalEsperaDecolagem2;
	private int numAterrissagensCombustivelBaixo;
	private int tempoTotalEmVoo;
	private int quantidadeDecolagens1;
	private int quantidadeDecolagens2;
	private int numAterrissagens;
	private int numDecolagens;
	Aviao aviao = null;
	private int tempoTotalUltimaAterrissagem;
	private int tempoTotalUltimaDecolagem;
	private int tempoDecolagem1;
	private int tempoDecolagem2;
	private int tempoEntreDecolagens;
	private int tempoAterrissagem1;
	private int tempoAterrissagem2;
	private int tempoEntreAterrissagens;
	private int tamanhoMaximoFilaDecolagem;

	// constructor
	public Aeroporto() {
	}
	public Aeroporto(int tamanhoMaximoFilaDecolagem) {
		filaAterrissagemPrioritaria = new Fila();
		this.pista1 = new Pista("Pista 1");
		this.pista2 = new Pista("Pista 2");
		this.filaAterrissagem1 = new Fila("Fila de aterrissagem 1", 10);
		this.filaAterrissagem2 = new Fila("Fila de aterrissagem 2", 10);
		this.filaDecolagem1 = new Fila("Fila de decolagem 1", 5);
		this.filaDecolagem2 = new Fila("Fila de decolagem 2", 5);
		this.tempoTotalEsperaAterrissagem1 = 0;
		this.tempoTotalEsperaAterrissagem2 = 0;
		this.tempoTotalEsperaDecolagem1 = 0;
		this.tempoTotalEsperaDecolagem2 = 0;
		this.numAterrissagensCombustivelBaixo = 0;
		this.tamanhoMaximoFilaDecolagem = tamanhoMaximoFilaDecolagem;
		this.filaDecolagem1 = new Fila("Decolagem 1", tamanhoMaximoFilaDecolagem);
		this.filaDecolagem2 = new Fila("Decolagem 2", tamanhoMaximoFilaDecolagem);
	}
	public void setTempoDecolagem2(int tempoDecolagem2) {
		this.tempoDecolagem2 = tempoDecolagem2;
	}

	public void setTempoDecolagem1(int tempoDecolagem1) {
		this.tempoDecolagem1 = tempoDecolagem1;
	}

	public void setTempoEntreDecolagens(int tempoEntreDecolagens) {
		this.tempoEntreDecolagens = tempoEntreDecolagens;
	}

	public void setTempoAterrissagem1(int tempoAterrissagem1) {
		this.tempoAterrissagem1 = tempoAterrissagem1;
	}

	public void setTempoAterrissagem2(int tempoAterrissagem2) {
		this.tempoAterrissagem2 = tempoAterrissagem2;
	}

	public void setTempoEntreAterrissagens(int tempoEntreAterrissagens) {
		this.tempoEntreAterrissagens = tempoEntreAterrissagens;
	}

	public Fila getFilaDecolagem1() {
		return filaDecolagem1;
	}

	public Fila getFilaDecolagem2() {
		return filaDecolagem2;
	}

	public Pista getPista1() {
	    return this.pista1;
	}

	public Pista getPista2() {
	    return this.pista2;
	}

	public Fila getFilaAterrissagemPrioritaria() {
	    return this.filaAterrissagemPrioritaria;
	}
	public int getTamanhoMaximoFilaDecolagem() {
		return tamanhoMaximoFilaDecolagem;
	}
	public Fila getFilaAterrissagem1() {
	    return filaAterrissagem1;
	}

	public Fila getFilaAterrissagem2() {
	    return filaAterrissagem2;
	}
	
	public void setPista1(Pista pista) {
		this.pista1 = pista;
	}
	
	//METHODS 

	
	public void adicionarAviaoDecolagem(Aviao aviao) {
		if (filaDecolagem1.tamanho() < filaDecolagem2.tamanho()) {
			System.out.println("Avião " + aviao.getIdAviao() + " adicionado à fila de decolagem 1.");
			filaDecolagem1.adicionar(aviao);
		} else {
			System.out.println("Avião " + aviao.getIdAviao() + " adicionado à fila de decolagem 2.");
			filaDecolagem2.adicionar(aviao);
		}
	}

	/*public int tamanhoAtualFilaDecolagem() {
		return filaDecolagem1.tamanho() + filaDecolagem2.tamanho();
	}

	public double getTempoMedioEsperaDecolagem() {
	    double totalEspera = 0;
	    int numDecolagens = 0;

	  // Percorre as filas de decolagem e soma os tempos de espera de cada avião
	    for (Nodo nodo : filaDecolagemPrioritaria) {
	        totalEspera += tempoTotal - nodo.getTempoChegada();
	        numDecolagens++;
	
	    }
	    for (Nodo nodo : filaDecolagem1) {
	        totalEspera += tempoTotal - nodo.getTempoChegada();
	        numDecolagens++;
	    }
	    for (Nodo nodo : filaDecolagem2) {
	        totalEspera += tempoTotal - nodo.getTempoChegada();
	        numDecolagens++;
	    }

	    // Retorna o tempo médio de espera para decolagem, ou 0 se não houver decolagens
	    return numDecolagens > 0 ? totalEspera / numDecolagens : 0;
	}

	public double getTempoMedioEsperaAterrissagem() {
	    double totalEspera = 0;
	    int numAterrissagens = 0;

	    // Percorre as filas de aterrissagem e soma os tempos de espera de cada avião
	    for (Fila fila : Fila) {
	        for (Nodo nodo : fila) {
	            totalEspera += tempoTotal - nodo.getTempoChegada();
	            numAterrissagens++;
	        }
	    }

	    // Retorna o tempo médio de espera para aterrissagem, ou 0 se não houver aterrissagens
	    return numAterrissagens > 0 ? totalEspera / numAterrissagens : 0;
	}
	*/
	public void removerAviaoAterrissagem(Aviao aviao) {
		if (filaAterrissagem1.contem(aviao)) {
			filaAterrissagem1.remover(aviao);
		} else if (filaAterrissagem2.contem(aviao)) {
			filaAterrissagem2.remover(aviao);
		} else {
			System.out.println("Avião não encontrado na fila de aterrissagem.");
		}
	}

	

	public void adicionarAviaoDecolagem1(Aviao aviao) {
		filaDecolagem1.adicionar(aviao);
	}

	public void adicionarAviaoDecolagem2(Aviao aviao) {
		filaDecolagem2.adicionar(aviao);
	}

	public Aviao verificarPrioridade() {
	    Aviao aviaoComPrioridade = null;
	    int prioridadeMinima = RESERVA_COMBUSTIVEL_PRIORITARIO;
	    for (Fila fila : Arrays.asList(filaAterrissagem1, filaAterrissagem2)) {
	        if (fila != null) { // Verifica se a fila é nula
	            Nodo nodoAtual = fila.getInicio(); // Declara a variável nodoAtual dentro do loop
	            while (nodoAtual != null) {
	                Aviao aviaoAtual = nodoAtual.getAviao();
	                if (aviaoAtual.getPrioridade() < prioridadeMinima) {
	                    prioridadeMinima = aviaoAtual.getPrioridade();
	                    aviaoComPrioridade = aviaoAtual;
	                }
	                nodoAtual = nodoAtual.getProximo();
	            }
	        }
	    }
	    return aviaoComPrioridade;
	}
	

	public void pousarComPrioridade(Aviao aviao, int tempoAtual) {
		if (aviao == null) {
			System.out.println("Aviso: Avião inválido.");
			return;
		}

		if (aviao.getQuantidadeCombustivel() > 5) {
			System.out.println(
					"Aviso: O avião " + aviao.getIdAviao() + " tem combustível suficiente para pousar normalmente.");
			return;
		}

		try {
			System.out.println("Aviso: Avião " + aviao.getIdAviao()
					+ " está pousando com prioridade devido a baixa reserva de combustível.");

			if (pista1.estaLivre()) {
				pista1.ocupar(aviao);
				filaAterrissagemPrioritaria.remover1();
				tempoTotalEsperaAterrissagem1 += tempoAtual - aviao.getTempoChegada();
				numAterrissagensCombustivelBaixo++;
			} else if (pista2.estaLivre()) {
				pista2.ocupar(aviao);
				filaAterrissagemPrioritaria.remover1();
				tempoTotalEsperaAterrissagem2 += tempoAtual - aviao.getTempoChegada();
				numAterrissagensCombustivelBaixo++;
			} else {
				if (filaAterrissagemPrioritaria.estaCheia()) {
					System.out.println(
							"Aviso: Todas as pistas estão ocupadas e a fila de aterrissagem prioritária está cheia, avião "
									+ aviao.getIdAviao() + " não pode pousar.");
					return;
				}
				System.out.println("Aviso: Todas as pistas estão ocupadas, avião " + aviao.getIdAviao()
						+ " aguardando para pousar.");
				filaAterrissagemPrioritaria.adicionar(aviao);
			}
			this.tempoTotalUltimaAterrissagem = this.tempoTotal;
		} finally {
			filaAterrissagemPrioritaria.removerAviao(aviao);
		}
	}

	private void aterrissar(Pista pista, Fila filaAterrissagem) {
	    Aviao aviao = filaAterrissagem.remover1();
	    pista.ocupar(aviao);
	    int tempoEspera = pista.aterrisar(aviao);
	    System.out.println("Avião " + aviao.getIdAviao() + " pousou na " + pista.getNome() + " após esperar "
	        + tempoEspera + " segundos.");
	    this.tempoTotalUltimaAterrissagem = this.tempoTotal;
	}

	public void pousar(Aviao aviao, int tempoTotal) {
	    this.tempoTotal = tempoTotal;
	    if (pista1.estaLivre()) {
	        aterrissar(pista1, filaAterrissagem1);
	    } else if (pista2.estaLivre()) {
	        aterrissar(pista2, filaAterrissagem2);
	    } else {
	        adicionarAterrissagem(aviao);
	    }
	}

		public void adicionarAterrissagem(Aviao aviao) { // ESCOLHE QUAL PISTA VAI SER COLOCADO PRA POUSAR
			if (verificarPrioridade() == aviao) {
				System.out.println("Avião " + aviao.getIdAviao() + " adicionado à fila de aterrissagem 1 com prioridade.");
				filaAterrissagem1.adicionar(aviao);
			} else {
				System.out.println("Avião " + aviao.getIdAviao() + " adicionado à fila de aterrissagem 2.");
				filaAterrissagem2.adicionar(aviao);
			}
		}

		public void adicionarDecolagem(Aviao aviao, Pista pista1, Pista pista2) {
		    if (filaDecolagem1.tamanho() < filaDecolagem2.tamanho()) {
		        System.out.println("Avião " + aviao.getIdAviao() + " adicionado à fila de decolagem 1.");
		        filaDecolagem1.adicionar(aviao);
		        aviao.setPista(pista1);
		    } else {
		        System.out.println("Avião " + aviao.getIdAviao() + " adicionado à fila de decolagem 2.");
		        filaDecolagem2.adicionar(aviao);
		        aviao.setPista(pista2);
		    }
		}

		public void decolar(Pista pista1, Pista pista2) {
		    this.tempoTotalUltimaDecolagem = this.tempoTotal;
		    if (pista1.estaLivre()) {
		        if (!filaDecolagem1.estaVazia()) {
		            Aviao aviao = filaDecolagem1.remover1();
		            System.out.println("Avião " + aviao.getIdAviao() + " decolando na pista 1.");
		            pista1.ocupar();
		            int tempoEspera = tempoAtual - aviao.getTempoChegada();
		            tempoTotalEsperaDecolagem1 += tempoEspera;
		            quantidadeDecolagens1++;
		            tempoTotalEmVoo += tempoAtual - aviao.getTempoDecolagem();
		        } else {
		            System.out.println("Não há aviões na fila de decolagem 1.");
		        }
		    } else if (pista2.estaLivre()) {
		        if (!filaDecolagem2.estaVazia()) {
		            Aviao aviao = filaDecolagem2.remover1();
		            System.out.println("Avião " + aviao.getIdAviao() + " decolando na pista 2.");
		            pista2.ocupar();
		            int tempoEspera = tempoAtual - aviao.getTempoChegada();
		            tempoTotalEsperaDecolagem2 += tempoEspera;
		            quantidadeDecolagens2++;
		            tempoTotalEmVoo += tempoAtual - aviao.getTempoDecolagem();
		        } else {
		            System.out.println("Não há aviões na fila de decolagem 2.");
		        }
		    } else {
		        System.out.println("Não há pistas de decolagem livres.");
		    }
		}
		







	
	public void atualizar(int tempoTotal) {
		tempoTotal++; // atualiza o tempo total
		// atualiza as filas de aterrissagem
		if (!filaAterrissagemPrioritaria.estaVazia()) {
			Aviao aviao = filaAterrissagemPrioritaria.getInicio().getAviao();
			if (pista1.estaLivre() && pista2.estaLivre()) {
				aterrissar(pista1, filaAterrissagemPrioritaria);
			} else if (pista1.estaLivre()) {
				aterrissar(pista1, filaAterrissagemPrioritaria);
			} else if (pista2.estaLivre()) {
				aterrissar(pista2, filaAterrissagemPrioritaria);
			}
		} else if (!filaAterrissagem1.estaVazia()) {
			Aviao aviao = filaAterrissagem1.getInicio().getAviao();
			if (pista1.estaLivre() && pista2.estaLivre()) {
				aterrissar(pista1, filaAterrissagem1);
			} else if (pista1.estaLivre()) {
				aterrissar(pista1, filaAterrissagem1);
			} else if (pista2.estaLivre()) {
				aterrissar(pista2, filaAterrissagem1);
			}
		} else if (!filaAterrissagem2.estaVazia()) {
			Aviao aviao = filaAterrissagem2.getInicio().getAviao();
			if (pista1.estaLivre() && pista2.estaLivre()) {
				aterrissar(pista1, filaAterrissagem2);
			} else if (pista1.estaLivre()) {
				aterrissar(pista1, filaAterrissagem2);
			} else if (pista2.estaLivre()) {
				aterrissar(pista2, filaAterrissagem2);
			}
		}
		// atualiza as filas de decolagem
		if (!filaAterrissagemPrioritaria.estaVazia()) {
			if (pista1.estaLivre()) {
				aterrissar(pista1, filaAterrissagemPrioritaria);
			} else if (pista2.estaLivre()) {
				aterrissar(pista2, filaAterrissagemPrioritaria);
			}
		} else if (!filaAterrissagem1.estaVazia()) {
			if (pista1.estaLivre()) {
				aterrissar(pista1, filaAterrissagem1);
			} else if (pista2.estaLivre()) {
				aterrissar(pista2, filaAterrissagem1);
			}
		} else if (!filaAterrissagem2.estaVazia()) {
			if (pista1.estaLivre()) {
				aterrissar(pista1, filaAterrissagem2);
			} else if (pista2.estaLivre()) {
				aterrissar(pista2, filaAterrissagem2);
			}
		}

		// verifica se há algum avião com pouca reserva de combustível que precisa
		// aterrissar com prioridade
		if (!filaAterrissagemPrioritaria.estaVazia()) {
			Aviao aviao = filaAterrissagemPrioritaria.getInicio().getAviao();
			if (aviao.getQuantidadeCombustivel() <= RESERVA_COMBUSTIVEL_PRIORITARIO) {
				pousarComPrioridade(aviao, tempoAtual);
			}
		} else if (!filaAterrissagem1.estaVazia()) {
			Aviao aviao = filaAterrissagem1.getInicio().getAviao();
			if (aviao.getQuantidadeCombustivel() <= RESERVA_COMBUSTIVEL_PRIORITARIO) {
				pousarComPrioridade(aviao, tempoAtual);
			}
		} else if (!filaAterrissagem2.estaVazia()) {
			Aviao aviao = filaAterrissagem2.getInicio().getAviao();
			if (aviao.getQuantidadeCombustivel() <= RESERVA_COMBUSTIVEL_PRIORITARIO) {
				pousarComPrioridade(aviao, tempoAtual);
			}
		}

		// atualiza as estatísticas
		if (!filaAterrissagem1.estaVazia() || !filaAterrissagem2.estaVazia()
				|| !filaAterrissagemPrioritaria.estaVazia()) {
			numAterrissagens++;

			if (!filaAterrissagemPrioritaria.estaVazia()) {
				numAterrissagensCombustivelBaixo++;
			}
		}

		if (!filaDecolagem1.estaVazia() || !filaDecolagem2.estaVazia()) {
			numDecolagens++;

			if (!filaDecolagem1.estaVazia() || !filaDecolagem2.estaVazia()) {
				quantidadeDecolagens1++;
			}
		}

		// atualiza tempo de espera na fila de aterrissagem 1
		if (!filaAterrissagem1.estaVazia()) {
			Nodo nodoAtual = filaAterrissagem1.getInicio();
			while (nodoAtual != null) {
				tempoTotalEsperaAterrissagem1 += tempoAtual - nodoAtual.getAviao().getTempoChegada();
				nodoAtual = nodoAtual.getProximo();
			}
		}

		// atualiza tempo de espera na fila de aterrissagem 2
		if (!filaAterrissagem2.estaVazia()) {
			Nodo nodoAtual = filaAterrissagem2.getInicio();
			while (nodoAtual != null) {
				tempoTotalEsperaAterrissagem2 += tempoAtual - nodoAtual.getAviao().getTempoChegada();
				nodoAtual = nodoAtual.getProximo();
			}
		}

		// atualiza tempo de espera na fila de decolagem 1
		if (!filaDecolagem1.estaVazia()) {
			Nodo nodoAtual = filaDecolagem1.getInicio();
			while (nodoAtual != null) {
				tempoTotalEsperaDecolagem1 += tempoAtual - nodoAtual.getAviao().getTempoChegada();
				nodoAtual = nodoAtual.getProximo();
			}
		}

		// atualiza tempo de espera na fila de decolagem 2
		if (!filaDecolagem2.estaVazia()) {
			Nodo nodoAtual = filaDecolagem2.getInicio();
			while (nodoAtual != null) {
				tempoTotalEsperaDecolagem2 += tempoAtual - nodoAtual.getAviao().getTempoChegada();
				nodoAtual = nodoAtual.getProximo();
			}
		}
		// atualiza a quantidade de decolagens por pista
		if (!filaDecolagem1.estaVazia()) {
		    Aviao aviao = filaDecolagem1.remover1();
		    if (aviao.getPista() == pista1) {
		        quantidadeDecolagens1++;
		        tempoTotalEsperaDecolagem1 += aviao.getTempoEsperaDecolagem();
		    } else if (aviao.getPista() == pista2) {
		        quantidadeDecolagens2++;
		        tempoTotalEsperaDecolagem2 += aviao.getTempoEsperaDecolagem();
		    }
		}

		if (!filaDecolagem2.estaVazia()) {
		    Aviao aviao = filaDecolagem2.remover1();
		    if (aviao.getPista() == pista1) {
		        quantidadeDecolagens1++;
		        tempoTotalEsperaDecolagem1 += aviao.getTempoEsperaDecolagem();
		    } else if (aviao.getPista() == pista2) {
		        quantidadeDecolagens2++;
		        tempoTotalEsperaDecolagem2 += aviao.getTempoEsperaDecolagem();
		    }
		}         
		// atualiza tempo total em voo
		tempoTotalEmVoo += aviao.getTempoVoo();
		// imprime as informações
		if (tempoTotal % INTERVALO_IMPRESSAO == 0) {
			System.out.println("\n--- Tempo: " + tempoTotal + " ---");
			System.out.println("Fila de aterrissagem prioritária: " + filaAterrissagemPrioritaria);
			System.out.println("Fila de aterrissagem normal pista 1: " + filaAterrissagem1);
			System.out.println("Fila de aterrissagem normal pista 2: " + filaAterrissagem2);
			System.out.println("Fila de decolagem normal pista 1: " + filaDecolagem1);
			System.out.println("Fila de decolagem normal pista 1: " + filaDecolagem2);

			// calcula e imprime os tempos médios de espera
			if (numAterrissagens > 0) {
				System.out.println("Tempo médio de espera para aterrissagem: "
						+ (tempoTotal - tempoTotalUltimaAterrissagem) / numAterrissagens);
			}
			if (numDecolagens > 0) {
				System.out.println("Tempo médio de espera para decolagem: "
						+ (tempoTotal - tempoTotalUltimaDecolagem) / numDecolagens);
			}

			// atualiza os tempos totais desde a última aterrissagem ou decolagem
			if (!filaAterrissagem1.estaVazia() || !filaAterrissagem2.estaVazia()
					|| !filaAterrissagemPrioritaria.estaVazia()) {
				tempoTotalUltimaAterrissagem = tempoTotal;
			}
			if (!filaDecolagem1.estaVazia() || !filaDecolagem2.estaVazia()) {
				tempoTotalUltimaDecolagem = tempoTotal;
			}
		}
	}
}