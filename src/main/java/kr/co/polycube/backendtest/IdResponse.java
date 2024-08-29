package kr.co.polycube.backendtest;

public class IdResponse {
    private Long id;

    public IdResponse(Long id) {
        this.id = id;
    }

    public IdResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
