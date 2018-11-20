package cn.wolfcode.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseDomain {
    private String name;

    private String password;

    private String email;

    private Integer age;

    private boolean admin;

    private Department department;

    private List<Role> list;

}