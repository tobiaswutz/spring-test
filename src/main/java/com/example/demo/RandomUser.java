package com.example.demo;

class RandomUser {
  private int hello;
  private String world;

  public int getHello() {
    return hello;
  }

  public void setHello(int hello) {
    this.hello = hello;
  }

  public String getWorld() {
    return world;
  }

  public void setWorld(String world) {
    this.world = world;
  }

  @Override
  public String toString() {
    return "RandomUser{" +
        "hello=" + hello +
        ", world='" + world + '\'' +
        '}';
  }
}
