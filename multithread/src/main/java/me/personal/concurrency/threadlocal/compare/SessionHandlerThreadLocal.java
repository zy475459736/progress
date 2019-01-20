package me.personal.concurrency.threadlocal.compare;

/**
 * Created by zhongyi on 2019/1/20.
 */
public class SessionHandlerThreadLocal {
    public static ThreadLocal<Session> session = new ThreadLocal<Session>();

    public static class Session {
        private String id;
        private String user;
        private String status;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }


    public void createSession() {
        session.set(new Session());
    }

    public String getUser() {
        return session.get().getUser();
    }

    public String getStatus() {
        return session.get().getStatus();
    }

    public void setStatus(String status) {
        session.get().setStatus(status);
    }

    public static void main(String[] args) {
        new Thread(() -> {
            SessionHandlerThreadLocal handler = new SessionHandlerThreadLocal();
            System.out.println(handler.getStatus());;
            System.out.println(handler.getUser());;handler.setStatus("close");
            System.out.println(handler.getStatus());;
            ;
        }).start();
    }
}
