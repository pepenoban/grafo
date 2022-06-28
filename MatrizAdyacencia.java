
public class MatrizAdyacencia extends Grafo {

	private int tamanio;
	private int[][] grafo;

	/*
	 * public MatrizAdyacencia(int[][] matrizDFS) { grafo = new
	 * double[matrizDFS][matrizDFS]; }
	 */

	public MatrizAdyacencia(int[][] matrizDFS) {
		this.grafo = matrizDFS;
		this.tamanio = grafo.length;
	}

	@Override
	public int getNodo() {
		return grafo.length;
	}

	@Override
	public void setArista(int desde, int hasta, double costo) {
		grafo[desde][hasta] = (int) costo;
		grafo[hasta][desde] = (int) costo;
	}

	@Override
	public double getArista(int desde, int hasta) {
		return grafo[desde][hasta];
	}

	public int[] obtenerAdyacentes(int nodo) {
		int[] adyacentes = new int[grafo.length];
		int j = 0;
		for (int i = 0; i < grafo.length; i++) {
			if (grafo[nodo-1][i] != Integer.MAX_VALUE) 
				adyacentes[j] = i + 1;
			else
				adyacentes[j] = Integer.MAX_VALUE;
			j++;
		}
		return adyacentes;
	}
	
	public int[] obtenerAdyacentes2(int nodo) {
		return grafo[nodo];
	}
}
