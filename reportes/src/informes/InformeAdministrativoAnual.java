package informes;

import informes.interfaces.IInformeAnual;

public class InformeAdministrativoAnual implements IInformeAnual {
    @Override
    public String generarInformeAnual() {
        return "Informe Administrativo Anual";
    }
}
