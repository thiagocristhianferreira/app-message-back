package com.appmessage.AppMessage.App.Repository;

import com.appmessage.AppMessage.App.DTO.ProdutoDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoDTO, Integer> {}
