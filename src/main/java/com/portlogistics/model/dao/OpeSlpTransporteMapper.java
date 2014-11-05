package com.portlogistics.model.dao;

import java.util.List;
import java.util.Map;


/**
 * Created by Francisco on 04/11/2014.
 */
public interface OpeSlpTransporteMapper {

    List<Map<String, Object>> listCabTransporte(Map<String, Object> paramMap);

    List<Map<String, Object>> listDetTransporte(Map<String, Object> paramMap);

}
