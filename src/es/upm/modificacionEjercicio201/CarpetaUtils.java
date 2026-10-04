package es.upm.modificacionEjercicio201;

public class CarpetaUtils {

	public static double calcularPesoTotal(Carpeta inicio) {
	    // Caso base implícito: si la carpeta no tiene archivos ni subcarpetas,
	    // los bucles no se ejecutan y devuelve 0.0.
	    
	    if (inicio == null) return 0.0; // Protección contra null

	    double pesoTotal = 0.0;

	    // Sumar peso de archivos directos
	    if (inicio.getArchivos() != null) {
	        for (Archivo a : inicio.getArchivos()) {
	            pesoTotal += a.getPesoMB();
	        }
	    }

	    // Sumar peso de subcarpetas (Paso recursivo)
	    if (inicio.getSubcarpetas() != null) {
	        for (Carpeta sub : inicio.getSubcarpetas()) {
	            pesoTotal += calcularPesoTotal(sub);
	        }
	    }

	    return pesoTotal;
	}
	
	public static int contarArchivos(Carpeta inicio) {
	    if (inicio == null) return 0;

	    int contador = inicio.getArchivos().size();

	    for (Carpeta sub : inicio.getSubcarpetas()) {
	        contador += contarArchivos(sub);
	    }

	    return contador;
	}
	
	public static Archivo buscarArchivo(Carpeta inicio, String nombre) {
	    if (inicio == null) return null;

	    for (Archivo archivo : inicio.getArchivos()) {
	        if (archivo.getNombre().equals(nombre)) {
	            return archivo;
	        }
	    }

	    for (Carpeta sub : inicio.getSubcarpetas()) {
	        Archivo encontrado = buscarArchivo(sub, nombre);

	        if (encontrado != null) {
	            return encontrado;
	        }
	    }
	    return null;
	}
	
}
