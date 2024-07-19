package com.example.IIS.domain;

import com.example.IIS.domain.enums.WorkshopCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.Text;

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "workshops")
public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Date date;

    private String startTime;

    private String endTime;

    private WorkshopCategory category;

    private boolean isOnline;

    private double price;



    @ElementCollection
    @CollectionTable(name = "workshop_images", joinColumns = @JoinColumn(name = "workshop_id"))
    @Column(name = "image")
    private List<String> images;

    @JoinColumn(name = "psychologist_id")
    @ManyToOne(fetch=FetchType.LAZY)
    private Psychologist psychologist;

//    @ManyToMany(mappedBy = "workshops",cascade = CascadeType.ALL)
//    private List<RegisteredUser> users;

    @JoinColumn(name = "hall_id")
    @ManyToOne(fetch=FetchType.LAZY)
    private Hall hall;

    @OneToMany(mappedBy = "workshop", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<WorkshopTest> workshopsTests = new HashSet<WorkshopTest>();

}
