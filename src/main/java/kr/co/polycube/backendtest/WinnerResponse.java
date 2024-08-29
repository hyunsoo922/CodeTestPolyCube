package kr.co.polycube.backendtest;

public class WinnerResponse {

    private Long lotto_id;
    private Integer rank;

    public WinnerResponse(Long lotto_id, Integer rank) {
        this.lotto_id = lotto_id;
        this.rank = rank;
    }

    public Long getLotto_id() {
        return lotto_id;
    }

    public void setLotto_id(Long lotto_id) {
        this.lotto_id = lotto_id;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
