package com.portlogistics.service.imp;

import com.portlogistics.model.dao.DuaDocHistoricoMapper;
import com.portlogistics.model.dao.OpeSlpTransporteMapper;
import com.portlogistics.model.dao.OpeSlpAdicionalMapper;
import com.portlogistics.model.dao.OpeBookingMapper;
import com.portlogistics.service.itz.DuaDocHistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cvfrans on 4/11/14.
 */
@Service
public class DuaDocHistoricoImpl implements DuaDocHistoricoService {

    @Autowired
    private DuaDocHistoricoMapper duaDocHistoricoMapper;
    @Autowired
	private OpeSlpTransporteMapper opeSlpTransporteMapper;
    @Autowired
	private OpeSlpAdicionalMapper opeSlpAdicionalMapper;
    @Autowired
	private OpeBookingMapper opeBookingMapper;

    @Override
    public Map<String, Object> listarDocDuaHistorico(String codEmp, String anioDua, String codAduana, String codRegimen, String numDua) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("codEmp",codEmp);
        param.put("anioDua",anioDua);
        param.put("codAduana",codAduana);
        param.put("codRegimen",codRegimen);
        param.put("numDua",numDua);

        Map<String, Object> paramResul = new HashMap<String, Object>();
        paramResul.put("cabecera",duaDocHistoricoMapper.listCabDuaDocHistorico(param).get(0));
        paramResul.put("detalle", duaDocHistoricoMapper.listDetDuaDocHistorico(param));

        return paramResul;
    }

    public Map<String, Object> listarDetalleDuaHistorico(String codEmp, String anioDua, String codAduana, String codRegimen, String numDua,String item) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("codEmp",codEmp);
        param.put("anioDua",anioDua);
        param.put("codAduana",codAduana);
        param.put("codRegimen",codRegimen);
        param.put("numDua",numDua);
        param.put("item",item);

        Map<String, Object> paramResul = new HashMap<String, Object>();
        paramResul.put("cabecera",duaDocHistoricoMapper.listCabDetDocHistorico(param).get(0));
        paramResul.put("detalle", duaDocHistoricoMapper.listArchivosDua(param));

        return paramResul;
    }
	
	public Map<String, Object> listarCabTransporte(String codEmp, String anioSlp, String nroSlp) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("codEmp",codEmp);
        param.put("anioSlp",anioSlp);
        param.put("nroSlp",nroSlp);

        Map<String, Object> paramResul = new HashMap<String, Object>();
        paramResul.put("cabecera",opeSlpTransporteMapper.listCabTransporte(param).get(0));
        paramResul.put("detalle", opeSlpTransporteMapper.listDetTransporte(param));
		paramResul.put("lstDua", opeBookingMapper.listDuabySlp(param));
        return paramResul;
    }
	
	public Map<String, Object> listarCabAdicional(String codEmp, String anioSlp, String nroSlp) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("codEmp",codEmp);
        param.put("anioSlp",anioSlp);
        param.put("nroSlp",nroSlp);

        Map<String, Object> paramResul = new HashMap<String, Object>();
        paramResul.put("cabecera",opeSlpAdicionalMapper.listCabAdicional(param).get(0));
        paramResul.put("detalle", opeSlpAdicionalMapper.listDetAdicional(param));
		paramResul.put("lstDua", opeBookingMapper.listDuabySlp(param));

        return paramResul;
    }
	
	public Map<String, Object> listarDetAdicional(String codEmp, String anioSlp, String nroSlp, String item) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("codEmp",codEmp);
        param.put("anioSlp",anioSlp);
        param.put("nroSlp",nroSlp);
        param.put("item",item);

        Map<String, Object> paramResul = new HashMap<String, Object>();
        paramResul.put("cabecera",opeSlpAdicionalMapper.listDetCabAdicional(param).get(0));
		paramResul.put("lstDua", opeBookingMapper.listDuabySlp(param));

        return paramResul;
    }
	
	public Map<String, Object> obtenerUsuarioCliente(String codEmp, String usuario, String clave) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("codEmp",codEmp);
        param.put("usuario",usuario);
        param.put("clave",clave);

        Map<String, Object> paramResul = new HashMap<String, Object>();
		
		Map<String, Object> mapUsuario = opeBookingMapper.getUsuarioCliente(param);
		paramResul.put("datosUsuario", mapUsuario);
		if (mapUsuario != null ){
			paramResul.put("success",true);
		} else {
			paramResul.put("success",false);
		}
        return paramResul;
    }
	
	

}


