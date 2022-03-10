package com.demo.security.service.impl;

import com.demo.security.domain.entity.JwtUser;
import com.demo.security.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Auther guozhiyang
 * @Date 2022-03-10 14:28
 */
@Slf4j
@Service(value = "userDetailsService")
public class UserDetailsServiceImpl  implements UserDetailsService {

    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JwtUser jwtUser = new JwtUser();
        jwtUser.setUsername("xiaohua");
        jwtUser.setPassword(bCryptPasswordEncoder.encode("123456"));
        jwtUser.setRole("ROLE_admins");
        jwtUser.setEnabled(true);
        jwtUser.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList("admins,ROLE_sale"));
        jwtUser.setAccountNonExpired(true);
        jwtUser.setAccountNonLocked(true);
        jwtUser.setCredentialsNonExpired(true);
        return jwtUser;
    }
}

