import java.util.Scanner;

public class Validacion {
    Scanner in = new Scanner(System.in);

    public int validarEntero(String mensaje,int min,int max) {
        int num = min-1;
        boolean val = false;
        while (!val){
            System.out.print(mensaje);
            String entrada = in.nextLine().trim();
            try {
                num = Integer.parseInt(entrada);
                if (num>=min && num<=max) {
                    val = true;
                } else {
                    System.out.println("Debe estar entre "+min+" y "+max+".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida: escribe un número entero.");
            }
        }
        return num;
    }

    public String validarNombre(String mensaje) {
        String texto = "";
        boolean val = false;
        while (!val){
            System.out.print(mensaje);
            texto = in.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("No puede estar vacío.");
            } else if (!soloLetrasYEspacios(texto)) {
                System.out.println("Solo se permiten letras y espacios.");
            } else {
                val = true;
            }
        }
        return texto;
    }

    public String validarCI(String mensaje) {
        String ci = "";
        boolean val = false;
        while (!val) {
            System.out.print(mensaje);
            ci = in.nextLine().trim();
            if (ci.length() != 11 || !soloDigitos(ci)) {
                System.out.println("El CI debe tener exactamente 11 dígitos.");
            } else {
                int mes = Integer.parseInt(ci.substring(2,4));
                int dia = Integer.parseInt(ci.substring(4,6));
                if (mes<1 || mes>12) {
                    System.out.println("El mes del CI (dígitos 3 y 4) debe estar entre 01 y 12.");
                } else if (dia<1 || dia>31) {
                    System.out.println("El día del CI (dígitos 5 y 6) debe estar entre 01 y 31.");
                } else {
                    val= true;
                }
            }
        }
        return ci;
    }

    public boolean validarSiNo(String mensaje) {
        boolean respuesta = false;
        boolean val = false;
        while (!val) {
            System.out.print(mensaje + " (S/N): ");
            String entrada = in.nextLine().trim();
            if (entrada.equalsIgnoreCase("S")) {
                respuesta = true;
                val = true;
            } else if (entrada.equalsIgnoreCase("N")) {
                respuesta = false;
                val = true;
            } else {
                System.out.println("Escribe S o N.");
            }
        }
        return respuesta;
    }

    private boolean soloLetrasYEspacios(String texto) {
        boolean val = true;
        for (int i=0;i<texto.length();i++) {
            char c = texto.charAt(i);
            if (!Character.isLetter(c) && c != ' ') {
                val = false;
            }
        }
        return val;
    }

    private boolean soloDigitos(String texto) {
        boolean val = true;
        for (int i=0;i<texto.length();i++) {
            if (!Character.isDigit(texto.charAt(i))) {
                val = false;
            }
        }
        return val;
    }
}