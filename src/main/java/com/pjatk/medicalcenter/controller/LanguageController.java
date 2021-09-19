package com.pjatk.medicalcenter.controller;

import com.pjatk.medicalcenter.model.Language;
import com.pjatk.medicalcenter.service.LanguageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping
    public ResponseEntity<List<Language>> getLanguages() {
        return ResponseEntity.ok(languageService.getLanguages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Language> getLanguageById(@PathVariable long id) {
        Language language = languageService.getLanguageById(id);

        return ResponseEntity.ok(language);
    }

    @PostMapping
    public ResponseEntity<Language> addLanguage(@RequestBody Language language) {
        Language createdLanguage = languageService.addLanguage(language);

        return ResponseEntity.created(URI.create(String.format("/patients/%d", createdLanguage.getId()))).build();
    }

    @PutMapping
    public ResponseEntity<Language> updateLanguage(@RequestBody Language language) {
        Language updatedLanguage = languageService.updateLanguage(language);

        return ResponseEntity.created(URI.create(String.format("/patients/%d", updatedLanguage.getId()))).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLanguage(@PathVariable long id) {
        languageService.deleteLanguageById(id);

        return ResponseEntity.ok("Success");
    }

}
