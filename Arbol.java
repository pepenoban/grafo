package unlam.progava.oia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Arbol {
	List<Integer> res1 = new ArrayList<Integer>();
	List<Integer> res2 = new ArrayList<Integer>();
	List<Integer> res3 = new ArrayList<Integer>();
	String resultado;
	Integer cantNodos;
	Integer cantAristas;
	List<Arista> valores = new ArrayList<Arista>();
	MatrizAdyacencia matrizWarshall = new MatrizAdyacencia();
	MatrizAdyacencia matriz = new MatrizAdyacencia();

	public Integer getCantNodos() {
		return cantNodos;
	}

	public void setCantNodos(Integer cantNodos) {
		this.cantNodos = cantNodos;
	}

	public Integer getCantAristas() {
		return cantAristas;
	}

	public void setCantAristas(Integer cantAristas) {
		this.cantAristas = cantAristas;
	}

	public boolean agregar(int origen, int destino) {
		return valores.add(new Arista(origen, destino));
	}

	public void agregarMatriz() {
		for (int i = 0; i < matriz.getNodo(); i++) {
			for (int j = 0; j < matriz.getNodo(); j++) {
				matriz.setArista(i, j, 0);
			}
		}
		for (Arista arista : valores) {
			matriz.setArista(arista.getOrigen() - 1, arista.getDestino() - 1, 1);
		}
		/*for (int i = 0; i < matriz.getNodo(); i++) {
			for (int j = 0; j < matriz.getNodo(); j++) {
				System.out.print(matriz.getArista(i, j) + " ");
			}
			System.out.println();
		}*/
	}

	public String getResultado() {
		return resultado;
	}

	public List<Integer> resolverPunto1() {
		List<Integer> res = new ArrayList<Integer>();
		int contador = 0;
		for (int i = 0; i < cantNodos; i++) {
			contador = 0;
			for (int j = 0; j < cantNodos; j++) {
				if (matriz.getArista(j, i) == 1)
					contador++;
			}
			if (contador == 0)
				res.add(i + 1);
		}
		return res;
	}

	public List<Integer> resolverPunto2() {
		List<Integer> res = new ArrayList<Integer>();
		int contador = 0;
		for (int i = 0; i < cantNodos; i++) {
			contador = 0;
			for (int j = 0; j < cantNodos; j++) {
				if (matriz.getArista(j, i) == 1)
					contador++;
			}
			if (contador != 1 && res1.contains(i+1) == false)
				res.add(i + 1);
		}		
		return res;
	}

	public List<Integer> resolverPunto3() {
		matrizWarshall = matriz;
		List<Integer> res = new ArrayList<Integer>();
		if (res1.size() == 1) {
			int nodoRaiz = res1.get(0) - 1;
			
				for (int j = 0; j < cantNodos; j++) {
					for (int k = 0; k < cantNodos; k++) {
						if (matrizWarshall.getArista(nodoRaiz, j) == 1
								|| matrizWarshall.getArista(nodoRaiz, k) == 1 && matrizWarshall.getArista(k, j) == 1) {
							matrizWarshall.setArista(nodoRaiz, j, 1);
					}
				}
			}
				int[] vectorWarshall = new int[cantNodos];
				vectorWarshall = matrizWarshall.obtenerAdyacentes(nodoRaiz);
				for (int i = 0; i < cantNodos; i++) {
					if (vectorWarshall[i] != 1 && i != nodoRaiz)
						res.add(i + 1);
					}
				}
		return res;
	}

	public List<Integer> getRes1() {
		return res1;
	}

	public void setRes1(List<Integer> res1) {
		this.res1 = res1;
	}

	public List<Integer> getRes2() {
		return res2;
	}

	public void setRes2(List<Integer> res2) {
		this.res2 = res2;
	}

	public List<Integer> getRes3() {
		return res3;
	}

	public void setRes3(List<Integer> res3) {
		this.res3 = res3;
	}

	public void resolverTodo() {
		agregarMatriz();
		res1 = resolverPunto1();
		res2 = resolverPunto2();
		res3 = resolverPunto3();
		if (res1.size() == 1 && res2.size() == 0 && res3.size() == 0)
			resultado = "SI";
		else
			resultado = "NO";
	}

}
