package com.example.jpasql.controller;

import com.example.jpasql.model.Account;
import com.example.jpasql.repository.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class AccountController{

    @RequestMapping("/signup")
    public String signUpForm(){
        return "signup";
    }
 /*   @RequestMapping("/login")
    public String hello() {
        return "login";
    }*/

    /**
     * GET /create  --> Create a new user and save it in the database.
     */
    @RequestMapping("/create")
    @ResponseBody
    public String create(String email, String name) {
        String userId = "";
        try {
            Account account = new Account(email, name);
            accountDao.save(account);
            userId = String.valueOf(account.getId());
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created with id = " + userId;
    }

    /**
     * GET /delete  --> Delete the user having the passed id.
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            Account account = new Account(id);
            accountDao.delete(account);
        }
        catch (Exception ex) {
            return "Error deleting the account:" + ex.toString();
        }
        return "Account succesfully deleted!";
    }

    /**
     * GET /get-by-email  --> Return the id for the user having the passed
     * email.
     */
    @RequestMapping("/get-by-id")
    @ResponseBody
    public String getById(long id) {
        String userId = "";
        try {
            Account account = accountDao.findById(id).get();
            userId = String.valueOf(account.getId());
        }
        catch (Exception ex) {
            return "Account not found";
        }
        return "The account id is: " + userId;
    }

    /**
     * GET /update  --> Update the email and the name for the user in the
     * database having the passed id.
     */
    @RequestMapping("/update")
    @ResponseBody
    public String updateUser(long id, String username, String password) {
        try {
            Account account = accountDao.findById(id).get();
            account.setUsername(username);
            account.setPassword(password);
            accountDao.save(account);
        }
        catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }

    // Private fields
    @Autowired
    private AccountDao accountDao;
}