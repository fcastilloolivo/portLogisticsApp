package com.portlogistics.model.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by cvfrans on 3/11/14.
 */
public interface DuaDocHistoricoMapper {

    List<Map<String, Object>> listCabDuaDocHistorico(Map<String, Object> paramMap);

    List<Map<String, Object>> listDetDuaDocHistorico(Map<String, Object> paramMap);

    List<Map<String, Object>> listCabDetDocHistorico(Map<String, Object> paramMap);

    List<Map<String, Object>> listArchivosDua(Map<String, Object> paramMap);
}
