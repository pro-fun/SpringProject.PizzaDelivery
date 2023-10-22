package by.academypvt.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(schema = "delivery", name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_id")
    @SequenceGenerator(name = "comment_id", sequenceName = "comment_seq", allocationSize = 50)
    private Long id;
    private String comment;
    private LocalDate date;
}