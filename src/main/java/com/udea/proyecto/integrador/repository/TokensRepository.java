package com.udea.proyecto.integrador.repository;

import com.udea.proyecto.integrador.Entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokensRepository extends JpaRepository<Token, Long> {
    Token findByWalletAddress(String address);
}
