package com.oro.model1.controller;

import com.oro.model1.entity.UserProfile;
import com.oro.model1.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/user-profile/")
@RestController
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;

    @GetMapping("/{email}")
    public UserProfile getUserProfileByEmail(@PathVariable String email) {
        return userProfileService.getUserProfileByEmail(email);
    }
}
