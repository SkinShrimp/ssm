package cn.wolfcode.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseDomain {
    private String name;

    private String sn;

    private List<Permission> permissonList;

}