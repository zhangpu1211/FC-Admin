package org.fcadmin;

import org.fcadmin.exception.TokenException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.Assert;

@SpringBootTest
class FcadminApplicationTests {

    @Test
    void contextLoads() {
    }
    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Test
    public void test() {
        pathMatcher.setCachePatterns(true);
        pathMatcher.setCaseSensitive(true);
        pathMatcher.setTrimTokens(true);
        pathMatcher.setPathSeparator("/");

        System.out.println(pathMatcher.match("a", "a"));
        System.out.println(pathMatcher.match("a*", "ab"));
        System.out.println(pathMatcher.match("a*/**/a", "ab/asdsa/a"));
        System.out.println(pathMatcher.match("a*/**/a", "ab/asdsa/asdasd/a"));


        System.out.println(pathMatcher.match("*", "a"));
        System.out.println(pathMatcher.match("*/*", "a/a"));
    }



}
