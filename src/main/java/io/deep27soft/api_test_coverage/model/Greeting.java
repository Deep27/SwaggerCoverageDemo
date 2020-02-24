package io.deep27soft.api_test_coverage.model;

import java.util.Objects;

public class Greeting {

    private Long id;
    private String content;

    public Greeting() {

    }

    public Greeting(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + id.intValue();
        hash = 31 * hash + content.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Greeting)) {
            return false;
        }
        return id.equals(((Greeting) obj).id) && Objects.equals(content, ((Greeting) obj).content);
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
