package com.example.exercicio13.repositories;

import com.example.exercicio13.models.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JogadorRepository extends JpaRepository<Jogador, UUID> {
}
