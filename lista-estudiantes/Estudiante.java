public class Estudiante {
    private String ci;
    private String nombre;
    private String apellido;
    private String sexo;
    private int anno;
    private boolean militante;
    private boolean becado;

    public Estudiante(String ci, String nombre, String apellido, String sexo, int anno, boolean militante, boolean becado) {
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.anno = anno;
        this.militante = militante;
        this.becado = becado;
    }

    public String getCi() {
        return ci;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public int getAnno() {
        return anno;
    }

    public boolean isMilitante() {
        return militante;
    }

    public boolean isBecado() {
        return becado;
    }

    @Override 
    public String toString() {
        return "CI: "+ci+", Nombre: "+nombre+", Apellido: "+apellido+", Sexo: "+sexo+", Año: "+anno+", Militante: "+militante+", Becado: "+(becado ? "Sí":"No");
    }
}
