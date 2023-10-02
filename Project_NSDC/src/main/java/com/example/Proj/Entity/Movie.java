package com.example.Proj.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Movie_Tbl")

public class Movie {
	
	@Id
	@GeneratedValue
	private int mid;
	@NotNull(message="movies name should not be null")
	private String name;
	@Pattern(regexp="^\\d{2}-\\d{2}-\\d{4}$",message="The expected format should be: dd-mm-yyyy")
	private String releaseDate;
	@NotBlank(message="Field should not blank")
	private String genres;
	private long runtime_minutes;
}
