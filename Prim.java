import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prim {

	private int costoTotal = 0;
	private int nodoActual;
	private MatrizAdyacencia grafo;
	private List<Arista> listaFinal = new ArrayList<Arista>();
	private List<Boolean> nodosVisitados = new ArrayList<Boolean>();

	public Prim(MatrizAdyacencia grafo) {
		this.grafo = grafo;
	}

	public void arbolCostoMinimoPrim(int nodoInicial) {
		for (int i = 0; i < grafo.getNodo(); i++)
			nodosVisitados.add(false);

		int bandera = 0;
		Arista arista;
		PriorityQueue<Arista> colaPrioridad = new PriorityQueue<Arista>();

		nodoActual = nodoInicial;
		nodosVisitados.set(nodoActual, true);

		while (nodosVisitados.contains(false)) {
			bandera = 0;
			int[] adyacentes = grafo.obtenerAdyacentes2(nodoActual);

			for (int i = 0; i < adyacentes.length; i++) {
				if (adyacentes[i] != Integer.MAX_VALUE && nodosVisitados.get(i) == false) {
					arista = new Arista(nodoActual, i, adyacentes[i]);
					colaPrioridad.add(arista);
				}
			}
			
			while (!colaPrioridad.isEmpty() && bandera == 0) {
				arista = colaPrioridad.poll();
				nodoActual = arista.getDestino();
				if (nodosVisitados.get(nodoActual) == false) {
					listaFinal.add(arista);
					costoTotal += arista.getCosto();
					nodosVisitados.set(nodoActual, true);
					bandera = 1;
				}
			}
		}

		this.printListaFinal(listaFinal);
		System.out.println("Costo Total:" + costoTotal);
	}

	private void printListaFinal(List<Arista> listaFinal) {
		System.out.println("Origen\tDestino\tCosto");
		System.out.println("------\t-------\t-----");
		for (Arista arista : listaFinal) {
			System.out.println(arista.getOrigen() + "\t" + arista.getDestino() + "\t" + arista.getCosto());
		}
	}
}