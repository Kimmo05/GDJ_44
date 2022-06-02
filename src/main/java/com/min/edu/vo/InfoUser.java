package com.min.edu.vo;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class InfoUser {
	private String name;
	private String email;
	private String birth;
	private String phone;
	private String profile;
	private String milage;
	private String bank;
	private String banknum;
	private String delflag;
	private String regdate;
}
