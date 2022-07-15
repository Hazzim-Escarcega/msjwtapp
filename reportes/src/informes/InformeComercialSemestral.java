package informes;

import informes.interfaces.IInformeSemestral;

public class InformeComercialSemestral implements IInformeSemestral {
    @Override
    public String generarInformeH1() {
        return "Informe Comercial H1";
    }

    @Override
    public String generarInformeH2() {
        return "Informe Comercial H2";
    }
}
