/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.fashion.util;

import poly.fashion.entity.Users;

public class XAuth {
    public static Users user = Users.builder()
            .username("admin")
            .password("123")
            .enabled(true)
            .manager(true)
            .fullname("Vo Thanh Danh")
            .photo("trump.png")
            .build();
}