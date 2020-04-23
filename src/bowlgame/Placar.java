package bowlgame;

/**
 * Classe que representa o placar do jogo de boliche, ela faz todo o controle dos arremessos
 * executados no jogo, frame a frame.
 */
public class Placar {
    /**
     * Propriedade interna da classe, um array unidimensional que mantém os lançamentos feitos no jogo
     */
    private int[] arremessos = new int[21];
    private int arremessoAtual = 1;
    private int placarGeral;

    /**
     * Método público que representa um lançamentos sendo executado
     *
     * @param pinosDerrubados - a quantidade de pinos derrubados no lançamento
     */
    public void adicionarLancamento(int pinosDerrubados) {
        arremessos[arremessoAtual] = pinosDerrubados;
        arremessoAtual++;
    }

    /**
     * Método que faz o cálculo do placar, através dos lançamentos feitos até o quadro dado pelo parâmetro
     *
     * @param quadro - é o quadro do qual se deseja a pontuação
     * @return a pontuação do quadro solicitado
     */
    public int calcularPontuacaoPor(int quadro) {
        int placar = 0;
        for (int quadrosPassados = 1; quadrosPassados <= quadro; quadrosPassados++) {
            int primeiraBolaDoQuadro = obterBolasPertencentesAoQuadro(quadro, 1);
            int segundaBolaDoQuadro = primeiraBolaDoQuadro - 1;
            placar += arremessos[primeiraBolaDoQuadro];
            if ( ehStrike(quadrosPassados)) {
                placar += calcularStrike(quadrosPassados);
                continue;
            }
            placar += arremessos[segundaBolaDoQuadro];
        }
        return placar;
    }

    private boolean ehStrike(int quadro) {
        return arremessos[obterBolasPertencentesAoQuadro(quadro, 1)] == 10;
    }

    private int calcularStrike(int quadro) {
        int primeiroQuadroAposOStrike = quadro + 1;
        int segundoQuadroAposOStrike = primeiroQuadroAposOStrike + 1;
        int resultado = arremessos[obterBolasPertencentesAoQuadro(primeiroQuadroAposOStrike, 1)];
        resultado += ehStrike(primeiroQuadroAposOStrike) ? arremessos[obterBolasPertencentesAoQuadro(segundoQuadroAposOStrike, 1)] : arremessos[obterBolasPertencentesAoQuadro(primeiroQuadroAposOStrike, 2)];
        return resultado;

    }

    private int obterBolasPertencentesAoQuadro(int quadro, int bolaQueSeDesejaObter) {
        int segundaBola = quadro * 2;
        int primeiraBola = segundaBola - 1;
        return bolaQueSeDesejaObter == 1 ? primeiraBola : segundaBola;
    }
}
