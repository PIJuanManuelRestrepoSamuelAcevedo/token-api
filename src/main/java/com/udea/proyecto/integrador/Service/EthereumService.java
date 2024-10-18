package com.udea.proyecto.integrador.Service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;

@Service
public class EthereumService {

    private Web3j web3j;

    @Value("${ethereum.node.url}")
    private String nodeUrl;

    @PostConstruct
    public void init() {
        web3j = Web3j.build(new HttpService(nodeUrl));
    }

    public String getBlockNumber() throws IOException {
        EthBlockNumber blockNumber = web3j.ethBlockNumber().send();
        return blockNumber.getBlockNumber().toString();
    }
}
