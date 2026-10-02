package hq;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sistema {

    public static boolean possuiAutor(Revista revista, Autor autor) {

        for (Historia historia : revista.getHistorias()) {

            if (historia.getAutores().contains(autor)) {
                return true;
            }
        }

        return false;
    }


    public static int qtdRevistas(List<Revista> listaRevistas,
                                  Personagem personagem) {

        int quantidade = 0;

        for (Revista revista : listaRevistas) {

            boolean apareceu = false;

            for (Historia historia : revista.getHistorias()) {

                if (historia.getPersonagens().contains(personagem)) {
                    apareceu = true;
                    break;
                }
            }

            if (apareceu) {
                quantidade++;
            }
        }

        return quantidade;
    }


    public static int qtdDesenhistas(Revista revista) {

        Set<Desenhista> desenhistas = new HashSet<>();

        for (Historia historia : revista.getHistorias()) {

            for (Autor autor : historia.getAutores()) {

                if (autor instanceof Desenhista) {
                    desenhistas.add((Desenhista) autor);
                }
            }
        }

        return desenhistas.size();
    }


    public static boolean autorUsaPersonagem(
            List<Historia> listaHistorias,
            Autor autor,
            Personagem personagem) {

        for (Historia historia : listaHistorias) {

            boolean autorParticipou =
                    historia.getAutores().contains(autor);

            boolean personagemParticipou =
                    historia.getPersonagens().contains(personagem);

            if (autorParticipou && personagemParticipou) {
                return true;
            }
        }

        return false;
    }


    public static int pontuacaoTotal(List<Autor> listaAutores) {

        int total = 0;

        for (Autor autor : listaAutores) {
            total += autor.pontuacao();
        }

        return total;
    }


    public static int pontuacaoDaRevista(Revista revista) {

        List<Autor> autores = new ArrayList<>();

        for (Historia historia : revista.getHistorias()) {

            for (Autor autor : historia.getAutores()) {

                if (!autores.contains(autor)) {
                    autores.add(autor);
                }
            }
        }

        return pontuacaoTotal(autores);
    }
}