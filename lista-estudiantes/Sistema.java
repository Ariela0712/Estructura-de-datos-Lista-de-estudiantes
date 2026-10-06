public class Sistema {
    private ListaEstudiantes lista;
    private Validacion val;

    public Sistema() {
        this.lista = new ListaEstudiantes();
        this.val = new Validacion();
    }

    public void iniciar() {
        int op = -1;
        while (op != 0) {
            mostrarMenu();
            op = val.validarEntero("Elige una opción: ",0,6);

            if(op == 1){
                agregarEstudiante();
            } else if (op == 2){
                mostrarEstudiantes("Estudiantes registrados",lista);
            } else if(op == 3){
                consultarCumpleanios();
            } else if(op == 4){
                mostrarEstudiantes("Militantes de la UJC (año de menor a mayor)",lista.cantMilitantes());
            } else if(op == 5){
                System.out.println("\nCantidad de estudiantes becados: " + lista.cantBecados());
            } else if(op == 6){
                ejecutarPruebas();
            }else {
                System.out.println("Saliendo del sistema....");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("\nMenu: Control de estudiantes");
        System.out.println("1. Agregar estudiante");
        System.out.println("2. Mostrar estudiantes registrados");
        System.out.println("3. Estudiantes que cumplen años en un mes");
        System.out.println("4. Militantes de la UJC ordenados por año");
        System.out.println("5. Cantidad de estudiantes becados");
        System.out.println("6. Ejecutar casos de prueba");
        System.out.println("0. Salir");
    }

    private void agregarEstudiante() {
        String ci = val.validarCI("CI (11 dígitos): ");
        if (ciRepetido(ci)) {
            System.out.println("Ya existe un estudiante con ese CI.");
        } else {
            String nombre = val.validarNombre("Nombre: ");
            String apellido = val.validarNombre("Apellido: ");
            System.out.println("Sexo: 1.Masculino  2.Femenino");
            int s = val.validarEntero("Sexo (1 a 2): ",1,2);
            String sexo;
            if (s == 1) {
                sexo = "Masculino";
            } else {
                sexo = "Femenino";
            }
            int anio = val.validarEntero("Año (1 a 5): ",1,5);
            boolean militante = val.validarSiNo("¿Es militante de la UJC?");
            boolean becado = val.validarSiNo("¿Es becado?");
            lista.add(new Estudiante(ci, nombre, apellido, sexo, anio, militante, becado));
            System.out.println("Estudiante agregado.");
        }
    }

    private boolean ciRepetido(String ci) {
        boolean repetido = false;
        for (int i=0;i<lista.size();i++) {
            if (lista.get(i).getCi().equals(ci)) {
                repetido = true;
            }
        }
        return repetido;
    }

    private void consultarCumpleanios() {
        int m = val.validarEntero("Mes (1 a 12): ",1,12);
        String mes;
        if (m<10) {
            mes = "0"+m;
        } else {
            mes = ""+m;
        }
        mostrarNombres("Cumplen años en el mes "+mes,lista.cumpleanios(mes));
    }

    private void agregar(ListaEstudiantes l,String ci,String nombre,String apellido,String sexo,int anio,boolean militante,boolean becado) {
        l.add(new Estudiante(ci, nombre, apellido, sexo, anio, militante, becado));
    }

    private void ejecutarPruebas() {
        ListaEstudiantes p = new ListaEstudiantes();
        agregar(p, "05051512345", "Carlos", "Gomez", "Masculino", 1, true, true);
        agregar(p, "03052212355", "Lucia", "Diaz", "Femenino", 3, false, true);
        agregar(p, "04110812344", "Mario", "Ruiz", "Masculino", 2, true, false);
        agregar(p, "02032012375", "Elena", "Soto", "Femenino", 4, true, true);
        agregar(p, "04051012304", "Pablo", "Rey", "Masculino", 2, true, false);
        agregar(p, "99121012315", "Sara", "Mena", "Femenino", 5, false, false);
        agregar(p, "05071812344", "Luis", "Pena", "Masculino", 1, false, true);
        agregar(p, "03091912395", "Diana", "Cruz", "Femenino", 3, true, false);

        System.out.println("\n1. Metodo cumpleanios");
        mostrarNombres("Mes 05", p.cumpleanios("05"));
        mostrarNombres("Mes 11", p.cumpleanios("11"));
        mostrarNombres("Mes 08 (nadie)", p.cumpleanios("08"));
        mostrarNombres("Lista vacía, mes 05",new ListaEstudiantes().cumpleanios("05"));

        System.out.println("\n2. Metodo cantMilitantes");
        mostrarEstudiantes("Militantes ordenados por año",p.cantMilitantes());
        mostrarEstudiantes("Original (no debe cambiar)",p);

        ListaEstudiantes q = new ListaEstudiantes();
        agregar(q, "05051512345", "Carlos","Gomez","Masculino",1, false, true);
        agregar(q, "03052212355", "Lucia","Diaz", "Femenino",3, false, false);
        mostrarEstudiantes("Sin ningún militante",q.cantMilitantes());
        mostrarEstudiantes("Lista vacía",new ListaEstudiantes().cantMilitantes());

        System.out.println("\n3. Metodo cantBecados");
        System.out.println("Becados (lista normal): "+p.cantBecados());
        System.out.println("Becados (ninguno es becado): "+crearSinBecados().cantBecados());
        System.out.println("Becados (lista vacía): "+new ListaEstudiantes().cantBecados());
    }

    private ListaEstudiantes crearSinBecados() {
        ListaEstudiantes r = new ListaEstudiantes();
        agregar(r, "04110812344", "Mario", "Ruiz", "Masculino", 2, true, false);
        agregar(r, "99121012315", "Sara", "Mena", "Femenino", 5, false, false);
        return r;
    }

    private void mostrarNombres(String titulo,LinkedList<String> nombres) {
        String texto = "";
        for (int i=0;i<nombres.size();i++) {
            texto = texto + nombres.get(i);
            if (i < nombres.size()-1) {
                texto = texto + ", ";
            }
        }
        if (nombres.isEmpty()) {
            texto = "(ninguno)";
        }
        System.out.println(titulo +": "+texto);
    }

    private void mostrarEstudiantes(String titulo,LinkedList<Estudiante>estudiantes) {
        System.out.println(titulo + ":");
        if (estudiantes.isEmpty()) {
            System.out.println("  (vacía)");
        } else {
            for (int i=0;i<estudiantes.size();i++) {
                System.out.println("  "+(i+1)+". "+estudiantes.get(i));
            }
        }
    }
}