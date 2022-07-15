package informes;

import informes.interfaces.IInformeCuatrimestral;

public class InformeAdministrativoCuatrimestral implements IInformeCuatrimestral {

    @Override
    public String generarInformeQ1() {
        return "Informe Administrativo Q1";
    }

    @Override
    public String generarInformeQ2() {
        return "Informe Administrativo Q2";

    }

    @Override
    public String generarInformeQ3() {
        return "Informe Administrativo Q3";
    }
}
