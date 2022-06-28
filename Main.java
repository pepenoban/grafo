
public class Main {

	public static void main(String[] args) {
		int m = Integer.MAX_VALUE;
		int[][] matrizEjemplo = 
			{ 
				{ m , 1, 1, m, m},
				{ 1, m, m, 1, m },
				{ 1, m, m, 1, 1 }, 
				{ m, 1, 1, m, 1}, 
				{ m, m, 1, 1, m }				
			};
		
		int[][] matrizEjemploPrim = 
			{ 
				{ m , 2, 1, m, m},
				{ 2, m, m, 4, m },
				{ 1, m, m, 2, 1 }, 
				{ m, 4, 2, m, 3}, 
				{ m, m, 1, 3, m }				
			};
		
		int[][] matrizPrim = 
	        { 
	            { m , 4, m, m, m, m, m, 8, m  }, //0
	            { 4 , m, 8, m, m, m, m, 11, m  }, //1
	            { m , 8, m, 7, m, 4, m, m, 2  }, //2
	            { m , m, 7, m, 9, 14, m, m, m  }, //3
	            { m , m, m, 9, m, 10, m, m, m  }, //4
	            { m , m, 4, 14, 10, m, 2, m, m  }, //5
	            { m , m, m, m, m, 2, m, 1, 6  }, //6
	            { 8 , 11, m, m, m, m, 1, m, 7  }, //7
	            { m , m, 2, m, m, m, 6, 7, m  }  //8
	        };

		/*MatrizAdyacencia matriz = new MatrizAdyacencia(matrizEjemplo);
		DFS recorrido = new DFS(matriz);
		recorrido.recorrerGrafo(1);
		
		MatrizAdyacencia matriz = new MatrizAdyacencia(matrizEjemplo);
		BFS recorrido2 = new BFS(matriz);
		recorrido2.recorrerGrafo(1);*/
		
		MatrizAdyacencia matriz = new MatrizAdyacencia(matrizEjemploPrim);
		
		DijkstraTest caminoMasCorto = new DijkstraTest(matriz);
		caminoMasCorto.caminoMasCorto(1);
		
		PrimTest mst = new PrimTest(matriz);
		mst.mst(1);
		
		Kruskal kt = new Kruskal(matriz);
		kt.kt();
	}

}
