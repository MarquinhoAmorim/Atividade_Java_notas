package br.com.fatecararas.devnotes.model.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatecararas.devnotes.model.entities.Categoria;
import br.com.fatecararas.devnotes.model.entities.Nota;
import br.com.fatecararas.devnotes.model.repositories.NotaRepository;

@Service
public class NotaService {
    
    @Autowired
    private NotaRepository repository;

    public List<Nota> findAll() {
        return repository.findAll();
    }

    public void salvar(Nota nota) {
        repository.save(nota);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public Nota buscarPorId(Long id) throws Exception{
        Optional<Nota> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new Exception("Nota não localizada. ID: " + id);
        }

        return optional.get();
    }

    public void atualizar(Nota nota) throws Exception {
        Nota c = buscarPorId(nota.getId());
        salvar(c);
    }
}
