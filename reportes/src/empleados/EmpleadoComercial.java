package empleados;

import empleados.interfaces.IEmpleadoComercial;
import informes.InformeComercialCuatrimestral;
import informes.InformeComercialSemestral;

public class EmpleadoComercial implements IEmpleadoComercial {


    public EmpleadoComercial() {

    }

    @Override
    public String presentarInformeSemestralH1() {
        InformeComercialSemestral informeSemestral = new InformeComercialSemestral();
        return informeSemestral.generarInformeH1();
    }

    @Override
    public String presentarInformeSemestralH2() {
        InformeComercialSemestral informeSemestral = new InformeComercialSemestral();
        return informeSemestral.generarInformeH2();
    }

    @Override
    public String presentarInformeCuatrimestralQ1() {
        InformeComercialCuatrimestral informeCuatrimestral = new InformeComercialCuatrimestral();
        return informeCuatrimestral.generarInformeQ1();
    }

    @Override
    public String presentarInformeCuatrimestralQ2() {
        InformeComercialCuatrimestral informeCuatrimestral = new InformeComercialCuatrimestral();
        return informeCuatrimestral.generarInformeQ2();
    }

    @Override
    public String presentarInformeCuatrimestralQ3() {
        InformeComercialCuatrimestral informeCuatrimestral = new InformeComercialCuatrimestral();
        return informeCuatrimestral.generarInformeQ3();
    }

}
