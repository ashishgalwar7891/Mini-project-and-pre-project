package com.example_PE.Login_App.ToKen;

import com.example_PE.Login_App.domain.LoginData;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator {
    @Override
    public Map<String, String> generateToken(LoginData user) {
        // generate JWT user algo, userdata, issued time, expiration time, secret key...
        Map<String,String> result = new HashMap<String,String>();
       user.setPassword("");

        Map<String,Object> userdata = new HashMap<>();

        userdata.put("user_email",user.getEmail_Id());
        String jwt = Jwts.builder()
                .setClaims(userdata)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, "mysecretkey")
                .compact();

        result.put("token",jwt);
        result.put("email",user.getEmail_Id());
        result.put("message","User login success");
        System.out.println(result);
        return result;
    }
}
