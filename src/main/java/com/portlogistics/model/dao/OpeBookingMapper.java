package com.portlogistics.model.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by cvfrans on 2/11/14.
 */
public interface OpeBookingMapper {

    List<Map<String, Object>> listBookingDua(Map<String, Object> mapBookingDua);
	List<Map<String, Object>> listDuabySlp(Map<String, Object> mapDuabySlp);
    Map<String, Object> getUsuarioCliente(Map<String, Object> mapUsuario);

}
