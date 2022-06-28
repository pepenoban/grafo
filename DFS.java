import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class DFS {

	private Stack<Integer> pila = new Stack<>();
	private List<Integer> listaFinal = new ArrayList<>();
	private List<Boolean> nodosVisitados = new ArrayList<Boolean>();
	private MatrizAdyacencia grafo;

	public DFS(MatrizAdyacencia grafo) {
		this.grafo = grafo;
	}

	public void recorrerGrafo(int nodoInicial) {
		for (int i = 0; i < grafo.getNodo(); i++)
			nodosVisitados.add(false);
		// System.out.println(nodosVisitados.);

		int nodoActual;
		int[] adyacentes;
		pila.push(nodoInicial);

		while (!pila.isEmpty()) {
			nodoActual = pila.pop();
			listaFinal.add(nodoActual);
			nodosVisitados.set(nodoActual - 1, true);
			adyacentes = grafo.obtenerAdyacentes(nodoActual);
			

			for (int i = 0; i < adyacentes.length; i++) {
				// System.out.println(i);
				if (adyacentes[i] != Integer.MAX_VALUE && nodosVisitados.get((int) adyacentes[i] - 1) == false) {
					pila.push((int) adyacentes[i]);
					nodosVisitados.set((int) adyacentes[i] - 1, true);
				}
			}
		}
	}

	public void dfs(int ini, Grafo grafo) {
		listaFinal.add(ini);
	}

}