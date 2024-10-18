package com.udea.proyecto.integrador.Controller;

import com.udea.proyecto.integrador.Entity.Token;
import com.udea.proyecto.integrador.Service.EthereumService;
import com.udea.proyecto.integrador.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/tokens")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private EthereumService ethereumService;

    @GetMapping("/blockNumber")
    public String getBlockNumber() throws IOException {
        return ethereumService.getBlockNumber();
    }

    @GetMapping
    ResponseEntity<Token> getToken() {
        return ResponseEntity.ok(new Token());
    }

    @PostMapping
    ResponseEntity<Token> saveToken() {
        return ResponseEntity.ok(new Token());
    }
}
