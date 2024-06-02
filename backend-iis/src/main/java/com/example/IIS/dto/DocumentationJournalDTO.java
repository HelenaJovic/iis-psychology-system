package com.example.IIS.dto;

import com.example.IIS.domain.enums.Operation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentationJournalDTO {

    private Long id;

    private LocalDate date;

    private Operation operation;

    private String topicSummary;

    private String emotionalReactions;

    private String plan;

    private Long documentationId;


//    CREATE OR REPLACE FUNCTION session_documentation_changes()
//    RETURNS TRIGGER AS $$
//    BEGIN
//    IF (TG_OP = 'INSERT') THEN
//    INSERT INTO documentation_journal (operation, topic_summary, emotional_reactions, plan, date)
//    VALUES (0, NEW.topic_summary, NEW.emotional_reactions, NEW.plan, CURRENT_DATE);
//    RETURN NEW;
//    ELSIF (TG_OP = 'UPDATE') THEN
//    INSERT INTO documentation_journal (operation, topic_summary, emotional_reactions, plan, date)
//    VALUES (1, OLD.topic_summary, OLD.emotional_reactions, OLD.plan, CURRENT_DATE);
//    RETURN NEW;
//    ELSIF (TG_OP = 'DELETE') THEN
//    INSERT INTO documentation_journal (operation, topic_summary, emotional_reactions, plan, date)
//    VALUES (2, OLD.topic_summary, OLD.emotional_reactions, OLD.plan, CURRENT_DATE);
//    RETURN OLD;
//    END IF;
//    RETURN NULL;
//    END;
//    $$ LANGUAGE plpgsql;
//
//
//    CREATE TRIGGER session_documentation_trigger
//    AFTER INSERT OR UPDATE OF plan, topic_summary, emotional_reactions OR DELETE ON session_documentation
//    FOR EACH ROW
//    EXECUTE FUNCTION session_documentation_changes();
}
