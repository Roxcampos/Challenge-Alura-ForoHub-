package com.alura.forohub.dominios.usuarios;

public record UserDataList(Integer id,
                           String nombre,
                           String email){
    public UserDataList(Usuario user){
        this(user.getId(),user.getUsername(),user.getEmail());
    }
}
