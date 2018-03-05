
package com.yingying.searchapp;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author KimBrian
 */
public class UserProfile extends Profile {

    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
    private String securityQuestion;
    private String securityAnswer;
    private String type;
    public ratingPost[] ratingHistory;
    public int ratingPostCount = 0;

    private String accountType = "User";
    private HashMap<String, String> hm = new HashMap<>();

    //TableData.TableInfo.USER_NAME+ " TEXT," + TableData.TableInfo.USER_PASS + " TEXT," + TableData.TableInfo.USER_LAST_NAME+ " TEXT,"
 //   +TableData.TableInfo.USER_FIRST_NAME +" TEXT," + TableData.TableInfo.USER_EMAIL + " TEXT," + TableData.TableInfo.USER_SECURITY_QUESTION+ " TEXT,"
  //          +TableData.TableInfo.USER_SECURITY_ANSWER+ " TEXT," +TableData.TableInfo.USER_TYPE+ " TEXT);" ;
    public UserProfile(String un, String p, String fn, String ln, String e, String sq, String sa, String u){
        super(un,p,fn,ln,e,sq,sa,"User");
    }

    public String getAccountType() {
        return accountType;
    }

    public String signUp(String fn, String ln, String e, String u, String p) {
        String accepted = "Sign up finished";
        boolean b = false;
        boolean userExists = hm.containsKey(u);
        do {
            if (userExists == true) {
                System.out.println("User already exists");
                b = false;
            } else {
                super.setFirstname(fn);
                super.setLastname(ln);
                super.setEmail(e);
                super.setPassword(p);
                super.setUsername(u);
                hm.put(super.getUsername(), super.getPassword());
                b = true;
            }
        } while (b = false);
        return accepted;
    }

    public String logIn(String u, String p) {
        String accepted = "Logged In";
        boolean b = false;
        boolean userExists = hm.containsKey(u);
        do {
            if (userExists == true) {
                String passwordCheck = hm.get(u);
                if (passwordCheck.equals(p)) {
                    b = true;
                    return accepted;
                } else {
                    b = false;
                    System.out.println("Log in failed");
                }
            }
        } while (b = false);
        return accepted;
    }
    public boolean getHashMap (){
        if (hm.isEmpty()) {
            return false;
        }
        else return true;
    }
}
