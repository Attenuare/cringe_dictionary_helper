package br.com.fatecararas.f290_dsm_tp2_cringe_dictionary_helper.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatecararas.f290_dsm_tp2_cringe_dictionary_helper.model.Word;
import br.com.fatecararas.f290_dsm_tp2_cringe_dictionary_helper.repositories.WordRepository;

@Service
public class WordService {

    @Autowired
    private WordRepository repository;

    public void cadastration(Word word) {
        repository.save(word);
    }

    public List<Word> getAll() {
        return repository.findAll();
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Word searchAll(Integer id) {
        Optional<Word> word = repository.findById(id);
        if (word.isEmpty()) {
            throw new RuntimeException("Word not found. ID: " + id);
        }
        return word.get();
    }
}
