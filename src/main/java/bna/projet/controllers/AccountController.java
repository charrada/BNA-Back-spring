// AccountController.java
package bna.projet.controllers;

import bna.projet.Services.AccountService;
import bna.projet.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("account")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<String> registerAccount(@RequestBody Account account) {
        boolean isUsernameExists = accountService.isUsernameExists(account.getUsername());
        boolean isEmailExists = accountService.isEmailExists(account.getEmail());

        if (isUsernameExists) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"error\": \"Username already exists.\"}");
        }

        if (isEmailExists) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"error\": \"Email already exists.\"}");
        }

        Account registeredAccount = accountService.registerAccount(account);

        if (registeredAccount != null) {
            return ResponseEntity.ok().body("{\"message\": \"Registered successfully!\"}");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"Failed to register account.\"}");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Account account) {
        boolean authenticated = accountService.authenticateAccount(account.getUsername(), account.getPassword());

        if (authenticated) {
            return ResponseEntity.ok().body("{\"message\": \"Login successful!\"}");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"error\": \"Invalid username or password.\"}");
        }
    }


}
