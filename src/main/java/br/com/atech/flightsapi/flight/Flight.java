package br.com.atech.flightsapi.flight;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.atech.flightsapi.aircraft.Aircraft;
import br.com.atech.flightsapi.pilot.Pilot;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Flight implements Serializable {

	private static final long serialVersionUID = -8111171834005695974L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	@Enumerated(EnumType.STRING)
	private Status status;

	@NonNull
    @Column(name = "departure_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureDate;

    @NonNull
    @Column(name = "arrival_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalDate;

    @NonNull
    @JoinColumn(name = "aircraft")
    @ManyToOne
    private Aircraft aircraft;

    @NonNull
    @JoinColumn(name = "pilot")
    @ManyToOne
    private Pilot pilot;
    
    @NonNull
    @Column(name = "departure_airport")
    private String departureAirport;

    @NonNull
    @Column(name = "arrival_airport")
    private String arrivalAirport;
	
}
