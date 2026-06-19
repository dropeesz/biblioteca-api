package com.biblioteca.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.springframework.web.bind.annotation.*;

import com.biblioteca.model.Livro;

@RestController
@RequestMapping("/livros")
@CrossOrigin("*")
public class LivroController {

    private List<Livro> livros = new ArrayList<>();

    private Map<Long, Queue<String>> filaEspera =
            new HashMap<>();

    private Long contador = 1L;

    @GetMapping
    public List<Livro> listar() {
        return livros;
    }

    @PostMapping
    public Livro cadastrar(@RequestBody Livro livro) {

        livro.setId(contador++);
        livro.setDisponivel(true);
        livro.setEmprestadoPara(null);

        livros.add(livro);

        return livro;
    }

    @PutMapping("/emprestar/{id}")
    public String emprestar(
            @PathVariable Long id,
            @RequestParam String usuario) {

        System.out.println("EMPRESTAR CHAMADO -> ID: " + id + " | Usuário: " + usuario);

        for (Livro livro : livros) {

            System.out.println("Verificando livro: " + livro.getTitulo());

            if (livro.getId().equals(id)) {

                System.out.println("Livro encontrado!");

                if (livro.isDisponivel()) {

                    livro.setDisponivel(false);
                    livro.setEmprestadoPara(usuario);

                    System.out.println("Livro emprestado para: " + usuario);

                    return usuario +
                            " pegou o livro " +
                            livro.getTitulo();
                }

                filaEspera.putIfAbsent(
                        id,
                        new LinkedList<>());

                filaEspera.get(id).add(usuario);

                System.out.println(usuario + " entrou na fila de espera");

                return usuario +
                        " entrou na fila de espera.";
            }
        }

        System.out.println("Livro não encontrado!");

        return "Livro não encontrado";
    }

    @PutMapping("/devolver/{id}")
    public String devolver(
            @PathVariable Long id) {

        for (Livro livro : livros) {

            if (livro.getId().equals(id)) {

                Queue<String> fila =
                        filaEspera.get(id);

                if (fila != null &&
                        !fila.isEmpty()) {

                    String proximo =
                            fila.poll();

                    livro.setEmprestadoPara(
                            proximo);

                    livro.setDisponivel(false);

                    return "Livro entregue automaticamente para "
                            + proximo;
                }

                livro.setDisponivel(true);
                livro.setEmprestadoPara(null);

                return "Livro devolvido e disponível";
            }
        }

        return "Livro não encontrado";
    }

    @DeleteMapping("/{id}")
    public String excluir(
            @PathVariable Long id) {

        livros.removeIf(
                livro -> livro.getId().equals(id));

        filaEspera.remove(id);

        return "Livro removido";
    }

    @GetMapping("/fila/{id}")
    public Queue<String> fila(
            @PathVariable Long id) {

        return filaEspera.getOrDefault(
                id,
                new LinkedList<>());
    }
}