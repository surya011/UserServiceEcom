package dev.surya.userservice.models;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class User extends BaseModel {
    private String email;
    private String password;
    @ManyToOne
    private Set<Role> roles = new HashSet<>();

}
