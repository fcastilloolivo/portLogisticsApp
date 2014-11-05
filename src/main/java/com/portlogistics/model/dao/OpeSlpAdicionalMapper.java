package com.portlogistics.model.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by Francisco on 04/11/2014.
 */
public interface OpeSlpAdicionalMapper {

    List<Map<String, Object>> listCabAdicional(Map<String, Object> paramMap);

    List<Map<String, Object>> listDetAdicional(Map<String, Object> paramMap);

    List<Map<String, Object>> listDetCabAdicional(Map<String, Object> paramMap);

}
