package com.portlogistics.service.itz;

import java.util.List;
import java.util.Map;

/**
 * Created by cvfrans on 3/11/14.
 */
public interface OpeSlpNotificacionService {

    public List<Map<String,Object>> listarSlpNotificacion(String codEmp, String codApp, String codCliente);
}
