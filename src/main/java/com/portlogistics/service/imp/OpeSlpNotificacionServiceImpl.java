package com.portlogistics.service.imp;

import com.portlogistics.model.dao.OpeSlpNotificacionMapper;
import com.portlogistics.service.itz.OpeSlpNotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cvfrans on 3/11/14.
 */

@Service
public class OpeSlpNotificacionServiceImpl implements OpeSlpNotificacionService {

    @Autowired
    private OpeSlpNotificacionMapper opeSlpNotificacionMapper;

    @Override
    public List<Map<String, Object>> listarSlpNotificacion(String codEmp, String codApp, String codCliente) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("codEmp",codEmp);
        param.put("codApp",codApp);
        param.put("codCliente",codCliente);

        return opeSlpNotificacionMapper.listSlpNotificacion(param);
    }
}
