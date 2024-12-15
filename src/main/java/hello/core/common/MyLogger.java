package hello.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(value="request",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {
    private String uuid;
    private String requestUrl;

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public void log(String message){

        System.out.println("["+this.uuid+"]["+this.requestUrl+"] "+message);
    }

    @PostConstruct
    public void init(){
        this.uuid = UUID.randomUUID().toString();

        System.out.println("["+this.uuid+"]Request scope bean created : "+ this);
    }

    @PreDestroy
    public void destroy(){
        System.out.println("["+this.uuid+"]Request scope bean close : "+ this);
    }
}