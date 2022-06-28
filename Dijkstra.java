public class Dijkstra {
	
	private MatrizAdyacencia grafo;
	private int[] dist;
	private boolean[] nVisitados;
	private int[] pred;
	private int nodoActual;

	public Dijkstra(MatrizAdyacencia grafo) {
		this.grafo = grafo;
	}

	public int distanciaMinima(int[] distancias, boolean[] nVisitados) {
		int min = Integer.MAX_VALUE;
		int min_index = -1;

		for (int i = 0; i < distancias.length; i++) {
			if (!nVisitados[i] && distancias[i] < min) {
				min = distancias[i];
				min_index = i;
			}
		}

		return min_index;
	}

	public void caminoMasCorto(int nodoInicial) {
		int cantNodo = grafo.getNodo();
		dist = new int[cantNodo];
		nVisitados = new boolean[cantNodo];
		pred = new int[cantNodo];

		for (int i = 0; i < cantNodo; i++) {
			dist[i] = Integer.MAX_VALUE;
			nVisitados[i] = false;
		}

		this.nodoActual = nodoInicial - 1;
		dist[nodoActual] = 0;

		for (int i = 0; i < cantNodo - 1; i++) {
			int minimo = distanciaMinima(dist, nVisitados);
			nVisitados[minimo] = true;
			for (int j = 0; j < cantNodo; j++) {
				if (!nVisitados[j] && dist[minimo] != Integer.MAX_VALUE && grafo.getArista(minimo, j) != 0
						&& dist[minimo] + grafo.getArista(minimo, j) < dist[j]) {
					dist[j] = (int) (dist[minimo] + grafo.getArista(minimo, j));
					pred[j] = minimo + 1;
				}
			}
		}
		for (int i = 0; i < dist.length; i++) {
			System.out.println(nodoInicial + " -> " + (i + 1) + " - " + dist[i]);
		}
		
		for (int i = 0; i < dist.length; i++) {
			System.out.println(pred[i]);
		}
	}

}
