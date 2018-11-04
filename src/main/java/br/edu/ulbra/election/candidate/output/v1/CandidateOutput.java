package br.edu.ulbra.election.candidate.output.v1;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Candidate.java Output Information")
public class CandidateOutput {

    @ApiModelProperty(example = "1", notes = "Candidate.java Unique Identification")
    private Long id;
    @ApiModelProperty(example = "John Doe", notes = "Candidate.java name")
    private String name;
    @ApiModelProperty(example = "77654", notes = "Candidate.java Election Number")
    private Long numberElection;
    @ApiModelProperty(notes = "Candidate.java Election Data")
    private ElectionOutput electionOutput;
    @ApiModelProperty(notes = "Candidate.java Party Data")
    private PartyOutput partyOutput;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumberElection() {
        return numberElection;
    }

    public void setNumberElection(Long numberElection) {
        this.numberElection = numberElection;
    }

    public ElectionOutput getElectionOutput() {
        return electionOutput;
    }

    public void setElectionOutput(ElectionOutput electionOutput) {
        this.electionOutput = electionOutput;
    }

    public PartyOutput getPartyOutput() {
        return partyOutput;
    }

    public void setPartyOutput(PartyOutput partyOutput) {
        this.partyOutput = partyOutput;
    }
}
