package by.academypvt.domain.entity;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(schema = "delivery", name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private LocalDate date;
}