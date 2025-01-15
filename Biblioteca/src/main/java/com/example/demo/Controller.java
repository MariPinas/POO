package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controller {

    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Periodico> periodicos = new ArrayList<>();
    private List<UsuarioAluno> usuariosAlunos = new ArrayList<>();
    private List<UsuarioProfessor> usuariosProfessores = new ArrayList<>();

    // LIVRO CRUD

    @PostMapping("/livros")
    public ResponseEntity<Livro> criarLivro(@RequestBody Livro livro) {
        livros.add(livro);
        return new ResponseEntity<>(livro, HttpStatus.CREATED);
    }

    @GetMapping("/livros")
    public ResponseEntity<List<Livro>> listarLivros() {
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @GetMapping("/livros/{id}")
    public ResponseEntity<Livro> buscarLivro(@PathVariable int id) {
        Optional<Livro> livro = livros.stream().filter(l -> l.getId() == id).findFirst();
        return livro.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/livros/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable int id, @RequestBody Livro livroAtualizado) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getId() == id) {
                livros.set(i, livroAtualizado);
                return new ResponseEntity<>(livroAtualizado, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/livros/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable int id) {
        boolean removed = livros.removeIf(l -> l.getId() == id);
        return removed ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Empréstimos

    @PostMapping("/livros/{id}/emprestar")
    public ResponseEntity<String> emprestarLivro(@PathVariable int id, @RequestParam int usuarioId) {
        Optional<Livro> livroOpt = livros.stream().filter(l -> l.getId() == id).findFirst();
        Optional<Usuario> usuarioOpt = usuarios.stream().filter(u -> u.getId() == usuarioId).findFirst();

        if (livroOpt.isEmpty() || usuarioOpt.isEmpty()) {
            return new ResponseEntity<>("Livro ou Usuário não encontrado.", HttpStatus.NOT_FOUND);
        }

        Livro livro = livroOpt.get();
        Usuario usuario = usuarioOpt.get();

        if (livro.isEmprestado()) {
            return new ResponseEntity<>("Livro já está emprestado.", HttpStatus.BAD_REQUEST);
        }

        if (usuario.getLivrosEmprestados().size() >= usuario.getLimiteEmprestimos()) {
            return new ResponseEntity<>("Usuário atingiu o limite de empréstimos.", HttpStatus.BAD_REQUEST);
        }

        livro.setEmprestado(true);
        livro.setDataEmprestimo(LocalDate.now());
        livro.setDataDevolucaoPrevista(LocalDate.now().plusDays(usuario.getPrazoEmprestimoDias()));
        livro.setUsuarioEmprestimo(usuario);
        usuario.getLivrosEmprestados().add(livro);

        return new ResponseEntity<>("Livro emprestado com sucesso.", HttpStatus.OK);
    }

    @PostMapping("/livros/{id}/devolver")
    public ResponseEntity<String> devolverLivro(@PathVariable int id) {
        Optional<Livro> livroOpt = livros.stream().filter(l -> l.getId() == id).findFirst();

        if (livroOpt.isEmpty()) {
            return new ResponseEntity<>("Livro não encontrado.", HttpStatus.NOT_FOUND);
        }

        Livro livro = livroOpt.get();

        if (!livro.isEmprestado()) {
            return new ResponseEntity<>("Livro não está emprestado.", HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = livro.getUsuarioEmprestimo();
        usuario.getLivrosEmprestados().remove(livro);
        livro.setEmprestado(false);
        livro.setUsuarioEmprestimo(null); // vei eu acho q fiz/tofazendo errado se ja tem as funcao la nas classe n precisa dessas
        livro.setDataEmprestimo(null);
        livro.setDataDevolucaoPrevista(null);

        return new ResponseEntity<>("Livro devolvido com sucesso.", HttpStatus.OK);
    }

    // BLOQUEIO

    @PostMapping("/livros/{id}/bloquear")
    public ResponseEntity<String> bloquearLivro(@PathVariable int id, @RequestParam int professorId) {
        Optional<Livro> livroOpt = livros.stream().filter(l -> l.getId() == id).findFirst();
        Optional<UsuarioProfessor> professorOpt = usuariosProfessores.stream().filter(up -> up.getId() == professorId).findFirst();

        if (livroOpt.isEmpty() || professorOpt.isEmpty()) {
            return new ResponseEntity<>("Livro ou Professor não encontrado.", HttpStatus.NOT_FOUND);
        }

        Livro livro = livroOpt.get();
        UsuarioProfessor professor = professorOpt.get();

        livro.setBloqueado(true);
        livro.setUsuarioBloqueio(professor);
        livro.setDataBloqueio(LocalDate.now());
        livro.setDataDesbloqueio(LocalDate.now().plusDays(20));

        return new ResponseEntity<>("Livro bloqueado com sucesso.", HttpStatus.OK);
    }

    @PostMapping("/livros/{id}/desbloquear")
    public ResponseEntity<String> desbloquearLivro(@PathVariable int id) {
        Optional<Livro> livroOpt = livros.stream().filter(l -> l.getId() == id).findFirst();

        if (livroOpt.isEmpty()) {
            return new ResponseEntity<>("Livro não encontrado.", HttpStatus.NOT_FOUND);
        }

        Livro livro = livroOpt.get();

        if (!livro.isBloqueado()) {
            return new ResponseEntity<>("Livro não está bloqueado.", HttpStatus.BAD_REQUEST);
        }

        livro.setBloqueado(false);
        livro.setUsuarioBloqueio(null);
        livro.setDataBloqueio(null);
        livro.setDataDesbloqueio(null);

        return new ResponseEntity<>("Livro desbloqueado com sucesso.", HttpStatus.OK);
    }
}
