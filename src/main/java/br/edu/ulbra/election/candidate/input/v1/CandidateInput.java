package br.edu.ulbra.election.candidate.input.v1;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Candidate.java Input Information")
public class CandidateInput {

    @ApiModelProperty(example = "John Doe", notes = "Candidate.java name")
    private String name;
    @ApiModelProperty(example = "1", notes = "Candidate.java Party ID")
    private int partyId;
    @ApiModelProperty(example = "97654", notes = "Candidate.java Election Number")
    private int numberElection;
    @ApiModelProperty(example = "3", notes = "Candidate.java Election Id")
    private int electionId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    public int getNumberElection() {
        return numberElection;
    }

    public void setNumberElection(int numberElection) {
        this.numberElection = numberElection;
    }

    public int getElectionId() {
        return electionId;
    }

    public void setElectionId(int electionId) {
        this.electionId = electionId;
    }
}
