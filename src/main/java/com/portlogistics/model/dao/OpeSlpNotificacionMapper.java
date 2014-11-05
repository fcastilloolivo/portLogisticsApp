package com.portlogistics.model.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by cvfrans on 3/11/14.
 */
public interface OpeSlpNotificacionMapper {

    List<Map<String, Object>> listSlpNotificacion(Map<String, Object> mapSqlNotificacion);
}
