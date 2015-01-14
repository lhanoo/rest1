package com.gerrydevstory.rest1.login;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gerrydevstory.rest1.SecurityConfig;

@RestController
@RequestMapping("/login")
public class LoginController {

  @Autowired
  private SecurityConfig securityConfig;
  
  private AuthenticationDetailsSource<HttpServletRequest,?> authenticationDetailsSource = new WebAuthenticationDetailsSource();
  
  private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
  
  @RequestMapping(method = RequestMethod.POST)
  public String login(@RequestParam("u") String username,
    @RequestParam("p") String password,
    HttpServletRequest req) throws Exception {
    
    // Force session creation so it's available to Spring Security post processor filter
    req.getSession(true);
    
    // Authenticate using AuthenticationManager configured on SecurityContext
    AuthenticationManager authMgr = securityConfig.authenticationManagerBean();
    UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(username, password);
    authReq.setDetails(authenticationDetailsSource.buildDetails(req));
    Authentication authResp = authMgr.authenticate(authReq);
    
    // If successful add the authentication response to context so the post processor filter
    // can save it to session
    SecurityContextHolder.getContext().setAuthentication(authResp);
    
    return "Authentication successful";
  }
  
  @ExceptionHandler(BadCredentialsException.class)
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  public String badCredentialsExceptionHandler(BadCredentialsException e) {
    LOG.debug("Authentication failed", e);
    return "Authentication failed: " + e.getMessage();
  }
  
  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public String exceptionHandler(Exception e) {
    LOG.debug("Authentication error", e);
    return "Authentication error: " + e.getMessage();
  }
}
