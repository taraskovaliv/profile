package dev.kovaliv.data.entity;

import io.javalin.http.Context;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.SEQUENCE;
import static org.apache.commons.lang3.math.NumberUtils.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "results")
public class Result {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "results_generator")
    @SequenceGenerator(name = "results_generator", sequenceName = "results_id_seq", allocationSize = 1)
    @Column(updatable = false, nullable = false, unique = true)
    private Long id;

    private int counts;

    private int threads;
    private long time;

    private double frequency;
    private int physicalCores;
    private int logicalCores;

    public Result(Context context) {
        this.counts = toInt(context.queryParam("counts"), 0);
        this.threads = toInt(context.queryParam("threads"), 0);
        this.time = toLong(context.queryParam("time"), 0L);
        this.frequency = toDouble(context.queryParam("frequency"), 0);
        this.physicalCores = toInt(context.queryParam("physical_cores"), 0);
        this.logicalCores = toInt(context.queryParam("logical_cores"), 0);
    }
}
