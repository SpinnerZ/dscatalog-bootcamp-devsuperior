package com.devsuperior.dscatalog.services;

import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Informa que controla a injeção de dependências
@Service
public class CategoryService {

    //Injeta uma dependência pelo Spring
    @Autowired
    private CategoryRepository repository;

    //Controla as transações do banco de dados, abrindo e fechando as conexões automaticamente.
    // Torna a aplicação mais simples, fácil e eficiente.
    //O readOnly é para ganho de performance e evita perda de informação em caso de erro, pois não marca o bd para escrita.
    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return repository.findAll();
    }
}
