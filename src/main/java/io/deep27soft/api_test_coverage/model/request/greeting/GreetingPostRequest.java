package io.deep27soft.api_test_coverage.model.request.greeting;

public class GreetingPostRequest {

    private Long id;

    public GreetingPostRequest() {

    }

    public GreetingPostRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
