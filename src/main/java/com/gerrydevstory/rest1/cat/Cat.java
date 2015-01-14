package com.gerrydevstory.rest1.cat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cat {

  @Id
  @GeneratedValue
  private long id;
  
  private String name = "";
  
  private String colour = "";

  @Override
  public String toString() {
    return "Cat [id=" + id + ", name=" + name + ", colour=" + colour + "]";
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getColour() {
    return colour;
  }

  public void setColour(String colour) {
    this.colour = colour;
  }
  
}
