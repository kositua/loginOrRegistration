/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.koss.dao;

import ua.com.koss.entity.Users;


/**
 *
 * @author koss
 */
public interface UserDao {
    Users getUser(String name);
    void adduser(String name, String password, String email);
    Users isExist(String name, String password);
}
