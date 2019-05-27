package com.travel.utils;

import com.travel.models.Role;
import com.travel.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.jsp.tagext.SimpleTag;

public interface ArrayUtils extends SimpleTag {
    public static boolean containsRole(Set<Role> roles, String roleName) {
        boolean containsRole = false;

        for (Role role: roles) {
            if (role.getName().equals(roleName)) {
                containsRole = true;
            }
        }

        return containsRole;
    }

    public static List<User> filterSelfUser(Set<User> users, User comparer) {
        List<User> result = new ArrayList<>();

        for (User user: users) {
            if (user.getId() != comparer.getId()) {
                result.add(user);
            }
        }

        return result;
    }
}