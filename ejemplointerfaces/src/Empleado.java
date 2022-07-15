import java.util.Date;

public class Empleado {
    private int idEmpleado;
    private String nombre;
    private String apellido;
    private String correo;
    private int area;
    private Date contratoInicio;

    public Empleado(int idEmpleado, String nombre, String apellido, String correo, int area, Date contratoInicio) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.area = area;
        this.contratoInicio = contratoInicio;
    }

    public Empleado() {
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public Date getContratoInicio() {
        return contratoInicio;
    }

    public void setContratoInicio(Date contratoInicio) {
        this.contratoInicio = contratoInicio;
    }
}
