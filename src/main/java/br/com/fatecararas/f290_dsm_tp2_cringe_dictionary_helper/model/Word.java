package br.com.fatecararas.f290_dsm_tp2_cringe_dictionary_helper.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "words")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100, unique = true)
    private String description;

    @Column(nullable = false)
    private String meaning;

    public Word() {
    }

    public Word(String description, String meaning) {
        this.id = null;
        this.description = description;
        this.meaning = meaning;
    }

    public Integer getId() {
        return id;
    }

    public Word setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getDescricao() {
        return description;
    }

    public void setDescricao(String word) {
        this.description = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setSignificado(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return "Word [id=" + id + ", description=" + description + ", meaning=" + meaning + "]";
    }
}
