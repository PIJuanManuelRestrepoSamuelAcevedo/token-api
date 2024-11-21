package com.udea.proyecto.integrador.Controller;

import com.udea.proyecto.integrador.Entity.Token;
import com.udea.proyecto.integrador.Service.EthereumService;
import com.udea.proyecto.integrador.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/balance/{address}")
    public String getUserBalance(@PathVariable String address) throws Exception {
        return tokenService.getUserBalanceFromAddress(address);
    }

    @PutMapping("/update_buyer_balance/{address}")
    public Boolean updateBuyerBalance(@PathVariable String address, @RequestParam String amount) {
        return tokenService.updateBuyerBalanceFromAddress(address, amount);
    }

    @PutMapping("/update_seller_balance/{address}")
    public Boolean updateSellerBalance(@PathVariable String address, @RequestParam String amount) {
        return tokenService.updateSellerBalanceFromAddress(address, amount);
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
