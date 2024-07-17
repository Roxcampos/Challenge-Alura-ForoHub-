package com.alura.forohub.dominios.usuarios;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nombre;
    @Column(unique = true)
    private String email;
    private String username;
    private String password;

    public String getEmail() {
        return email;
    }
    public Usuario(DataRegister dataRegister) {
        this.nombre=dataRegister.nombre();
        this.email=dataRegister.email();
        this.username=dataRegister.username();
        this.password=dataRegister.password();
    }

    public Usuario(Long id) {
        this.id=getId();
    }


    public Usuario(DataRegister dataRegister, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.nombre=dataRegister.nombre();
        this.email=dataRegister.email();
        this.username=dataRegister.username();
        this.password= bCryptPasswordEncoder.encode(dataRegister.password());
    }

    public void updateData (UserDataUpdate userDataUpdate){
        if (userDataUpdate.nombre() != null){
            this.nombre=userDataUpdate.nombre();
        }
        if (userDataUpdate.email() != null){
            this.email=userDataUpdate.email();
        }

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }
    @Override
    public String getPassword(){
        return password;
    }
    @Override
    public String getUsername(){
        return username;
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

    public Integer getId() {
        return id;
    }
}