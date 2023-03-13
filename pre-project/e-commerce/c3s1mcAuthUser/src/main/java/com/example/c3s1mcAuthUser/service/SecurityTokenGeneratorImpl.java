package com.example.c3s1mcAuthUser.service;

import com.example.c3s1mcAuthUser.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.sound.midi.Track;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGeneratorImpl implements SecurityTokengenerator{
    @Override
    public Map<String, String> generateToken(User user) {
        Map<String,String> result = new HashMap<String,String>();
        user.setPassword("");

        Map<String,Object> userdata = new HashMap<>();

//        userdata.put("user_role",user.getRole());
        userdata.put("user_email",user.getEmail());
        String jwt = Jwts.builder()
                .setClaims(userdata) // emailid,  role
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, "secretKeyForWave37")
                .compact();

        result.put("token",jwt);
        result.put("message","User login success");
        result.put("role",user.getEmail());
        return result;

    }

}
