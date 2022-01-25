package com.example.current_exchange_rates.entity;

import com.example.current_exchange_rates.entity.enums.CodeCurrency;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "actual_course")
@NoArgsConstructor
@AllArgsConstructor
public class CourseEntity implements Serializable {

    private static final long serialVersionUID = -6464268112542971975L;

    @Id
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();

    @Column(name = "api_key")
    private String apiKey;

    @Column(name = "last_update_course")
    private String lastUpdateCourse;

    @Column(name = "base_code")
    private String baseCode;

    @Column(name = "code_currency")
    private CodeCurrency codeCurrency;

    @Column(name = "usd", precision = 10, scale = 6)
    private BigDecimal usd;

    @Column(name = "eur", precision = 10, scale = 6)
    private BigDecimal eur;

    @UpdateTimestamp
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @CreationTimestamp
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public CourseEntity(
            String apiKey,
            String lastUpdateCourse,
            String baseCode,
            CodeCurrency codeCurrency,
            BigDecimal usd,
            BigDecimal eur
    ) {
        this.apiKey = apiKey;
        this.lastUpdateCourse = lastUpdateCourse;
        this.baseCode = baseCode;
        this.codeCurrency = codeCurrency;
        this.usd = usd;
        this.eur = eur;
    }

    public CourseEntity(
            String id,
            String apiKey,
            String lastUpdateCourse,
            String baseCode,
            CodeCurrency codeCurrency,
            BigDecimal usd,
            BigDecimal eur
    ) {
        this.id = id;
        this.apiKey = apiKey;
        this.lastUpdateCourse = lastUpdateCourse;
        this.baseCode = baseCode;
        this.codeCurrency = codeCurrency;
        this.usd = usd;
        this.eur = eur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CourseEntity courseEntity = (CourseEntity) o;
        return id != null && Objects.equals(id, courseEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
