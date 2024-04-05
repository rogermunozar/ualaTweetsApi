package com.tweets.api.infrastructure.ES;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SqlQuery {
    public SqlQuery(String query){
        this.query=query;
    }
    private String query;
}
