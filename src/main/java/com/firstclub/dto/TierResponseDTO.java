package com.firstclub.dto;

import com.firstclub.benefit.BenefitConfigDTO;

import java.util.List;

public class TierResponseDTO {

    private Long id;
    private String name;
    private int rank;
    private List<BenefitConfigDTO> benefits;

    public TierResponseDTO() {
    }

    public TierResponseDTO(Long id, String name, int rank, List<BenefitConfigDTO> benefits) {
        this.id = id;
        this.name = name;
        this.rank = rank;
        this.benefits = benefits;
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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public List<BenefitConfigDTO> getBenefits() {
        return benefits;
    }

    public void setBenefits(List<BenefitConfigDTO> benefits) {
        this.benefits = benefits;
    }
}
