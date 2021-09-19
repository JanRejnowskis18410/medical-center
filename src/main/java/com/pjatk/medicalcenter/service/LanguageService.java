package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.model.Doctor;
import com.pjatk.medicalcenter.model.Language;
import com.pjatk.medicalcenter.repository.LanguageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LanguageService {

    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<Language> getLanguages() {
        return languageRepository.findAll();
    }

    public Language getLanguageById(long id) {
        return languageRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Language does not exist"));
    }

    public Language addLanguage(Language language) {
        return languageRepository.save(language);
    }

    public Language updateLanguage(Language language) {
        if (languageRepository.findById(language.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Language does not exists")) != null)
            return languageRepository.save(language);

        return null;
    }

    public void deleteLanguageById(long id) {
        Language language = languageRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Language does not exists"));

        languageRepository.delete(language);
    }
}
