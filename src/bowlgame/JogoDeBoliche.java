package bowlgame;

/**
 * Classe que representa um jogo de boliche a interação com o jogo se dá pelos métodos públicos,
 * com os quais se adiciona pontos e obtem o placar
 */
public class JogoDeBoliche {


    private Placar placar = new Placar();

    /**
     * Adiciona a quantidade de pinos derrubados
     *
     * @param pinosDerrubados - quantidade de pinos derrubados
     */
    public void adicionarPontos(int pinosDerrubados) {
        placar.adicionarLancamento(pinosDerrubados);
    }

    /**
     * Método que retorna o placar atual do jogo
     *
     * @return o retorno do método deve ser um inteiro que é o valor do placar atual
     */
    public int obterPlacar() {
        return placar.calcularPontuacaoPor(9);
    }

}
