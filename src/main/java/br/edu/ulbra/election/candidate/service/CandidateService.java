package br.edu.ulbra.election.candidate.service;

import br.edu.ulbra.election.candidate.client.ElectionClientService;
import br.edu.ulbra.election.candidate.client.PartyClientService;
import br.edu.ulbra.election.candidate.exception.GenericOutputException;
import br.edu.ulbra.election.candidate.input.v1.CandidateInput;
import br.edu.ulbra.election.candidate.model.Candidate;
import br.edu.ulbra.election.candidate.output.v1.CandidateOutput;
import br.edu.ulbra.election.candidate.output.v1.GenericOutput;
import br.edu.ulbra.election.candidate.repository.CandidateRepository;
import org.apache.commons.lang.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static br.edu.ulbra.election.candidate.util.ValidateCandidateInput.validateLastCandidatesName;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;
    private final ElectionClientService electionClientService;
    private final PartyClientService partyClientService;

    private final ModelMapper modelMapper;

    private static final String MESSAGE_INVALID_ID = "Invalid id";
    private static final String MESSAGE_CANDIDATE_NOT_FOUND = "Candidate not found";

    @Autowired
    public CandidateService(CandidateRepository candidateRepository, ElectionClientService electionClientService, PartyClientService partyClientService, ModelMapper modelMapper){
        this.candidateRepository = candidateRepository;
        this.electionClientService = electionClientService;
        this.partyClientService = partyClientService;
        this.modelMapper = modelMapper;

    }

    public List<CandidateOutput> getAll(){
        List<Candidate> candidateList = (List<Candidate>)candidateRepository.findAll();
        return candidateList.stream().map(Candidate::toCandidateOutput).collect(Collectors.toList());
    }



    public CandidateOutput create(CandidateInput candidateInput) {
        validateInput(candidateInput, false);
        validateLastCandidatesName(candidateInput);
        Candidate candidate = modelMapper.map(candidateInput, Candidate.class);
        candidate = candidateRepository.save(candidate);
        return Candidate.toCandidateOutput(candidate);
    }

    public CandidateOutput getById(Long candidateId){
        if (candidateId == null){
            throw new GenericOutputException(MESSAGE_INVALID_ID);
        }

        Candidate candidate = candidateRepository.findById(candidateId).orElse(null);
        if (candidate == null){
            throw new GenericOutputException(MESSAGE_CANDIDATE_NOT_FOUND);
        }

        return modelMapper.map(candidate, CandidateOutput.class);
    }

    public CandidateOutput update(Long candidateId, CandidateInput candidateInput) {
        if (candidateId == null){
            throw new GenericOutputException(MESSAGE_INVALID_ID);
        }
        validateInput(candidateInput, true);
        validateLastCandidatesName(candidateInput);

        Candidate candidate = candidateRepository.findById(candidateId).orElse(null);
        if (candidate == null){
            throw new GenericOutputException(MESSAGE_CANDIDATE_NOT_FOUND);
        }
        candidate.setName(candidate.getName());
        candidate.setNumberElection(candidate.getNumberElection());
        candidate.setElectionId(candidate.getElectionId());
        candidate.setPartyId(candidate.getPartyId());
        candidate = candidateRepository.save(candidate);
        return modelMapper.map(candidate, CandidateOutput.class);
    }

    public GenericOutput delete(Long candidateId) {
        if (candidateId == null){
            throw new GenericOutputException(MESSAGE_INVALID_ID);
        }

        Candidate candidate = candidateRepository.findById(candidateId).orElse(null);
        if (candidate == null){
            throw new GenericOutputException(MESSAGE_CANDIDATE_NOT_FOUND);
        }

        candidateRepository.delete(candidate);

        return new GenericOutput("Candidate deleted");
    }

    private void validateInput(CandidateInput candidateInput, boolean isUpdate){
        if (StringUtils.isBlank(candidateInput.getName())){
            throw new GenericOutputException("Invalid name");
        }
    }

}
