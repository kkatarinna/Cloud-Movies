package com.example.cloudcomputing.springdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/film")
public class FilmController {

    @Autowired
    private FilmRepository filmRepository;

    @GetMapping
    public ResponseEntity<List<Film>> getFilms() {
        return ResponseEntity.ok(filmRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilm(@PathVariable Long id) {
        Film film = filmRepository.findById(id).orElse(null);
        if (film == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(film);
    }

    @PostMapping
    public ResponseEntity<Film> addFilm(@RequestBody Film film) {
        film = filmRepository.save(film);
        return ResponseEntity.ok(film);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Film> updatefilm(@PathVariable Long id, @RequestBody Film film) {
        Film storedfilm = filmRepository.findById(id).orElse(null);
        if (storedfilm == null) {
            return ResponseEntity.notFound().build();
        }
        film.setId(storedfilm.getId());
        filmRepository.save(film);
        return ResponseEntity.ok(film);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removefilm(@PathVariable Long id) {
        Film film = filmRepository.findById(id).orElse(null);
        if (film == null) {
            return ResponseEntity.notFound().build();
        }
        filmRepository.delete(film);
        return ResponseEntity.noContent().build();
    }
}
