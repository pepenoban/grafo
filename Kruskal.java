import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Kruskal {
	private MatrizAdyacencia grafo;
	private int costoTotal;
	private int[] rep;
	private int[] ady;
	private List<Boolean> visitados = new ArrayList<>();
	private Arista arista;
	private PriorityQueue<Arista> cp = new PriorityQueue<Arista>();

	private int find(int nodo) {
		while (rep[nodo] != nodo)
			nodo = rep[nodo];

		return nodo;
	}

	private void union(int origen, int destino) {
		if (origen < destino) {
			rep[destino] = origen;
		} else {
			rep[origen] = destino;
		}
	}

	public Kruskal(MatrizAdyacencia grafo) {
		this.grafo = grafo;
	}

	public void kt() {
		int nodos = grafo.getNodo();
		int origen, destino, costo;
		rep = new int[nodos];
		ady = new int[nodos];

		for (int i = 0; i < nodos; i++) {
			visitados.add(false);
		}

		for (int i = 0; i < nodos; i++) {
			rep[i] = i;
			ady = grafo.obtenerAdyacentes2(i);
			visitados.set(i, true);
			for (int j = 0; j < ady.length; j++) {
				if (!visitados.get(j) && ady[j] != Integer.MAX_VALUE) {
					arista = new Arista(i, j, ady[j]);
					cp.add(arista);
				}
			}
		}
		while (!cp.isEmpty()) {
			arista = cp.poll();
			origen = find(arista.getOrigen());
			destino = find(arista.getDestino());
			costo = arista.getCosto();
			if (rep[origen] != rep[destino]) {
				union(origen, destino);
				costoTotal += costo;
			}
		}
		
		System.out.println(costoTotal);
	}

}
