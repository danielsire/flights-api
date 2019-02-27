package br.com.atech.flightsapi.aircraft;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode(of = "serialNumber")
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Aircraft implements Serializable {

	private static final long serialVersionUID = -2867570210212308385L;

	@Id
    @NonNull
    @Column(name = "serial_number")
    private String serialNumber;

	@NonNull
    @Column(name = "tail_number")
    private String tailNumber;
	
    @NonNull
    private String model;
	
}
