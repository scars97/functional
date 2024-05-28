package org.example.part02.ch05.code;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class LocalRecord {

    public static void main(String[] args) {
        Map<Integer, List<String>> albums = Map.of(1991, List.of("Music1", "Listen Without PreJudice"),
                1992, List.of("Music2", "Ten", "Blue lines"),
                1993, List.of("Music3", "CheekToCheek", "Christian Mcbride"),
                1994, List.of("Music4", "One Not Samba"),
                1995, List.of("Music5", "Jazz Crime", "Joshua Redman"));

        List<String> result = filtersAlbums(albums, 1993);

        for (String s : result) {
            System.out.println(s);
        }
    }


    public static List<String> filtersAlbums(Map<Integer, List<String>> albums, int minimumYear) {

        record AlbumsPerYear(int year, List<String> titles) {
            AlbumsPerYear(Map.Entry<Integer, List<String>> entry) {
                this(entry.getKey(), entry.getValue());
            }

            static Predicate<AlbumsPerYear> minimumYear(int year) {
                return albumsPerYear -> albumsPerYear.year() >= year;
            }

            static Comparator<AlbumsPerYear> sortByYear() {
                return Comparator.comparing(AlbumsPerYear::year);
            }

        }

        return albums.entrySet()
                .stream()
                .filter(entry -> entry.getKey() >= minimumYear)
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .flatMap(List::stream)
                .toList();
    }

}
