import java.util.ArrayList;
import java.util.List;

public class PanelBusqueda {


    public class BuscadorPeliculas {

        public List<Pelicula> buscarPorTextoExacto(List<Pelicula> peliculas, String consulta) {
            if (consulta == null || consulta.trim().isEmpty()) {
                throw new IllegalArgumentException("Ingrese un texto válido para buscar.");
            }

            List<Pelicula> coincidencias = new ArrayList<>();
            if (peliculas == null) {
                return coincidencias;
            }

            for (Pelicula p : peliculas) {
                if (p != null) {
                    boolean coincideTitulo = consulta.equals(p.getTitulo());
                    boolean coincideDirector = consulta.equals(p.getDirector());
                    if (coincideTitulo || coincideDirector) {
                        coincidencias.add(p);
                    }
                }
            }
            return coincidencias;
        }

        public int buscarBinariaPorNumeroDesc(List<Pelicula> peliculasOrdenadasDesc, int numeroID) {
            if (numeroID <= 0) {
                throw new IllegalArgumentException("El número de película debe ser un entero positivo.");
            }
            if (peliculasOrdenadasDesc == null || peliculasOrdenadasDesc.isEmpty()) {
                return -1;
            }

            int inicio = 0;
            int fin = peliculasOrdenadasDesc.size() - 1;

            while (inicio <= fin) {
                int mid = inicio + (fin - inicio) / 2;
                int idActual = peliculasOrdenadasDesc.get(mid).getNumeroID();

                if (idActual == numeroID) {
                    return mid;
                } else if (idActual < numeroID) {

                    fin = mid - 1;
                } else {

                    inicio = mid + 1;
                }
            }

            return -1;
        }
    }
}
