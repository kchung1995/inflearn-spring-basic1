package com.tistory.katfun.core.lifecycle;

// javax: Java에서 공식 지원하는 기능. 스프링이 아니어도 동작한다 (JSR-250이라는 자바 표준)
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//public class NetworkClient implements InitializingBean, DisposableBean {
public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메세지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("close");
    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지");
    }

    @PreDestroy
    public void close() throws Exception{
        System.out.println("NetworkClient.close");
        disconnect();
    }
    // 어노테이션 기반의 유일한 단점: 외부 라이브러리에는 적용할 수 없다.
}
