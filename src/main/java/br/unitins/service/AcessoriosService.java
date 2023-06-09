package br.unitins.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import br.unitins.model.Acessorios;
import br.unitins.repository.AcessoriosRepository;

@Named
@ApplicationScoped
public class AcessoriosService {

    @Inject
    private AcessoriosRepository repository;

    public void create(Acessorios acessorios) {
        repository.create(acessorios);
    }

    public Acessorios findById(Long id) {
        return repository.findById(id);
    }

    public void update(Acessorios acessorios) {
        repository.update(acessorios);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public List<Acessorios> findAll() {
        return repository.findAll();
    }

}
