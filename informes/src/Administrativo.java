

public class Administrativo implements Empleado{
    @Override
    public String presentarInforme() {
        GenerarInforme informe = new GenerarInforme();
        return informe.informeSemestral();
    }

}
