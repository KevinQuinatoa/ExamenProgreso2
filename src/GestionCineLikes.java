import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class GestionCineLikes {


    public int darMeGusta(Pelicula pelicula) {
        if (pelicula == null) {
            throw new IllegalArgumentException("No hay una película seleccionada.");
        }
        if (pelicula.getMeGusta() < 0) {
            pelicula.setMeGusta(0);
        }
        int nuevoTotal = pelicula.getMeGusta() + 1;
        pelicula.setMeGusta(nuevoTotal);
        return nuevoTotal;
    }


    public List<Pelicula> obtenerRankingDescendente(List<Pelicula> catalogoPrincipal) {
        List<Pelicula> ranking = new ArrayList<>();
        if (catalogoPrincipal == null || catalogoPrincipal.isEmpty()) {
            return ranking;
        }

        ranking.addAll(catalogoPrincipal);
        // Comparator.comparingInt(..., Comparator.reverseOrder()) es estable en Java:
        // mantiene el orden relativo cuando dos películas tienen los mismos meGusta.
        ranking.sort(Comparator.comparingInt(Pelicula::getMeGusta).reversed());
        return ranking;
    }
}