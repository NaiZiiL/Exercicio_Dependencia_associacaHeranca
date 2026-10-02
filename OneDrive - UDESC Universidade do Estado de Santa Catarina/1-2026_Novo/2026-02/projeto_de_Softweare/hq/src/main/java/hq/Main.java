package hq;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // =========================
        // PERSONAGENS
        // =========================

        Personagem batman = new Personagem("Batman", 35);
        Personagem robin = new Personagem("Robin", 18);
        Personagem coringa = new Personagem("Coringa", 40);


        // =========================
        // AUTORES
        // =========================

        Autor carlos = new Autor("Carlos", 4);

        Escritor joao = new Escritor(
                "Joao",
                10,
                12345
        );

        Desenhista maria = new Desenhista(
                "Maria",
                5,
                "Manga"
        );

        Desenhista pedro = new Desenhista(
                "Pedro",
                8,
                "Realista"
        );


        // =========================
        // HISTÓRIA 1
        // =========================

        Historia historia1 = new Historia(
                "O retorno do Batman",
                "Batman retorna para proteger Gotham."
        );

        historia1.adicionarAutor(joao);
        historia1.adicionarAutor(maria);

        historia1.adicionarPersonagem(batman);
        historia1.adicionarPersonagem(robin);


        // =========================
        // HISTÓRIA 2
        // =========================

        Historia historia2 = new Historia(
                "O ataque do Coringa",
                "Coringa ataca Gotham."
        );

        historia2.adicionarAutor(joao);
        historia2.adicionarAutor(pedro);

        historia2.adicionarPersonagem(batman);
        historia2.adicionarPersonagem(coringa);


        // =========================
        // HISTÓRIA 3
        // =========================

        Historia historia3 = new Historia(
                "A nova ameaça",
                "Uma nova ameaça surge em Gotham."
        );

        historia3.adicionarAutor(carlos);
        historia3.adicionarAutor(maria);

        historia3.adicionarPersonagem(robin);
        historia3.adicionarPersonagem(coringa);


        // =========================
        // REVISTA
        // =========================

        Revista revista = new Revista(
                "Batman",
                1
        );

        revista.adicionarHistoria(historia1);
        revista.adicionarHistoria(historia2);
        revista.adicionarHistoria(historia3);


        // =========================
        // LISTA DE REVISTAS
        // =========================

        Revista revista2 = new Revista(
                "Batman Especial",
                2
        );

        Historia historia4 = new Historia(
                "Batman contra o Coringa",
                "Mais uma batalha."
        );

        historia4.adicionarAutor(pedro);
        historia4.adicionarPersonagem(batman);
        historia4.adicionarPersonagem(coringa);

        revista2.adicionarHistoria(historia4);

        List<Revista> revistas = new ArrayList<>();

        revistas.add(revista);
        revistas.add(revista2);


        // =========================
        // TESTANDO OS MÉTODOS
        // =========================

        System.out.println(
                "1 - Revista possui Joao? "
                + Sistema.possuiAutor(revista, joao)
        );


        System.out.println(
                "2 - Batman aparece em quantas revistas? "
                + Sistema.qtdRevistas(revistas, batman)
        );


        System.out.println(
                "3 - Quantos desenhistas diferentes trabalharam? "
                + Sistema.qtdDesenhistas(revista)
        );


        System.out.println(
                "4 - Joao usou Batman? "
                + Sistema.autorUsaPersonagem(
                        revista.getHistorias(),
                        joao,
                        batman
                )
        );


        List<Autor> autores = new ArrayList<>();

        autores.add(carlos);
        autores.add(joao);
        autores.add(maria);
        autores.add(pedro);


        System.out.println(
                "5 - Pontuacao total dos autores: "
                + Sistema.pontuacaoTotal(autores)
        );


        System.out.println(
                "6 - Pontuacao total da revista: "
                + Sistema.pontuacaoDaRevista(revista)
        );
    }
}
    