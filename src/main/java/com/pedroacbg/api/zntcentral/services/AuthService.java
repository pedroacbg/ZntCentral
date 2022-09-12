package com.pedroacbg.api.zntcentral.services;

import com.pedroacbg.api.zntcentral.models.Post;
import com.pedroacbg.api.zntcentral.models.User;
import com.pedroacbg.api.zntcentral.respositories.UserRepository;
import com.pedroacbg.api.zntcentral.services.exceptions.ForbiddenException;
import com.pedroacbg.api.zntcentral.services.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public User authenticated(){
        try{
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            return userRepository.findByEmail(username);
        }catch(Exception e){
            throw new UnauthorizedException("Invalid user");
        }
    }

    public void validadeSelfOrAdmin(Long userId){
        User user = authenticated();
        if(!user.getId().equals(userId) && !user.hasRole("ROLE_ADMIN")){
            throw new ForbiddenException("Access denied");
        }
    }

    public void validadeUserLogged(Long userId){
        User user = authenticated();
        if(!user.getId().equals(userId)){
            throw new ForbiddenException("Access denied");
        }
    }

    public void validadeAdmin(Long userId){
        User user = authenticated();
        if(user.getId().equals(userId) && !user.hasRole("ROLE_ADMIN")){
            throw new ForbiddenException("Access denied");
        }
    }
}
