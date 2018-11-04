package br.edu.ulbra.election.candidate.model;

import javax.persistence.*;

@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, name = "number")
    private Integer numberElection;

    @Column(nullable = false, name = "election_id")
    private Integer electionId;

    @Column(nullable = false, name = "party_id")
    private Integer partyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberElection() {
        return numberElection;
    }

    public void setNumberElection(Integer numberElection) {
        this.numberElection = numberElection;
    }

    public Integer getElectionId() {
        return electionId;
    }

    public void setElectionId(Integer electionId) {
        this.electionId = electionId;
    }

    public Integer getPartyId() {
        return partyId;
    }

    public void setPartyId(Integer partyId) {
        this.partyId = partyId;
    }
}
