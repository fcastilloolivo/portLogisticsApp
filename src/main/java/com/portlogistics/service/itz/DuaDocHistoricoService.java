package com.portlogistics.service.itz;

import java.util.List;
import java.util.Map;

/**
 * Created by cvfrans on 4/11/14.
 */
public interface DuaDocHistoricoService {

    public Map<String,Object> listarDocDuaHistorico(String codEmp, String anioDua, String codAduana, String codRegimen, String numDua);
    public Map<String,Object> listarDetalleDuaHistorico(String codEmp, String anioDua, String codAduana, String codRegimen, String numDua, String item);
	public Map<String, Object> listarCabTransporte(String codEmp, String anioSlp, String nroSlp);
	public Map<String, Object> listarCabAdicional(String codEmp, String anioSlp, String nroSlp);
	public Map<String, Object> listarDetAdicional(String codEmp, String anioSlp, String nroSlp, String item);
    public Map<String, Object> obtenerUsuarioCliente(String codEmp, String usuario, String clave);

}
