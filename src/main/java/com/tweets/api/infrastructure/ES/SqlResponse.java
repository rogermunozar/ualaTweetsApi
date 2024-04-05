package com.tweets.api.infrastructure.ES;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SqlResponse {
    private SqlMeta[] columns;
    private String[][] rows;
    
    @Getter
    private Map<String,Integer> hash;

    public SqlResponse buildHash(){
        hash = new HashMap<String,Integer>();
        for(int i=0; i< columns.length; i++){
            hash.put(columns[i].getName(),i);
        }
        return this;
    }

    public String getString(String field, int i){
        String[] row = this.getRows()[i];
        return (row[hash.get(field)]);
    }


}
