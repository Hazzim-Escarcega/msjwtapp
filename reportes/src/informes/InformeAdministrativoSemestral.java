package informes;

import informes.interfaces.IInformeSemestral;

public class InformeAdministrativoSemestral implements IInformeSemestral {
    @Override
    public String generarInformeH1() {
        return "Informe Administrativo H1";
    }

    @Override
    public String generarInformeH2() {
        return "Informe Administrativo H2";

    }
}
