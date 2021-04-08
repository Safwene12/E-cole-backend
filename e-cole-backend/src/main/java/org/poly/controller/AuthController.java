package org.poly.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.poly.entities.ERole;
import org.poly.entities.Role;
import org.poly.entities.User;
import org.poly.repository.RoleRepository;
import org.poly.repository.UserRepository;
import org.poly.request.LoginForm;
import org.poly.request.SignUpForm;
import org.poly.response.JwtResponse;
import org.poly.security.jwt.JwtUtils;
import org.poly.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import communication.UserResponse;





@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		/**UserResponse user = new UserResponse();
		user.setUser(userRepository.getOne(userDetails.getId()));
		user.setAccessToken(jwt);
		
		user.setRole(roles.get(0));
**/
		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 roles));
		
		
	}

	    @PostMapping("/signup")
	    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
	        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
	            return new ResponseEntity<String>("Fail -> Username is already taken!",
	                    HttpStatus.BAD_REQUEST);
	        }

	       

	        // Creating user's account
	        User user = new User(signUpRequest.getUsername(),
	                 encoder.encode(signUpRequest.getPassword()));

	        Set<String> strRoles = signUpRequest.getRole();
	        Set<Role> roles = new HashSet<>();

	       /** strRoles.forEach(role -> {
	        	switch(role) {
		    		case "admin":
		    			Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
		                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
		    			roles.add(adminRole);
		    			
		    			break;
		    		case "etudiant":
		            	Role etudiantRole = roleRepository.findByName(ERole.ROLE_ETUDIANT)
		                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
		            	roles.add(pmRole);
		            	
		    			break;
		    		default:
		        		Role userRole = roleRepository.findByName(ERole.ROLE_ENSEIGNANT)
		                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
		        		roles.add(userRole);        			
	        	}
	        });**/
	       
	        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN) ;
			roles.add(adminRole);
	        user.setRoles(roles);
	        userRepository.save(user);

	        return ResponseEntity.ok().body("User registered successfully!");
	    }
}
