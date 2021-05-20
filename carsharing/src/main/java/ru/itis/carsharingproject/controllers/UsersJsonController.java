package ru.itis.carsharingproject.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.carsharingproject.dto.UserDto;
import ru.itis.carsharingproject.services.UsersService;
import ru.itis.carsharingproject.validation.ValidAge;

import java.util.List;

@RestController
public class UsersJsonController {

    @Autowired
    private UsersService usersService;

    @ApiOperation(value = "Выдает всех пользователей")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Успешно", response = UserDto.class)})
    @GetMapping("/users/json")
    public ResponseEntity<List<UserDto>> getJsonUsers() {
        return ResponseEntity.ok(usersService.getAllUsers());
    }

    @PostMapping("/users/json")
    public ResponseEntity<UserDto> addTeacher(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(usersService.addUser(userDto));
    }

    @PutMapping("/users/json/{user-id}")
    public ResponseEntity<UserDto> updateTeacher(@PathVariable("user-id") Long id, @RequestBody UserDto userDto) {
        return ResponseEntity.ok(usersService.updateUser(id, userDto));
    }

    @DeleteMapping("users/json/{user-id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable("user-id") Long id) {
        usersService.deleteUser(id);
        return ResponseEntity.ok().build();
    }


}
