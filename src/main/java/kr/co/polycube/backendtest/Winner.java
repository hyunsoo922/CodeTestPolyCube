package kr.co.polycube.backendtest;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Builder
public class Winner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer rank;

    @ManyToOne
    @JoinColumn(name = "lotto_id")
    private Lotto lotto;
}
