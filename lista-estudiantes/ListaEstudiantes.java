public class ListaEstudiantes extends LinkedList<Estudiante>{

    public ListaEstudiantes() {
        super();
    }

    public int cantBecados(){
        int cont = 0;
        for (int i = 0; i < size(); i++) {
            if (get(i).isBecado()) {
                cont++;
            }
        }
        return cont;
    }

    public LinkedList<String> cumpleanios(String mes){
        LinkedList<String> lista = new LinkedList<>();
        for (int i=0;i<size();i++) {
            if (get(i).getCi().substring(2,4).equals(mes)) {
                lista.add(get(i).getNombre()+" "+get(i).getApellido());
            }
        }
        return lista;
    }

    public LinkedList<Estudiante> cantMilitantes(){
        LinkedList<Estudiante> lista = new LinkedList<>();
        for (int i=0;i<this.size();i++) {
            Estudiante e = this.get(i);
            if (e.isMilitante()) {
                int pos = 0;
                while (pos < lista.size() && lista.get(pos).getAnno()<=e.getAnno()) {
                    pos++;
                }
                lista.add(e, pos);
            }
        }
        return lista;
    }

}
