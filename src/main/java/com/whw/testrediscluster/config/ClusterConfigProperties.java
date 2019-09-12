package com.whw.testrediscluster.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "spring.redis.cluster")
public class ClusterConfigProperties {

    private List<String> nodes = new ArrayList<>();

    public List<String> getNodes(){
        return nodes;
    }

    public void setNodes(List<String> nodes){
        this.nodes = nodes;
    }


}
