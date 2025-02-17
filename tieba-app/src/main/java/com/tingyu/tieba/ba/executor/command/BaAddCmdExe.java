package com.tingyu.tieba.ba.executor.command;

import com.alibaba.cola.dto.Response;
import com.tingyu.tieba.ba.converter.AppConverter;
import com.tingyu.tieba.ba.dto.command.BaAddCmd;
import com.tingyu.tieba.domain.ba.gateway.BaGateway;
import com.tingyu.tieba.domain.ba.model.BaEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaAddCmdExe{

    @Autowired
    private BaGateway baGateway;

    public Response execute(BaAddCmd cmd) {
        //The flow of usecase is defined here.
        //The core ablility should be implemented in Domain. or sink to Domian gradually
        BaEntity ba = AppConverter.toDomainEntity(cmd.getBaDTO());
        ba.setCreator("tingyu");
        ba.setModifier("tingyu");
        baGateway.create(ba);
        return Response.buildSuccess();
    }

}