package com.sysvent.clientui.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/")

    public String accueil(Model model)
    {

        return "Accueil";

    }
}
