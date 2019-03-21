package streams.building;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;
import static java.util.stream.Collectors.groupingBy;

public class StreamFromFiles {

  public static void main(String[] args) {
    long uniqueWords = 0;

    try (Stream<String> lines = Files.lines(Paths.get("data/sample.txt"), Charset.defaultCharset())) {

      uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
          .distinct()
          .count();
    } catch (IOException ioe) {
      System.err.println("IOE Error!");
      ioe.printStackTrace();
    }

    System.out.println("Unique Words: " + uniqueWords);


    Map<String, List<String>> wfm = new HashMap<>();
    try (Stream<String> lines = Files.lines(Paths.get("data/sample.txt"), Charset.defaultCharset())) {

      wfm = lines.flatMap(line -> Arrays.stream(line.split(" ")))
          .collect(groupingBy(String::valueOf));
    } catch (IOException ioe) {
      System.err.println("IOE Error!");
      ioe.printStackTrace();
    }


    wfm.entrySet().stream()
        .map(entry -> new WordFreq((String)entry.getKey(), entry.getValue().size()))
        .sorted(Comparator.comparing(WordFreq::getFreq))
        .forEach(wf -> System.out.println("word: \"" + wf.getWord() + "\" count: " + wf.getFreq()));

  }

  static class WordFreq {
    String word;
    int freq;

    public WordFreq(String word, int freq) {
      this.word = word;
      this.freq = freq;
    }

    public String getWord() {
      return word;
    }

    public int getFreq() {
      return freq;
    }
  }
}
