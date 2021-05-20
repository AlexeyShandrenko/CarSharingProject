package ru.itis.carsharingproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.carsharingproject.dto.UserDto;
import ru.itis.carsharingproject.models.User;
import ru.itis.carsharingproject.security.details.UserDetailsImpl;
import ru.itis.carsharingproject.services.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class ProfileController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/profile")
    public String getProfilePage(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        User user1 = usersService.findUserById(user.getUser().getId()).orElseThrow(IllegalAccessError::new);
        model.addAttribute("user", user1);
        return "profile";
    }

    @PostMapping("/profile&phone")
    public String addPhone(@AuthenticationPrincipal UserDetailsImpl userDetails, UserDto userDto) {
        userDto.setId(userDetails.getUser().getId());
        usersService.addUserPhone(userDto);
        return "redirect:/profile";
    }

    @PostMapping("/profile&city")
    public String addCity(@AuthenticationPrincipal UserDetailsImpl userDetails, UserDto userDto) {
        userDto.setId(userDetails.getUser().getId());
        usersService.addUserCity(userDto);
        return "redirect:/profile";
    }

    @GetMapping("/edit_profile")
    public String getEditProfilePage() {
        return "edit_profile";
    }

    @PostMapping("/edit_profile")
    public String editProfile(@AuthenticationPrincipal UserDetailsImpl userDetails, UserDto userDto) {
        userDto.setId(userDetails.getUser().getId());
        usersService.editProfile(userDto);
        return "redirect:/profile";
    }

    @GetMapping("/edit_image")
    public String getEditImagePage() {
        return "edit_image";
    }

    @PostMapping("/edit_image")
    public String editImage(@AuthenticationPrincipal UserDetailsImpl userDetails, UserDto userDto) {
        userDto.setId(userDetails.getUser().getId());
        usersService.editImage(userDto);
        return "redirect:/profile";
    }

}
