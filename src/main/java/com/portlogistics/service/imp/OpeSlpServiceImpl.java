package com.portlogistics.service.imp;


import com.portlogistics.bean.OpeSlp;
import com.portlogistics.model.dao.OpeSlpMapper;
import com.portlogistics.service.itz.OpeSlpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpeSlpServiceImpl implements OpeSlpService {

    @Autowired
    private OpeSlpMapper opeSlpMapper;

    @Override
    public List<OpeSlp> listaOpeSlp(Integer nroSlp) {
        return opeSlpMapper.getListOpeSlp(nroSlp);
    }
}
