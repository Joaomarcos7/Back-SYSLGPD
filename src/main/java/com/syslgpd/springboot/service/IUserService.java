package com.syslgpd.springboot.service;

import com.syslgpd.springboot.model.User;

import java.util.List;

public interface IUserService {

    public User adduser(User user);
    public List<User> getallusers();
    public User getuserbyid(int id) throws Exception;

    public void deleteuserbyid(int id);

    public void updateuser(User user);


}
