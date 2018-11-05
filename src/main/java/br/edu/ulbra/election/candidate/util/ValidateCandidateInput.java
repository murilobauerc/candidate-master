package br.edu.ulbra.election.candidate.utils;

import br.edu.ulbra.election.candidate.exception.GenericOutputException;
import br.edu.ulbra.election.candidate.input.v1.CandidateInput;

public class ValidateCandidateInput {
    private ValidateCandidateInput(){}

    /**
     * Throw an generic exception if the voter's name does not contain at least 5 letters and a last name.
     * @param candidateInput object which case it is the name to be searched.
     * @throws GenericOutputException if name goes wrong.
     */
    public static void validateLastCandidatesName(CandidateInput candidateInput){
        String[] word = candidateInput.getName().trim().split(" ");
        if(word.length < 2){
            throw new GenericOutputException("The name must have at least a last name.");
        }
        if(lengthCandidatesName(candidateInput) < 5) {
            throw new GenericOutputException("The name must have at least 5 letters.");
        }
    }


    /**
     * Get the length of the candidate's name (already trimmed)
     * @param candidateInput object which case it is the name to be searched.
     * @return an integer number that is the length of the candidate's name
     */
    public static int lengthCandidatesName(CandidateInput candidateInput){
        return candidateInput.getName().trim().length();
    }

}
