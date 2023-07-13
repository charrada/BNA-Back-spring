package bna.projet.Services;

import bna.projet.entities.Account;
import bna.projet.entities.Operation;

import java.util.List;

public interface IAccountService {
    Account registerAccount(Account account);
    boolean authenticateAccount(String username, String password);
    boolean login(String username, String password);
    String encryptPassword(String password);

}
