//sidney tsui
//comments: this is just to get started, may need changing and adding 
package com.example.csc331accountingapp;

public class Account{
  //assign private instance variables
  private String username; 
  private String password;
  private int userID; 

    //error handling, if user doesn't provide input for either username or password
  public Account(String username, String password, int userID) thows exception{
    if ((username == null || username.isEmpty()) | (password == null || password.isEmpty())) {
      throw new IllegalArgumentException("invalid input")}
    this.username = username;
    this.password = password;
    this.userID = userID;
}
  //accessors
  public String getUsername(){
    return username;}
  public String getPassword(){
    return password;}
  public int getUserID(){
    return userID;}
  //mutators
  public void setUsername(String username){
    this.username = username;}
  public void setPassword(String password){
    this.password = password;}
  public void setUserID(int userID){
    this.userID = userID;}
