package empleados;

import empleados.interfaces.IEmpleadoAdministrativo;
import informes.InformeAdministrativoAnual;
import informes.InformeAdministrativoCuatrimestral;
import informes.InformeAdministrativoSemestral;

public class EmpleadoAdministrativo implements IEmpleadoAdministrativo {




    public EmpleadoAdministrativo() {

    }

    @Override
    public String presentarInformeAnual() {
        InformeAdministrativoAnual informeAnual = new InformeAdministrativoAnual();
        return informeAnual.generarInformeAnual();
    }

    @Override
    public String presentarInformeSemestralH1() {
        InformeAdministrativoSemestral informeSemestral = new InformeAdministrativoSemestral();
        return informeSemestral.generarInformeH1();
    }

    @Override
    public String presentarInformeSemestralH2() {
        InformeAdministrativoSemestral informeSemestral = new InformeAdministrativoSemestral();
        return informeSemestral.generarInformeH2();
    }

    @Override
    public String presentarInformeCuatrimestralQ1() {
        InformeAdministrativoCuatrimestral informeCuatrimestral = new InformeAdministrativoCuatrimestral();
        return informeCuatrimestral.generarInformeQ1();
    }

    @Override
    public String presentarInformeCuatrimestralQ2() {
        InformeAdministrativoCuatrimestral informeCuatrimestral = new InformeAdministrativoCuatrimestral();
        return informeCuatrimestral.generarInformeQ2();
    }

    @Override
    public String presentarInformeCuatrimestralQ3() {
        InformeAdministrativoCuatrimestral informeCuatrimestral = new InformeAdministrativoCuatrimestral();
        return informeCuatrimestral.generarInformeQ3();
    }

}
