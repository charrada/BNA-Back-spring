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
        Account registeredAccount = accountService.registerAccount(account);

        if (registeredAccount != null) {
            return ResponseEntity.ok("Account registered successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register account.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Account account) {
        boolean authenticated = accountService.authenticateAccount(account.getUsername(), account.getPassword());

        if (authenticated) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password.");
        }
    }
}
