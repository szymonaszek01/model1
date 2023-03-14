package com.oro.model1.service;

import com.oro.model1.entity.UserProfile;
import com.oro.model1.exception.UserProfileNotFoundException;
import com.oro.model1.repository.UserProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserProfileService {

    private UserProfileRepository userProfileRepository;

    public UserProfile getUserProfileById(long id) {
        return userProfileRepository.findById(id).orElseThrow(() -> new UserProfileNotFoundException("User profile not found"));
    }

    public UserProfile getUserProfileByEmail(String email) {
        return userProfileRepository.findUserProfileByEmail(email).orElseThrow(() -> new UserProfileNotFoundException("User profile not found"));
    }
}
