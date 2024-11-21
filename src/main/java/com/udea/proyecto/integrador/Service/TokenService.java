package com.udea.proyecto.integrador.Service;

import com.udea.proyecto.integrador.Entity.Token;
import com.udea.proyecto.integrador.repository.TokensRepository;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    private final EthereumService ethereumService;
    private final TokensRepository tokensRepository;


    public TokenService(EthereumService ethereumService, TokensRepository tokensRepository) {
        this.ethereumService = ethereumService;
        this.tokensRepository = tokensRepository;
    }

    public String getUserBalanceFromAddress(String address) {
        return String.valueOf(tokensRepository.findByWalletAddress(address).getBalance());
    }

    public Boolean updateBuyerBalanceFromAddress(String address, String amount) {
        try {
            Token token = tokensRepository.findByWalletAddress(address);
            token.setBalance(token.getBalance() - Integer.valueOf(amount));
            if (token.getBalance() < 0) {
                return false;
            }
            tokensRepository.save(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean updateSellerBalanceFromAddress(String address, String amount) {
        try {
            Token token = tokensRepository.findByWalletAddress(address);
            token.setBalance(token.getBalance() + Integer.valueOf(amount));
            tokensRepository.save(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
