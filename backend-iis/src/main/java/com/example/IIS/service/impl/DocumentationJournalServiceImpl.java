package com.example.IIS.service.impl;

import com.example.IIS.domain.DocumentationJournal;
import com.example.IIS.domain.SessionDocumentation;
import com.example.IIS.dto.DocumentationJournalDTO;
import com.example.IIS.dto.SessionDocumentationDTO;
import com.example.IIS.repository.DocumentationJournalRepo;
import com.example.IIS.service.DocumentationJournalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentationJournalServiceImpl implements DocumentationJournalService {

    @Autowired
    private DocumentationJournalRepo documentationJournalRepo;

    @Autowired
    private ModelMapper mapper;

    private DocumentationJournal mapToEntity(DocumentationJournalDTO documentationJournalDTO){
        DocumentationJournal documentation = mapper.map(documentationJournalDTO, DocumentationJournal.class);
        return documentation;
    }

    private DocumentationJournalDTO mapToDTO(DocumentationJournal documentationJournal){
        DocumentationJournalDTO documentationJournalDTO= mapper.map(documentationJournal, DocumentationJournalDTO.class);
        return documentationJournalDTO;
    }

    @Override
    public List<DocumentationJournalDTO> getAll() {
        List<DocumentationJournal> documentations = documentationJournalRepo.findAll();
        List<DocumentationJournalDTO> dtos = new ArrayList<>();

        for(DocumentationJournal doc : documentations){
            dtos.add(mapToDTO(doc));
        }
        return dtos;
    }
}
