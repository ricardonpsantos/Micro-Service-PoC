package com.example.notification_managment_Service.Controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;

@RestController
@RequestMapping("/log")
public class TestLogController {

    private static final Logger logger = LoggerFactory.getLogger(TestLogController.class);

    @GetMapping("/log-test")
    public String testLog() {
        //logger.debug("Debug: endpoint /log-test chamado");
        logger.info("Info: endpoint /log-test chamado");
        //logger.warn("Warn: exemplo de aviso");
        //logger.error("Error: exemplo de erro");
        return "Logs enviados! Confere no console";
    }


}

