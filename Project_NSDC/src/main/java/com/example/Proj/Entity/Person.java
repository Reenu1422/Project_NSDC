package com.example.Proj.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Table(name="Person_Tbl")

public class Person {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int id;
	@Email(message="Invalid email correct format is abc@gmail.com")
	private String email;
	@Pattern(regexp="^\\d{10}$",message="Mobile have 10 digit")
	private String mobile;
	@NotBlank(message="Field should not blank")
	private String gender;
	@Min(10)
	@Max(90)
	private int age;
	@NotNull(message="users name should not be null")
	private String name;
	@OneToMany(targetEntity=Movie.class,cascade=CascadeType.ALL)
	@JoinColumn(name="pm_fk",referencedColumnName="id")
	private List<Movie>movies;
}
