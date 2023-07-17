// AccountService.java
package bna.projet.Services;

import bna.projet.Repository.AccountRepository;
import bna.projet.entities.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
// AccountService.java


@Service
@Slf4j
public class AccountService implements IAccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account registerAccount(Account account) {
        if (accountRepository.existsByUsername(account.getUsername()) || accountRepository.existsByEmail(account.getEmail())) {
            return null; // Account already exists
        }

        String encryptedPassword = encryptPassword(account.getPassword());
        account.setPassword(encryptedPassword);

        return accountRepository.save(account);
    }

    @Override
    public boolean authenticateAccount(String username, String password) {
        Account account = accountRepository.findByUsername(username);

        if (account != null) {
            String encryptedPassword = encryptPassword(password);

            if (encryptedPassword != null && encryptedPassword.equals(account.getPassword())) {
                return true; // Passwords match
            } else {
                log.error("Passwords do not match. Encrypted password: {}, Stored password: {}", encryptedPassword, account.getPassword());
            }
        } else {
            log.error("Account not found for username: {}", username);
        }

        return false;
    }

    @Override
    public boolean login(String username, String password) {
        return authenticateAccount(username, password);
    }

    public String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = String.format("%02x", b);
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            log.error("Failed to encrypt password due to unsupported algorithm.");
            return null;
        }
    }

    @Override
    public boolean isEmailExists(String email) {
        return accountRepository.existsByEmail(email);

    }

    @Override

    public boolean isUsernameExists(String username) {
        return accountRepository.existsByUsername(username);

    }

    @Override

    public Account findAccountByUsername(String username) {
        return accountRepository.findByUsername(username);

    }
}
