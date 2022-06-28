import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

	private Queue<Integer> cola = new LinkedList<Integer>();
	private List<Integer> listaFinal = new ArrayList<>();
	private List<Boolean> nodosVisitados = new ArrayList<Boolean>();
	private MatrizAdyacencia grafo;

	public BFS(MatrizAdyacencia grafo) {
		this.grafo = grafo;
	}

	public void recorrerGrafo(int nodoInicial) {
		for (int i = 0; i < grafo.getNodo(); i++)
			nodosVisitados.add(false);

		int nodoActual;
		int[] adyacentes;
		cola.add(nodoInicial);

		while (!cola.isEmpty()) {
			nodoActual = cola.poll();
			nodosVisitados.set(nodoActual - 1, true);
			listaFinal.add(nodoActual);
			adyacentes = grafo.obtenerAdyacentes(nodoActual);

			for (int i = 0; i < adyacentes.length; i++) {
				if (adyacentes[i] != Integer.MAX_VALUE && nodosVisitados.get(adyacentes[i] - 1) == false) {
					cola.add(adyacentes[i]);
					nodosVisitados.set(adyacentes[i] - 1, true);
				}
			}

		}
		for (int numero : listaFinal) {
			System.out.println(listaFinal);
		}
	}

}
