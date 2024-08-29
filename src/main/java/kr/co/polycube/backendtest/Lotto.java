package kr.co.polycube.backendtest;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer number_1;
    @Column
    private Integer number_2;
    @Column
    private Integer number_3;
    @Column
    private Integer number_4;
    @Column
    private Integer number_5;
    @Column
    private Integer number_6;

}
