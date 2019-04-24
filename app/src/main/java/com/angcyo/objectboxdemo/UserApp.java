package com.angcyo.objectboxdemo;

import io.objectbox.annotation.BaseEntity;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class UserApp {
    @Id
    public long id;
    public String name;
}