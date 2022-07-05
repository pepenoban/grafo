package unlam.progava.oia;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscritorDeArchivos {

	public static void escribir(String path, Arbol arbol) {
		FileWriter file = null;
		PrintWriter printerWriter = null;

		try {
			file = new FileWriter(path);
			printerWriter = new PrintWriter(file);

			printerWriter.println(arbol.getResultado());
			if(arbol.getRes1().isEmpty())
				printerWriter.println(0);
			else {
				for (Integer res1 : arbol.getRes1()) {
					printerWriter.print(res1 + " ");
				}
				printerWriter.println();
			}
				//printerWriter.println(arbol.getRes1());		
			if (arbol.getResultado() == "NO") {
				if(arbol.getRes2().isEmpty())
					printerWriter.println(0);
				else
				{
					for (Integer res2 : arbol.getRes2()) {
						printerWriter.print(res2 + " ");
					}
					printerWriter.println();
				}
				if(arbol.getRes1().size() != 1 || arbol.getRes3().isEmpty())
					printerWriter.println(0);
				else
				{
					for (Integer res3 : arbol.getRes3()) {
						printerWriter.print(res3 + " ");
					}
					printerWriter.println();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
