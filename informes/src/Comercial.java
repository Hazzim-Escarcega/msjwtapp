public class Comercial implements Empleado{

    @Override
    public String presentarInforme() {
        GenerarInforme informe = new GenerarInforme();
        return informe.informeSemestral();
    }
}
