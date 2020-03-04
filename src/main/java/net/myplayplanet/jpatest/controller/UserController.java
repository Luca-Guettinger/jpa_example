package net.myplayplanet.jpatest.controller;

import net.myplayplanet.jpatest.dtos.UserDto;
import net.myplayplanet.jpatest.model.UserTestEntity;
import net.myplayplanet.jpatest.repository.UserTestEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
public class UserController {
    @PersistenceContext
    EntityManager entityManager;
    private UserTestEntityRepository userTestEntityRepository;

    @Autowired
    public UserController(UserTestEntityRepository userTestEntityRepository) {
        this.userTestEntityRepository = userTestEntityRepository;
    }

    @GetMapping("user/get/{id}")
    public UserDto getUser(@PathVariable String id) {
        final UserTestEntity one = this.userTestEntityRepository.getOne(id);
        System.out.println(one);
        final UserDto userDto = new UserDto();
        userDto.setUsername(one.getUsername());
        return userDto;
    }
    @Transactional
    @PostMapping("user/set/")
    public void setUser(@RequestBody UserTestEntity user) {
        System.out.println(user.getUsername());
        this.entityManager.persist(user);
    }
}
