package es.upm.modificacionEjercicio201;

public class Main {

	public static void main(String[] args) {
		
		Carpeta principal = new Carpeta("Principal");

	        principal.addArchivo(new Archivo("foto", 5.2));
	        principal.addArchivo(new Archivo("documento", 2.5));

	        Carpeta trabajos = new Carpeta("Trabajos");
	        trabajos.addArchivo(new Archivo("practicaJava", 1.2));

	        Carpeta universidad = new Carpeta("Universidad");
	        universidad.addArchivo(new Archivo("apuntes", 10.0));

	        trabajos.addSubcarpeta(universidad);
	        principal.addSubcarpeta(trabajos);

	        System.out.println("Peso total: "
	                + CarpetaUtils.calcularPesoTotal(principal) + " MB");

	        System.out.println("Número de archivos: "
	                + CarpetaUtils.contarArchivos(principal));

	        Archivo encontrado =
	                CarpetaUtils.buscarArchivo(principal, "apuntes");

	        if (encontrado != null) {
	            System.out.println("Encontrado: "
	                    + encontrado.getNombre()
	                    + " (" + encontrado.getPesoMB() + " MB)");
	        }
	    }

	}


