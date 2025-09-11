package com.example.notification_managment_Service.Service.ServiceImp;

import com.example.notification_managment_Service.Config.LogsServiceProperties;
import com.example.notification_managment_Service.Model.User;
import com.example.notification_managment_Service.Service.UserService;
import com.example.notification_managment_Service.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final LogsServiceProperties logsProperties;


    public UserServiceImpl(UserRepository userRepository, LogsServiceProperties logsProperties) {
        this.userRepository = userRepository;
        this.logsProperties = logsProperties;
    }


    public String returnName(String name) {
        try {
            int delay = ThreadLocalRandom.current().nextInt(2000, 5000) ;
            logger.info("Dormindo por {} s antes de retornar o nome", delay/1000);
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.info("Sleep interrompido", e);
        }

        logger.info("Retornando nome: {}", name);
        return name;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
