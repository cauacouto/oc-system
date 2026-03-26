package br.coutodev.order.service.domin;

import br.coutodev.order.service.enums.StatusOc;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "OcModel")
@Table(name = "TB_OCS")

@NoArgsConstructor
@AllArgsConstructor
public class OrderModel  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    private String numeroOc = UUID.randomUUID().toString();
    private String descricao;
    private BigDecimal valor;
    private Integer quantidade;
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime dataCriacao;
    @Enumerated(EnumType.STRING)
    private StatusOc statusOc;
    private String emailTo;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getNumeroOc() {
        return numeroOc;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public void setNumeroOc(String numeroOc) {
        this.numeroOc = numeroOc;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public StatusOc getStatusOc() {
        return statusOc;
    }

    public void setStatusOc(StatusOc statusOc) {
        this.statusOc = statusOc;
    }
}
