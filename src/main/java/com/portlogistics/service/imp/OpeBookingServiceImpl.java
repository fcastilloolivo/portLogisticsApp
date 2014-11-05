package com.portlogistics.service.imp;

import com.portlogistics.model.dao.OpeBookingMapper;
import com.portlogistics.service.itz.OpeBookingService;
import com.portlogistics.util.Constante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cvfrans on 2/11/14.
 */
@Service
public class OpeBookingServiceImpl implements OpeBookingService {

    @Autowired
    private OpeBookingMapper opeBookingMapper;

    @Override
    public List<Map<String, Object>> listarBookingDua(String valor, String indicador, String pagina) {



        Map<String, Object> param = new HashMap<String, Object>();

        String[] vBusqueda = indicador.split(",");
        for (String strFil : vBusqueda) {
            if (strFil.equals(Constante.IND_BOOKING)){ param.put("numBooking",valor); }
            if (strFil.equals(Constante.IND_DUA)){ param.put("numDua",valor); }
            if (strFil.equals(Constante.IND_SERVICIO)){ param.put("numSlp",valor); }
            if (strFil.equals(Constante.IND_DOCE_MESES)){
                param.put("numDoce",12);
                param.remove("numSeis");
                param.remove("numTres");
            }
            if (strFil.equals(Constante.IND_SEIS_MESES)){
                param.put("numSeis",6);
                param.remove("numTres");
            }
            if (strFil.equals(Constante.IND_TRES_MESES)){ param.put("numTres",3); }
        }
            param.put("pagina",pagina);

        return opeBookingMapper.listBookingDua(param);
    }
}
