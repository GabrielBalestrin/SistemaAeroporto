import java.util.Random;

// ESSA CLASSE FOI CRIADA PARA EXECUTAR TODAS AS FUNCIONALIDADES CRIADAS NAS DEMAIS CLASSES
// TEM POR OBJETIVO TESTAR E SIMULAR UM AEROPORTO COM LA�O DE REPETI��O PARA SIMULAR O TEMPO
// E AO FINAL MOSTRA ALGUMAS ESTAT�STICAS DO RESULTADO SIMULADO.

public class Main {
	public static void main(String[] args) {
		Aeroporto aeroporto = new Aeroporto();
	

		final int TEMPO_SIMULACAO = 50;
		
		final int MAX_COMBUSTIVEL = 20;
		final int MAX_TEMPO_TOTAL = 15;
		int tempoTotal = 0;
		int tempoDecolagem1 = 0;
		int tempoDecolagem2 = 0;
		int tempoEntreDecolagens = 0;
		int tempoAterrissagem1 = 0;
		int tempoAterrissagem2 = 0;
		int tempoEntreAterrissagens = 0;
		int numAvioesChegada = 0;
		int numAvioesPartida = 0;
		int numAterrissagensCombustivelBaixo = 0;


		// Configura��o dos tempos de decolagem e aterrissagem

		aeroporto.setTempoDecolagem1(tempoDecolagem1);
		aeroporto.setTempoDecolagem2(tempoDecolagem2);
		aeroporto.setTempoEntreDecolagens(10);
		aeroporto.setTempoAterrissagem1(tempoAterrissagem1);
		aeroporto.setTempoAterrissagem2(tempoAterrissagem2);
		aeroporto.setTempoEntreAterrissagens(tempoEntreAterrissagens);

		// Loop principal do simulador

		while (tempoTotal < TEMPO_SIMULACAO) {

			// Gera um novo avi�o para chegar no aeroporto

			Aviao aviao = new Aviao(numAvioesChegada, (int) (Math.random() * MAX_COMBUSTIVEL), "CHEGADA");
			aviao.setTempoTotal((int) (Math.random() * MAX_TEMPO_TOTAL));
			aeroporto.adicionarAterrissagem(aviao);
			numAvioesChegada++;

			// Gera um novo avi�o para partir do aeroporto
			
			if (numAvioesPartida > 0) {
				while (numAvioesPartida > 0) {
					aeroporto.removerAviaoAterrissagem(aviao);
					if (aviao != null) {
						if (aeroporto.getFilaDecolagem1().tamanho() < aeroporto.getFilaDecolagem2().tamanho()) {
							aeroporto.getFilaDecolagem1().adicionar(aviao);
							System.out.println("Avi�o " + aviao.getIdAviao() + " adicionado � fila de decolagem 1.");
						} else if (aeroporto.getFilaDecolagem1().tamanho() >= aeroporto.getFilaDecolagem2().tamanho()
								&& aeroporto.getFilaDecolagem2().tamanho() < aeroporto
										.getTamanhoMaximoFilaDecolagem()) {
							aeroporto.getFilaDecolagem2().adicionar(aviao);
							System.out.println("Avi�o " + aviao.getIdAviao() + " adicionado � fila de decolagem 2.");
						} else {
							System.out.println("N�o h� espa�o na fila de decolagem.");
						}
					}
				}
			}

			// Realiza uma aterrissagem se a pista estiver livre e houver avi�o na fila de
			// aterrissagem priorit�ria
			
			if (aeroporto.getPista1().estaLivre() && !aeroporto.getFilaAterrissagemPrioritaria().estaVazia()) {
				aviao = aeroporto.getFilaAterrissagemPrioritaria().getInicio().getAviao();
				aeroporto.pousarComPrioridade(aviao, tempoTotal);
			} else if (aeroporto.getPista1().estaLivre() && !aeroporto.getFilaAterrissagem1().estaVazia()) {
				aviao = aeroporto.getFilaAterrissagem1().getInicio().getAviao();
				aeroporto.pousar(aviao, tempoTotal);
			} else if (aeroporto.getPista1().estaLivre() && !aeroporto.getFilaAterrissagem2().estaVazia()) {
				aviao = aeroporto.getFilaAterrissagem2().getInicio().getAviao();
				aeroporto.pousar(aviao, tempoTotal);
			} else {
				System.out.println("Nenhum avi�o pousou neste minuto.");
			}

			// Realiza uma aterrissagem se a pista estiver livre e houver avi�o na fila de
			// aterrissagem 1
			
			if (aeroporto.getPista1().estaLivre() && !aeroporto.getFilaAterrissagem1().estaVazia()) {
				Aviao aviao1 = aeroporto.getFilaAterrissagem1().getInicio().getAviao();
				aeroporto.pousar(aviao1, tempoTotal);
				if (aviao1.getQuantidadeCombustivel() <= Aeroporto.RESERVA_COMBUSTIVEL_PRIORITARIO) {
					numAterrissagensCombustivelBaixo++;
				}
			} else if (aeroporto.getPista1().estaLivre() && !aeroporto.getFilaAterrissagem2().estaVazia()) {
				Aviao aviao2 = aeroporto.getFilaAterrissagem2().getInicio().getAviao();
				aeroporto.pousar(aviao2, tempoTotal);
				if (aviao2.getQuantidadeCombustivel() <= Aeroporto.RESERVA_COMBUSTIVEL_PRIORITARIO) {
					numAterrissagensCombustivelBaixo++;
				}
		}

			// Realiza uma aterrissagem se a pista estiver livre e houver avi�o na fila de
			// aterrissagem 2
			
			if (aeroporto.getPista2().estaLivre() && !aeroporto.getFilaAterrissagem2().estaVazia()) {
				Aviao aviao3 = aeroporto.getFilaAterrissagem2().getInicio().getAviao();
				aeroporto.pousar(aviao, tempoTotal);
				if (aviao.getQuantidadeCombustivel() <= Aeroporto.RESERVA_COMBUSTIVEL_PRIORITARIO) {
					numAterrissagensCombustivelBaixo++;
				}
			}
			// Incrementa o tempo total do simulador e atualiza o estado do aeroporto
			tempoTotal++;
			aeroporto.atualizar(tempoTotal);
		}
		
		// Exibe os resultados do simulador
		
		System.out.println("Tempo total de simula��o: " + TEMPO_SIMULACAO);
		
		// System.out.println("Tempo m�dio de espera para decolagem: "+aeroporto.getTempoMedioEsperaDecolagem());
		// System.out.println("Tempo m�dio de espera para aterrissagem: "+aeroporto.getTempoMedioEsperaAterrissagem());
		System.out.println("N�mero de aterrissagens com pouco combust�vel: " + numAterrissagensCombustivelBaixo);
		System.out.println("N�mero de avi�es que chegaram: " + numAvioesChegada);
		System.out.println("N�mero de avi�es que partiram: " + numAvioesPartida);

	}
}
