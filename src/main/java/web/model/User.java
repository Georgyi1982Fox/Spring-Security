package web.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;


    @Transient
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;


    public User(){}

    public User(Long id, String name, String password, String email){
        this.id = id;
        this.userName = name;
        this.password = password;
        this.email = email;
    }

    public User(String name, String password, String email){
        this.userName = name;
        this.password = password;
        this.email = email;
    }

    public User(Long id, String name, String email){
        this.id = id;
        this.userName = name;
        this.email = email;

    }

    public User(String name, String email){
        this.userName = name;
        this.email = email;
    }



    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.userName = username;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
         return getRoles();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {

        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public Long getId(){
        return id;
    }







/*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;



    public User(){}

    public User(Long id, String name, String password, String email){
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public User(String name, String password, String email){
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public User(Long id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;

    }

    public User(String name, String email){
        this.name = name;
        this.email = email;
    }

    public Long getId(){
        return id;
    }


    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    private boolean enabled;

 */

}












