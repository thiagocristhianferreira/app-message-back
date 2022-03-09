package com.appmessage.AppMessage.App.Controller;

import com.appmessage.AppMessage.App.DTO.StatusDTO;
import com.appmessage.AppMessage.App.DTO.UserRegistrationDTO;
import com.appmessage.AppMessage.App.DTO.UserResponserDTO;
import com.appmessage.AppMessage.App.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@AllArgsConstructor
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    public UserRepository repository;

    @GetMapping("/{userID}")
    public Optional<UserRegistrationDTO> consultar(@PathVariable("userID") Long userID) {
        return repository.findById(userID);
    }

    @GetMapping
    public Stream<Object> consultarTodos() {
        return repository.findAll().stream().map(user -> {
            UserResponserDTO userRes = new UserResponserDTO();
            userRes.setId(user.getId());
            userRes.setNome(user.getNome());
            userRes.setEmail(user.getNome());
            return userRes;
        });
    }

    @PostMapping("/cadastrar")
    public Object salvar(@RequestBody UserRegistrationDTO user) {
        try {
            repository.save(user);
            UserResponserDTO userRes = new UserResponserDTO();
            userRes.setId(user.getId());
            userRes.setNome(user.getNome());
            userRes.setEmail(user.getNome());
            return userRes;
        } catch (Exception e) {
            e.printStackTrace();
            StatusDTO status = new StatusDTO();
            status.setStatusCode("400");
            status.setStatusMessage("Bad Request");
            return status;
        }
    }

    @PutMapping("/editar/{userID}")
    public Object editar(@PathVariable("userID") Long userID, @RequestBody UserRegistrationDTO user) {
        try {
            user.setId(userID);
            repository.save(user);
            UserResponserDTO userRes = new UserResponserDTO();
            userRes.setId(user.getId());
            userRes.setNome(user.getNome());
            userRes.setEmail(user.getNome());
            return userRes;
        } catch (Exception e) {
            e.printStackTrace();
            StatusDTO status = new StatusDTO();
            status.setStatusCode("400");
            status.setStatusMessage("Bad Request");
            return status;
        }
    }

    @DeleteMapping("/deletar/{userID}")
    public StatusDTO deletar(@PathVariable("userID") Long userID) {
        try {
            repository.deleteById(userID);
            StatusDTO status = new StatusDTO();
            status.setStatusCode("200");
            status.setStatusMessage("OK: Usuário deletado com sucesso");
            return status;
        } catch (Exception e) {
            e.printStackTrace();
            StatusDTO status = new StatusDTO();
            status.setStatusCode("400");
            status.setStatusMessage("Bad Request");
            return status;
        }
    }

}
