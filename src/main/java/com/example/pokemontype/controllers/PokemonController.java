package com.example.pokemontype.controllers;

import com.example.pokemontype.models.Pokemon;
import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

@RestController
public class PokemonController {
    private List<Pokemon> pokemons = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("pokemons", pokemons);
        return "index";
    }

    @PostMapping("/adicionar")
    public String adicionarPokemon(@RequestParam String nome, @RequestParam String tipo) {
        Pokemon pokemon = new Pokemon();
        pokemon.setNome(nome);
        pokemon.setTipo(tipo);
        pokemons.add(pokemon);
        return "redirect:/";
    }
}