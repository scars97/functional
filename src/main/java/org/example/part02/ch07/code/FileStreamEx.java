package org.example.part02.ch07.code;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FileStreamEx {

    public static void main(String[] args) {
        Path dir = Paths.get("src/main/java/org/example/part02");

        // 디렉터리 내용 읽기
        try (Stream<Path> stream = Files.list(dir)) {
            stream.map(Path::getFileName)
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 깊이 우선 디렉터리 순회
        System.out.println("===============");
        try (Stream<Path> stream = Files.walk(dir)) {
            stream.map(Path::toFile)
                    .filter(Predicate.not(File::isFile))
                    .sorted()
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // find를 사용한 파일 시스템 탐색
        System.out.println("===============");

        BiPredicate<Path, BasicFileAttributes> matcher =
                (path, attr) -> attr.isDirectory();
        try (Stream<Path> stream = Files.find(dir, Integer.MAX_VALUE, matcher)) {
            stream.sorted()
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
