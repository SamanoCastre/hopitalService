package com.hopital.urgence.services;
import org.springframework.stereotype.Service;

@Service
public interface ISequenceGeneratorService {
    public int generateSequence(String seqName);
}
