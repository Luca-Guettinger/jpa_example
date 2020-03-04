package net.myplayplanet.jpatest.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "user_test")
@Entity
@Data
public class UserTestEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(insertable = false, name = "username", nullable = false)
    private String username;

    @Column(name = "age", nullable = false)
    private Integer age;
}