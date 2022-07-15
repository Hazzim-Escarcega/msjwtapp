import empleados.EmpleadoAdministrativo;
import empleados.EmpleadoComercial;

public class Reportes {
    public static void main(String[] args) {
        EmpleadoAdministrativo administrativo = new EmpleadoAdministrativo();
        EmpleadoComercial comercial = new EmpleadoComercial();


        System.out.println("-----Reporte Administrativo-----");
        System.out.println(administrativo.presentarInformeAnual());
        System.out.println(administrativo.presentarInformeSemestralH1());
        System.out.println(administrativo.presentarInformeSemestralH2());

        System.out.println(administrativo.presentarInformeCuatrimestralQ1());
        System.out.println(administrativo.presentarInformeCuatrimestralQ2());
        System.out.println(administrativo.presentarInformeCuatrimestralQ3());


        System.out.println("-----Reporte Comercial-----");
        System.out.println(comercial.presentarInformeSemestralH1());
        System.out.println(comercial.presentarInformeSemestralH2());

        System.out.println(comercial.presentarInformeCuatrimestralQ1());
        System.out.println(comercial.presentarInformeCuatrimestralQ2());
        System.out.println(comercial.presentarInformeCuatrimestralQ3());
    }
}
