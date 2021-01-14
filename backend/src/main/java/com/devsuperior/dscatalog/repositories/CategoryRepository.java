package com.devsuperior.dscatalog.repositories;

import com.devsuperior.dscatalog.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Marca com componente injetável pelo gerenciador de dependências do Spring
//Esses objetos passam a serem gerenciados pelo Spring
@Repository
//JpaRepository precisa do tipo do objeto e do tipo do seu identificador
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
