package com.ceti.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Entity
@Table(name = "command_reason")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class CommandReason {
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private String id;

	@NotNull
	@Column(name = "command_type")
	private String commandType;

	@NotNull
	@Column(name = "name", columnDefinition = "nvarchar")
	private String name;
}

