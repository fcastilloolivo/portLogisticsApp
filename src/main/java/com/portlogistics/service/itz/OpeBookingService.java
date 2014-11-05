package com.portlogistics.service.itz;

import java.util.List;
import java.util.Map;

/**
 * Created by cvfrans on 2/11/14.
 */
public interface OpeBookingService {

    public List<Map<String,Object>> listarBookingDua(String valor, String indicador, String pagina);

}
