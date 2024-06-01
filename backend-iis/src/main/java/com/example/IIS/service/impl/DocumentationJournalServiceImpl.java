package com.example.IIS.service.impl;

import com.example.IIS.repository.DocumentationJournalRepo;
import com.example.IIS.service.DocumentationJournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentationJournalServiceImpl implements DocumentationJournalService {

    @Autowired
    private DocumentationJournalRepo documentationJournalRepo;
}
