package net.myplayplanet.jpatest.controller;

import net.myplayplanet.jpatest.dtos.UserDto;
import net.myplayplanet.jpatest.model.UserTestEntity;
import net.myplayplanet.jpatest.repository.UserTestEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;


@RestController
public class UserController {
    private UserTestEntityRepository userTestEntityRepository;
    private EntityManager entityManager;

    @Autowired
    public UserController(UserTestEntityRepository userTestEntityRepository, EntityManager entityManager) {
        this.userTestEntityRepository = userTestEntityRepository;
        this.entityManager = entityManager;
    }

    @GetMapping("user/get/{id}")
    public UserDto getUser(@PathVariable String id) {
        var userTestEntity = this.userTestEntityRepository.findById(id).orElse(null);

        if (userTestEntity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Benutzer mit der ID '" + id + "' nicht gefunden.");
        }

        return new UserDto(userTestEntity.getUsername());
    }

    @Transactional
    @PostMapping("user/set/")
    public void setUser(@RequestBody UserTestEntity user) {
        this.userTestEntityRepository.save(user);
        //this.entityManager.persist(user);
    }
}
