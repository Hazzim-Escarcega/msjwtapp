package informes;

import informes.interfaces.IInformeCuatrimestral;

public class InformeComercialCuatrimestral implements IInformeCuatrimestral {

    @Override
    public String generarInformeQ1() {
        return "Informe Comercial Q1";
    }

    @Override
    public String generarInformeQ2() {
        return "Informe Comercial Q2";
    }

    @Override
    public String generarInformeQ3() {
        return "Informe Comercial Q3";
    }
}
