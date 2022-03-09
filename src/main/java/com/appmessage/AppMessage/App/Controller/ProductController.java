package com.appmessage.AppMessage.App.Controller;

import com.appmessage.AppMessage.App.DTO.ProdutoDTO;
import com.appmessage.AppMessage.App.Repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/produto")
public class ProductController {

    @Autowired
    public ProdutoRepository repository;

    @GetMapping("/{userID}")
    public Optional<ProdutoDTO> consultar(@PathVariable("userID") Integer userID) {
        return repository.findById(userID);
    }

    @PostMapping("/cadastrar")
    public ProdutoDTO salvar(@RequestBody ProdutoDTO produtoDTO) {
        try {
            return repository.save(produtoDTO);

        } catch (Exception e) {
            e.printStackTrace();
            return produtoDTO;
        }
    }

}
