/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.fashion.util;

import poly.fashion.entity.User;

public class XAuth {
    public static User user = User.builder()
            .username("danh@gmail.com")
            .password("123")
            .enabled(true)
            .manager(true)
            .fullname("Võ Thành Danh")
            .photo("trump.png")
            .build();
}