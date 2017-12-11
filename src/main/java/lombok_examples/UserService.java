package lombok_examples;

import lombok.*;

import java.io.*;

public class UserService {
    public static void main(String[] args) throws IOException{

        @Cleanup InputStream in = new FileInputStream(args[0]); //close streams
        @Cleanup OutputStream out = new FileOutputStream(args[1]);

        byte[] b = new byte[10000];
        while (true) {
            int r = in.read(b);
            if (r == -1) break;
            out.write(b, 0, r);
        }

        UserService us = new UserService();
        System.out.println(us.loadUserByUsername("Ivan"));
    }

    @SneakyThrows //no exceptions here
    public User loadUserByUsername(@NonNull String username) { //validate for NonNull argument

        Thread.sleep(1000);

        return User.builder() //build our instance
                .username(username)
                .password("pass")
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .build();
    }
}
