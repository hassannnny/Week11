package com.example.UserDataAPI.Controller;

import ch.qos.logback.core.util.Duration;
import com.example.UserDataAPI.Entity.UserFinder;
import com.example.UserDataAPI.Entity.UserInfo;
import com.example.UserDataAPI.Filter.JwtUtil;
import com.example.UserDataAPI.Service.UserInfoService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin(origins="https://localhost:3000","https://localhost:9080")
@RestController
public class MyController {
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Value("${cookies.domain}")
    String domain;
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("name","Dijon");
        return "home";
    }
    @GetMapping("/logout")
    public ResponseEntity<?> logout(){
        ResponseCookie cookie = ResponseCookie.from("jwt","")
                .domain(domain)
                .path("/")
                .maxAge(Duration.buildByDays(0).getMilliseconds())
                .build();
        return ResponseEntity.ok()
                .header(
                        HttpHeaders.SET_COOKIE,
                        cookie.toString()
                )
                .body("logged out");
    }
    @PostMapping("/api/auth/login")
    public ResponseEntity<?> login(@RequestBody CredentialsRequest request){
        try {
            Authentication authenticate = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    request.getUsername(), request.getPassword()
                            )
                    );

            UserFinder user = (UserFinder) authenticate.getPrincipal();
            user.setPassword(null);
            String token=jwtUtil.generateToken(user);
            ResponseCookie cookie = ResponseCookie.from("jwt", token)
                    .domain(domain)
                    .path("/")
                    .maxAge(Duration.buildByDays(365).getMilliseconds())
                    .build();
            return ResponseEntity.ok()
                    .header(
                            HttpHeaders.SET_COOKIE,
                            cookie.toString()
                    )
                    .body(token);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/userService")
    public List<UserInfo> getUsers(){
        return this.userInfoService.getUsers();
    }
    @GetMapping("/userService/{id}")
    public UserInfo getUserByID(@PathVariable int id){
        return this.userInfoService.getUserByID(id);
    }

    @GetMapping("/{password}")
    public String getUsername(@PathVariable String password){
        return this.userInfoService.getUsername(password);
    }
    @GetMapping("/validate")
    public ResponseEntity<?> validateToken(@CookieValue(name="jwt") String token,
                                            @AuthenticationPrincipal UserFinder userFinder){
        try{
            Boolean tokenValidated=jwtUtil.validateToken(token,userFinder);
            return ResponseEntity.ok(tokenValidated);
        }
        catch (ExpiredJwtException e)
        {
            return ResponseEntity.ok(false);
        }
    }

    @PostMapping("/userService")
    public UserInfo addUser(@RequestBody UserInfo user){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        return this.userInfoService.addUser(user);
    }
    @PutMapping("/userService")
    public UserInfo setUser(@RequestBody UserInfo user){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        return this.userInfoService.setUser(user);
    }
    @DeleteMapping("/userService/{id}")
    public String deleteUserByID(@PathVariable int id){
        return this.userInfoService.deleteUserByID(id);
    }
}
