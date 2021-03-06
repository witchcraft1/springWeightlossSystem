package com.rf.springsecurity.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
@Table( name="users",
        uniqueConstraints={@UniqueConstraint(columnNames={"login"})})
public class MyUser {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)//SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
//    @ManyToOne
    private Role roles;

    private boolean active;

   /* @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JoinColumn(name = "userInfoId", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)//!!!
    @JoinColumn(name = "info_id")//!!!

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @OneToOne(mappedBy = "user", cascade = CascadeType.PERSIST)*/
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private UserInfo userInfo;

   /* @ManyToMany
    @JoinTable(
            name = "users_dishes",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private List<Dish> dishes;*/

   @OneToMany(mappedBy = "user")
    private List<UserDish> userDishes;

   @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Dish> special_dishes;
}