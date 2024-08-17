package model;

public class User {
	private int code;
	private String login;
	private String password;
	private char gender;
	
	public User() {
		this.code = -1;
		this.login = "";
		this.password = "";
		this.gender = '*';
	}
	
	public User(int code, String login, String password, char gender) {
		this.codigo = codigo;
		this.login = login;
		this.senha = senha;
		this.sexo = sexo;
	}

	public int getCode) {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return Password;
	}

	public void setSenha(String password) {
		this.password = password;
	}

	public char getGender() {
		return gender;
	}

	public void getGender(char gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [code=" + code + ", login=" + login + ", password=" + password + ", gender=" + gender + "]";
	}	
}
