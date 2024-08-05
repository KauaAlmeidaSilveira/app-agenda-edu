package com.agendaedu.schedule_service.domain.local;

import com.agendaedu.schedule_service.domain.booking.BookingEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_local")
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;

    @OneToOne(mappedBy = "local")
    private BookingEntity booking;

    public Local(LocalDTO localDTO) {
        this.id = localDTO.getId();
        this.name = localDTO.getName();
    }
}
