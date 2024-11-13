package br.com.fatecararas.devnotes.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatecararas.devnotes.model.services.CategoriaService;

@RestController("/api/v1/notas")
public class NotasResource {
    //TODO: Criar os métodos para o gerenciamento de Notas via REST
    
    @Autowired
    private CategoriaService service;

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable("id") Long id) {
        service.excluir(id);
    }
}
