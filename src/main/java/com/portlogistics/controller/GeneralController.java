package com.portlogistics.controller;


import com.portlogistics.bean.OpeSlp;
import com.portlogistics.service.itz.DuaDocHistoricoService;
import com.portlogistics.service.itz.OpeBookingService;
import com.portlogistics.service.itz.OpeSlpNotificacionService;
import com.portlogistics.service.itz.OpeSlpService;
import com.portlogistics.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/data")
public class GeneralController {


    @Autowired
    private OpeSlpService opeSlpService;

    @Autowired
    private OpeBookingService opeBookingService;

    @Autowired
    private OpeSlpNotificacionService opeSlpNotificacionService;

    @Autowired
    private DuaDocHistoricoService duaDocHistoricoService;

	@RequestMapping("/person")
	public OpeSlp getPersonDetail(@RequestParam(value = "id",required = false, defaultValue = "0") Integer id) {

        List<OpeSlp> lstOpenSlp = opeSlpService.listaOpeSlp(id);

		return lstOpenSlp.get(0);

	}

    @RequestMapping("/autoCompletar")
    public List<Map<String,Object>> mostrarAutoCompletar(
            @RequestParam(value = "valor",required = false, defaultValue = "") String valor,
            @RequestParam(value = "indicador",required = false, defaultValue = "") String indicador,
            @RequestParam(value = "pagina",required = false, defaultValue = "") String pagina)
    {
        /*
        Pagina permitira un query especifico:
         01 : PagDua
         02 : PagTransporte y PagAdicional
         Ejem URl: http://localhost:8080/data/autoCompletar?valor=578&indicador=01,04&pagina=01
         */

        List<Map<String,Object>> lstBookingDuaMap = opeBookingService.listarBookingDua(valor, indicador, pagina);

        return lstBookingDuaMap;
    }

    @RequestMapping("/slpNotificacion")
    public List<Map<String,Object>> mostrarSlpNotificacion(
            @RequestParam(value = "codEmp",required = false, defaultValue = "") String codEmp,
            @RequestParam(value = "codApp",required = false, defaultValue = "") String codApp,
            @RequestParam(value = "codCliente",required = false, defaultValue = "") String codCliente)
    {
        /*
        Noticias relacionada a su importacion/exportacion de mercaderia.
        Se mostrar en la portada del aplicativo
        URL: http://localhost:8080/data/slpNotificacion?codEmp=08&codApp=001&codCliente=20517661211
        */
        List<Map<String,Object>> lstSlpNotificacionMap = opeSlpNotificacionService.listarSlpNotificacion(codEmp,codApp,codCliente);

        return lstSlpNotificacionMap;
    }

    @RequestMapping("/docDuaHistorico")
    public Map<String,Object> mostrarDocDuaHistorico(
            @RequestParam(value = "codEmp",required = false, defaultValue = "") String codEmp,
            @RequestParam(value = "idBusqueda",required = false, defaultValue = "") String idBusqueda,
            @RequestParam(value = "pagina",required = false, defaultValue = "") String pagina)
    {
        Map<String,Object> lstDuaDocHistoricoMap = new HashMap<String,Object>();
		String[] lstDeclara = idBusqueda.split("_");
        if (pagina.equals("pagDua")){            
            lstDuaDocHistoricoMap = duaDocHistoricoService.listarDocDuaHistorico(codEmp,lstDeclara[3],lstDeclara[1],lstDeclara[2],lstDeclara[0]);
        } else if (pagina.equals("pagTransporte")){
			lstDuaDocHistoricoMap = duaDocHistoricoService.listarCabTransporte(codEmp,lstDeclara[0],lstDeclara[1]);
		} else if (pagina.equals("pagAdicional")){
			lstDuaDocHistoricoMap = duaDocHistoricoService.listarCabAdicional(codEmp,lstDeclara[0],lstDeclara[1]);
		}
        /*
        Noticias relacionada a su importacion/exportacion de mercaderia.
        Se mostrar en la portada del aplicativo
        URL: http://localhost:8080/data/slpNotificacion?codEmp=08&codApp=001&codCliente=20517661211
        */
        return lstDuaDocHistoricoMap;
    }

    @RequestMapping("/detalleHistorico")
    public Map<String,Object> mostrarDetalleHistorico(
            @RequestParam(value = "codEmp",required = false, defaultValue = "") String codEmp,
            @RequestParam(value = "idBusqueda",required = false, defaultValue = "") String idBusqueda,
            @RequestParam(value = "item",required = false, defaultValue = "") String item,
            @RequestParam(value = "pagina",required = false, defaultValue = "") String pagina)
    {
        Map<String,Object> lstDuaDocHistoricoMap = new HashMap<String,Object>();
		String[] lstDeclara = idBusqueda.split("_");
        if (pagina.equals("pagDua")){
            lstDuaDocHistoricoMap = duaDocHistoricoService.listarDetalleDuaHistorico(codEmp, lstDeclara[0],lstDeclara[1],lstDeclara[2],lstDeclara[3],item);
        } else if (pagina.equals("pagTransporte")){
			//lstDuaDocHistoricoMap = duaDocHistoricoService.listarDetalleDuaHistorico(codEmp, lstDeclara[3],lstDeclara[1],lstDeclara[2],lstDeclara[0],item);
		} else if (pagina.equals("pagAdicional")){
			lstDuaDocHistoricoMap = duaDocHistoricoService.listarDetAdicional(codEmp, lstDeclara[0],lstDeclara[1],item);
		}

        return lstDuaDocHistoricoMap;
    }
	
	@RequestMapping("/autenticaPLX")
    public Map<String,Object> mostrarDetalleHistorico(
            @RequestParam(value = "codEmp",required = false, defaultValue = "") String codEmp,
            @RequestParam(value = "usuario",required = false, defaultValue = "") String usuario,
            @RequestParam(value = "clave",required = false, defaultValue = "") String clave)
    {
        Map<String,Object> lstDuaDocHistoricoMap = new HashMap<String,Object>();
		lstDuaDocHistoricoMap = duaDocHistoricoService.obtenerUsuarioCliente(codEmp, usuario, clave);
		
        return lstDuaDocHistoricoMap;
    }

}