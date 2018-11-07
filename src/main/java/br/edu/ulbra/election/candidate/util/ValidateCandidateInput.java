package br.edu.ulbra.election.candidate.util;

import br.edu.ulbra.election.candidate.exception.GenericOutputException;
import br.edu.ulbra.election.candidate.input.v1.CandidateInput;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCandidateInput {
    private ValidateCandidateInput(){}

    /**
     * Throw an generic exception if the candidate's name does not contain at least 5 letters and a last name.
     * @param candidateInput object which case it is the name to be searched.
     * @throws GenericOutputException if name goes wrong.
     */
    public static void validateLastCandidatesName(CandidateInput candidateInput){
        if(trimInsideOut(candidateInput.getName()).split(" ").length < 2){
            throw new GenericOutputException("The name must have at least a last name.");
        }
        if(trimInsideOut(candidateInput.getName()).length() < 5) {
            throw new GenericOutputException("The name must have at least 5 letters.");
        }
    }

    /**
     * Removes blank spaces in the beginning and the end
     * Replaces multiple blank spaces,if exists, to a single one
     *
     * @param word any string
     * @return trimmed string and treated at all
     */
    public static String trimInsideOut(String word){
        word = word.trim();
        Pattern pattern = Pattern.compile("\\s+");
        Matcher matcher = pattern.matcher(word);
        word = matcher.replaceAll(" ");

        return word;
    }
}
