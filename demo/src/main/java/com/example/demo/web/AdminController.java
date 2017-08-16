package com.example.demo.web;

import com.example.demo.entity.userModel.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.*;

import java.util.List;


/**
 * Created by yang on 2017/7/26.
 */
@Controller
@RequestMapping("/admin")
//@RequiresPermissions(value ={"admin:view","admin:edit","admin:del"},logical = Logical.AND)
public class AdminController {
    @Autowired
    private UserService userSevice;

    @RequestMapping(value = "/user/all", method = RequestMethod.GET)
    public @ResponseBody
    List<UserInfo> getUserList() {
        return userSevice.findAll();
    }

    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public @ResponseBody
    UserInfo getUserByUsername(@PathVariable("username") String username) {
        System.out.print(username);
        return userSevice.findByUsername(username);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public @ResponseBody
    UserInfo getUserByUidandUsername(@RequestParam(name = "username", required = false) String username,
                                     @RequestParam(name = "uid", defaultValue = "0", required = false) Long uid) {

        return userSevice.findByUidOrUsername(uid, username);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public @ResponseBody
    Integer deleteUserByUidandUsername(@RequestParam(name = "username", required = false) String username,
                                       @RequestParam(name = "uid", defaultValue = "0", required = false) Long uid) {

        return userSevice.deleteUserByUsernameOrUid(username, uid);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public @ResponseBody
    boolean createUser(@RequestBody UserInfo userInfo) {
        try {
            userSevice.createUser(userInfo);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    @RequestMapping(value = "/userlist", method = RequestMethod.PUT)
    public @ResponseBody
    boolean createUserList(@RequestBody List<UserInfo> userInfos) {
        try {
            userSevice.createUserList(userInfos);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public @ResponseBody
    boolean updateUser(@RequestBody UserInfo userInfo) {
        try {
            userSevice.updateUser(userInfo);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @RequestMapping(value = "/user/page", method = RequestMethod.GET)
    public @ResponseBody
    Page<UserInfo> getUserByUidandUsernameInpage(@RequestParam(name = "page", defaultValue = "0") Integer
                                                         page,
                                                 @RequestParam(name = "size", defaultValue = "0") Integer size) {
        Sort sort= new Sort(Sort.Direction.ASC,"uid");
        Pageable pageable=new PageRequest(page,size,sort);
        return userSevice.findAllInPage(pageable);

    }
//@RequestMapping(value = "/user/page",method = RequestMethod.GET)
//public String createUser(HttpServletRequest request){
//    UserInfo userInfo;
//
//    userInfo.setName(request.getAttribute("name").toString());
//    userInfo.setPassword(request.getAttribute("password").toString());
//    userInfo.setState(request.getAttribute("state").toString().getBytes()[0]);
//    userInfo.setUsername(request.getAttribute("username").toString());
//    try {
//        userSevice.createUser(userInfo);
//    } catch (Exception e) {
//        return "403";
//    }
//    return "index";
//}


}
