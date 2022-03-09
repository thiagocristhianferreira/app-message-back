package com.appmessage.AppMessage.App.Controller;

import com.appmessage.AppMessage.App.DTO.StatusDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping("/api/status")
    public StatusDTO check() {
        StatusDTO res = new StatusDTO();
        res.setStatusCode("200");
        res.setStatusMessage("Servidor Online");
        return res;
    }

}
