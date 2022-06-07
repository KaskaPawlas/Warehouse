package pl.pawlas.warehouse.model;


import org.hibernate.validator.constraints.pl.NIP;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Long id;

    @NotBlank
    @Size(max = 256)
    @Column(nullable = false, length = 256)
    private String name;

    @NIP
    @Size(max = 10)
    @NotNull
    @Column(length = 10, name = "NIP", nullable = false)
    private String nip;

    @Enumerated(EnumType.STRING)
    @Column(name = "supplier_type")
    private SupplierType type;

    public Supplier() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public SupplierType getType() {
        return type;
    }

    public void setType(SupplierType type) {
        this.type = type;
    }
}
