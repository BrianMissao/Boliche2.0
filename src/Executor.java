import bowlgame.*;

public class Executor {
    public static void main(String[] args) {
        JogoDeBoliche jogoDeBoliche = new JogoDeBoliche();
        for (int contador = 1; contador < 10; contador++) {
            jogoDeBoliche.adicionarPontos(10);
            jogoDeBoliche.adicionarPontos(0);
        }
        System.out.println(jogoDeBoliche.obterPlacar());
    }
}