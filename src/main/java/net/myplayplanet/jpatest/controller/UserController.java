package net.myplayplanet.jpatest.controller;

import net.myplayplanet.jpatest.dtos.UserDto;
import net.myplayplanet.jpatest.model.UserTestEntity;
import net.myplayplanet.jpatest.repository.UserTestEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserTestEntityRepository userTestRepository;


    @GetMapping("user/get/{id}")
    public UserDto getUser(@PathVariable String id) {
        final UserTestEntity one = this.userTestRepository.getOne(id);

        final UserDto userDto = new UserDto();
        userDto.setUsername(one.getUsername());
        return userDto;
    }
}
