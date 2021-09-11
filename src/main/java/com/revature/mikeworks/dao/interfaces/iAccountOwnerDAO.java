package com.revature.mikeworks.dao.interfaces;

import com.revature.mikeworks.components.AccountOwner;

import java.util.HashMap;

public interface iAccountOwnerDAO {
    void deleteAccountOwner(AccountOwner toDelete);
    HashMap<String, AccountOwner> readAccountOwners();
    void updateAccountOwner(AccountOwner updateMe);
    void writeAccountOwner(AccountOwner input);
    }
